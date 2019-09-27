package com.example.jnrizvi_ridebook;

import java.io.Serializable;

public class Ride implements Serializable {
    private String date;
    private String time;
    private String distance;
    private String avg_speed;
    private String avg_cadence;
    private String comment;

    // shorter constructor for testing purposes
    public Ride (String date, String time, String distance) {
        this.date = date;
        this.time = time;
        this.distance = distance;
    }

    public Ride (String date, String time, String distance, String avg_speed, String avg_cadence, String comment) {
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.avg_speed = avg_speed;
        this.avg_cadence = avg_cadence;
        this.comment = comment;
    }

    String getRideDate() { return this.date; }

    String getRideTime() { return this.time; }

    String getDistance() { return this.distance; }

    String getAvg_speed() { return this.avg_speed; }

    String getAvg_cadence() { return this.avg_cadence; }

    String getRideComment() { return this.comment; }

}
