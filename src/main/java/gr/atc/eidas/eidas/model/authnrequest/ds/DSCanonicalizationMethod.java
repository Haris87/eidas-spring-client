package gr.atc.eidas.eidas.model.authnrequest.ds;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DSCanonicalizationMethod {

  @JacksonXmlProperty(localName = "Algorithm", isAttribute = true)
  private String attrAlgorithm = "http://www.w3.org/2001/10/xml-exc-c14n#";

  public String getAttrAlgorithm() {
    return attrAlgorithm;
  }

  public void setAttrAlgorithm(String attrAlgorithm) {
    this.attrAlgorithm = attrAlgorithm;
  }
}
