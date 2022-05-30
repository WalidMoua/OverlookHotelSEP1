package com.example.hoteloverlookjavafx.Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "room")
@XmlAccessorType(XmlAccessType.FIELD)
public class Room {
    private int number;
    private float price;
    private String type;
    private int beds;
    private int bedRooms;

    public Room(){

    }

    //basic constructor
    public Room(int n, float p, String t, int b, int bR){
        this.number = n;
        this.price = p;
        this.type = t;
        this.beds = b;
        this.bedRooms = bR;
    }

    //function to change room info
    private void changeRoomInfo(int n, float p, String t, int b, int bR){
        this.number = n;
        this.price = p;
        this.type = t;
        this.beds = b;
        this.bedRooms = bR;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBedRooms() {
        return bedRooms;
    }

    public void setBedRooms(int bedRooms) {
        this.bedRooms = bedRooms;
    }
}
