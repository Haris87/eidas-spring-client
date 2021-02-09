package gr.atc.eidas.eidas.model.authnrequest.saml2p;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class SAML2PNameIDPolicy {

  @JacksonXmlProperty(localName = "AllowCreate", isAttribute = true)
  private Boolean attrAllowCreate = true;

  @JacksonXmlProperty(localName = "Format", isAttribute = true)
  private String attrFormat = "urn:oasis:names:tc:SAML:2.0:nameid-format:persistent";

  public Boolean getAttrAllowCreate() {
    return attrAllowCreate;
  }

  public void setAttrAllowCreate(Boolean attrAllowCreate) {
    this.attrAllowCreate = attrAllowCreate;
  }

  public String getAttrFormat() {
    return attrFormat;
  }

  public void setAttrFormat(String attrFormat) {
    this.attrFormat = attrFormat;
  }
}
