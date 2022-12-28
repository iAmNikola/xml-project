package backend.patent.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement(name = "zahtevZaPriznanjePatentaDisplayDto")
public class ZahtevZaPriznanjePatentaDisplayDto {
    @XmlAttribute(name = "brojPrijave")
    public String brojPrijave;
    @XmlAttribute(name = "datumPrijema")
    public XMLGregorianCalendar datumPrijema;
    @XmlAttribute(name = "datumPodnosenja")
    public XMLGregorianCalendar datumPodnosenja;
    @XmlElement(name = "nazivPronalaska")
    public NazivPronalaskaDto nazivPronalaska;
    @XmlElement(name = "podnosilac")
    public PodnosilacDto podnosilac;
    @XmlElement(name = "pronalazac")
    public PronalazacDto pronalazac;
    @XmlElement(name = "punomocnik")
    public PunomocnikDto punomocnik;
    @XmlElement(name = "adresaZaDostavljanje")
    public AdresaDto adresaZaDostavljanje;
    @XmlElement(name = "nacinDostavljanja")
    public NacinDostavljanjaDto nacinDostavljanja;
    @XmlElement(name = "prijava")
    public PrijavaDto prijava;
    @XmlElement(name = "zahteviZaPriznanjePrvenstvaIzRanijihPrijava")
    public ZahteviZaPriznanjePrvenstvaIzRanijihPrijavaDto zahteviZaPriznanjePrvenstvaIzRanijihPrijava;
}
