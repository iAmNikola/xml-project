
package jaxb.a;

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
 *         &lt;element name="Podnosilac" type="{http://www.foolstech.com/a1}TPodnosilac"/>
 *         &lt;element name="Pseudonim_autora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Punomocnik" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.foolstech.com/a1}TPuno_ime">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.foolstech.com/a1}Adresa"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Naslov">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Podaci_o_delu_na_kome_se_zasnova_autorsko_delo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Naslov_autorskog_dela">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="200"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Autor" type="{http://www.foolstech.com/a1}TAutor"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Vrsta_autorskog_dela">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Forma_zapisa_autorskog_dela">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Podaci_o_autoru" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="Autor" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://www.foolstech.com/a1}TAutor">
 *                           &lt;sequence>
 *                             &lt;element name="Drzavljanstvo" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;minLength value="1"/>
 *                                   &lt;maxLength value="100"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Anoniman_autor" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Autorsko_delo_je_stvoreno_u_radnom_odnosu" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Nacin_koriscenja_autorskog_dela" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Autorsko_delo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="file" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="broj_prijave" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="(A-)[0-9]+"/>
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
    "podnosilac",
    "pseudonimAutora",
    "punomocnik",
    "naslov",
    "podaciODeluNaKomeSeZasnovaAutorskoDelo",
    "vrstaAutorskogDela",
    "formaZapisaAutorskogDela",
    "podaciOAutoru",
    "autorskoDeloJeStvorenoURadnomOdnosu",
    "nacinKoriscenjaAutorskogDela",
    "autorskoDelo"
})
@XmlRootElement(name = "Zahtev_za_unosenje_u_evidenciju_i_deponovanje_autorskih_dela", namespace = "http://www.foolstech.com/a1")
public class ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela {

