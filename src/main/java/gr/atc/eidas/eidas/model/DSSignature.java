package gr.atc.eidas.eidas.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DSSignature {

  @JacksonXmlProperty(localName = "xmlns:ds", isAttribute = true)
  private String attrDs = "http://www.w3.org/2000/09/xmldsig#";

  @JacksonXmlProperty(localName = "ds:SignedInfo")
  private DSSignedInfo sigendInfo = new DSSignedInfo();

  @JacksonXmlProperty(localName = "ds:SignatureValue")
  private DSSignatureValue signatureValue = new DSSignatureValue();

  @JacksonXmlProperty(localName = "ds:KeyInfo")
  private DSKeyInfo keyInfo = new DSKeyInfo();

  public String getAttrDs() {
    return attrDs;
  }

  public void setAttrDs(String attrDs) {
    this.attrDs = attrDs;
  }

  public DSSignedInfo getSigendInfo() {
    return sigendInfo;
  }

  public void setSigendInfo(DSSignedInfo sigendInfo) {
    this.sigendInfo = sigendInfo;
  }

  public DSSignatureValue getSignatureValue() {
    return signatureValue;
  }

  public void setSignatureValue(DSSignatureValue signatureValue) {
    this.signatureValue = signatureValue;
  }

  public DSKeyInfo getKeyInfo() {
    return keyInfo;
  }

  public void setKeyInfo(DSKeyInfo keyInfo) {
    this.keyInfo = keyInfo;
  }
}
