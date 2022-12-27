package backend.patent.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class PronalazacDto {
    @XmlAttribute(name = "neZeliDaBudeNaveden")
    public Boolean neZeliDaBudeNaveden;
    @XmlElement(name = "ime")
    public String ime;
    @XmlElement(name = "adresa")
    public AdresaDto adresa;
    @XmlElement(name = "kontakt")
    public KontaktDto kontakt;
}
