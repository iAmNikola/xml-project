
package backend.patent.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="naziv_pronalaska">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="naziv_na_srpskom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="naziv_na_engleskom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="podnosilac">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.foolstech.com/p1}TOsoba">
 *                 &lt;attribute name="je_pronalazac" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="drzavljanstvo">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;pattern value="[A-Za-z ]+"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="pronalazac">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.foolstech.com/p1}TOsoba">
 *                 &lt;attribute name="ne_zeli_da_bude_naveden" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="punomocnik">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.foolstech.com/p1}TOsoba">
 *                 &lt;attribute name="vrsta_punomocnika">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;pattern value="zastupanje|prijem"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="je_zajednicki_predstavnik" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="adresa_za_dostavljanje" type="{http://www.foolstech.com/p1}TAdresa"/>
 *         &lt;element name="nacin_dostavljanja">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="saglasnost_za_dostavljanje_u_elektronskoj_formi" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="saglasnost_za_dostavljanje_u_papirnoj_formi" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="prijava">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="dopunska_prijava" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="izdvojena_prijava" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="broj_prvobitne_prijave" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;pattern value="P-[0-9]{6}"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="datum_podnosenja_prvobitne_prijave" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="zahtevi_za_priznanje_prvenstva_iz_ranijih_prijava">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="zahtev" type="{http://www.foolstech.com/p1}TZahtevZaPriznanjePrvenstvaIzRanijihPrijava" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="broj_prijave">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="P-[0-9]{6}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="datum_prijema" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="datum_podnosenja" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nazivPronalaska",
    "podnosilac",
    "pronalazac",
    "punomocnik",
    "adresaZaDostavljanje",
    "nacinDostavljanja",
    "prijava",
    "zahteviZaPriznanjePrvenstvaIzRanijihPrijava"
})
@XmlRootElement(name = "zahtev_za_priznanje_patenta", namespace = "http://www.foolstech.com/p1")
public class ZahtevZaPriznanjePatenta {

    @XmlElement(name = "naziv_pronalaska", namespace = "http://www.foolstech.com/p1", required = true)
    protected NazivPronalaska nazivPronalaska;
    @XmlElement(namespace = "http://www.foolstech.com/p1", required = true)
    protected Podnosilac podnosilac;
    @XmlElement(namespace = "http://www.foolstech.com/p1", required = true)
    protected Pronalazac pronalazac;
    @XmlElement(namespace = "http://www.foolstech.com/p1", required = true)
    protected Punomocnik punomocnik;
    @XmlElement(name = "adresa_za_dostavljanje", namespace = "http://www.foolstech.com/p1", required = true)
    protected TAdresa adresaZaDostavljanje;
    @XmlElement(name = "nacin_dostavljanja", namespace = "http://www.foolstech.com/p1", required = true)
    protected NacinDostavljanja nacinDostavljanja;
    @XmlElement(namespace = "http://www.foolstech.com/p1", required = true)
    protected Prijava prijava;
    @XmlElement(name = "zahtevi_za_priznanje_prvenstva_iz_ranijih_prijava", namespace = "http://www.foolstech.com/p1", required = true)
    protected ZahteviZaPriznanjePrvenstvaIzRanijihPrijava zahteviZaPriznanjePrvenstvaIzRanijihPrijava;
    @XmlAttribute(name = "broj_prijave")
    protected String brojPrijave;
    @XmlAttribute(name = "datum_prijema")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPrijema;
    @XmlAttribute(name = "datum_podnosenja")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPodnosenja;

    /**
     * Gets the value of the nazivPronalaska property.
     * 
     * @return
     *     possible object is
     *     {@link NazivPronalaska }
     *     
     */
    public NazivPronalaska getNazivPronalaska() {
        return nazivPronalaska;
    }

    /**
     * Sets the value of the nazivPronalaska property.
     * 
     * @param value
     *     allowed object is
     *     {@link NazivPronalaska }
     *     
     */
    public void setNazivPronalaska(NazivPronalaska value) {
        this.nazivPronalaska = value;
    }

    /**
     * Gets the value of the podnosilac property.
     * 
     * @return
     *     possible object is
     *     {@link Podnosilac }
     *     
     */
    public Podnosilac getPodnosilac() {
        return podnosilac;
    }

