package gr.atc.eidas.eidas.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DSRSAKeyValue {

  @JacksonXmlProperty(localName = "ds:Modulus")
  private DSModulus modulus = new DSModulus();

  @JacksonXmlProperty(localName = "ds:Exponent")
  private DSExponent exponent = new DSExponent();

}
