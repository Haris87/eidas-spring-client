package gr.atc.eidas.eidas.model.authnrequest.ds;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DSKeyValue {

  @JacksonXmlProperty(localName = "RSAKeyValue", namespace = "ds")
  private DSRSAKeyValue rsaKeyValue = new DSRSAKeyValue();

  public DSRSAKeyValue getRsaKeyValue() {
    return rsaKeyValue;
  }

  public void setRsaKeyValue(DSRSAKeyValue rsaKeyValue) {
    this.rsaKeyValue = rsaKeyValue;
  }
}
