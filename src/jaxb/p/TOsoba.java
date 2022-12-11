
package jaxb.p;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TOsoba complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TOsoba">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="adresa" type="{http://www.foolstech.com/p1}TAdresa"/>
 *         &lt;element name="kontakt" type="{http://www.foolstech.com/p1}TKontakt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TOsoba", namespace = "http://www.foolstech.com/p1", propOrder = {
    "ime",
    "adresa",
    "kontakt"
})
@XmlSeeAlso({
    jaxb.p.ZahtevZaPriznanjePatenta.Podnosilac.class,
    jaxb.p.ZahtevZaPriznanjePatenta.Pronalazac.class,
    jaxb.p.ZahtevZaPriznanjePatenta.Punomocnik.class
})
public class TOsoba {

    @XmlElement(namespace = "http://www.foolstech.com/p1", required = true)
    protected String ime;
    @XmlElement(namespace = "http://www.foolstech.com/p1", required = true)
    protected TAdresa adresa;
    @XmlElement(namespace = "http://www.foolstech.com/p1", required = true)
    protected TKontakt kontakt;

    /**
     * Gets the value of the ime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link TAdresa }
     *     
     */
    public TAdresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAdresa }
     *     
     */
    public void setAdresa(TAdresa value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the kontakt property.
     * 
     * @return
     *     possible object is
     *     {@link TKontakt }
     *     
     */
    public TKontakt getKontakt() {
        return kontakt;
    }

    /**
     * Sets the value of the kontakt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TKontakt }
     *     
     */
    public void setKontakt(TKontakt value) {
        this.kontakt = value;
    }

}
