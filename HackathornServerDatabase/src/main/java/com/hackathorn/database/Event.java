package com.hackathorn.database;

/**
 * Created by lukasz on 20.06.15.
 */
import org.springframework.data.annotation.Id;

public class Event {

    //id will be used for storing MongoDB _id
    @Id
    private String id;

    private String event_id;
    private String event_name;
    private String event_description;
    private String event_category;
    private String event_owner;
    private String start_time;
    private String picture_url;
    private String location_place;
    private String location_city;
    private String location_street;
    private double latitude = 0.0;
    private double longitude = 0.0;
    private String categoy;

    public String getCategoy() {
        return categoy;
    }

    public void setCategoy(String categoy) {
        this.categoy = categoy;
    }

    public Event(String event_id, String event_name, String event_description, String event_category, String event_owner, String start_time, String picture_url, String location_place, String location_city, String location_street,String category) {

        this.event_id = event_id;
        this.event_name = event_name;
        this.event_description = event_description;
        this.event_category = event_category;
        this.event_owner = event_owner;
        this.start_time = start_time;
        this.picture_url = picture_url;
        this.location_place = location_place;
        this.location_city = location_city;
        this.location_street = location_street;
        this.categoy = category;


    }

    public String getStart_time() {
        return start_time;
    }

    public String getId() {
        return id;
    }

    public String getEvent_id() {
        return event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public String getEvent_description() {
        return event_description;
    }

    public String getEvent_category() {
        return event_category;
    }

    public String getEvent_owner() {
        return event_owner;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public String getLocation_place() {
        return location_place;
    }

    public String getLocation_city() {
        return location_city;
    }

    public String getLocation_street() {
        return location_street;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public void setEvent_category(String event_category) {
        this.event_category = event_category;
    }

    public void setEvent_owner(String event_owner) {
        this.event_owner = event_owner;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public void setLocation_place(String location_place) {
        this.location_place = location_place;
    }

    public void setLocation_city(String location_city) {
        this.location_city = location_city;
    }

    public void setLocation_street(String location_street) {
        this.location_street = location_street;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", event_id='" + event_id + '\'' +
                ", event_name='" + event_name + '\'' +
                ", event_description='" + event_description + '\'' +
                ", event_category='" + event_category + '\'' +
                ", event_owner='" + event_owner + '\'' +
                ", start_time='" + start_time + '\'' +
                ", picture_url='" + picture_url + '\'' +
                ", location_place='" + location_place + '\'' +
                ", location_city='" + location_city + '\'' +
                ", location_street='" + location_street + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}