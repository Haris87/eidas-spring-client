//package gr.atc.eidas.eidas.service;
//
//import com.google.common.io.CharSource;
//import gr.atc.eidas.eidas.model.SAML2PAuthnRequest;
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.charset.StandardCharsets;
//import java.time.Instant;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import javax.xml.namespace.QName;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import net.shibboleth.utilities.java.support.xml.XMLParserException;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
//import org.opensaml.core.xml.Namespace;
//import org.opensaml.core.xml.XMLObject;
//import org.opensaml.core.xml.XMLObjectBuilder;
//import org.opensaml.core.xml.XMLObjectBuilderFactory;
//import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
//import org.opensaml.core.xml.io.UnmarshallingException;
//import org.opensaml.core.xml.util.XMLObjectSupport;
//import org.opensaml.saml.saml2.core.Assertion;
//import org.opensaml.saml.saml2.core.Attribute;
//import org.opensaml.saml.saml2.core.AttributeStatement;
//import org.opensaml.saml.saml2.core.AuthnContextClassRef;
//import org.opensaml.saml.saml2.core.AuthnContextComparisonTypeEnumeration;
//import org.opensaml.saml.saml2.core.AuthnRequest;
//import org.opensaml.saml.saml2.core.Extensions;
//import org.opensaml.saml.saml2.core.Issuer;
//import org.opensaml.saml.saml2.core.NameID;
//import org.opensaml.saml.saml2.core.NameIDPolicy;
//import org.opensaml.saml.saml2.core.NameIDType;
//import org.opensaml.saml.saml2.core.RequestedAuthnContext;
//import org.springframework.stereotype.Service;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import se.litsec.eidas.opensaml.common.EidasConstants;
//import se.litsec.eidas.opensaml.common.EidasLoaEnum;
//import se.litsec.eidas.opensaml.ext.RequestedAttribute;
//import se.litsec.eidas.opensaml.ext.RequestedAttributes;
//import se.litsec.eidas.opensaml.ext.SPType;
//import se.litsec.eidas.opensaml.ext.SPTypeEnumeration;
//import se.litsec.eidas.opensaml.ext.attributes.AttributeConstants;
//import se.swedenconnect.opensaml.OpenSAMLInitializer;
//import se.swedenconnect.opensaml.OpenSAMLSecurityExtensionConfig;
//
//@Service
//public class EidasService {
//
//  public void testSendRequest() throws Exception {
//    SAML2PAuthnRequest request = new SAML2PAuthnRequest();
//    System.out.println(request.serializeToXML());
//
//    throw new Exception();
//
//    List<String> requiredAttributesNames = Arrays.asList(
//        AttributeConstants.EIDAS_PERSON_IDENTIFIER_ATTRIBUTE_NAME,
//        AttributeConstants.EIDAS_CURRENT_FAMILY_NAME_ATTRIBUTE_NAME,
//        AttributeConstants.EIDAS_CURRENT_GIVEN_NAME_ATTRIBUTE_NAME,
//        AttributeConstants.EIDAS_DATE_OF_BIRTH_ATTRIBUTE_NAME
//    );
//
//    AuthnRequest authnRequest = createAuthnRequest(
//        "_171ccc6b39b1e8f6e762c2e4ee4ded3a", /* The ID of the request */
//        "https://eidas-service.eu/post", /* The destination URL - This is found in the IdP metadata */
//        "https://eidas-connector.eu", /* The entityID of the requesting SP */
//        SPTypeEnumeration.PUBLIC, /* Public or private SP type (eIDAS specific) */
//        requiredAttributesNames, /* eIDAS required attributes */
//        EidasLoaEnum.LOA_HIGH /* The required eIDAS LoA */
//    );
//
//    // Marshall and print the XML
//    //
//    Element authnRequestElement = XMLObjectProviderRegistrySupport.getMarshallerFactory()
//        .getMarshaller(authnRequest).marshall(
//            authnRequest);
//    System.out.println("eIDAS AuthnRequest:");
//    System.out.println(authnRequest.getAssertionConsumerServiceURL());
//    System.out.println(authnRequest.getAssertionConsumerServiceIndex());
//    System.out.println(authnRequest.getAttributeConsumingServiceIndex());
//    System.out.println(authnRequest.getID());
//    System.out.println(authnRequest.getRequestedAuthnContext().getSchemaLocation());
//    System.out.println(authnRequest.getProviderName());
//
//    // Unmarshall and assert eIDAS specific elements ...
//    //
//    AuthnRequest authnRequest2 = AuthnRequest.class.cast(
//        XMLObjectProviderRegistrySupport.getUnmarshallerFactory()
//            .getUnmarshaller(authnRequestElement)
//            .unmarshall(authnRequestElement));
//
//    // The SPType extension
//    Optional<SPTypeEnumeration> spType = authnRequest2.getExtensions()
//        .getUnknownXMLObjects()
//        .stream()
//        .filter(o -> SPType.class.isInstance(o))
//        .map(SPType.class::cast)
//        .map(t -> t.getType())
//        .findFirst();
////    Assert.assertTrue("Expected SPType in AuthnRequest extension", spType.isPresent());
////    Assert.assertEquals("Expected SPType to be PUBLIC", SPTypeEnumeration.PUBLIC, spType.get());
//
//    System.out.println("2 - " + spType.get().getValue());
//
//    // The requested attributes ...
//    Optional<RequestedAttributes> requestedAttributes = authnRequest2.getExtensions()
//        .getUnknownXMLObjects()
//        .stream()
//        .filter(o -> RequestedAttributes.class.isInstance(o))
//        .map(RequestedAttributes.class::cast)
//        .findFirst();
////    Assert.assertTrue("Expected RequestedAttributes in AuthnRequest extension", requestedAttributes.isPresent());
//
//    System.out.println(
//        "3 - Expected RequestedAttributes in AuthnRequest extension " + requestedAttributes
//            .isPresent());
//
//    Optional<RequestedAttribute> personIdentifierAttr = requestedAttributes.get()
//        .getRequestedAttributes()
//        .stream()
//        .filter(a -> a.getName().equals(AttributeConstants.EIDAS_PERSON_IDENTIFIER_ATTRIBUTE_NAME))
//        .findFirst();
////    Assert.assertTrue("Expected PersonIdentifier attribute among the RequestedAttributes", personIdentifierAttr.isPresent());
//    // We have hard-wired the isRequired attribute to true.
////    Assert.assertTrue("Expected isRequired to be true", personIdentifierAttr.get().isRequired());
//
//    System.out.println("4 - Expected PersonIdentifier attribute among the RequestedAttributes "
//        + personIdentifierAttr.isPresent());
//
//    System.out
//        .println("5 - Expected isRequired to be true " + personIdentifierAttr.get().isRequired());
//    // OK, you get it. Make sure we got all requested attributes ...
//
//    List<String> requestedAttributesNames2 = requestedAttributes.get()
//        .getRequestedAttributes()
//        .stream()
//        .map(a -> a.getName())
//        .collect(Collectors.toList());
////    Assert.assertEquals(requiredAttributesNames, requestedAttributesNames2);
//
//    System.out.println("6 - " + requestedAttributesNames2.equals(requiredAttributesNames));
//
//    // The RequestedAuthnContext
//    String loaUri = authnRequest2.getRequestedAuthnContext().getAuthnContextClassRefs().get(0)
//        .getURI();
////    Assert.assertEquals("Expected requested LoA URI to be \"high\"", EidasLoaEnum.LOA_HIGH.getUri(), loaUri);
//
//    System.out.println(
//        "7 - Expected requested LoA URI to be \"high\" " + EidasLoaEnum.LOA_HIGH.getUri() + " --- "
//            + loaUri);
//
//  }
//
//  private AuthnRequest createAuthnRequest(
//      String requestID,
//      String destination,
//      String spEntityID,
//      SPTypeEnumeration spType,
//      List<String> requstedAttributes,
//      EidasLoaEnum loa) throws Exception {
//
//    OpenSAMLInitializer.getInstance()
//        .initialize(
//            new OpenSAMLSecurityExtensionConfig());
//
//    AuthnRequest request = createSamlObject(AuthnRequest.class, AuthnRequest.DEFAULT_ELEMENT_NAME);
//    request.getNamespaceManager().registerNamespaceDeclaration(
//        new Namespace(EidasConstants.EIDAS_NS, EidasConstants.EIDAS_PREFIX));
//
//    // Add the request attributes.
//    //
//    request.setID(requestID);
//    request.setDestination(destination);
//    request.setIssueInstant(Instant.now());
//
//    // Add the issuer element (the entity that issues this request).
//    //
//    Issuer issuer = createSamlObject(Issuer.class, Issuer.DEFAULT_ELEMENT_NAME);
//    issuer.setFormat(NameIDType.ENTITY);
//    issuer.setValue(spEntityID);
//    request.setIssuer(issuer);
//
//    Extensions extensions = createSamlObject(Extensions.class, Extensions.DEFAULT_ELEMENT_NAME);
//
//    // Add the type of SP as an extension.
//    //
//    SPType spTypeElement = createSamlObject(SPType.class, SPType.DEFAULT_ELEMENT_NAME);
//    spTypeElement.setType(spType);
//    extensions.getUnknownXMLObjects().add(spTypeElement);
//
//    // Add the eIDAS requested attributes as an extension.
//    //
//    if (requstedAttributes != null && !requstedAttributes.isEmpty()) {
//      RequestedAttributes requestedAttributesElement = createSamlObject(RequestedAttributes.class,
//          RequestedAttributes.DEFAULT_ELEMENT_NAME);
//
//      // Also see the RequestedAttributeTemplates class ...
//
//      for (String attr : requstedAttributes) {
//        RequestedAttribute reqAttr = createSamlObject(RequestedAttribute.class,
//            RequestedAttribute.DEFAULT_ELEMENT_NAME);
//        reqAttr.setName(attr);
//        reqAttr.setNameFormat(Attribute.URI_REFERENCE);
//        reqAttr.setIsRequired(true);
//        requestedAttributesElement.getRequestedAttributes().add(reqAttr);
//      }
//      extensions.getUnknownXMLObjects().add(requestedAttributesElement);
//    }
//    request.setExtensions(extensions);
//
//    // Set the requested NameID policy to "persistent".
//    //
//    NameIDPolicy nameIDPolicy = createSamlObject(NameIDPolicy.class,
//        NameIDPolicy.DEFAULT_ELEMENT_NAME);
//    nameIDPolicy.setFormat(NameID.PERSISTENT);
//    nameIDPolicy.setAllowCreate(true);
//    request.setNameIDPolicy(nameIDPolicy);
//
//    // Create the requested authentication context and assign the "level of assurance" that we require
//    // the authentication to be performed under.
//    //
//    RequestedAuthnContext requestedAuthnContext = createSamlObject(RequestedAuthnContext.class,
//        RequestedAuthnContext.DEFAULT_ELEMENT_NAME);
//    requestedAuthnContext
//        .setComparison(AuthnContextComparisonTypeEnumeration.MINIMUM); // Should be exact!
//    AuthnContextClassRef authnContextClassRef = createSamlObject(AuthnContextClassRef.class,
//        AuthnContextClassRef.DEFAULT_ELEMENT_NAME);
//    authnContextClassRef.setURI(loa.getUri());
//    requestedAuthnContext.getAuthnContextClassRefs().add(authnContextClassRef);
//    request.setRequestedAuthnContext(requestedAuthnContext);
//
//    return request;
//  }
//
//  private static <T extends XMLObject> T createSamlObject(Class<T> clazz, QName elementName) {
//    if (!XMLObject.class.isAssignableFrom(clazz)) {
//      throw new RuntimeException(String.format("%s is not a XMLObject class", clazz.getName()));
//    }
//    XMLObjectBuilderFactory builderFactory = XMLObjectProviderRegistrySupport.getBuilderFactory();
//    XMLObjectBuilder<? extends XMLObject> builder = builderFactory.getBuilder(elementName);
//    if (builder == null) {
//      // No builder registered for the given element name. Try creating a builder for the default element name.
//      builder = builderFactory.getBuilder(getDefaultElementName(clazz));
//    }
//    Object object = builder.buildObject(elementName);
//    return clazz.cast(object);
//  }
//
//  private static <T extends XMLObject> QName getDefaultElementName(Class<T> clazz) {
//    try {
//      return (QName) clazz.getDeclaredField("DEFAULT_ELEMENT_NAME").get(null);
//    } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | SecurityException e) {
//      throw new RuntimeException(e);
//    }
//  }
//
//
//  public void testAssertion()
//      throws IOException, UnmarshallingException, XMLParserException {
//    InputStream is = this.getClass().getResourceAsStream("/static/assertion.xml");
//    System.out.println(is.readAllBytes().length);
//    Assertion assertion = (Assertion) XMLObjectSupport
//        .unmarshallFromInputStream(XMLObjectProviderRegistrySupport.getParserPool(), is);
//
//    printAssertion(assertion);
//  }
//
//
//  public static void printAssertion(Assertion assertion) {
//
//    System.out.println("Attributes:");
//    if (assertion.getAttributeStatements().isEmpty()) {
//      System.out.println("  No attribute statement available in assertion");
//    } else {
//      AttributeStatement as = assertion.getAttributeStatements().get(0);
//      for (Attribute attr : as.getAttributes()) {
//        System.out.println("  " + attr.getName());
//      }
//    }
//  }
//
//}
