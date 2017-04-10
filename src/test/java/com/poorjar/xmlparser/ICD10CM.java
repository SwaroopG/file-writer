package com.poorjar.xmlparser;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Created by sgaddameedhi on 4/7/2017.
 */
@JacksonXmlRootElement(localName = "ICD10CM.tabular")
public class ICD10CM {
    @JacksonXmlProperty(localName = "chapter")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Chapter[] chapters;

    public Chapter[] getChapters() {
        return chapters;
    }

    public void setChapters(Chapter[] chapters) {
        this.chapters = chapters;
    }
}

class Chapter {
    @JacksonXmlProperty(localName = "name")
    private String name;

    @JacksonXmlProperty(localName = "desc")
    private String desc;

    @JacksonXmlProperty(localName = "section")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Section[] sections;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Section[] getSections() {
        return sections;
    }

    public void setSections(Section[] sections) {
        this.sections = sections;
    }
}

class Section {
    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlProperty(localName = "desc")
    private String desc;

    @JacksonXmlProperty(localName = "diag")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Diag[] diags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Diag[] getDiags() {
        return diags;
    }

    public void setDiags(Diag[] diags) {
        this.diags = diags;
    }
}

class Diag {
    @JacksonXmlProperty(localName = "name")
    private String name;

    @JacksonXmlProperty(localName = "desc")
    private String desc;

    @JacksonXmlProperty(localName = "diag")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Diag[] diags;

    // Ignoring the inclusion terms for now
    // Ex. <name>A01.02</name><inclusionTerm><note>Typhoid endocarditis</note></inclusionTerm>

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Diag[] getDiags() {
        return diags;
    }

    public void setDiags(Diag[] diags) {
        this.diags = diags;
    }
}
