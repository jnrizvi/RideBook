package com.example.jnrizvi_ridebook;

import java.sql.Time;
import java.util.Date;

public class Ride {
    private Date date;
    private Time time;
    private float distance;
    private float avg_speed;
    private int avg_cadence;
    private String comment;

    public Ride (Date date, Time time, float distance, float avg_speed, int avg_cadence, String comment) {
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.avg_speed = avg_speed;
        this.avg_cadence = avg_cadence;
        this.comment = comment;
    }

    Date getRideDate() { return this.date; }

    Time getRideTime() { return this.time; }

    float getDistance() { return this.distance; }

    float getAvg_speed() { return this.avg_speed; }

    float getAvg_cadence() { return this.avg_cadence; }

    String getRideComment() { return this.comment; }

}
