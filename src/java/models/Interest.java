package models;

import java.io.Serializable;

public class Interest implements Serializable {

    private String interestName;
    private String owner;

    public Interest() {
    }

    public Interest(String interestName, String owner) {
        this.interestName = interestName;
        this.owner = owner;
    }

    public String getInterestName() {
        return interestName;
    }

    public void setInterestName(String interestName) {
        this.interestName = interestName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
