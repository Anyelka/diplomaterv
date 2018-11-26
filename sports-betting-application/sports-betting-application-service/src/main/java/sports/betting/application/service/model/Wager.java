//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.08 at 06:00:06 PM CEST 
//


package sports.betting.application.service.model;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="betType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="betDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="outcomeValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element ref="{}currency"/>
 *         &lt;element name="odd" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="win" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "betType",
    "betDescription",
    "outcomeValue",
    "amount",
    "currency",
    "odd",
    "win",
    "date"
})
@XmlRootElement(name = "wager")
public class Wager {

    protected long id;
    @XmlElement(required = true)
    protected String betType;
    @XmlElement(required = true)
    protected String betDescription;
    @XmlElement(required = true)
    protected String outcomeValue;
    @XmlElement(required = true)
    protected BigDecimal amount;
    @XmlElement(required = true)
    protected String currency;
    protected float odd;
    protected boolean win;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the betType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBetType() {
        return betType;
    }

    /**
     * Sets the value of the betType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBetType(String value) {
        this.betType = value;
    }

    /**
     * Gets the value of the betDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBetDescription() {
        return betDescription;
    }

    /**
     * Sets the value of the betDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBetDescription(String value) {
        this.betDescription = value;
    }

    /**
     * Gets the value of the outcomeValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutcomeValue() {
        return outcomeValue;
    }

    /**
     * Sets the value of the outcomeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutcomeValue(String value) {
        this.outcomeValue = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the odd property.
     * 
     */
    public float getOdd() {
        return odd;
    }

    /**
     * Sets the value of the odd property.
     * 
     */
    public void setOdd(float value) {
        this.odd = value;
    }

    /**
     * Gets the value of the win property.
     * 
     */
    public boolean isWin() {
        return win;
    }

    /**
     * Sets the value of the win property.
     * 
     */
    public void setWin(boolean value) {
        this.win = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

}