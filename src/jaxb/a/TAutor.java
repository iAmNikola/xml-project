
package jaxb.a;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TAutor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAutor">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.foolstech.com/a1}TPuno_ime">
 *       &lt;sequence>
 *         &lt;element name="Godina_smrti" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAutor", namespace = "http://www.foolstech.com/a1", propOrder = {
    "godinaSmrti"
})
@XmlSeeAlso({
    jaxb.a.ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.PodaciOAutoru.Autor.class
})
public class TAutor
    extends TPunoIme
{

    @XmlElement(name = "Godina_smrti", namespace = "http://www.foolstech.com/a1")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger godinaSmrti;

    /**
     * Gets the value of the godinaSmrti property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGodinaSmrti() {
        return godinaSmrti;
    }

    /**
     * Sets the value of the godinaSmrti property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGodinaSmrti(BigInteger value) {
        this.godinaSmrti = value;
    }

}
