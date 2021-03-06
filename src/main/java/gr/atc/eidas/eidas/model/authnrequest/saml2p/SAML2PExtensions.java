package gr.atc.eidas.eidas.model.authnrequest.saml2p;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import gr.atc.eidas.eidas.model.authnrequest.eidas.EIDASRequestedAttribute;
import gr.atc.eidas.eidas.model.authnrequest.eidas.EIDASSPType;
import java.util.ArrayList;
import java.util.List;

public class SAML2PExtensions {

  @JacksonXmlProperty(localName = "SPType", namespace = "eidas")
  private EIDASSPType spType = new EIDASSPType();

  @JacksonXmlElementWrapper(localName = "RequestedAttributes", namespace = "eidas")
  @JacksonXmlProperty(localName = "RequestedAttribute", namespace = "eidas")
  private List<EIDASRequestedAttribute> requestedAttributes = new ArrayList<>();

  public SAML2PExtensions(){
    EIDASRequestedAttribute attr1 = new EIDASRequestedAttribute();
    attr1.setAttrName("http://eidas.europa.eu/attributes/naturalperson/PersonIdentifier");

    EIDASRequestedAttribute attr2 = new EIDASRequestedAttribute();
    attr2.setAttrName("http://eidas.europa.eu/attributes/naturalperson/CurrentFamilyName");

    EIDASRequestedAttribute attr3 = new EIDASRequestedAttribute();
    attr3.setAttrName("http://eidas.europa.eu/attributes/naturalperson/CurrentGivenName");

    EIDASRequestedAttribute attr4 = new EIDASRequestedAttribute();
    attr4.setAttrName("http://eidas.europa.eu/attributes/naturalperson/DateOfBirth");

    this.requestedAttributes.add(attr1);
    this.requestedAttributes.add(attr2);;
    this.requestedAttributes.add(attr3);;
    this.requestedAttributes.add(attr4);
  }

  public List<EIDASRequestedAttribute> getRequestedAttributes() {
    return requestedAttributes;
  }

  public void setRequestedAttributes(
      List<EIDASRequestedAttribute> requestedAttributes) {
    this.requestedAttributes = requestedAttributes;
  }

  public EIDASSPType getSpType() {
    return spType;
  }

  public void setSpType(EIDASSPType spType) {
    this.spType = spType;
  }
}
