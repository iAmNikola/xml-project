
package backend.patent.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TAdresa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAdresa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ulica" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="postanski_broj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="drzava" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAdresa", namespace = "http://www.foolstech.com/p1", propOrder = {
    "ulica",
    "postanskiBroj",
    "mesto",
    "drzava"
})
public class TAdresa {

    @XmlElement(namespace = "http://www.foolstech.com/p1", required = true)
    protected String ulica;
    @XmlElement(name = "postanski_broj", namespace = "http://www.foolstech.com/p1", required = true)
    protected String postanskiBroj;
    @XmlElement(namespace = "http://www.foolstech.com/p1", required = true)
    protected String mesto;
    @XmlElement(namespace = "http://www.foolstech.com/p1")
    protected String drzava;

    /**
     * Gets the value of the ulica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUlica() {
        return ulica;
    }

    /**
     * Sets the value of the ulica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUlica(String value) {
        this.ulica = value;
    }

    /**
     * Gets the value of the postanskiBroj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostanskiBroj() {
        return postanskiBroj;
    }

    /**
     * Sets the value of the postanskiBroj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostanskiBroj(String value) {
        this.postanskiBroj = value;
    }

    /**
     * Gets the value of the mesto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMesto() {
        return mesto;
    }

    /**
     * Sets the value of the mesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMesto(String value) {
        this.mesto = value;
    }

    /**
     * Gets the value of the drzava property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrzava() {
        return drzava;
    }

    /**
     * Sets the value of the drzava property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrzava(String value) {
        this.drzava = value;
    }

}
