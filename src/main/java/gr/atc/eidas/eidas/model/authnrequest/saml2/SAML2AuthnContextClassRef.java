package gr.atc.eidas.eidas.model.authnrequest.saml2;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class SAML2AuthnContextClassRef {

  @JacksonXmlProperty(localName = "saml2", isAttribute = true, namespace = "xmlns")
  private String attrSAML2 = "urn:oasis:names:tc:SAML:2.0:assertion";

  @JacksonXmlText
  private String value = "http://eidas.europa.eu/LoA/high";

  public String getAttrSAML2() {
    return attrSAML2;
  }

  public void setAttrSAML2(String attrSAML2) {
    this.attrSAML2 = attrSAML2;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
