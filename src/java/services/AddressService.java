package services;

import dataaccess.AddressDB;
import models.Address;

public class AddressService {
    public void insert(String owner, String zipcode, String city, String province,  String country, char isValid) throws Exception {
        AddressDB addressDB = new AddressDB();
        Address address = new Address(owner, zipcode, city, province,  country, isValid);
        addressDB.insert(address);
    }
}
