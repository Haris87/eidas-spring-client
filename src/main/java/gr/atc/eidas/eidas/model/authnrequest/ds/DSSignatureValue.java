package gr.atc.eidas.eidas.model.authnrequest.ds;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class DSSignatureValue {

  @JacksonXmlText
  private String value = "SaO8==";

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
