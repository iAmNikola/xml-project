
package jaxb.z;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
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
 *         &lt;element name="Podnosilac_prijave" type="{http://www.foolstech.com/z1}TLice"/>
 *         &lt;element name="Punomocnik" type="{http://www.foolstech.com/z1}TLice" minOccurs="0"/>
 *         &lt;element name="Zajednicki_predstavnik" type="{http://www.foolstech.com/z1}TLice" minOccurs="0"/>
 *         &lt;element name="Podaci_o_znaku">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Tip_ziga" type="{http://www.foolstech.com/z1}TTip_ziga"/>
 *                   &lt;element name="Tip_znaka" type="{http://www.foolstech.com/z1}TTip_znaka"/>
 *                   &lt;element name="Izgled_znaka" type="{http://www.foolstech.com/z1}TDokument"/>
 *                   &lt;element name="Naznacenje_boje">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Transliteracija_znaka" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Prevod_znaka" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Opis_znaka">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Zatrazeno_pravo_prvenstva_i_osnov">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Klase">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Klasa" maxOccurs="45">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                                   &lt;minInclusive value="1"/>
 *                                   &lt;maxInclusive value="45"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Podaci_o_placanju">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Osnovna_taksa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="Taksa_za_klase">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>int">
 *                           &lt;attribute name="broj_klasa">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                                 &lt;minExclusive value="1"/>
 *                                 &lt;maxExclusive value="45"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Taksa_za_graficko_resenje" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="Ukupno" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Podaci_o_zavodu">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Primerak_znaka" type="{http://www.foolstech.com/z1}TDokument"/>
 *                   &lt;element name="Spisak_robe_i_usluge">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Roba_i_usluge" type="{http://www.foolstech.com/z1}TRoba_i_usluge" maxOccurs="45"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Punomocje" type="{http://www.foolstech.com/z1}TDokument"/>
 *                   &lt;element name="Generalno_punomocije_ranije_prilozeno" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="Punomocje_ce_biti_naknadno_dostavljeno" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="Opsti_akt" type="{http://www.foolstech.com/z1}TDokument"/>
 *                   &lt;element name="Dokaz_o_pravu_prvenstva" type="{http://www.foolstech.com/z1}TDokument"/>
 *                   &lt;element name="Dokaz_o_uplati_takse" type="{http://www.foolstech.com/z1}TDokument"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="institucija" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="100"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="broj_prijave" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="(Z-)[0-9]{4}/[0-9]{2}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="datum_podnosenja" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "podnosilacPrijave",
    "punomocnik",
    "zajednickiPredstavnik",
    "podaciOZnaku",
    "podaciOPlacanju",
    "podaciOZavodu"
})
@XmlRootElement(name = "Zahtev_za_priznanje_ziga", namespace = "http://www.foolstech.com/z1")
public class ZahtevZaPriznanjeZiga {

    @XmlElement(name = "Podnosilac_prijave", namespace = "http://www.foolstech.com/z1", required = true)
    protected TLice podnosilacPrijave;
    @XmlElement(name = "Punomocnik", namespace = "http://www.foolstech.com/z1")
    protected TLice punomocnik;
    @XmlElement(name = "Zajednicki_predstavnik", namespace = "http://www.foolstech.com/z1")
    protected TLice zajednickiPredstavnik;
    @XmlElement(name = "Podaci_o_znaku", namespace = "http://www.foolstech.com/z1", required = true)
    protected ZahtevZaPriznanjeZiga.PodaciOZnaku podaciOZnaku;
    @XmlElement(name = "Podaci_o_placanju", namespace = "http://www.foolstech.com/z1", required = true)
    protected ZahtevZaPriznanjeZiga.PodaciOPlacanju podaciOPlacanju;
    @XmlElement(name = "Podaci_o_zavodu", namespace = "http://www.foolstech.com/z1", required = true)
    protected ZahtevZaPriznanjeZiga.PodaciOZavodu podaciOZavodu;
    @XmlAttribute(name = "institucija", required = true)
    protected String institucija;
    @XmlAttribute(name = "broj_prijave", required = true)
    protected String brojPrijave;
    @XmlAttribute(name = "datum_podnosenja", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPodnosenja;

    /**
     * Gets the value of the podnosilacPrijave property.
     * 
     * @return
     *     possible object is
     *     {@link TLice }
     *     
     */
    public TLice getPodnosilacPrijave() {
        return podnosilacPrijave;
    }

    /**
     * Sets the value of the podnosilacPrijave property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLice }
     *     
     */
    public void setPodnosilacPrijave(TLice value) {
        this.podnosilacPrijave = value;
    }

    /**
     * Gets the value of the punomocnik property.
     * 
     * @return
     *     possible object is
     *     {@link TLice }
     *     
     */
    public TLice getPunomocnik() {
        return punomocnik;
    }

    /**
     * Sets the value of the punomocnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLice }
     *     
     */
    public void setPunomocnik(TLice value) {
        this.punomocnik = value;
    }

    /**
     * Gets the value of the zajednickiPredstavnik property.
     * 
     * @return
     *     possible object is
     *     {@link TLice }
     *     
     */
    public TLice getZajednickiPredstavnik() {
        return zajednickiPredstavnik;
    }

    /**
     * Sets the value of the zajednickiPredstavnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLice }
     *     
     */
    public void setZajednickiPredstavnik(TLice value) {
        this.zajednickiPredstavnik = value;
    }

    /**
     * Gets the value of the podaciOZnaku property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaPriznanjeZiga.PodaciOZnaku }
     *     
     */
    public ZahtevZaPriznanjeZiga.PodaciOZnaku getPodaciOZnaku() {
        return podaciOZnaku;
    }

    /**
     * Sets the value of the podaciOZnaku property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaPriznanjeZiga.PodaciOZnaku }
     *     
     */
    public void setPodaciOZnaku(ZahtevZaPriznanjeZiga.PodaciOZnaku value) {
        this.podaciOZnaku = value;
    }

    /**
     * Gets the value of the podaciOPlacanju property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaPriznanjeZiga.PodaciOPlacanju }
     *     
     */
    public ZahtevZaPriznanjeZiga.PodaciOPlacanju getPodaciOPlacanju() {
        return podaciOPlacanju;
    }

    /**
     * Sets the value of the podaciOPlacanju property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaPriznanjeZiga.PodaciOPlacanju }
     *     
     */
    public void setPodaciOPlacanju(ZahtevZaPriznanjeZiga.PodaciOPlacanju value) {
        this.podaciOPlacanju = value;
    }

    /**
     * Gets the value of the podaciOZavodu property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaPriznanjeZiga.PodaciOZavodu }
     *     
     */
    public ZahtevZaPriznanjeZiga.PodaciOZavodu getPodaciOZavodu() {
        return podaciOZavodu;
    }

    /**
     * Sets the value of the podaciOZavodu property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaPriznanjeZiga.PodaciOZavodu }
     *     
     */
    public void setPodaciOZavodu(ZahtevZaPriznanjeZiga.PodaciOZavodu value) {
        this.podaciOZavodu = value;
    }

    /**
     * Gets the value of the institucija property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstitucija() {
        return institucija;
    }

    /**
     * Sets the value of the institucija property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstitucija(String value) {
        this.institucija = value;
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
     *         &lt;element name="Osnovna_taksa" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="Taksa_za_klase">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>int">
     *                 &lt;attribute name="broj_klasa">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *                       &lt;minExclusive value="1"/>
     *                       &lt;maxExclusive value="45"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Taksa_za_graficko_resenje" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="Ukupno" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
        "osnovnaTaksa",
        "taksaZaKlase",
        "taksaZaGrafickoResenje",
        "ukupno"
    })
    public static class PodaciOPlacanju {

        @XmlElement(name = "Osnovna_taksa", namespace = "http://www.foolstech.com/z1")
        protected int osnovnaTaksa;
        @XmlElement(name = "Taksa_za_klase", namespace = "http://www.foolstech.com/z1", required = true)
        protected ZahtevZaPriznanjeZiga.PodaciOPlacanju.TaksaZaKlase taksaZaKlase;
        @XmlElement(name = "Taksa_za_graficko_resenje", namespace = "http://www.foolstech.com/z1")
        protected int taksaZaGrafickoResenje;
        @XmlElement(name = "Ukupno", namespace = "http://www.foolstech.com/z1")
        protected int ukupno;

        /**
         * Gets the value of the osnovnaTaksa property.
         * 
         */
        public int getOsnovnaTaksa() {
            return osnovnaTaksa;
        }

        /**
         * Sets the value of the osnovnaTaksa property.
         * 
         */
        public void setOsnovnaTaksa(int value) {
            this.osnovnaTaksa = value;
        }

        /**
         * Gets the value of the taksaZaKlase property.
         * 
         * @return
         *     possible object is
         *     {@link ZahtevZaPriznanjeZiga.PodaciOPlacanju.TaksaZaKlase }
         *     
         */
        public ZahtevZaPriznanjeZiga.PodaciOPlacanju.TaksaZaKlase getTaksaZaKlase() {
            return taksaZaKlase;
        }

        /**
         * Sets the value of the taksaZaKlase property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZahtevZaPriznanjeZiga.PodaciOPlacanju.TaksaZaKlase }
         *     
         */
        public void setTaksaZaKlase(ZahtevZaPriznanjeZiga.PodaciOPlacanju.TaksaZaKlase value) {
            this.taksaZaKlase = value;
        }

        /**
         * Gets the value of the taksaZaGrafickoResenje property.
         * 
         */
        public int getTaksaZaGrafickoResenje() {
            return taksaZaGrafickoResenje;
        }

        /**
         * Sets the value of the taksaZaGrafickoResenje property.
         * 
         */
        public void setTaksaZaGrafickoResenje(int value) {
            this.taksaZaGrafickoResenje = value;
        }

        /**
         * Gets the value of the ukupno property.
         * 
         */
        public int getUkupno() {
            return ukupno;
        }

        /**
         * Sets the value of the ukupno property.
         * 
         */
        public void setUkupno(int value) {
            this.ukupno = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>int">
         *       &lt;attribute name="broj_klasa">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
         *             &lt;minExclusive value="1"/>
         *             &lt;maxExclusive value="45"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class TaksaZaKlase {

            @XmlValue
            protected int value;
            @XmlAttribute(name = "broj_klasa")
            protected Integer brojKlasa;

            /**
             * Gets the value of the value property.
             * 
             */
            public int getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             */
            public void setValue(int value) {
                this.value = value;
            }

            /**
             * Gets the value of the brojKlasa property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getBrojKlasa() {
                return brojKlasa;
            }

            /**
             * Sets the value of the brojKlasa property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setBrojKlasa(Integer value) {
                this.brojKlasa = value;
            }

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
     *         &lt;element name="Primerak_znaka" type="{http://www.foolstech.com/z1}TDokument"/>
     *         &lt;element name="Spisak_robe_i_usluge">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Roba_i_usluge" type="{http://www.foolstech.com/z1}TRoba_i_usluge" maxOccurs="45"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Punomocje" type="{http://www.foolstech.com/z1}TDokument"/>
     *         &lt;element name="Generalno_punomocije_ranije_prilozeno" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;element name="Punomocje_ce_biti_naknadno_dostavljeno" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;element name="Opsti_akt" type="{http://www.foolstech.com/z1}TDokument"/>
     *         &lt;element name="Dokaz_o_pravu_prvenstva" type="{http://www.foolstech.com/z1}TDokument"/>
     *         &lt;element name="Dokaz_o_uplati_takse" type="{http://www.foolstech.com/z1}TDokument"/>
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
        "primerakZnaka",
        "spisakRobeIUsluge",
        "punomocje",
        "generalnoPunomocijeRanijePrilozeno",
        "punomocjeCeBitiNaknadnoDostavljeno",
        "opstiAkt",
        "dokazOPravuPrvenstva",
        "dokazOUplatiTakse"
    })
    public static class PodaciOZavodu {

        @XmlElement(name = "Primerak_znaka", namespace = "http://www.foolstech.com/z1", required = true)
        protected TDokument primerakZnaka;
        @XmlElement(name = "Spisak_robe_i_usluge", namespace = "http://www.foolstech.com/z1", required = true)
        protected ZahtevZaPriznanjeZiga.PodaciOZavodu.SpisakRobeIUsluge spisakRobeIUsluge;
        @XmlElement(name = "Punomocje", namespace = "http://www.foolstech.com/z1", required = true)
        protected TDokument punomocje;
        @XmlElement(name = "Generalno_punomocije_ranije_prilozeno", namespace = "http://www.foolstech.com/z1")
        protected boolean generalnoPunomocijeRanijePrilozeno;
        @XmlElement(name = "Punomocje_ce_biti_naknadno_dostavljeno", namespace = "http://www.foolstech.com/z1")
        protected boolean punomocjeCeBitiNaknadnoDostavljeno;
        @XmlElement(name = "Opsti_akt", namespace = "http://www.foolstech.com/z1", required = true)
        protected TDokument opstiAkt;
        @XmlElement(name = "Dokaz_o_pravu_prvenstva", namespace = "http://www.foolstech.com/z1", required = true)
        protected TDokument dokazOPravuPrvenstva;
        @XmlElement(name = "Dokaz_o_uplati_takse", namespace = "http://www.foolstech.com/z1", required = true)
        protected TDokument dokazOUplatiTakse;

        /**
         * Gets the value of the primerakZnaka property.
         * 
         * @return
         *     possible object is
         *     {@link TDokument }
         *     
         */
        public TDokument getPrimerakZnaka() {
            return primerakZnaka;
        }

        /**
         * Sets the value of the primerakZnaka property.
         * 
         * @param value
         *     allowed object is
         *     {@link TDokument }
         *     
         */
        public void setPrimerakZnaka(TDokument value) {
            this.primerakZnaka = value;
        }

        /**
         * Gets the value of the spisakRobeIUsluge property.
         * 
         * @return
         *     possible object is
         *     {@link ZahtevZaPriznanjeZiga.PodaciOZavodu.SpisakRobeIUsluge }
         *     
         */
        public ZahtevZaPriznanjeZiga.PodaciOZavodu.SpisakRobeIUsluge getSpisakRobeIUsluge() {
            return spisakRobeIUsluge;
        }

        /**
         * Sets the value of the spisakRobeIUsluge property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZahtevZaPriznanjeZiga.PodaciOZavodu.SpisakRobeIUsluge }
         *     
         */
        public void setSpisakRobeIUsluge(ZahtevZaPriznanjeZiga.PodaciOZavodu.SpisakRobeIUsluge value) {
            this.spisakRobeIUsluge = value;
        }

        /**
         * Gets the value of the punomocje property.
         * 
         * @return
         *     possible object is
         *     {@link TDokument }
         *     
         */
        public TDokument getPunomocje() {
            return punomocje;
        }

        /**
         * Sets the value of the punomocje property.
         * 
         * @param value
         *     allowed object is
         *     {@link TDokument }
         *     
         */
        public void setPunomocje(TDokument value) {
            this.punomocje = value;
        }

        /**
         * Gets the value of the generalnoPunomocijeRanijePrilozeno property.
         * 
         */
        public boolean isGeneralnoPunomocijeRanijePrilozeno() {
            return generalnoPunomocijeRanijePrilozeno;
        }

        /**
         * Sets the value of the generalnoPunomocijeRanijePrilozeno property.
         * 
         */
        public void setGeneralnoPunomocijeRanijePrilozeno(boolean value) {
            this.generalnoPunomocijeRanijePrilozeno = value;
        }

        /**
         * Gets the value of the punomocjeCeBitiNaknadnoDostavljeno property.
         * 
         */
        public boolean isPunomocjeCeBitiNaknadnoDostavljeno() {
            return punomocjeCeBitiNaknadnoDostavljeno;
        }

        /**
         * Sets the value of the punomocjeCeBitiNaknadnoDostavljeno property.
         * 
         */
        public void setPunomocjeCeBitiNaknadnoDostavljeno(boolean value) {
            this.punomocjeCeBitiNaknadnoDostavljeno = value;
        }

        /**
         * Gets the value of the opstiAkt property.
         * 
         * @return
         *     possible object is
         *     {@link TDokument }
         *     
         */
        public TDokument getOpstiAkt() {
            return opstiAkt;
        }

        /**
         * Sets the value of the opstiAkt property.
         * 
         * @param value
         *     allowed object is
         *     {@link TDokument }
         *     
         */
        public void setOpstiAkt(TDokument value) {
            this.opstiAkt = value;
        }

        /**
         * Gets the value of the dokazOPravuPrvenstva property.
         * 
         * @return
         *     possible object is
         *     {@link TDokument }
         *     
         */
        public TDokument getDokazOPravuPrvenstva() {
            return dokazOPravuPrvenstva;
        }

        /**
         * Sets the value of the dokazOPravuPrvenstva property.
         * 
         * @param value
         *     allowed object is
         *     {@link TDokument }
         *     
         */
        public void setDokazOPravuPrvenstva(TDokument value) {
            this.dokazOPravuPrvenstva = value;
        }

        /**
         * Gets the value of the dokazOUplatiTakse property.
         * 
         * @return
         *     possible object is
         *     {@link TDokument }
         *     
         */
        public TDokument getDokazOUplatiTakse() {
            return dokazOUplatiTakse;
        }

        /**
         * Sets the value of the dokazOUplatiTakse property.
         * 
         * @param value
         *     allowed object is
         *     {@link TDokument }
         *     
         */
        public void setDokazOUplatiTakse(TDokument value) {
            this.dokazOUplatiTakse = value;
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
         *         &lt;element name="Roba_i_usluge" type="{http://www.foolstech.com/z1}TRoba_i_usluge" maxOccurs="45"/>
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
            "robaIUsluge"
        })
        public static class SpisakRobeIUsluge {

            @XmlElement(name = "Roba_i_usluge", namespace = "http://www.foolstech.com/z1", required = true)
            protected List<TRobaIUsluge> robaIUsluge;

            /**
             * Gets the value of the robaIUsluge property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the robaIUsluge property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getRobaIUsluge().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link TRobaIUsluge }
             * 
             * 
             */
            public List<TRobaIUsluge> getRobaIUsluge() {
                if (robaIUsluge == null) {
                    robaIUsluge = new ArrayList<TRobaIUsluge>();
                }
                return this.robaIUsluge;
            }

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
     *         &lt;element name="Tip_ziga" type="{http://www.foolstech.com/z1}TTip_ziga"/>
     *         &lt;element name="Tip_znaka" type="{http://www.foolstech.com/z1}TTip_znaka"/>
     *         &lt;element name="Izgled_znaka" type="{http://www.foolstech.com/z1}TDokument"/>
     *         &lt;element name="Naznacenje_boje">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Transliteracija_znaka" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Prevod_znaka" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Opis_znaka">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Zatrazeno_pravo_prvenstva_i_osnov">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Klase">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Klasa" maxOccurs="45">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *                         &lt;minInclusive value="1"/>
     *                         &lt;maxInclusive value="45"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
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
    @XmlType(name = "", propOrder = {
        "tipZiga",
        "tipZnaka",
        "izgledZnaka",
        "naznacenjeBoje",
        "transliteracijaZnaka",
        "prevodZnaka",
        "opisZnaka",
        "zatrazenoPravoPrvenstvaIOsnov",
        "klase"
    })
    public static class PodaciOZnaku {

        @XmlElement(name = "Tip_ziga", namespace = "http://www.foolstech.com/z1", required = true)
        protected TTipZiga tipZiga;
        @XmlElement(name = "Tip_znaka", namespace = "http://www.foolstech.com/z1", required = true)
        protected TTipZnaka tipZnaka;
        @XmlElement(name = "Izgled_znaka", namespace = "http://www.foolstech.com/z1", required = true)
        protected TDokument izgledZnaka;
        @XmlElement(name = "Naznacenje_boje", namespace = "http://www.foolstech.com/z1", required = true)
        protected String naznacenjeBoje;
        @XmlElement(name = "Transliteracija_znaka", namespace = "http://www.foolstech.com/z1")
        protected String transliteracijaZnaka;
        @XmlElement(name = "Prevod_znaka", namespace = "http://www.foolstech.com/z1")
        protected String prevodZnaka;
        @XmlElement(name = "Opis_znaka", namespace = "http://www.foolstech.com/z1", required = true)
        protected String opisZnaka;
        @XmlElement(name = "Zatrazeno_pravo_prvenstva_i_osnov", namespace = "http://www.foolstech.com/z1", required = true)
        protected String zatrazenoPravoPrvenstvaIOsnov;
        @XmlElement(name = "Klase", namespace = "http://www.foolstech.com/z1", required = true)
        protected ZahtevZaPriznanjeZiga.PodaciOZnaku.Klase klase;

        /**
         * Gets the value of the tipZiga property.
         * 
         * @return
         *     possible object is
         *     {@link TTipZiga }
         *     
         */
        public TTipZiga getTipZiga() {
            return tipZiga;
        }

        /**
         * Sets the value of the tipZiga property.
         * 
         * @param value
         *     allowed object is
         *     {@link TTipZiga }
         *     
         */
        public void setTipZiga(TTipZiga value) {
            this.tipZiga = value;
        }

        /**
         * Gets the value of the tipZnaka property.
         * 
         * @return
         *     possible object is
         *     {@link TTipZnaka }
         *     
         */
        public TTipZnaka getTipZnaka() {
            return tipZnaka;
        }

        /**
         * Sets the value of the tipZnaka property.
         * 
         * @param value
         *     allowed object is
         *     {@link TTipZnaka }
         *     
         */
        public void setTipZnaka(TTipZnaka value) {
            this.tipZnaka = value;
        }

        /**
         * Gets the value of the izgledZnaka property.
         * 
         * @return
         *     possible object is
         *     {@link TDokument }
         *     
         */
        public TDokument getIzgledZnaka() {
            return izgledZnaka;
        }

        /**
         * Sets the value of the izgledZnaka property.
         * 
         * @param value
         *     allowed object is
         *     {@link TDokument }
         *     
         */
        public void setIzgledZnaka(TDokument value) {
            this.izgledZnaka = value;
        }

        /**
         * Gets the value of the naznacenjeBoje property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNaznacenjeBoje() {
            return naznacenjeBoje;
        }

        /**
         * Sets the value of the naznacenjeBoje property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNaznacenjeBoje(String value) {
            this.naznacenjeBoje = value;
        }

        /**
         * Gets the value of the transliteracijaZnaka property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransliteracijaZnaka() {
            return transliteracijaZnaka;
        }

        /**
         * Sets the value of the transliteracijaZnaka property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransliteracijaZnaka(String value) {
            this.transliteracijaZnaka = value;
        }

        /**
         * Gets the value of the prevodZnaka property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPrevodZnaka() {
            return prevodZnaka;
        }

        /**
         * Sets the value of the prevodZnaka property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPrevodZnaka(String value) {
            this.prevodZnaka = value;
        }

        /**
         * Gets the value of the opisZnaka property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOpisZnaka() {
            return opisZnaka;
        }

        /**
         * Sets the value of the opisZnaka property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOpisZnaka(String value) {
            this.opisZnaka = value;
        }

        /**
         * Gets the value of the zatrazenoPravoPrvenstvaIOsnov property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getZatrazenoPravoPrvenstvaIOsnov() {
            return zatrazenoPravoPrvenstvaIOsnov;
        }

        /**
         * Sets the value of the zatrazenoPravoPrvenstvaIOsnov property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setZatrazenoPravoPrvenstvaIOsnov(String value) {
            this.zatrazenoPravoPrvenstvaIOsnov = value;
        }

        /**
         * Gets the value of the klase property.
         * 
         * @return
         *     possible object is
         *     {@link ZahtevZaPriznanjeZiga.PodaciOZnaku.Klase }
         *     
         */
        public ZahtevZaPriznanjeZiga.PodaciOZnaku.Klase getKlase() {
            return klase;
        }

        /**
         * Sets the value of the klase property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZahtevZaPriznanjeZiga.PodaciOZnaku.Klase }
         *     
         */
        public void setKlase(ZahtevZaPriznanjeZiga.PodaciOZnaku.Klase value) {
            this.klase = value;
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
         *         &lt;element name="Klasa" maxOccurs="45">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
         *               &lt;minInclusive value="1"/>
         *               &lt;maxInclusive value="45"/>
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
        @XmlType(name = "", propOrder = {
            "klasa"
        })
        public static class Klase {

            @XmlElement(name = "Klasa", namespace = "http://www.foolstech.com/z1", type = Integer.class)
            protected List<Integer> klasa;

            /**
             * Gets the value of the klasa property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the klasa property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getKlasa().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Integer }
             * 
             * 
             */
            public List<Integer> getKlasa() {
                if (klasa == null) {
                    klasa = new ArrayList<Integer>();
                }
                return this.klasa;
            }

        }

    }

}
