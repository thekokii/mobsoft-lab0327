package com.example.mobsoft.mobsoft.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class Event {
    private Long id = null;
    @SerializedName("title")
    private String title = null;
    private Date date = null;
    private String address = null;
    private String description = null;
    private String coordinates = null;

    public Event(Long id, String title, Date date, String address, String description, String coordinates) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.address = address;
        this.description = description;
        this.coordinates = coordinates;
    }

    public Event(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}
