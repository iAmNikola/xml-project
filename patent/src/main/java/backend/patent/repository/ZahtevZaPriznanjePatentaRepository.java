package backend.patent.repository;

import backend.patent.jaxb.ZahtevZaPriznanjePatenta;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;
import backend.patent.util.AuthenticationUtilities;
import backend.patent.util.AuthenticationUtilities.ConnectionProperties;
import org.xmldb.api.modules.XPathQueryService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

@SuppressWarnings("deprecation")
public class ZahtevZaPriznanjePatentaRepository {

    public ZahtevZaPriznanjePatenta findById(String id) throws Exception {
        ZahtevZaPriznanjePatenta zahtev = null;

        ConnectionProperties conn = AuthenticationUtilities.loadProperties();

        // initialize collection and document identifiers
        String collectionId = "/db/xml-project/patenti";
        String documentId = id + ".xml";

        // initialize database driver
        Class<?> cl = Class.forName(conn.driver);

        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        DatabaseManager.registerDatabase(database);

        Collection col = null;
        XMLResource res;
        try {
            // get the collection
            col = DatabaseManager.getCollection(conn.uri + collectionId);
            col.setProperty(OutputKeys.INDENT, "yes");

            res = (XMLResource)col.getResource(documentId);


            if(res != null) {

                JAXBContext context = JAXBContext.newInstance("backend.patent.jaxb");

                Unmarshaller unmarshaller = context.createUnmarshaller();

                zahtev = (ZahtevZaPriznanjePatenta) unmarshaller.unmarshal(res.getContentAsDOM());

            }
        } finally {
            cleanup(col);
        }
        return zahtev;
    }

    public void save(ZahtevZaPriznanjePatenta zahtev) throws Exception {

        ConnectionProperties conn = AuthenticationUtilities.loadProperties();

        String collectionId = "/db/xml-project/patenti";
        String documentId = zahtev.getBrojPrijave() + ".xml";
        
        Class<?> cl = Class.forName(conn.driver);

        // encapsulation of the database driver functionality
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        // entry point for the API which enables you to get the Collection reference
        DatabaseManager.registerDatabase(database);

        // a collection of Resources stored within an XML database
        Collection col = null;
        XMLResource res;
        OutputStream os = new ByteArrayOutputStream();

        try {
            col = getOrCreateCollection(conn, collectionId);
            res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);

            JAXBContext context = JAXBContext.newInstance("backend.patent.jaxb");

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // marshal the contents to an output stream
            marshaller.marshal(zahtev, os);

            // link the stream to the XML resource
            res.setContent(os);
            col.storeResource(res);

        } finally {
            cleanup(col);
        }
    }

    private void cleanup(Collection col) throws XMLDBException {
        if(col != null) {
            col.close();
        }
    }

    public ArrayList<ZahtevZaPriznanjePatenta> getAll() throws Exception {
        AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties();

        // initialize collection and document identifiers
        String collectionId = "/db/xml-project/patenti";

        Class<?> cl = Class.forName(conn.driver);

        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        DatabaseManager.registerDatabase(database);

        Collection col = null;

        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta;
        ArrayList<ZahtevZaPriznanjePatenta> zahteviZaPriznanjePatenta;
        try {
            // get the collection
            col = DatabaseManager.getCollection(conn.uri + collectionId);
            col.setProperty(OutputKeys.INDENT, "yes");

            XPathQueryService xPathQueryService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            xPathQueryService.setProperty("indent", "yes");

            zahteviZaPriznanjePatenta = new ArrayList<>();
            String[] resources = col.listResources();
            XMLResource res;
            for (String resourceId : resources) {
                res = (XMLResource) col.getResource(resourceId);
                JAXBContext context = JAXBContext.newInstance(ZahtevZaPriznanjePatenta.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                zahtevZaPriznanjePatenta = (ZahtevZaPriznanjePatenta) unmarshaller.unmarshal(res.getContentAsDOM());
                zahteviZaPriznanjePatenta.add(zahtevZaPriznanjePatenta);
            }
        } finally {
            if (col != null) {
                col.close();
            }
        }
        return zahteviZaPriznanjePatenta;
    }

    private Collection getOrCreateCollection(ConnectionProperties conn, String collectionUri) throws XMLDBException {
        return getOrCreateCollection(conn, collectionUri, 0);
    }

    private Collection getOrCreateCollection(ConnectionProperties conn, String collectionUri, int pathSegmentOffset) throws XMLDBException {

        Collection col = DatabaseManager.getCollection(conn.uri + collectionUri, conn.user, conn.password);

        // create the collection if it does not exist
        if(col == null) {
            if(collectionUri.startsWith("/")) {
                collectionUri = collectionUri.substring(1);
            }

            String[] pathSegments = collectionUri.split("/");

            if(pathSegments.length > 0) {
                StringBuilder path = new StringBuilder();

                for(int i = 0; i <= pathSegmentOffset; i++) {
                    path.append("/").append(pathSegments[i]);
                }

                Collection startCol = DatabaseManager.getCollection(conn.uri + path, conn.user, conn.password);

                if (startCol == null) {
                    // child collection does not exist
                    String parentPath = path.substring(0, path.lastIndexOf("/"));
                    Collection parentCol = DatabaseManager.getCollection(conn.uri + parentPath, conn.user, conn.password);

                    CollectionManagementService mgt = (CollectionManagementService) parentCol.getService("CollectionManagementService", "1.0");

                    col = mgt.createCollection(pathSegments[pathSegmentOffset]);

                    col.close();
                    parentCol.close();

                } else {
                    startCol.close();
                }
            }
            return getOrCreateCollection(conn, collectionUri, ++pathSegmentOffset);
        } else {
            return col;
        }
    }
}
