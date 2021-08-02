package models;

import java.io.Serializable;

public class Address implements Serializable {

    private String owner;
    private String zipcode;
    private String city;
    private String province;
    private String country;
    private char isValid;

    public Address() {
    }

    public Address(String owner, String zipcode, String city, String province,  String country, char isValid) {
        this.owner = owner;
        this.zipcode = zipcode;
        this.city = city;
        this.province = province;
        this.country = country;
        this.isValid = isValid;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province =province;
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country =country;
    }
    

    public char getIsValid() {
        return isValid;
    }

    public void setIsValid(char isValid) {
        this.isValid = isValid;
    }
}

