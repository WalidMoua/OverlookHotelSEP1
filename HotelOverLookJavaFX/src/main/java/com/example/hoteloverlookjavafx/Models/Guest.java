package com.example.hoteloverlookjavafx.Models;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "guest")
@XmlAccessorType(XmlAccessType.FIELD)
public class Guest {
    private String name;
    private String phone;
    private Date birthday;
    private String address;
    private String nationality;

    //basic constructor for guest without complex info
    public Guest(String n, String p, Date b) {
        this.name = n;
        this.phone = p;
        this.birthday = b.copy();
    }

    //constructor with some info
    public Guest(String n, String p, Date b, String a, String na){
        this.name = n;
        this.phone = p;
        this.birthday = b.copy();
        this.address = a;
        this.nationality = na;
    }

    public Guest(){

    }

    //function to change info about guest
    public void editGuestInfo(String n, String p, Date b, String a, String na){
        this.name = n;
        this.phone = p;
        this.birthday = b.copy();
        this.address = a;
        this.nationality = na;
    }

    //GET AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
