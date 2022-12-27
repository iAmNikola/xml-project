package backend.patent.dto;

import backend.patent.jaxb.TZahtevZaPriznanjePrvenstvaIzRanijihPrijava;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class ZahteviZaPriznanjePrvenstvaIzRanijihPrijavaDto {
    @XmlElement(name = "zahtev")
    public List<ZahtevZaPriznanjePrvenstvaIzRanijihPrijavaDto> zahtev;
}
