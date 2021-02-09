package gr.atc.eidas.eidas.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DSTransform {

  @JacksonXmlProperty(localName = "Algorithm", isAttribute = true)
  private String attrAlgorithm = "http://www.w3.org/2000/09/xmldsig#enveloped-signature";

  public String getAttrAlgorithm() {
    return attrAlgorithm;
  }

  public void setAttrAlgorithm(String attrAlgorithm) {
    this.attrAlgorithm = attrAlgorithm;
  }
}
