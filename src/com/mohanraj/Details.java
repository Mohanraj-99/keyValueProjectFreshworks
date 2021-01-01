package com.mohanraj;

import java.io.Serializable;

public class Details implements Serializable {
    private String name;
    private String emailID;
    private Long phoneNumber;
    private String message;
    private Integer liveTime;
    private Boolean status;

    public Details(String name, String emailID, Long phoneNumber, String message, Integer liveTime) {
        this.name = name;
        this.emailID = emailID;
        this.phoneNumber = phoneNumber;
        this.message = message;
        this.liveTime = liveTime;
        this.status = true;
    }

    @Override
    public String toString() {
        return "{" +
                "\nname='" + name  +
                "\nemailID='" + emailID +
                "\nphoneNumber=" + phoneNumber +
                "\nmessage='" + message +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(Integer liveTime) {
        this.liveTime = liveTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
