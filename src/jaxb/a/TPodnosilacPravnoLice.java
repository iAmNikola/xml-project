
package jaxb.a;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TPodnosilac_pravno_lice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPodnosilac_pravno_lice">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.foolstech.com/a1}TPodnosilac">
 *       &lt;sequence>
 *         &lt;element name="Poslovno_ime" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element ref="{http://www.foolstech.com/a1}Adresa"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPodnosilac_pravno_lice", namespace = "http://www.foolstech.com/a1", propOrder = {
    "poslovnoIme",
    "adresa"
})
public class TPodnosilacPravnoLice
    extends TPodnosilac
{

    @XmlElement(name = "Poslovno_ime", namespace = "http://www.foolstech.com/a1", required = true)
    protected Object poslovnoIme;
    @XmlElement(name = "Adresa", namespace = "http://www.foolstech.com/a1", required = true)
    protected Adresa adresa;

    /**
     * Gets the value of the poslovnoIme property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getPoslovnoIme() {
        return poslovnoIme;
    }

    /**
     * Sets the value of the poslovnoIme property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setPoslovnoIme(Object value) {
        this.poslovnoIme = value;
    }

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link Adresa }
     *     
     */
    public Adresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Adresa }
     *     
     */
    public void setAdresa(Adresa value) {
        this.adresa = value;
    }

}
