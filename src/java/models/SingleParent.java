package models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class SingleParent implements Serializable {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private char gender;
    private String phoneNumber;
    private String occupation;
    private String aboutUser;
       private String path;
    private String photo;
    private char crimeClearanceChecked;
    private char isActive;
    private int Age;

    public SingleParent() {
    }

    public SingleParent(String email, String password, String firstName, String lastName, Date dateOfBirth,
            char gender, String phoneNumber, String occupation, String aboutUser, char crimeClearanceChecked, char isActive,String photo,String path) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.aboutUser = aboutUser;
        this.crimeClearanceChecked = crimeClearanceChecked;
        this.isActive = isActive;
        this.path=path;
        this.photo=photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAboutUser() {
        return aboutUser;
    }

    public void setAboutUser(String aboutUser) {
        this.aboutUser = aboutUser;
    }

    public char getCrimeClearanceChecked() {
        return crimeClearanceChecked;
    }

    public void setCrimeClearanceChecked(char crimeClearanceChecked) {
        this.crimeClearanceChecked = crimeClearanceChecked;
    }

    public char getIsActive() {
        return isActive;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }
    
     public String getPhoto() {
        return photo;
    }

    public void setPhoto(String aboutUser) {
        this.photo = photo;
    }
     public String getPath() {
        return path;
    }

    public void setPath (String path) {
        this.path = path;
    }
 public int getAge() {
     Date d =this.getDateOfBirth();
     int year=d.getYear();
      
     int yearnow =new Date().getYear();
     int age=yearnow-year;
        return age;
    }
}
