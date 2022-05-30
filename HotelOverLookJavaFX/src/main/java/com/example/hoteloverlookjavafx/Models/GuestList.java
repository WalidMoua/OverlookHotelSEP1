package com.example.hoteloverlookjavafx.Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@XmlRootElement(name = "guests")
@XmlAccessorType(XmlAccessType.FIELD)
public class GuestList {
    @XmlElement(name = "guest")
    public ArrayList<Guest> guests;


    public GuestList() throws FileNotFoundException {
        guests = new ArrayList<>();
    }

    public void add(Guest guest) throws IOException {
        guests.add(guest);
    }

    public Guest getGuest(int index){
        return guests.get(index);
    }

    public void set(Guest guest, int index){
        guests.set(index, guest);
    }

    public ArrayList<Guest> getAllGuest(){
        return guests;
    }

    public int size(){
        return guests.size();
    }
}
