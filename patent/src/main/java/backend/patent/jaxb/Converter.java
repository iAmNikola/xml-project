package backend.patent.jaxb;

import backend.patent.dto.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Converter {
    public ZahtevZaPriznanjePatenta convertFromCreationDTO(ZahtevZaPriznanjePatentaCreationDto zahtevDto) throws DatatypeConfigurationException {
        ZahtevZaPriznanjePatenta zahtev = new ZahtevZaPriznanjePatenta();

        zahtev.datumPodnosenja = getCurrentDate();

        // NazivPronalaska
        ZahtevZaPriznanjePatenta.NazivPronalaska nazivPronalaska = new ZahtevZaPriznanjePatenta.NazivPronalaska();
        nazivPronalaska.nazivNaSrpskom = zahtevDto.nazivPronalaska.nazivNaSrpskom;
        nazivPronalaska.nazivNaEngleskom = zahtevDto.nazivPronalaska.nazivNaEngleskom;
        zahtev.nazivPronalaska = nazivPronalaska;

        // Podnosilac
        ZahtevZaPriznanjePatenta.Podnosilac podnosilac = new ZahtevZaPriznanjePatenta.Podnosilac();
        podnosilac.jePronalazac = zahtevDto.podnosilac.jePronalazac;
        podnosilac.ime = zahtevDto.podnosilac.ime;
        podnosilac.drzavljanstvo = zahtevDto.podnosilac.drzavljanstvo;
        podnosilac.adresa = convertAdresaFromCreationDto(zahtevDto.podnosilac.adresa);
        podnosilac.kontakt = convertKontaktFromCreationDto(zahtevDto.podnosilac.kontakt);
        zahtev.podnosilac = podnosilac;

        // Pronalazac
        ZahtevZaPriznanjePatenta.Pronalazac pronalazac = new ZahtevZaPriznanjePatenta.Pronalazac();
        pronalazac.neZeliDaBudeNaveden = zahtevDto.pronalazac.neZeliDaBudeNaveden;
        pronalazac.ime = zahtevDto.pronalazac.ime;
        pronalazac.adresa = convertAdresaFromCreationDto(zahtevDto.pronalazac.adresa);
        pronalazac.kontakt = convertKontaktFromCreationDto(zahtevDto.pronalazac.kontakt);
        zahtev.pronalazac = pronalazac;

        // Punomocnik
        ZahtevZaPriznanjePatenta.Punomocnik punomocnik = new ZahtevZaPriznanjePatenta.Punomocnik();
        punomocnik.jeZajednickiPredstavnik = zahtevDto.punomocnik.jeZajednickiPredstavnik;
        punomocnik.vrstaPunomocnika = zahtevDto.punomocnik.vrstaPunomocnika;
        punomocnik.ime = zahtevDto.punomocnik.ime;
        punomocnik.adresa = convertAdresaFromCreationDto(zahtevDto.punomocnik.adresa);
        punomocnik.kontakt = convertKontaktFromCreationDto(zahtevDto.punomocnik.kontakt);
        zahtev.punomocnik = punomocnik;

        // Adresa za dostavljanje
        TAdresa adresaZaDostavljanje = convertAdresaFromCreationDto(zahtevDto.adresaZaDostavljanje);
        zahtev.adresaZaDostavljanje = adresaZaDostavljanje;

        // Nacin dostavljanja
        ZahtevZaPriznanjePatenta.NacinDostavljanja nacinDostavljanja = new ZahtevZaPriznanjePatenta.NacinDostavljanja();
        nacinDostavljanja.saglasnostZaDostavljanjeUElektronskojFormi = zahtevDto.nacinDostavljanja.saglasnostZaDostavljanjeUElektronskojFormi;
        nacinDostavljanja.saglasnostZaDostavljanjeUPapirnojFormi = zahtevDto.nacinDostavljanja.saglasnostZaDostavljanjeUPapirnojFormi;
        zahtev.nacinDostavljanja = nacinDostavljanja;

        // Prijava
        ZahtevZaPriznanjePatenta.Prijava prijava = new ZahtevZaPriznanjePatenta.Prijava();
        prijava.brojPrvobitnePrijave = zahtevDto.prijava.brojPrvobitnePrijave;
        prijava.datumPodnosenjaPrvobitnePrijave = zahtevDto.prijava.datumPodnosenjaPrvobitnePrijave;
        prijava.vrstaPrijave = zahtevDto.prijava.vrstaPrijave;
        zahtev.prijava = prijava;

        // Zahtevi za priznanje prvenstva iz ranijih prijava
        ZahtevZaPriznanjePatenta.ZahteviZaPriznanjePrvenstvaIzRanijihPrijava zahteviZaPrvenstvo = new ZahtevZaPriznanjePatenta.ZahteviZaPriznanjePrvenstvaIzRanijihPrijava();
        zahteviZaPrvenstvo.zahtev = new ArrayList<>();
        for (ZahtevZaPriznanjePrvenstvaIzRanijihPrijavaDto zahtevZaPrvenstvoDto: zahtevDto.zahteviZaPriznanjePrvenstvaIzRanijihPrijava.zahtev) {
            TZahtevZaPriznanjePrvenstvaIzRanijihPrijava zahtevZaPrvenstvo = new TZahtevZaPriznanjePrvenstvaIzRanijihPrijava();
            zahtevZaPrvenstvo.brojRanijePrijave = zahtevZaPrvenstvoDto.brojRanijePrijave;
            zahtevZaPrvenstvo.datumPodnosenjeRanijePrijave = zahtevZaPrvenstvoDto.datumPodnosenjeRanijePrijave;
            zahtevZaPrvenstvo.dvoslovnaOznakaDrzaveIliOrganizacije = zahtevZaPrvenstvoDto.dvoslovnaOznakaDrzaveIliOrganizacije;
            zahteviZaPrvenstvo.zahtev.add(zahtevZaPrvenstvo);
        }
        zahtev.zahteviZaPriznanjePrvenstvaIzRanijihPrijava = zahteviZaPrvenstvo;
        return zahtev;
    }

    private TAdresa convertAdresaFromCreationDto(AdresaDto adresaDto) {
        TAdresa adresa = new TAdresa();
        adresa.ulica = adresaDto.ulica;
        adresa.mesto = adresaDto.mesto;
        adresa.drzava = adresaDto.drzava;
        adresa.postanskiBroj = adresaDto.postanskiBroj;
        return adresa;
    }

    private TKontakt convertKontaktFromCreationDto(KontaktDto kontaktDto) {
        TKontakt kontakt = new TKontakt();
        kontakt.brojFaksa = kontaktDto.brojFaksa;
        kontakt.brojTelefona = kontaktDto.brojTelefona;
        kontakt.ePosta = kontaktDto.ePosta;
        return kontakt;
    }

    private XMLGregorianCalendar getCurrentDate() throws DatatypeConfigurationException {

            Date now = new Date();
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(now);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

    }

    public ZahtevZaPriznanjePatentaDisplayDto convertToDisplayDto(ZahtevZaPriznanjePatenta zahtev) {
        ZahtevZaPriznanjePatentaDisplayDto zahtevDto = new ZahtevZaPriznanjePatentaDisplayDto();

        zahtevDto.datumPodnosenja = zahtev.datumPodnosenja;
        zahtevDto.datumPrijema = zahtev.datumPrijema;
        zahtevDto.brojPrijave = zahtev.brojPrijave;

        // NazivPronalaska
        NazivPronalaskaDto nazivPronalaskaDto = new NazivPronalaskaDto();
        nazivPronalaskaDto.nazivNaSrpskom = zahtev.nazivPronalaska.nazivNaSrpskom;
        nazivPronalaskaDto.nazivNaEngleskom = zahtev.nazivPronalaska.nazivNaEngleskom;
        zahtevDto.nazivPronalaska = nazivPronalaskaDto;

        // Podnosilac
        PodnosilacDto podnosilacDto = new PodnosilacDto();
        podnosilacDto.jePronalazac = zahtev.podnosilac.jePronalazac;
        podnosilacDto.ime = zahtev.podnosilac.ime;
        podnosilacDto.drzavljanstvo = zahtev.podnosilac.drzavljanstvo;
        podnosilacDto.adresa = convertAdresaToDisplayDto(zahtev.podnosilac.adresa);
        podnosilacDto.kontakt = convertKontaktToDisplayDto(zahtev.podnosilac.kontakt);
        zahtevDto.podnosilac = podnosilacDto;

        // Pronalazac
        PronalazacDto pronalazacDto = new PronalazacDto();
        pronalazacDto.neZeliDaBudeNaveden = zahtev.pronalazac.neZeliDaBudeNaveden;
        pronalazacDto.ime = zahtev.pronalazac.ime;
        pronalazacDto.adresa = convertAdresaToDisplayDto(zahtev.pronalazac.adresa);
        pronalazacDto.kontakt = convertKontaktToDisplayDto(zahtev.pronalazac.kontakt);
        zahtevDto.pronalazac = pronalazacDto;

        // Punomocnik
        PunomocnikDto punomocnikDto = new PunomocnikDto();
        punomocnikDto.jeZajednickiPredstavnik = zahtev.punomocnik.jeZajednickiPredstavnik;
        punomocnikDto.vrstaPunomocnika = zahtev.punomocnik.vrstaPunomocnika;
        punomocnikDto.ime = zahtev.punomocnik.ime;
        punomocnikDto.adresa = convertAdresaToDisplayDto(zahtev.punomocnik.adresa);
        punomocnikDto.kontakt = convertKontaktToDisplayDto(zahtev.punomocnik.kontakt);
        zahtevDto.punomocnik = punomocnikDto;

        // Adresa za dostavljanje
        AdresaDto adresaZaDostavljanjeDto = convertAdresaToDisplayDto(zahtev.adresaZaDostavljanje);
        zahtevDto.adresaZaDostavljanje = adresaZaDostavljanjeDto;

        // Nacin dostavljanja
        NacinDostavljanjaDto nacinDostavljanjaDto = new NacinDostavljanjaDto();
        nacinDostavljanjaDto.saglasnostZaDostavljanjeUElektronskojFormi = zahtev.nacinDostavljanja.saglasnostZaDostavljanjeUElektronskojFormi;
        nacinDostavljanjaDto.saglasnostZaDostavljanjeUPapirnojFormi = zahtev.nacinDostavljanja.saglasnostZaDostavljanjeUPapirnojFormi;
        zahtevDto.nacinDostavljanja = nacinDostavljanjaDto;

        // Prijava
        PrijavaDto prijavaDto = new PrijavaDto();
        prijavaDto.brojPrvobitnePrijave = zahtev.prijava.brojPrvobitnePrijave;
        prijavaDto.datumPodnosenjaPrvobitnePrijave = zahtev.prijava.datumPodnosenjaPrvobitnePrijave;
        prijavaDto.vrstaPrijave = zahtev.prijava.vrstaPrijave;
        zahtevDto.prijava = prijavaDto;

        // Zahtevi za priznanje prvenstva iz ranijih prijava
        ZahteviZaPriznanjePrvenstvaIzRanijihPrijavaDto zahteviZaPrvenstvoDto = new ZahteviZaPriznanjePrvenstvaIzRanijihPrijavaDto();
        zahteviZaPrvenstvoDto.zahtev = new ArrayList<>();
        for (TZahtevZaPriznanjePrvenstvaIzRanijihPrijava zahtevZaPrvenstvo: zahtev.zahteviZaPriznanjePrvenstvaIzRanijihPrijava.zahtev) {
            ZahtevZaPriznanjePrvenstvaIzRanijihPrijavaDto zahtevZaPrvenstvoDto = new ZahtevZaPriznanjePrvenstvaIzRanijihPrijavaDto();
            zahtevZaPrvenstvoDto.brojRanijePrijave = zahtevZaPrvenstvo.brojRanijePrijave;
            zahtevZaPrvenstvoDto.datumPodnosenjeRanijePrijave = zahtevZaPrvenstvo.datumPodnosenjeRanijePrijave;
            zahtevZaPrvenstvoDto.dvoslovnaOznakaDrzaveIliOrganizacije = zahtevZaPrvenstvo.dvoslovnaOznakaDrzaveIliOrganizacije;
            zahteviZaPrvenstvoDto.zahtev.add(zahtevZaPrvenstvoDto);
        }
        zahtevDto.zahteviZaPriznanjePrvenstvaIzRanijihPrijava = zahteviZaPrvenstvoDto;
        return zahtevDto;
    }

    private AdresaDto convertAdresaToDisplayDto(TAdresa adresa) {
        AdresaDto adresaDto = new AdresaDto();
        adresaDto.ulica = adresa.ulica;
        adresaDto.mesto = adresa.mesto;
        adresaDto.drzava = adresa.drzava;
        adresaDto.postanskiBroj = adresa.postanskiBroj;
        return adresaDto;
    }

    private KontaktDto convertKontaktToDisplayDto(TKontakt kontakt) {
        KontaktDto kontaktDto = new KontaktDto();
        kontaktDto.brojFaksa = kontakt.brojFaksa;
        kontaktDto.brojTelefona = kontakt.brojTelefona;
        kontaktDto.ePosta = kontakt.ePosta;
        return kontaktDto;
    }

    public ArrayList<ZahtevZaPriznanjePatentaDisplayDto> convertZahtevZaPriznanjePatentaList(ArrayList<ZahtevZaPriznanjePatenta> zahtevi) {
        ArrayList<ZahtevZaPriznanjePatentaDisplayDto> dtoZahtevi =  new ArrayList<>();
        for (ZahtevZaPriznanjePatenta zahtev: zahtevi) {
            dtoZahtevi.add(convertToDisplayDto(zahtev));
        }
        return dtoZahtevi;
    }
}
