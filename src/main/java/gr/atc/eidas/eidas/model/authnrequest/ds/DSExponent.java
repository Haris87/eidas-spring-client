package gr.atc.eidas.eidas.model.authnrequest.ds;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class DSExponent {

  @JacksonXmlText
  private String value = "AQAB";

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
