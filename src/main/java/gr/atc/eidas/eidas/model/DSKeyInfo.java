package gr.atc.eidas.eidas.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DSKeyInfo {

  @JacksonXmlProperty(localName = "ds:KeyValue")
  private DSKeyValue keyValue = new DSKeyValue();

  public DSKeyValue getKeyValue() {
    return keyValue;
  }

  public void setKeyValue(DSKeyValue keyValue) {
    this.keyValue = keyValue;
  }
}
