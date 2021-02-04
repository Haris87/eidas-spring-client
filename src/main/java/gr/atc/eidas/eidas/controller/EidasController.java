package gr.atc.eidas.eidas.controller;

import gr.atc.eidas.eidas.service.EidasService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/eidas")
public class EidasController {

  @Autowired
  private EidasService eidasService;

  @RequestMapping(value = "/request", method = RequestMethod.GET)
  public void testSendRequest(final HttpServletRequest request)
      throws Exception {
    eidasService.testSendRequest();
  }

  @RequestMapping(value = "/assertion", method = RequestMethod.GET)
  public void testAssertion(final HttpServletRequest request)
      throws Exception {
    eidasService.testAssertion();
  }

}
