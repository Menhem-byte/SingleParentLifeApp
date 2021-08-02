package models;

import java.io.Serializable;

public class SocialMediaAccounts implements Serializable {

    private int smaID;
    private String smaCategory;
    private String smaName;
    private char isVisible;
    private int owner;

    public SocialMediaAccounts() {
    }

    public SocialMediaAccounts(int smaID, String smaCategory, char isVisible, int owner) {
        this.smaID = smaID;
        this.smaCategory = smaCategory;
        this.isVisible = isVisible;
        this.owner = owner;
    }

    public int getSmaID() {
        return smaID;
    }

    public void setSmaID(int smaID) {
        this.smaID = smaID;
    }

    public String getSmaCategory() {
        return smaCategory;
    }

    public void setSmaCategory(String smaCategory) {
        this.smaCategory = smaCategory;
    }

    public String getSmaName() {
        return smaName;
    }

    public void setSmaName(String smaName) {
        this.smaName = smaName;
    }

    public char getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(char isVisible) {
        this.isVisible = isVisible;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

}
