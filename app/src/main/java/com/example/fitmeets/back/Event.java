package com.example.fitmeets.back;


import java.util.Date;



public class Event {

    private final String title;
    private final Date date;
    private final String imagePath;
    private final EventStatus status;

    // TODO: get event color based on status (active = green, past = yellow, cancelled = red)


    public Event(String title, Date date, String imagePath, EventStatus status) {
        this.title = title;
        this.date = date;
        this.imagePath = imagePath;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getImagePath() {
        return imagePath;
    }

    public EventStatus getStatus() {
        return status;
    }
}
