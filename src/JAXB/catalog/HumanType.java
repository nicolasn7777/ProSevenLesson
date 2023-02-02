package JAXB.catalog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "humanType", propOrder = {
    "city",
    "street",
    "house"
})
public class HumanType {
    @XmlElement(required = true)
    protected String city;
    @XmlElement(required = true)
    protected String street;
    @XmlElement(required = true)
    protected String house;

    public String getStreet() {
        return street;
    }

    public void setStreet(String value) {
        this.street = value;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String value) {
        this.house = value;
    }

}
