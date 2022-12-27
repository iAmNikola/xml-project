package backend.patent.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.datatype.XMLGregorianCalendar;

public class PrijavaDto {
    @XmlElement(name = "vrstaPrijave")
    public String vrstaPrijave;
    @XmlElement(name = "brojPrvobitnePrijave")
    public String brojPrvobitnePrijave;
    @XmlElement(name = "datumPodnosenjaPrvobitnePrijave")
    public XMLGregorianCalendar datumPodnosenjaPrvobitnePrijave;
}
