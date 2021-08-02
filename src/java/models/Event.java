package models;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {

    private int eventID;
    private String title;
    private Date startTime;
    private Date finishTime;
    private String eventDescription;
    private int organizerID;
    private char isVisible;

    public Event() {
    }

    public Event(int eventID, String title, Date startTime, Date finishTime, String eventDescription, int organizerID, char isVisible) {
        this.eventID = eventID;
        this.title = title;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.eventDescription = eventDescription;
        this.organizerID = organizerID;
        this.isVisible = isVisible;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public int getOrganizerID() {
        return organizerID;
    }

    public void setOrganizerID(int organizerID) {
        this.organizerID = organizerID;
    }

    public char getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(char isVisible) {
        this.isVisible = isVisible;
    }

}
