package gr.atc.eidas.eidas.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class SAML2PRequestedAuthnContext {

  @JacksonXmlProperty(localName = "Comparison", isAttribute = true)
  private String attrComparison = "minimum";

  @JacksonXmlProperty(localName = "saml2:AuthnContextClassRef")
  SAML2AuthnContextClassRef authnContextClassRef = new SAML2AuthnContextClassRef();

  public String getAttrComparison() {
    return attrComparison;
  }

  public void setAttrComparison(String attrComparison) {
    this.attrComparison = attrComparison;
  }

  public SAML2AuthnContextClassRef getAuthnContextClassRef() {
    return authnContextClassRef;
  }

  public void setAuthnContextClassRef(
      SAML2AuthnContextClassRef authnContextClassRef) {
    this.authnContextClassRef = authnContextClassRef;
  }
}
