package gr.atc.eidas.eidas.model.authnrequest.ds;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DSSignedInfo {

  @JacksonXmlProperty(localName = "CanonicalizationMethod", namespace = "ds")
  DSCanonicalizationMethod canonicalizationMethod = new DSCanonicalizationMethod();

  @JacksonXmlProperty(localName = "SignatureMethod", namespace = "ds")
  DSSignatureMethod signatureMethod = new DSSignatureMethod();

  @JacksonXmlProperty(localName = "Reference", namespace = "ds")
  DSReference reference = new DSReference();
}
