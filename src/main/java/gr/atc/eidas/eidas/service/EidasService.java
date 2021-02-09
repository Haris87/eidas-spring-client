package gr.atc.eidas.eidas.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import gr.atc.eidas.eidas.model.EIDASAuthnRequest;
import org.springframework.stereotype.Service;

@Service
public class EidasService {

  public void testSendRequest() throws JsonProcessingException {

    EIDASAuthnRequest request = new EIDASAuthnRequest();
    System.out.println(request.serializeToXML());
  }
}
