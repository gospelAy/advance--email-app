package dtos.responses;

import data.models.User;

import java.time.LocalDateTime;

public class FindMailResponse {

    private int id;

    private String subject;

    private String body;

    private LocalDateTime timeCreated = LocalDateTime.now();

    private String ownerEmailAddress;

    @Override
    public String toString() {
        return "FindMailResponse{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", timeCreated=" + timeCreated +
                ", senderEmailAddress='" + ownerEmailAddress + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getOwnerEmailAddress() {
        return ownerEmailAddress;
    }

    public void setOwnerEmailAddress(String mail) {
        ownerEmailAddress = mail;
    }
}
