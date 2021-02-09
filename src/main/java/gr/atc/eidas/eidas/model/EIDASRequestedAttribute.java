package gr.atc.eidas.eidas.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EIDASRequestedAttribute {

  @JacksonXmlProperty(localName = "Name", isAttribute = true)
  private String attrName = "http://eidas.europa.eu/attributes/naturalperson/PersonIdentifier";

  @JacksonXmlProperty(localName = "NameFormat", isAttribute = true)
  private String attrNameFormat = "urn:oasis:names:tc:SAML:2.0:attrname-format:uri";

  @JacksonXmlProperty(localName = "isRequired", isAttribute = true)
  private Boolean attrIsRequired = true;

  public String getAttrName() {
    return attrName;
  }

  public void setAttrName(String attrName) {
    this.attrName = attrName;
  }

  public String getAttrNameFormat() {
    return attrNameFormat;
  }

  public void setAttrNameFormat(String attrNameFormat) {
    this.attrNameFormat = attrNameFormat;
  }

  public Boolean getAttrIsRequired() {
    return attrIsRequired;
  }

  public void setAttrIsRequired(Boolean attrIsRequired) {
    this.attrIsRequired = attrIsRequired;
  }
}
