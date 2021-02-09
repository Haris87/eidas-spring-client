package gr.atc.eidas.eidas.model.authnrequest.ds;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DSRSAKeyValue {

  @JacksonXmlProperty(localName = "Modulus", namespace = "ds")
  private DSModulus modulus = new DSModulus();

  @JacksonXmlProperty(localName = "Exponent", namespace = "ds")
  private DSExponent exponent = new DSExponent();

}
