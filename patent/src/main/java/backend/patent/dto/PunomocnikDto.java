package backend.patent.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class PunomocnikDto {
    @XmlAttribute(name = "vrstaPunomocnika")
    public String vrstaPunomocnika;
    @XmlAttribute(name = "jeZajednickiPredstavnik")
    public Boolean jeZajednickiPredstavnik;
    @XmlElement(name = "ime")
    public String ime;
    @XmlElement(name = "adresa")
    public AdresaDto adresa;
    @XmlElement(name = "kontakt")
    public KontaktDto kontakt;
}
