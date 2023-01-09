<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
    xmlns:p1="http://www.foolstech.com/p1"
>
    <xsl:template match="/">
        <rdf:RDF>
            <rdf:Description rdf:about="Patent">
                <xsl:variable name="broj_prijave">
                    <xsl:value-of select="@broj_prijave" />
                </xsl:variable>
                <xsl:variable name="datum_podnosenja">
                    <xsl:value-of select="@datum_podnosenja" />
                </xsl:variable>
                <xsl:variable name="naziv_na_srpskom">
                    <xsl:value-of select="//naziv_pronalaska/naziv_na_srpskom" />
                </xsl:variable>
                <xsl:variable name="naziv_na_engleskom">
                    <xsl:value-of select="//naziv_pronalaska/naziv_na_engleskom" />
                </xsl:variable>
                <xsl:variable name="podnosilac">
                    <xsl:value-of select="//podnosilac/ime" />
                </xsl:variable>

                <p1:broj_prijave>
                    <xsl:value-of select="$broj_prijave" />
                </p1:broj_prijave>
                <p1:datum_podnosenja>
                    <xsl:value-of select="$datum_podnosenja" />
                </p1:datum_podnosenja>
                <p1:naziv_na_srpskom>
                    <xsl:value-of select="$naziv_na_srpskom" />
                </p1:naziv_na_srpskom>
                <p1:naziv_na_engleskom>
                    <xsl:value-of select="$naziv_na_engleskom" />
                </p1:naziv_na_engleskom>
                <p1:podnosilac>
                    <xsl:value-of select="$podnosilac" />
                </p1:podnosilac>
            </rdf:Description>
        </rdf:RDF>
    </xsl:template>
</xsl:stylesheet>