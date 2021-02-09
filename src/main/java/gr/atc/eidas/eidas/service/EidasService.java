package gr.atc.eidas.eidas.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import gr.atc.eidas.eidas.model.authnrequest.saml2p.SAML2PAuthnRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;

@Service
public class EidasService {

  public void testSendRequest() throws JsonProcessingException {

    SAML2PAuthnRequest request = new SAML2PAuthnRequest();
    System.out.println(request.serializeToXML());
    try {
      request.writeToFile(new File("C:\\Users\\XBouchlis\\Documents\\eidas\\src\\main\\resources\\static\\test-request.xml"));

      deserializeXML();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void deserializeXML(){
    try {
      XmlMapper xmlMapper = new XmlMapper();

      // read file and put contents into the string
      String readContent = new String(Files.readAllBytes(Paths.get("C:\\Users\\XBouchlis\\Documents\\eidas\\src\\main\\resources\\static\\authn-request.xml")));

      // deserialize from the XML into a Phone object
      SAML2PAuthnRequest deserializedData = xmlMapper.readValue(readContent, SAML2PAuthnRequest.class);

      // Print object details
      System.out.println("Deserialized data: ");
      System.out.println("\tID: " + deserializedData.getAttrID());
      System.out.println("\tVersion: " + deserializedData.getAttrVersion());
      System.out.println("\tIssuer: " + deserializedData.getIssuer().getIssuer());
    } catch (IOException e) {
      // handle the exception
      e.printStackTrace();
    }
  }
}
