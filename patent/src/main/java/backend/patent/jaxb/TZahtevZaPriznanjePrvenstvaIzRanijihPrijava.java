
package backend.patent.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TZahtevZaPriznanjePrvenstvaIzRanijihPrijava complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TZahtevZaPriznanjePrvenstvaIzRanijihPrijava">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datum_podnosenje_ranije_prijave" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="broj_ranije_prijave">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="P-[0-9]{6}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="dvoslovna_oznaka_drzave_ili_organizacije">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="2"/>
 *               &lt;whiteSpace value="preserve"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TZahtevZaPriznanjePrvenstvaIzRanijihPrijava", namespace = "http://www.foolstech.com/p1", propOrder = {
    "datumPodnosenjeRanijePrijave",
    "brojRanijePrijave",
    "dvoslovnaOznakaDrzaveIliOrganizacije"
})
public class TZahtevZaPriznanjePrvenstvaIzRanijihPrijava {

    @XmlElement(name = "datum_podnosenje_ranije_prijave", namespace = "http://www.foolstech.com/p1", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPodnosenjeRanijePrijave;
    @XmlElement(name = "broj_ranije_prijave", namespace = "http://www.foolstech.com/p1", required = true)
    protected String brojRanijePrijave;
    @XmlElement(name = "dvoslovna_oznaka_drzave_ili_organizacije", namespace = "http://www.foolstech.com/p1", required = true)
    protected String dvoslovnaOznakaDrzaveIliOrganizacije;

    /**
     * Gets the value of the datumPodnosenjeRanijePrijave property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumPodnosenjeRanijePrijave() {
        return datumPodnosenjeRanijePrijave;
    }

    /**
     * Sets the value of the datumPodnosenjeRanijePrijave property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumPodnosenjeRanijePrijave(XMLGregorianCalendar value) {
        this.datumPodnosenjeRanijePrijave = value;
    }

    /**
     * Gets the value of the brojRanijePrijave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojRanijePrijave() {
        return brojRanijePrijave;
    }

    /**
     * Sets the value of the brojRanijePrijave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojRanijePrijave(String value) {
        this.brojRanijePrijave = value;
    }

    /**
     * Gets the value of the dvoslovnaOznakaDrzaveIliOrganizacije property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDvoslovnaOznakaDrzaveIliOrganizacije() {
        return dvoslovnaOznakaDrzaveIliOrganizacije;
    }

    /**
     * Sets the value of the dvoslovnaOznakaDrzaveIliOrganizacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDvoslovnaOznakaDrzaveIliOrganizacije(String value) {
        this.dvoslovnaOznakaDrzaveIliOrganizacije = value;
    }

}
