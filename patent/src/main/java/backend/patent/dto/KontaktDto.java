package backend.patent.dto;

import javax.xml.bind.annotation.XmlElement;

public class KontaktDto {
    @XmlElement(name = "brojTelefona")
    public String brojTelefona;
    @XmlElement(name = "brojFaksa")
    public String brojFaksa;
    @XmlElement(name = "ePosta")
    public String ePosta;
}
