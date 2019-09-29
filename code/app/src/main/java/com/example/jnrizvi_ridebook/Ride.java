package com.example.jnrizvi_ridebook;

import java.io.Serializable;

public class Ride implements Serializable {
    private String date;
    private String time;
    private String distance;
    private String avg_speed;
    private String avg_cadence;
    private String comment;

    private boolean expanded;

    // shorter constructor for testing purposes
    public Ride (String date, String time, String distance, boolean expanded) {
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.expanded = expanded;
    }

    public Ride (String date, String time, String distance, String avg_speed, String avg_cadence, String comment, boolean expanded) {
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.avg_speed = avg_speed;
        this.avg_cadence = avg_cadence;
        this.comment = comment;
        this.expanded = expanded;
    }

    String getRideDate() { return this.date; }

    String getRideTime() { return this.time; }

    String getDistance() { return this.distance; }

    String getAvg_speed() { return this.avg_speed; }

    String getAvg_cadence() { return this.avg_cadence; }

    String getRideComment() { return this.comment; }

    boolean getExpandStatus() { return this.expanded; }

    void setRideDate(String newRideDate) { this.date= newRideDate; }

    void setRideTime(String newRideTime) { this.time= newRideTime; }

    void setDistance(String newDistance) { this.distance= newDistance; }

    void setAvg_speed(String newAvg_speed) { this.avg_speed= newAvg_speed; }

    void setAvg_cadence(String newAvg_cadence) { this.avg_cadence= newAvg_cadence; }

    void setRideComment(String newComment) { this.comment= newComment; }

    void setExpanded(boolean isExpanded) { this.expanded = isExpanded; }

}
