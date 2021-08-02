package models;

import java.io.Serializable;
import java.util.Date;

public class Child implements Serializable {

    private String firstName;
    private String lastName;
    private Date dateOfBirth; //Need to change this to date format
    private char gender;
    private char isVisible;
    private String owner;

    public Child() {
    }

    public Child(String firstName, String lastName, Date dateOfBirth, char gender, char isVisible, String owner) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.isVisible = isVisible;
        this.owner = owner;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(char isVisible) {
        this.isVisible = isVisible;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
