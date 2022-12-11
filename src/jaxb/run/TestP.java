package jaxb.run;

import jaxb.p.Adresa;
import jaxb.p.Kontakt;
import jaxb.p.ZahtevZaPriznanjePatenta;
import jaxb.util.MyValidationEventHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TestP {
    public static void test() {
        try {
            System.out.println("[INFO] Example P1.\n");

            // Definiše se JAXB kontekst (putanja do paketa sa JAXB bean-ovima)
            JAXBContext context = JAXBContext.newInstance("jaxb.p");

            // Unmarshaller je objekat zadužen za konverziju iz XML-a u objektni model
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // XML schema validacija
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File("./data/p_schema.xsd"));

            // Podešavanje unmarshaller-a za XML schema validaciju
            unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(new MyValidationEventHandler());

            // Test: proširiti XML fajl nepostojećim elementom (npr. <test></test>)
            ZahtevZaPriznanjePatenta zahtev = (ZahtevZaPriznanjePatenta) unmarshaller.unmarshal(new File("./data/p_input.xml"));

            // Marshaller je objekat zadužen za konverziju iz objektnog u XML model
            Marshaller marshaller = context.createMarshaller();

            // Podešavanje marshaller-a
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Ispis sadržaja objektnog modela, nakon uspešne validacije
            marshaller.marshal(zahtev, System.out);

            // Izmena dokumenta
            zahtev.setPronalazac(newPronalazac());

            // Cuvanje izmena dokumenta
            marshaller.marshal(zahtev, new FileOutputStream("./data/p_output.xml"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ZahtevZaPriznanjePatenta.Pronalazac newPronalazac() {

        ZahtevZaPriznanjePatenta.Pronalazac newPronalazac = new ZahtevZaPriznanjePatenta.Pronalazac();

        newPronalazac.setIme("Maja Majic");
        newPronalazac.setNeZeliDaBudeNaveden(false);
        newPronalazac.setAdresa(new Adresa());
        newPronalazac.getAdresa().setUlica("Tolstojeva");
        newPronalazac.getAdresa().setBroj("15");
        newPronalazac.getAdresa().setPostanskiBroj("21000");
        newPronalazac.getAdresa().setMesto("Novi Sad");
        newPronalazac.setKontakt(new Kontakt());
        newPronalazac.getKontakt().setBrojFaksa("+1234567");
        newPronalazac.getKontakt().setBrojTelefona("+381652449815");
        newPronalazac.getKontakt().setEPosta("maja@gmail.com");

        return newPronalazac;
    }

    public static void main(String[] args) {
        test();
    }
}
