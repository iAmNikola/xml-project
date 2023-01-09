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

    ExistDBOperations existDB = new ExistDBOperations();
    FusekiOperations fusekiDB = new FusekiOperations();

    public ZahtevZaPriznanjePatenta findById(String id) throws Exception {
        return existDB.findById(id);
    }
    public ArrayList<ZahtevZaPriznanjePatenta> getAll() throws Exception {
        return existDB.getAll();
    }
    public void save(ZahtevZaPriznanjePatenta zahtev) throws Exception {
        existDB.save(zahtev);
        fusekiDB.save(zahtev);
    }
}
