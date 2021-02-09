package gr.atc.eidas.eidas.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import gr.atc.eidas.eidas.model.SAML2PAuthnRequest;
import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class EidasService {

  public void testSendRequest() throws JsonProcessingException {

    SAML2PAuthnRequest request = new SAML2PAuthnRequest();
    System.out.println(request.serializeToXML());
    try {
      request.writeToFile(new File("C:\\Users\\XBouchlis\\Documents\\eidas\\src\\main\\resources\\static\\test-request.xml"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
