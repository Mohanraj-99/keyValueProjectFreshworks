package com.mohanraj;

import java.io.Serializable;

public class Details implements Serializable {
    private String name;
    private String emailID;
    private Long phoneNumber;
    private String message;
    private Integer liveTime;
    private Boolean liveStatus;

    public Details(String name, String emailID, Long phoneNumber, String message, Integer liveTime , Boolean liveStatus) {
        this.name = name;
        this.emailID = emailID;
        this.phoneNumber = phoneNumber;
        this.message = message;
        this.liveTime = liveTime;
        this.liveStatus = liveStatus;
    }

    @Override
    public String toString() {
        return "{" +
                "\nname = " + name +
                "\nemailID =" + emailID +
                "\nphoneNumber = " + phoneNumber +
                "\nmessage = " + message +
                "\n}";
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

    public Boolean getLiveStatus() { return liveStatus; }

    public void setLiveStatus(Boolean liveStatus) { this.liveStatus = liveStatus; }
}