    /**
     * Sets the value of the podnosilac property.
     * 
     * @param value
     *     allowed object is
     *     {@link Podnosilac }
     *     
     */
    public void setPodnosilac(Podnosilac value) {
        this.podnosilac = value;
    }

    /**
     * Gets the value of the pronalazac property.
     * 
     * @return
     *     possible object is
     *     {@link Pronalazac }
     *     
     */
    public Pronalazac getPronalazac() {
        return pronalazac;
    }

    /**
     * Sets the value of the pronalazac property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pronalazac }
     *     
     */
    public void setPronalazac(Pronalazac value) {
        this.pronalazac = value;
    }

    /**
     * Gets the value of the punomocnik property.
     * 
     * @return
     *     possible object is
     *     {@link Punomocnik }
     *     
     */
    public Punomocnik getPunomocnik() {
        return punomocnik;
    }

    /**
     * Sets the value of the punomocnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Punomocnik }
     *     
     */
    public void setPunomocnik(Punomocnik value) {
        this.punomocnik = value;
    }

    /**
     * Gets the value of the adresaZaDostavljanje property.
     * 
     * @return
     *     possible object is
     *     {@link TAdresa }
     *     
     */
    public TAdresa getAdresaZaDostavljanje() {
        return adresaZaDostavljanje;
    }

    /**
     * Sets the value of the adresaZaDostavljanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAdresa }
     *     
     */
    public void setAdresaZaDostavljanje(TAdresa value) {
        this.adresaZaDostavljanje = value;
    }

    /**
     * Gets the value of the nacinDostavljanja property.
     * 
     * @return
     *     possible object is
     *     {@link NacinDostavljanja }
     *     
     */
    public NacinDostavljanja getNacinDostavljanja() {
        return nacinDostavljanja;
    }

    /**
     * Sets the value of the nacinDostavljanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link NacinDostavljanja }
     *     
     */
    public void setNacinDostavljanja(NacinDostavljanja value) {
        this.nacinDostavljanja = value;
    }

    /**
     * Gets the value of the prijava property.
     * 
     * @return
     *     possible object is
     *     {@link Prijava }
     *     
     */
    public Prijava getPrijava() {
        return prijava;
    }

    /**
     * Sets the value of the prijava property.
     * 
     * @param value
     *     allowed object is
     *     {@link Prijava }
     *     
     */
    public void setPrijava(Prijava value) {
        this.prijava = value;
    }

    /**
     * Gets the value of the zahteviZaPriznanjePrvenstvaIzRanijihPrijava property.
     * 
     * @return
     *     possible object is
     *     {@link ZahteviZaPriznanjePrvenstvaIzRanijihPrijava }
     *     
     */
    public ZahteviZaPriznanjePrvenstvaIzRanijihPrijava getZahteviZaPriznanjePrvenstvaIzRanijihPrijava() {
        return zahteviZaPriznanjePrvenstvaIzRanijihPrijava;
    }

    /**
     * Sets the value of the zahteviZaPriznanjePrvenstvaIzRanijihPrijava property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahteviZaPriznanjePrvenstvaIzRanijihPrijava }
     *     
     */
    public void setZahteviZaPriznanjePrvenstvaIzRanijihPrijava(ZahteviZaPriznanjePrvenstvaIzRanijihPrijava value) {
        this.zahteviZaPriznanjePrvenstvaIzRanijihPrijava = value;
    }

    /**
     * Gets the value of the brojPrijave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojPrijave() {
        return brojPrijave;
    }

    /**
     * Sets the value of the brojPrijave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojPrijave(String value) {
        this.brojPrijave = value;
    }

    /**
     * Gets the value of the datumPrijema property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumPrijema() {
        return datumPrijema;
    }

    /**
     * Sets the value of the datumPrijema property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumPrijema(XMLGregorianCalendar value) {
        this.datumPrijema = value;
    }

    /**
     * Gets the value of the datumPodnosenja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumPodnosenja() {
        return datumPodnosenja;
    }

    /**
     * Sets the value of the datumPodnosenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumPodnosenja(XMLGregorianCalendar value) {
        this.datumPodnosenja = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="saglasnost_za_dostavljanje_u_elektronskoj_formi" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;element name="saglasnost_za_dostavljanje_u_papirnoj_formi" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "saglasnostZaDostavljanjeUElektronskojFormi",
        "saglasnostZaDostavljanjeUPapirnojFormi"
    })
    public static class NacinDostavljanja {

        @XmlElement(name = "saglasnost_za_dostavljanje_u_elektronskoj_formi", namespace = "http://www.foolstech.com/p1")
        protected boolean saglasnostZaDostavljanjeUElektronskojFormi;
        @XmlElement(name = "saglasnost_za_dostavljanje_u_papirnoj_formi", namespace = "http://www.foolstech.com/p1")
        protected boolean saglasnostZaDostavljanjeUPapirnojFormi;

        /**
         * Gets the value of the saglasnostZaDostavljanjeUElektronskojFormi property.
         * 
         */
        public boolean isSaglasnostZaDostavljanjeUElektronskojFormi() {
            return saglasnostZaDostavljanjeUElektronskojFormi;
        }

