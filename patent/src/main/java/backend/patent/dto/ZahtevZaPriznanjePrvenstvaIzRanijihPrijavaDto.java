package backend.patent.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.datatype.XMLGregorianCalendar;

public class ZahtevZaPriznanjePrvenstvaIzRanijihPrijavaDto {
    @XmlElement(name = "datumPodnosenjeRanijePrijave")
    public XMLGregorianCalendar datumPodnosenjeRanijePrijave;
    @XmlElement(name = "brojRanijePrijave")
    public String brojRanijePrijave;
    @XmlElement(name = "dvoslovnaOznakaDrzaveIliOrganizacije")
    public String dvoslovnaOznakaDrzaveIliOrganizacije;
}
