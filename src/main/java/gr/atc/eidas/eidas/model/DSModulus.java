package gr.atc.eidas.eidas.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class DSModulus {

  @JacksonXmlText
  private String value = "nEPz==";

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