        /**
         * Sets the value of the saglasnostZaDostavljanjeUElektronskojFormi property.
         * 
         */
        public void setSaglasnostZaDostavljanjeUElektronskojFormi(boolean value) {
            this.saglasnostZaDostavljanjeUElektronskojFormi = value;
        }

        /**
         * Gets the value of the saglasnostZaDostavljanjeUPapirnojFormi property.
         * 
         */
        public boolean isSaglasnostZaDostavljanjeUPapirnojFormi() {
            return saglasnostZaDostavljanjeUPapirnojFormi;
        }

        /**
         * Sets the value of the saglasnostZaDostavljanjeUPapirnojFormi property.
         * 
         */
        public void setSaglasnostZaDostavljanjeUPapirnojFormi(boolean value) {
            this.saglasnostZaDostavljanjeUPapirnojFormi = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="naziv_na_srpskom" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="naziv_na_engleskom" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nazivNaSrpskom",
        "nazivNaEngleskom"
    })
    public static class NazivPronalaska {

        @XmlElement(name = "naziv_na_srpskom", namespace = "http://www.foolstech.com/p1", required = true)
        protected String nazivNaSrpskom;
        @XmlElement(name = "naziv_na_engleskom", namespace = "http://www.foolstech.com/p1", required = true)
        protected String nazivNaEngleskom;

        /**
         * Gets the value of the nazivNaSrpskom property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNazivNaSrpskom() {
            return nazivNaSrpskom;
        }

        /**
         * Sets the value of the nazivNaSrpskom property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNazivNaSrpskom(String value) {
            this.nazivNaSrpskom = value;
        }

        /**
         * Gets the value of the nazivNaEngleskom property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNazivNaEngleskom() {
            return nazivNaEngleskom;
        }

        /**
         * Sets the value of the nazivNaEngleskom property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNazivNaEngleskom(String value) {
            this.nazivNaEngleskom = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.foolstech.com/p1}TOsoba">
     *       &lt;attribute name="je_pronalazac" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="drzavljanstvo">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;pattern value="[A-Za-z ]+"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Podnosilac
        extends TOsoba
    {

        @XmlAttribute(name = "je_pronalazac")
        protected Boolean jePronalazac;
        @XmlAttribute(name = "drzavljanstvo")
        protected String drzavljanstvo;

        /**
         * Gets the value of the jePronalazac property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isJePronalazac() {
            return jePronalazac;
        }

        /**
         * Sets the value of the jePronalazac property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setJePronalazac(Boolean value) {
            this.jePronalazac = value;
        }

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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="dopunska_prijava" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;element name="izdvojena_prijava" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;element name="broj_prvobitne_prijave" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;pattern value="P-[0-9]{6}"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="datum_podnosenja_prvobitne_prijave" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dopunskaPrijava",
        "izdvojenaPrijava",
        "brojPrvobitnePrijave",
        "datumPodnosenjaPrvobitnePrijave"
    })
    public static class Prijava {

        @XmlElement(name = "dopunska_prijava", namespace = "http://www.foolstech.com/p1")
        protected boolean dopunskaPrijava;
        @XmlElement(name = "izdvojena_prijava", namespace = "http://www.foolstech.com/p1")
        protected boolean izdvojenaPrijava;
        @XmlElement(name = "broj_prvobitne_prijave", namespace = "http://www.foolstech.com/p1")
        protected String brojPrvobitnePrijave;
        @XmlElement(name = "datum_podnosenja_prvobitne_prijave", namespace = "http://www.foolstech.com/p1")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datumPodnosenjaPrvobitnePrijave;

        /**
         * Gets the value of the dopunskaPrijava property.
         * 
         */
        public boolean isDopunskaPrijava() {
            return dopunskaPrijava;
        }

        /**
         * Sets the value of the dopunskaPrijava property.
         * 
         */
        public void setDopunskaPrijava(boolean value) {
            this.dopunskaPrijava = value;
        }

        /**
         * Gets the value of the izdvojenaPrijava property.
         * 
         */
        public boolean isIzdvojenaPrijava() {
            return izdvojenaPrijava;
        }

        /**
         * Sets the value of the izdvojenaPrijava property.
         * 
         */
        public void setIzdvojenaPrijava(boolean value) {
            this.izdvojenaPrijava = value;
        }

        /**
         * Gets the value of the brojPrvobitnePrijave property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBrojPrvobitnePrijave() {
            return brojPrvobitnePrijave;
        }

        /**
         * Sets the value of the brojPrvobitnePrijave property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBrojPrvobitnePrijave(String value) {
            this.brojPrvobitnePrijave = value;
        }

        /**
         * Gets the value of the datumPodnosenjaPrvobitnePrijave property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDatumPodnosenjaPrvobitnePrijave() {
            return datumPodnosenjaPrvobitnePrijave;
        }

        /**
         * Sets the value of the datumPodnosenjaPrvobitnePrijave property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatumPodnosenjaPrvobitnePrijave(XMLGregorianCalendar value) {
            this.datumPodnosenjaPrvobitnePrijave = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.foolstech.com/p1}TOsoba">
     *       &lt;attribute name="ne_zeli_da_bude_naveden" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Pronalazac
        extends TOsoba
    {

        @XmlAttribute(name = "ne_zeli_da_bude_naveden")
        protected Boolean neZeliDaBudeNaveden;

        /**
         * Gets the value of the neZeliDaBudeNaveden property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNeZeliDaBudeNaveden() {
            return neZeliDaBudeNaveden;
        }

        /**
         * Sets the value of the neZeliDaBudeNaveden property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNeZeliDaBudeNaveden(Boolean value) {
            this.neZeliDaBudeNaveden = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.foolstech.com/p1}TOsoba">
     *       &lt;attribute name="vrsta_punomocnika">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;pattern value="zastupanje|prijem"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="je_zajednicki_predstavnik" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Punomocnik
        extends TOsoba
    {

        @XmlAttribute(name = "vrsta_punomocnika")
        protected String vrstaPunomocnika;
        @XmlAttribute(name = "je_zajednicki_predstavnik")
        protected Boolean jeZajednickiPredstavnik;

        /**
         * Gets the value of the vrstaPunomocnika property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVrstaPunomocnika() {
            return vrstaPunomocnika;
        }

        /**
         * Sets the value of the vrstaPunomocnika property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVrstaPunomocnika(String value) {
            this.vrstaPunomocnika = value;
        }

        /**
         * Gets the value of the jeZajednickiPredstavnik property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isJeZajednickiPredstavnik() {
            return jeZajednickiPredstavnik;
        }

        /**
         * Sets the value of the jeZajednickiPredstavnik property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setJeZajednickiPredstavnik(Boolean value) {
            this.jeZajednickiPredstavnik = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="zahtev" type="{http://www.foolstech.com/p1}TZahtevZaPriznanjePrvenstvaIzRanijihPrijava" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "zahtev"
    })
    public static class ZahteviZaPriznanjePrvenstvaIzRanijihPrijava {

        @XmlElement(namespace = "http://www.foolstech.com/p1")
        protected List<TZahtevZaPriznanjePrvenstvaIzRanijihPrijava> zahtev;

        /**
         * Gets the value of the zahtev property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the zahtev property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getZahtev().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TZahtevZaPriznanjePrvenstvaIzRanijihPrijava }
         * 
         * 
         */
        public List<TZahtevZaPriznanjePrvenstvaIzRanijihPrijava> getZahtev() {
            if (zahtev == null) {
                zahtev = new ArrayList<TZahtevZaPriznanjePrvenstvaIzRanijihPrijava>();
            }
            return this.zahtev;
        }

    }

}
