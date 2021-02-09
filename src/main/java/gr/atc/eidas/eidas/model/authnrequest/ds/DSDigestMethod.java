package gr.atc.eidas.eidas.model.authnrequest.ds;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DSDigestMethod {

  @JacksonXmlProperty(localName = "Algorithm", isAttribute = true)
  private String attrAlgorithm = "http://www.w3.org/2000/09/xmldsig#sha1";

  public String getAttrAlgorithm() {
    return attrAlgorithm;
  }

  public void setAttrAlgorithm(String attrAlgorithm) {
    this.attrAlgorithm = attrAlgorithm;
  }
}
