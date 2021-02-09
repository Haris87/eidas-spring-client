package gr.atc.eidas.eidas.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@JacksonXmlRootElement(localName = "saml2p:AuthnRequest")
public class SAML2PAuthnRequest {

  @JacksonXmlProperty(localName = "Destination", isAttribute = true)
  private final String attrDestination = "https://eidas-service.eu/post";

  @JacksonXmlProperty(localName = "ID", isAttribute = true)
  private final String attrID = "_171ccc6b39b1e8f6e762c2e4ee4ded3a";

  @JacksonXmlProperty(localName = "IssueInstant", isAttribute = true)
  private final String attrIssueInstant = "2021-04-30T19:25:14.273Z";

  @JacksonXmlProperty(localName = "Version", isAttribute = true)
  private final String attrVersion = "2.0";

  @JacksonXmlProperty(localName = "xmlns:saml2p", isAttribute = true)
  private final String attrSAML2P = "urn:oasis:names:tc:SAML:2.0:protocol";

  @JacksonXmlProperty(localName = "xmlns:eidas", isAttribute = true)
  private final String attrEIDAS = "http://eidas.europa.eu/saml-extensions";

  @JacksonXmlProperty(localName = "saml2:Issuer")
  private SAML2Issuer issuer = new SAML2Issuer();

  @JacksonXmlProperty(localName = "ds:Signature")
  private DSSignature signature = new DSSignature();

  public DSSignature getSignature() {
    return signature;
  }

  public void setSignature(DSSignature signature) {
    this.signature = signature;
  }

  public String getAttrDestination() {
    return attrDestination;
  }

  public String getAttrID() {
    return attrID;
  }

  public String getAttrIssueInstant() {
    return attrIssueInstant;
  }

  public String getAttrVersion() {
    return attrVersion;
  }

  public String getAttrSAML2P() {
    return attrSAML2P;
  }

  public String getAttrEIDAS() {
    return attrEIDAS;
  }

  public SAML2Issuer getIssuer() {
    return issuer;
  }

  public void setIssuer(SAML2Issuer issuer) {
    this.issuer = issuer;
  }


  public String serializeToXML() throws JsonProcessingException {
    XmlMapper xmlMapper = new XmlMapper();
    String xmlString = xmlMapper
        .writeValueAsString(this);
    return xmlString;
  }

  public void writeToFile(File xmlOutput) throws IOException {
    FileWriter fileWriter = new FileWriter(xmlOutput);
    fileWriter.write(this.serializeToXML());
    fileWriter.close();
  }
}
