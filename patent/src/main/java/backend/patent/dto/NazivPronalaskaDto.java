package backend.patent.dto;

import javax.xml.bind.annotation.XmlElement;

public class NazivPronalaskaDto {
    @XmlElement(name = "nazivNaSrpskom")
    public String nazivNaSrpskom;
    @XmlElement(name = "nazivNaEngleskom")
    public String nazivNaEngleskom;
}
