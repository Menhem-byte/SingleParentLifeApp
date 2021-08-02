package models;

import java.io.Serializable;

public class Organizer implements Serializable {

    private int organizerId;
    private String organizerName;
    private String contactName;
    private String organizerDescription;

    public Organizer() {
    }

    public Organizer(int organizerId, String organizerName, String contactName, String organizerDescription) {
        this.organizerId = organizerId;
        this.organizerName = organizerName;
        this.contactName = contactName;
        this.organizerDescription = organizerDescription;
    }

    public int getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getOrganizerDescription() {
        return organizerDescription;
    }

    public void setOrganizerDescription(String organizerDescription) {
        this.organizerDescription = organizerDescription;
    }
}
