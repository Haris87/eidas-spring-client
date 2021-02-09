package gr.atc.eidas.eidas.model.authnrequest.eidas;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class EIDASSPType {

  @JacksonXmlText
  private String value = "public";

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
