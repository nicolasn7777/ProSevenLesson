package JAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "human")
public class Human {
    private String city;
    private String street;
    private String house;

    public Human() {
    }

    public Human(String city, String street, String house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }

    @Override
    public String toString() {
        return "[" + city + ", " + street + ", " + house + "]";
    }

    public String getStreet() {
        return street;
    }

    @XmlElement
    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    @XmlElement
    public void setCity(String city) {
        this.city = city;
    }

    public String getHouse() {
        return house;
    }

    @XmlElement
    public void setHouse(String house) {
        this.house = house;
    }
}

