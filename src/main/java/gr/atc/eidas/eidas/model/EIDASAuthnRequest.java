package gr.atc.eidas.eidas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@JacksonXmlRootElement(localName = "md:EntityDescriptor")
public class EIDASAuthnRequest {

  @JacksonXmlProperty(localName = "xmlns:md", isAttribute = true)
  private final String md = "urn:oasis:names:tc:SAML:2.0:metadata";

  @JacksonXmlProperty(localName = "xmlns:eidas", isAttribute = true)
  private final String eidas = "http://eidas.europa.eu/saml-extensions";

  @JacksonXmlProperty(localName = "xmlns:alg", isAttribute = true)
  private final String alg = "urn:oasis:names:tc:SAML:metadata:algsupport";

  @JacksonXmlProperty(localName = "ID", isAttribute = true)
  private final String id = "_9ebc8854ec7f701da9749e87a801e5f2";

  @JacksonXmlProperty(localName = "entityID", isAttribute = true)
  private final String entityID = "https://eidas-connector.eu";

  @JacksonXmlProperty(localName = "validUntil", isAttribute = true)
  private final String validUntil = "2015-05-24T19:30:26.624Z";

  @JacksonXmlProperty(localName = "saml2:issuer")
  SAMLIssuer issuer;
  /*
  <md:EntityDescriptor
    xmlns:md="urn:oasis:names:tc:SAML:2.0:metadata"
    xmlns:eidas="http://eidas.europa.eu/saml-extensions"
    xmlns:alg="urn:oasis:names:tc:SAML:metadata:algsupport"
    ID="_9ebc8854ec7f701da9749e87a801e5f2"
    entityID="https://eidas-connector.eu"
    validUntil="2015-05-24T19:30:26.624Z">
   */


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

  public String getMd() {
    return md;
  }

  public String getEidas() {
    return eidas;
  }

  public String getAlg() {
    return alg;
  }

  public String getId() {
    return id;
  }

  public String getEntityID() {
    return entityID;
  }

  public String getValidUntil() {
    return validUntil;
  }
}
