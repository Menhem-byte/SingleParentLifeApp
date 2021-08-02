package models;

import java.io.Serializable;

public class Friendship implements Serializable {

    private String friend;
    private String owner;
    private char status;

    public Friendship() {
    }

    public Friendship(String friend, String owner, char status) {
        this.friend = friend;
        this.owner = owner;
        this.status = status;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend= friend;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
