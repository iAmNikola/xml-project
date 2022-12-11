
package jaxb.a;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TPodnosilac_fizicko_lice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPodnosilac_fizicko_lice">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.foolstech.com/a1}TPodnosilac">
 *       &lt;sequence>
 *         &lt;element name="Fizicko_lice">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.foolstech.com/a1}TPuno_ime">
 *                 &lt;sequence>
 *                   &lt;element name="Drzavljanstvo">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element ref="{http://www.foolstech.com/a1}Adresa"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPodnosilac_fizicko_lice", namespace = "http://www.foolstech.com/a1", propOrder = {
    "fizickoLice"
})
public class TPodnosilacFizickoLice
    extends TPodnosilac
{

    @XmlElement(name = "Fizicko_lice", namespace = "http://www.foolstech.com/a1", required = true)
    protected TPodnosilacFizickoLice.FizickoLice fizickoLice;

    /**
     * Gets the value of the fizickoLice property.
     * 
     * @return
     *     possible object is
     *     {@link TPodnosilacFizickoLice.FizickoLice }
     *     
     */
    public TPodnosilacFizickoLice.FizickoLice getFizickoLice() {
        return fizickoLice;
    }

    /**
     * Sets the value of the fizickoLice property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPodnosilacFizickoLice.FizickoLice }
     *     
     */
    public void setFizickoLice(TPodnosilacFizickoLice.FizickoLice value) {
        this.fizickoLice = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.foolstech.com/a1}TPuno_ime">
     *       &lt;sequence>
     *         &lt;element name="Drzavljanstvo">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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
    @XmlType(name = "", propOrder = {
        "drzavljanstvo",
        "adresa"
    })
    public static class FizickoLice
        extends TPunoIme
    {

        @XmlElement(name = "Drzavljanstvo", namespace = "http://www.foolstech.com/a1", required = true)
        protected String drzavljanstvo;
        @XmlElement(name = "Adresa", namespace = "http://www.foolstech.com/a1", required = true)
        protected Adresa adresa;

        /**
         * Gets the value of the drzavljanstvo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDrzavljanstvo() {
            return drzavljanstvo;
        }

        /**
         * Sets the value of the drzavljanstvo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDrzavljanstvo(String value) {
            this.drzavljanstvo = value;
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

}
