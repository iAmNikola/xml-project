package jaxb.run;

import jaxb.a.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Primer 1.
 * <p>
 * Primer demonstrira "unmarshalling" tj. konverziju
 * iz XML fajla u objektni model.
 */
public class TestA {
    public void test() {
        try {
            System.out.println("[INFO] Example A1.\n");
            // Definiše se JAXB kontekst (putanja do paketa sa JAXB bean-ovima)
            JAXBContext context = JAXBContext.newInstance("jaxb.a");

            // Unmarshaller je objekat zadužen za konverziju iz XML-a u objektni model
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Unmarshalling generiše objektni model na osnovu XML fajla
            ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela zahtev =
                    (ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela) unmarshaller
                            .unmarshal(new File("./schemas/a_instance1.xml"));

            // Prikazuje unmarshallovan objekat
            printZahtev(zahtev);

            // Promeni vrednosti
            zahtev.setBrojPrijave("A-200");
            zahtev.getPodnosilac().setEmail("promenjen@mejl.com");
            zahtev.setNaslov("Softver Inzinjering 101");
            zahtev.setFormaZapisaAutorskogDela("Digitalna; pdf");
            if (zahtev.getPodaciODeluNaKomeSeZasnovaAutorskoDelo() == null) {
                zahtev.setPodaciODeluNaKomeSeZasnovaAutorskoDelo(
                        new ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela
                                .PodaciODeluNaKomeSeZasnovaAutorskoDelo()
                );
                zahtev.getPodaciODeluNaKomeSeZasnovaAutorskoDelo().setAutor(new TAutor());
            }
            zahtev.getPodaciODeluNaKomeSeZasnovaAutorskoDelo().setNaslovAutorskogDela("Softver Inzinjering 100");
            zahtev.getPodaciODeluNaKomeSeZasnovaAutorskoDelo().getAutor().setIme("Mali");
            zahtev.getPodaciODeluNaKomeSeZasnovaAutorskoDelo().getAutor().setPrezime("Mrav");
            zahtev.getAutorskoDelo().setFile("putanja/do/fajla");

            // Marshaller je objekat zadužen za konverziju iz objektnog u XML model
            Marshaller marshaller = context.createMarshaller();

            // Podešavanje marshaller-a
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Umesto System.out-a, može se koristiti FileOutputStream
            marshaller.marshal(zahtev, new FileOutputStream("./data/a_output.xml"));

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void printZahtev(ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela zahtev) {
        // Prikaz broja prijave i datuma podnosenja privaje
        System.out.println("Zahtev Za Unosenje U Evidenciju I Deponovanje Autorskih Dela");
        System.out.printf(
                "Broj prijave: %s\tDatum podnosenja prijave: %s%n",
                zahtev.getBrojPrijave(),
                zahtev.getDatumPodnosenja()
        );

        // Prikaz podnosioca
        TPodnosilac podnosilac = zahtev.getPodnosilac();
        if (podnosilac instanceof TPodnosilacFizickoLice) {
            TPodnosilacFizickoLice podnosilacFizickoLice = (TPodnosilacFizickoLice) podnosilac;
            System.out.println("Podnosilac je fizicko lice.");
            System.out.printf("Ime: %s\n", podnosilacFizickoLice.getFizickoLice().getIme());
            System.out.printf("Prezime: %s\n", podnosilacFizickoLice.getFizickoLice().getPrezime());
            System.out.printf(
                    "Adresa:\n\tGrad: %s\n\tUlica: %s\n\tPostanski broj: %s\n",
                    podnosilacFizickoLice.getFizickoLice().getAdresa().getGrad(),
                    podnosilacFizickoLice.getFizickoLice().getAdresa().getUlica(),
                    podnosilacFizickoLice.getFizickoLice().getAdresa().getPostanskiBroj()
            );
            System.out.printf("Drzavljanstvo: %s", podnosilacFizickoLice.getFizickoLice().getDrzavljanstvo());
        } else {
            TPodnosilacPravnoLice podnosilacPravnoLice = (TPodnosilacPravnoLice) podnosilac;
            System.out.println("Podnosilac je pravno lice.");
        }
    }

    public static void main(String[] args) {
        TestA test = new TestA();
        test.test();
    }
}
