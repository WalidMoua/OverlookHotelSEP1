package com.example.hoteloverlookjavafx.Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.concurrent.atomic.AtomicInteger;

@XmlRootElement(name = "booking")
@XmlAccessorType(XmlAccessType.FIELD)
public class Booking {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "guest")
    private Guest guest;
    @XmlElement(name = "dateInterval")
    private DateInterval dateInterval;
    @XmlElement(name = "room")
    private Room room;
    private int guests;
    private String extraInfo;
    private float totalPrice;
    private int nightsSpent;
    private String state;
    @XmlElement(name = "extra")
    private Extra extra;

    public Booking(){

    }

    //basic constructor
    public Booking(Guest g, DateInterval dI, Room r, int guests,String eI, String state){
        this.guest = g;
        this.dateInterval = dI;
        this.room = r;
        this.extraInfo = eI;
        this.guests = guests;
        this.state = state;
    }

    //constructor with extra info
    public Booking(Guest g, DateInterval dI, Room r, int guests, String eI, String state, Extra extra){
        this.guest = g;
        this.dateInterval = dI;
        this.room = r;
        this.guests = guests;
        this.extraInfo = eI;
        this.state = state;
        this.extra = extra;
    }

    //function to update Booking
    public void updateBooking(Guest g, DateInterval dI, Room r, int guests, String eI, String state, Extra extra){
        this.guest = g;
        this.dateInterval = dI;
        this.room = r;
        this.guests = guests;
        this.extraInfo = eI;
        this.state = state;
        this.extra = extra;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public DateInterval getDateInterval() {
        return dateInterval;
    }

    public void setDateInterval(DateInterval dateInterval) {
        this.dateInterval = dateInterval;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getNightsSpent() {
        return nightsSpent;
    }

    public void setNightsSpent(int nightsSpent) {
        this.nightsSpent = nightsSpent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
