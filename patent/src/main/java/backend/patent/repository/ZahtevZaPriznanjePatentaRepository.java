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
import java.util.List;

public class ZahtevZaPriznanjePatentaRepository {

    public void findById(String id) throws Exception {

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
        XMLResource res = null;

        try {
            // get the collection
            col = DatabaseManager.getCollection(conn.uri + collectionId);
            col.setProperty(OutputKeys.INDENT, "yes");

            res = (XMLResource)col.getResource(documentId);

            if(res == null) {
                System.out.println("[WARNING] Document '" + documentId + "' can not be found!");
            } else {

                JAXBContext context = JAXBContext.newInstance("backend.patent.jaxb");

                Unmarshaller unmarshaller = context.createUnmarshaller();

                ZahtevZaPriznanjePatenta zahtev = (ZahtevZaPriznanjePatenta) unmarshaller.unmarshal(res.getContentAsDOM());

                System.out.println(zahtev);

            }
        } finally {
            cleanup(col, res);
        }
    }

    public void save(ZahtevZaPriznanjePatenta zahtev) throws Exception {

        ConnectionProperties conn = AuthenticationUtilities.loadProperties();


        System.out.println("[INFO] Using defaults.");
        String collectionId = "/db/xml-project/patenti";
        String documentId = zahtev.getBrojPrijave() + ".xml";
        String filePath = "data/p_input.xml";


        System.out.println("\t- collection ID: " + collectionId);
        System.out.println("\t- document ID: " + documentId);
        System.out.println("\t- file path: " + filePath + "\n");

        // initialize database driver
        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);

        // encapsulation of the database driver functionality
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        // entry point for the API which enables you to get the Collection reference
        DatabaseManager.registerDatabase(database);

        // a collection of Resources stored within an XML database
        Collection col = null;
        XMLResource res = null;
        OutputStream os = new ByteArrayOutputStream();

        try {
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = getOrCreateCollection(conn, collectionId);

            /*
             *  create new XMLResource with a given id
             *  an id is assigned to the new resource if left empty (null)
             */
            System.out.println("[INFO] Inserting the document: " + documentId);
            res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);

            System.out.println("[INFO] Unmarshalling XML document to an JAXB instance: ");
            JAXBContext context = JAXBContext.newInstance("backend.patent.jaxb");

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // marshal the contents to an output stream
            marshaller.marshal(zahtev, os);

            // link the stream to the XML resource
            res.setContent(os);
            System.out.println("[INFO] Storing the document: " + res.getId());

            col.storeResource(res);
            System.out.println("[INFO] Done.");

        } finally {
            cleanup(col, res);
        }
    }

    private void cleanup(Collection col, XMLResource res) throws XMLDBException {
        if(col != null) {
            col.close();
        }
    }

    public List<ZahtevZaPriznanjePatenta> getAll() throws Exception {
        AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties();

        // initialize collection and document identifiers
        String collectionId = "/db/xml-project/patenti";

        System.out.println("\t- collection ID: " + collectionId);

        System.out.println("[INFO] Loading driver class: " + conn.driver);
        Class<?> cl = Class.forName(conn.driver);

        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");

        DatabaseManager.registerDatabase(database);

        Collection col = null;

        ZahtevZaPriznanjePatenta zahtevZaPriznanjePatenta = null;
        List<ZahtevZaPriznanjePatenta> zahteviZaPriznanjePatenta;
        int sum;
        try {
            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = DatabaseManager.getCollection(conn.uri + collectionId);
            //col.setProperty(OutputKeys.INDENT, "yes");

            XPathQueryService xPathQueryService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            xPathQueryService.setProperty("indent", "yes");

            String xPathExp = "//Zahtev_za_priznanje_patenta";
            ResourceSet result = xPathQueryService.query(xPathExp);
            ResourceIterator i = result.getIterator();
            XMLResource res = null;
            zahteviZaPriznanjePatenta = new ArrayList<>();
            while (i.hasMoreResources()) {
                res = (XMLResource) i.nextResource();
                //System.out.println(res.getContent());

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

                    System.out.println("[INFO] Creating the collection: " + pathSegments[pathSegmentOffset]);
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
