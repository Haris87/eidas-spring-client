package gr.atc.eidas.eidas.model.authnrequest.saml2;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class SAML2Issuer {

  @JacksonXmlProperty(localName = "Format", isAttribute = true)
  private String attrFormat = "urn:oasis:names:tc:SAML:2.0:nameid-format:entity";

  @JacksonXmlProperty(localName = "saml2", isAttribute = true, namespace = "xmlns")
  private final String attrSAML2 = "urn:oasis:names:tc:SAML:2.0:assertion";

  @JacksonXmlText
  private String issuer = "https://eidas-connector.eu";

  public String getAttrFormat() {
    return attrFormat;
  }

  public void setAttrFormat(String attrFormat) {
    this.attrFormat = attrFormat;
  }

  public String getAttrSAML2() {
    return attrSAML2;
  }

  public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }
}
