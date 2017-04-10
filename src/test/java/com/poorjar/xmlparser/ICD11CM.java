package com.poorjar.xmlparser;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Created by sgaddameedhi on 4/7/2017.
 */
@JacksonXmlRootElement(localName = "ICD10CM.tabular")
public class ICD11CM {
    @JacksonXmlProperty(localName = "chapter")
    @JacksonXmlElementWrapper(useWrapping = false)
    public Chapter1[] chapters;
}

class Chapter1 {
    @JacksonXmlProperty(localName = "name")
    public String name;

    @JacksonXmlProperty(localName = "desc")
    public String desc;

    @JacksonXmlProperty(localName = "section")
    @JacksonXmlElementWrapper(useWrapping = false)
    public Section1[] sections;

    public int synthId;
}

class Section1 {
    @JacksonXmlProperty(isAttribute = true)
    public String id;

    @JacksonXmlProperty(localName = "desc")
    public String desc;

    @JacksonXmlProperty(localName = "diag")
    @JacksonXmlElementWrapper(useWrapping = false)
    public Diag1[] diags;

    public int synthId;
}

class Diag1 {
    @JacksonXmlProperty(localName = "name")
    public String name;

    @JacksonXmlProperty(localName = "desc")
    public String desc;

    @JacksonXmlProperty(localName = "diag")
    @JacksonXmlElementWrapper(useWrapping = false)
    public Diag1[] diags;

    // Ignoring the inclusion terms for now
    // Ex. <name>A01.02</name><inclusionTerm><note>Typhoid endocarditis</note></inclusionTerm>

    public int synthId;
}

