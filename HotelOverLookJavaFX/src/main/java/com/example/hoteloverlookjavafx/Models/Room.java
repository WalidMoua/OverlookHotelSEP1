package com.example.hoteloverlookjavafx.Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "room")
@XmlAccessorType(XmlAccessType.FIELD)
public class Room {
    private int number;
    private float price;
    private int guestAmount;
    private String type;
    private String beds;
    private String extras;


    public Room(){

    }
    //basic constructor
    public Room(String t, String b, int am, int n, float p, String ex){
        this.type = t;
        this.beds = b;
        this.guestAmount = am;
        this.number = n;
        this.price = p;
        this.extras = ex;

    }

    //function to change room info
    private void changeRoomInfo(String t, String b, int am, int n, float p, String ex){
        this.type = t;
        this.beds = b;
        this.guestAmount = am;
        this.number = n;
        this.price = p;
        this.extras = ex;
    }

    //GET AND SETTERS
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setGuestAmount(int guestAmount) {
        this.guestAmount = guestAmount;
    }

    public int getGuestAmount()
    {
        return guestAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getExtras()
    {
        return extras;
    }

}