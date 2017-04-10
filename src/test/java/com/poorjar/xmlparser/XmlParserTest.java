package com.poorjar.xmlparser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by sgaddameedhi on 4/7/2017.
 */
public class XmlParserTest {

    @Test
    public void testICD10Parser() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("icd10cm_tabular_2017.xml").getPath());

        XmlMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
        mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, Boolean.FALSE);
        ICD10CM icd10CM = mapper.readValue(file, ICD10CM.class);
        System.out.println(icd10CM.toString());
    }
    @Test
    public void testICD11Parser() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("icd10cm_tabular_2017.xml").getPath());

        XmlMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
        mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, Boolean.FALSE);
        ICD11CM icd11CM = mapper.readValue(file, ICD11CM.class);
        System.out.println(icd11CM.toString());
    }
}
