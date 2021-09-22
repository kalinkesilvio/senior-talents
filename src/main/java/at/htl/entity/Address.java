package at.htl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    private String street;
    private String streetNo;
    private int zipNo;
    private String city;
    private String country;
    private String state;

    public Address() {}

    public Address(Long addressId, String street, String streetNo, int zipNo, String city, String country, String state) {
        this.addressId = addressId;
        this.street = street;
        this.streetNo = streetNo;
        this.zipNo = zipNo;
        this.city = city;
        this.country = country;
        this.state = state;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public int getZipNo() {
        return zipNo;
    }

    public void setZipNo(int zipNo) {
        this.zipNo = zipNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", streetNo='" + streetNo + '\'' +
                ", zipNo=" + zipNo +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
