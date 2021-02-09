package gr.atc.eidas.eidas.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;

public class DSReference {

  @JacksonXmlProperty(localName = "URI", isAttribute = true)
  private String attrURI = "#_171ccc6b39b1e8f6e762c2e4ee4ded3a";

  @JacksonXmlElementWrapper(localName = "ds:Transforms")
  @JacksonXmlProperty(localName = "ds:Transform")
  private List<DSTransform> transforms = new ArrayList<>();

  @JacksonXmlProperty(localName = "ds:DigestMethod")
  private DSDigestMethod digestMethod = new DSDigestMethod();

  @JacksonXmlProperty(localName = "ds:DigestValue")
  private DSDigestValue digestValue = new DSDigestValue();

  public DSReference(){
    DSTransform transform1 = new DSTransform();
    transform1.setAttrAlgorithm("http://www.w3.org/2000/09/xmldsig#enveloped-signature");

    DSTransform transform2 = new DSTransform();
    transform2.setAttrAlgorithm("http://www.w3.org/2001/10/xml-exc-c14n#");

    this.transforms.add(transform1);
    this.transforms.add(transform2);
  }

  public String getAttrURI() {
    return attrURI;
  }

  public void setAttrURI(String attrURI) {
    this.attrURI = attrURI;
  }

  public DSDigestMethod getDigestMethod() {
    return digestMethod;
  }

  public void setDigestMethod(DSDigestMethod digestMethod) {
    this.digestMethod = digestMethod;
  }

  public DSDigestValue getDigestValue() {
    return digestValue;
  }

  public void setDigestValue(DSDigestValue digestValue) {
    this.digestValue = digestValue;
  }

  public List<DSTransform> getTransforms() {
    return transforms;
  }

  public void setTransforms(List<DSTransform> transforms) {
    this.transforms = transforms;
  }
}
