package backend.patent.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class PodnosilacDto {
    @XmlAttribute(name = "jePronalazac")
    public Boolean jePronalazac;
    @XmlAttribute(name = "drzavljanstvo")
    public String drzavljanstvo;
    @XmlElement(name = "ime")
    public String ime;
    @XmlElement(name = "adresa")
    public AdresaDto adresa;
    @XmlElement(name = "kontakt")
    public KontaktDto kontakt;
}
