package jaxb.run;

import jaxb.util.MyValidationEventHandler;
import jaxb.z.TRobaIUsluge;
import jaxb.z.ZahtevZaPriznanjeZiga;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileOutputStream;

public class TestZ {
    public static void test() {
        try {
            System.out.println("[INFO] Example Z1.\n");

            // Definiše se JAXB kontekst (putanja do paketa sa JAXB bean-ovima)
            JAXBContext context = JAXBContext.newInstance("jaxb.z");

            // Unmarshaller je objekat zadužen za konverziju iz XML-a u objektni model
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // XML schema validacija
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File("./data/z_schema.xsd"));

            // Podešavanje unmarshaller-a za XML schema validaciju
            unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(new MyValidationEventHandler());

            // Test: proširiti XML fajl nepostojećim elementom (npr. <test></test>)
            ZahtevZaPriznanjeZiga zahtev = (ZahtevZaPriznanjeZiga) unmarshaller.unmarshal(new File("./data/z_input.xml"));

            // Izmena podataka o zavodu
            changePodaciOZavodu(zahtev);

            // Marshaller je objekat zadužen za konverziju iz objektnog u XML model
            Marshaller marshaller = context.createMarshaller();

            // Podešavanje marshaller-a
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Umesto System.out-a, može se koristiti FileOutputStream
            marshaller.marshal(zahtev, new FileOutputStream("./data/z_output.xml"));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void changePodaciOZavodu(ZahtevZaPriznanjeZiga zahtev) {
        ZahtevZaPriznanjeZiga.PodaciOZavodu podaciOZavodu = zahtev.getPodaciOZavodu();
        // primerak znaka
        podaciOZavodu.getPrimerakZnaka().setPutanja("/usr/docs/punomocje.txt");
        // spisak robe i usluge
        ZahtevZaPriznanjeZiga.PodaciOZavodu.SpisakRobeIUsluge spisakRobeIUsluge = new ZahtevZaPriznanjeZiga.PodaciOZavodu.SpisakRobeIUsluge();
        TRobaIUsluge robaIUsluge = new TRobaIUsluge();
        robaIUsluge.setKlasa(1);
        robaIUsluge.getUsluga().add(0, "neka usluga, nesto, nesto jos");
        robaIUsluge.getUsluga().add("nesto; nesto; nesto;");
        spisakRobeIUsluge.getRobaIUsluge().add(robaIUsluge);
        podaciOZavodu.setSpisakRobeIUsluge(spisakRobeIUsluge);
        // punomocje
        podaciOZavodu.getPunomocje().setPutanja("/usr/docs/punomocje.txt");
        // punomocje generalno punomocje
        podaciOZavodu.setGeneralnoPunomocijeRanijePrilozeno(true);
        // punomocje naknadno
        podaciOZavodu.setPunomocjeCeBitiNaknadnoDostavljeno(false);
        // opsti akt
        podaciOZavodu.getOpstiAkt().setPutanja("/usr/docs/opsti_akt.txt");
        // dokaz o pravu prvenstva
        podaciOZavodu.getOpstiAkt().setPutanja("/usr/docs/dokaz_prvenstvo.txt");
        // dokaz o uplati takse
        podaciOZavodu.getDokazOUplatiTakse().setPutanja("/usr/docs/dokaz_takse.txt");

        zahtev.setPodaciOZavodu(podaciOZavodu);
    }

    public static void main(String[] args) {
        test();
    }
}
