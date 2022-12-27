package backend.patent.jaxb;

import backend.patent.dto.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class CreateTestData {
    public void writeToFile() throws JAXBException, DatatypeConfigurationException {
        ZahtevZaPriznanjePatentaCreationDto zahtev = getZahtevTestData();

        JAXBContext context = JAXBContext.newInstance(ZahtevZaPriznanjePatentaCreationDto.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(zahtev, System.out);
    }
    public ZahtevZaPriznanjePatentaCreationDto getZahtevTestData() throws DatatypeConfigurationException {
        ZahtevZaPriznanjePatentaCreationDto zahtev = new ZahtevZaPriznanjePatentaCreationDto();

        // NazivPronalaska
        NazivPronalaskaDto nazivPronalaska = new NazivPronalaskaDto();
        nazivPronalaska.nazivNaSrpskom = "Patent na srpskom";
        nazivPronalaska.nazivNaEngleskom = "Patent na engleskom";
        zahtev.nazivPronalaska = nazivPronalaska;

        // Podnosilac
        PodnosilacDto podnosilac = new PodnosilacDto();
        podnosilac.jePronalazac = false;
        podnosilac.ime = "Pera Peric";
        podnosilac.drzavljanstvo = "srpsko";
        podnosilac.adresa = getAdresaTestData();
        podnosilac.kontakt = getKontaktTestData();
        zahtev.podnosilac = podnosilac;

        // Pronalazac
        PronalazacDto pronalazac = new PronalazacDto();
        pronalazac.neZeliDaBudeNaveden = false;
        pronalazac.ime = "Maja Majic";
        pronalazac.adresa = getAdresaTestData();
        pronalazac.kontakt = getKontaktTestData();
        zahtev.pronalazac = pronalazac;

        // Punomocnik
        PunomocnikDto punomocnik = new PunomocnikDto();
        punomocnik.jeZajednickiPredstavnik = true;
        punomocnik.vrstaPunomocnika = "nekaVrsta";
        punomocnik.ime = "Sima Simic";
        punomocnik.adresa = getAdresaTestData();
        punomocnik.kontakt = getKontaktTestData();
        zahtev.punomocnik = punomocnik;

        // Adresa za dostavljanje
        zahtev.adresaZaDostavljanje = getAdresaTestData();

        // Nacin dostavljanja
        NacinDostavljanjaDto nacinDostavljanja = new NacinDostavljanjaDto();
        nacinDostavljanja.saglasnostZaDostavljanjeUElektronskojFormi = true;
        nacinDostavljanja.saglasnostZaDostavljanjeUPapirnojFormi = true;
        zahtev.nacinDostavljanja = nacinDostavljanja;

        // Prijava
        PrijavaDto prijava = new PrijavaDto();
        prijava.brojPrvobitnePrijave = "P-123456";
        prijava.datumPodnosenjaPrvobitnePrijave = getCurrentDate();
        prijava.vrstaPrijave = "dopunska";
        zahtev.prijava = prijava;

        // Zahtevi za priznanje prvenstva iz ranijih prijava
        ZahteviZaPriznanjePrvenstvaIzRanijihPrijavaDto zahteviZaPrvenstvo = new ZahteviZaPriznanjePrvenstvaIzRanijihPrijavaDto();
        zahteviZaPrvenstvo.zahtev = new ArrayList<>();

        ZahtevZaPriznanjePrvenstvaIzRanijihPrijavaDto zahtevZaPrvenstvo = new ZahtevZaPriznanjePrvenstvaIzRanijihPrijavaDto();
        zahtevZaPrvenstvo.brojRanijePrijave = "P-1111111";
        zahtevZaPrvenstvo.datumPodnosenjeRanijePrijave = getCurrentDate();
        zahtevZaPrvenstvo.dvoslovnaOznakaDrzaveIliOrganizacije = "RS";
        zahteviZaPrvenstvo.zahtev.add(zahtevZaPrvenstvo);

        zahtev.zahteviZaPriznanjePrvenstvaIzRanijihPrijava = zahteviZaPrvenstvo;
        return zahtev;
    }

    private KontaktDto getKontaktTestData() {
        KontaktDto kontakt = new KontaktDto();
        kontakt.brojFaksa = "123456";
        kontakt.brojTelefona = "123456";
        kontakt.ePosta = "nesto@gmail.com";
        return kontakt;
    }

    private AdresaDto getAdresaTestData() {
        AdresaDto adresa = new AdresaDto();
        adresa.ulica = "Neka ulica";
        adresa.mesto = "Sombor";
        adresa.drzava = "Srbija";
        adresa.postanskiBroj = "25000";
        return adresa;
    }

    private XMLGregorianCalendar getCurrentDate() throws DatatypeConfigurationException {

        Date now = new Date();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(now);
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

    }
}
