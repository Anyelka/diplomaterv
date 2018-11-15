//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.08 at 06:00:06 PM CEST 
//


package model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.sports.betting.application.app.xml package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Currency_QNAME = new QName("", "currency");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.sports.betting.application.app.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PlayerInfo }
     * 
     */
    public PlayerInfo createPlayerInfo() {
        return new PlayerInfo();
    }

    /**
     * Create an instance of {@link SportEvent }
     * 
     */
    public SportEvent createSportEvent() {
        return new SportEvent();
    }

    /**
     * Create an instance of {@link Wager }
     * 
     */
    public Wager createWager() {
        return new Wager();
    }

    /**
     * Create an instance of {@link PlayerInfo.SportEvents }
     * 
     */
    public PlayerInfo.SportEvents createPlayerInfoSportEvents() {
        return new PlayerInfo.SportEvents();
    }

    /**
     * Create an instance of {@link SportEvent.Wagers }
     * 
     */
    public SportEvent.Wagers createSportEventWagers() {
        return new SportEvent.Wagers();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "currency")
    public JAXBElement<String> createCurrency(String value) {
        return new JAXBElement<String>(_Currency_QNAME, String.class, null, value);
    }

}
