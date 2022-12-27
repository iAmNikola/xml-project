package backend.patent.dto;

import javax.xml.bind.annotation.XmlElement;

public class NacinDostavljanjaDto {
    @XmlElement(name = "saglasnostZaDostavljanjeUElektronskojFormi")
    public boolean saglasnostZaDostavljanjeUElektronskojFormi;
    @XmlElement(name = "saglasnostZaDostavljanjeUPapirnojFormi")
    public boolean saglasnostZaDostavljanjeUPapirnojFormi;

}