    @XmlElement(name = "Podnosilac", namespace = "http://www.foolstech.com/a1", required = true)
    protected TPodnosilac podnosilac;
    @XmlElement(name = "Pseudonim_autora", namespace = "http://www.foolstech.com/a1")
    protected String pseudonimAutora;
    @XmlElement(name = "Punomocnik", namespace = "http://www.foolstech.com/a1")
    protected ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.Punomocnik punomocnik;
    @XmlElement(name = "Naslov", namespace = "http://www.foolstech.com/a1", required = true)
    protected String naslov;
    @XmlElement(name = "Podaci_o_delu_na_kome_se_zasnova_autorsko_delo", namespace = "http://www.foolstech.com/a1")
    protected ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.PodaciODeluNaKomeSeZasnovaAutorskoDelo podaciODeluNaKomeSeZasnovaAutorskoDelo;
    @XmlElement(name = "Vrsta_autorskog_dela", namespace = "http://www.foolstech.com/a1", required = true)
    protected String vrstaAutorskogDela;
    @XmlElement(name = "Forma_zapisa_autorskog_dela", namespace = "http://www.foolstech.com/a1", required = true)
    protected String formaZapisaAutorskogDela;
    @XmlElement(name = "Podaci_o_autoru", namespace = "http://www.foolstech.com/a1")
    protected ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.PodaciOAutoru podaciOAutoru;
    @XmlElement(name = "Autorsko_delo_je_stvoreno_u_radnom_odnosu", namespace = "http://www.foolstech.com/a1", defaultValue = "false")
    protected boolean autorskoDeloJeStvorenoURadnomOdnosu;
    @XmlElement(name = "Nacin_koriscenja_autorskog_dela", namespace = "http://www.foolstech.com/a1")
    protected String nacinKoriscenjaAutorskogDela;
    @XmlElement(name = "Autorsko_delo", namespace = "http://www.foolstech.com/a1", required = true)
    protected ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.AutorskoDelo autorskoDelo;
    @XmlAttribute(name = "broj_prijave", required = true)
    protected String brojPrijave;
    @XmlAttribute(name = "datum_podnosenja", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPodnosenja;

    /**
     * Gets the value of the podnosilac property.
     * 
     * @return
     *     possible object is
     *     {@link TPodnosilac }
     *     
     */
    public TPodnosilac getPodnosilac() {
        return podnosilac;
    }

    /**
     * Sets the value of the podnosilac property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPodnosilac }
     *     
     */
    public void setPodnosilac(TPodnosilac value) {
        this.podnosilac = value;
    }

    /**
     * Gets the value of the pseudonimAutora property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPseudonimAutora() {
        return pseudonimAutora;
    }

    /**
     * Sets the value of the pseudonimAutora property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPseudonimAutora(String value) {
        this.pseudonimAutora = value;
    }

    /**
     * Gets the value of the punomocnik property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.Punomocnik }
     *     
     */
    public ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.Punomocnik getPunomocnik() {
        return punomocnik;
    }

    /**
     * Sets the value of the punomocnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.Punomocnik }
     *     
     */
    public void setPunomocnik(ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.Punomocnik value) {
        this.punomocnik = value;
    }

    /**
     * Gets the value of the naslov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaslov() {
        return naslov;
    }

    /**
     * Sets the value of the naslov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaslov(String value) {
        this.naslov = value;
    }

    /**
     * Gets the value of the podaciODeluNaKomeSeZasnovaAutorskoDelo property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.PodaciODeluNaKomeSeZasnovaAutorskoDelo }
     *     
     */
    public ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.PodaciODeluNaKomeSeZasnovaAutorskoDelo getPodaciODeluNaKomeSeZasnovaAutorskoDelo() {
        return podaciODeluNaKomeSeZasnovaAutorskoDelo;
    }

    /**
     * Sets the value of the podaciODeluNaKomeSeZasnovaAutorskoDelo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.PodaciODeluNaKomeSeZasnovaAutorskoDelo }
     *     
     */
    public void setPodaciODeluNaKomeSeZasnovaAutorskoDelo(ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.PodaciODeluNaKomeSeZasnovaAutorskoDelo value) {
        this.podaciODeluNaKomeSeZasnovaAutorskoDelo = value;
    }

    /**
     * Gets the value of the vrstaAutorskogDela property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVrstaAutorskogDela() {
        return vrstaAutorskogDela;
    }

    /**
     * Sets the value of the vrstaAutorskogDela property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVrstaAutorskogDela(String value) {
        this.vrstaAutorskogDela = value;
    }

    /**
     * Gets the value of the formaZapisaAutorskogDela property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormaZapisaAutorskogDela() {
        return formaZapisaAutorskogDela;
    }

    /**
     * Sets the value of the formaZapisaAutorskogDela property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormaZapisaAutorskogDela(String value) {
        this.formaZapisaAutorskogDela = value;
    }

    /**
     * Gets the value of the podaciOAutoru property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.PodaciOAutoru }
     *     
     */
    public ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.PodaciOAutoru getPodaciOAutoru() {
        return podaciOAutoru;
    }

    /**
     * Sets the value of the podaciOAutoru property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.PodaciOAutoru }
     *     
     */
    public void setPodaciOAutoru(ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.PodaciOAutoru value) {
        this.podaciOAutoru = value;
    }

    /**
     * Gets the value of the autorskoDeloJeStvorenoURadnomOdnosu property.
     * 
     */
    public boolean isAutorskoDeloJeStvorenoURadnomOdnosu() {
        return autorskoDeloJeStvorenoURadnomOdnosu;
    }

    /**
     * Sets the value of the autorskoDeloJeStvorenoURadnomOdnosu property.
     * 
     */
    public void setAutorskoDeloJeStvorenoURadnomOdnosu(boolean value) {
        this.autorskoDeloJeStvorenoURadnomOdnosu = value;
    }

    /**
     * Gets the value of the nacinKoriscenjaAutorskogDela property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacinKoriscenjaAutorskogDela() {
        return nacinKoriscenjaAutorskogDela;
    }

    /**
     * Sets the value of the nacinKoriscenjaAutorskogDela property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacinKoriscenjaAutorskogDela(String value) {
        this.nacinKoriscenjaAutorskogDela = value;
    }

    /**
     * Gets the value of the autorskoDelo property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.AutorskoDelo }
     *     
     */
    public ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.AutorskoDelo getAutorskoDelo() {
        return autorskoDelo;
    }

    /**
     * Sets the value of the autorskoDelo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.AutorskoDelo }
     *     
     */
    public void setAutorskoDelo(ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.AutorskoDelo value) {
        this.autorskoDelo = value;
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
     *       &lt;attribute name="file" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class AutorskoDelo {

        @XmlAttribute(name = "file", required = true)
        protected String file;

        /**
         * Gets the value of the file property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFile() {
            return file;
        }

        /**
         * Sets the value of the file property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFile(String value) {
            this.file = value;
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
     *       &lt;choice>
     *         &lt;element name="Autor" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://www.foolstech.com/a1}TAutor">
     *                 &lt;sequence>
     *                   &lt;element name="Drzavljanstvo" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="100"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Anoniman_autor" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "autor",
        "anonimanAutor"
    })
    public static class PodaciOAutoru {

        @XmlElement(name = "Autor", namespace = "http://www.foolstech.com/a1")
        protected List<ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.PodaciOAutoru.Autor> autor;
        @XmlElement(name = "Anoniman_autor", namespace = "http://www.foolstech.com/a1", defaultValue = "false")
        protected Boolean anonimanAutor;

        /**
         * Gets the value of the autor property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the autor property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAutor().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.PodaciOAutoru.Autor }
         * 
         * 
         */
        public List<ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.PodaciOAutoru.Autor> getAutor() {
            if (autor == null) {
                autor = new ArrayList<ZahtevZaUnosenjeUEvidencijuIDeponovanjeAutorskihDela.PodaciOAutoru.Autor>();
            }
            return this.autor;
        }

        /**
         * Gets the value of the anonimanAutor property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isAnonimanAutor() {
            return anonimanAutor;
        }

        /**
         * Sets the value of the anonimanAutor property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setAnonimanAutor(Boolean value) {
            this.anonimanAutor = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://www.foolstech.com/a1}TAutor">
         *       &lt;sequence>
         *         &lt;element name="Drzavljanstvo" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="100"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
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
        @XmlType(name = "", propOrder = {
            "drzavljanstvo"
        })
        public static class Autor
            extends TAutor
        {

            @XmlElement(name = "Drzavljanstvo", namespace = "http://www.foolstech.com/a1")
            protected String drzavljanstvo;

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
     *         &lt;element name="Naslov_autorskog_dela">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="200"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Autor" type="{http://www.foolstech.com/a1}TAutor"/>
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
        "naslovAutorskogDela",
        "autor"
    })
    public static class PodaciODeluNaKomeSeZasnovaAutorskoDelo {

        @XmlElement(name = "Naslov_autorskog_dela", namespace = "http://www.foolstech.com/a1", required = true)
        protected String naslovAutorskogDela;
        @XmlElement(name = "Autor", namespace = "http://www.foolstech.com/a1", required = true)
        protected TAutor autor;

        /**
         * Gets the value of the naslovAutorskogDela property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNaslovAutorskogDela() {
            return naslovAutorskogDela;
        }

        /**
         * Sets the value of the naslovAutorskogDela property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNaslovAutorskogDela(String value) {
            this.naslovAutorskogDela = value;
        }

        /**
         * Gets the value of the autor property.
         * 
         * @return
         *     possible object is
         *     {@link TAutor }
         *     
         */
        public TAutor getAutor() {
            return autor;
        }

        /**
         * Sets the value of the autor property.
         * 
         * @param value
         *     allowed object is
         *     {@link TAutor }
         *     
         */
        public void setAutor(TAutor value) {
            this.autor = value;
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
     *     &lt;extension base="{http://www.foolstech.com/a1}TPuno_ime">
     *       &lt;sequence>
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
        "adresa"
    })
    public static class Punomocnik
        extends TPunoIme
    {

        @XmlElement(name = "Adresa", namespace = "http://www.foolstech.com/a1", required = true)
        protected Adresa adresa;

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
