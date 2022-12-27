package backend.patent.dto;

import javax.xml.bind.annotation.XmlElement;

public class AdresaDto {
    @XmlElement(name = "ulica")
    public String ulica;
    @XmlElement(name = "postanskiBroj")
    public String postanskiBroj;
    @XmlElement(name = "mesto")
    public String mesto;
    @XmlElement(name = "drzava")
    public String drzava;
}
