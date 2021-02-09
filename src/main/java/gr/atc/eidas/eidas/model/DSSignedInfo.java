package gr.atc.eidas.eidas.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DSSignedInfo {

  @JacksonXmlProperty(localName = "ds:CanonicalizationMethod")
  DSCanonicalizationMethod canonicalizationMethod = new DSCanonicalizationMethod();

  @JacksonXmlProperty(localName = "ds:SignatureMethod")
  DSSignatureMethod signatureMethod = new DSSignatureMethod();

  @JacksonXmlProperty(localName = "ds:Reference")
  DSReference reference = new DSReference();
}
