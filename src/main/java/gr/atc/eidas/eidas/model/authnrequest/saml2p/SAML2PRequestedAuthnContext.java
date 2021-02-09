package gr.atc.eidas.eidas.model.authnrequest.saml2p;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import gr.atc.eidas.eidas.model.authnrequest.saml2.SAML2AuthnContextClassRef;

public class SAML2PRequestedAuthnContext {

  @JacksonXmlProperty(localName = "Comparison", isAttribute = true)
  private String attrComparison = "minimum";

  @JacksonXmlProperty(localName = "AuthnContextClassRef", namespace = "saml2")
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
