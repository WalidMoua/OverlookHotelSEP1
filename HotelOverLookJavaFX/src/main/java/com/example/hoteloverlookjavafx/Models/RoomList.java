package com.example.hoteloverlookjavafx.Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement(name = "rooms")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomList
{
    @XmlElement(name = "room")
    public ArrayList<Room> rooms;

    public RoomList() {
        rooms = new ArrayList<>();

    }

    public void delete(Room room){
        rooms.remove(room);
    }

    public void add(Room room){
        rooms.add(room);
    }

    public Room getRoom(int index){
        return rooms.get(index);
    }

    public Room getRoomByNumber(int number){
        Room returnRoom = new Room();
        for(Room r : getAllRooms()){
            if(r.getNumber()==number){
                returnRoom = r;
            }
        }
        return returnRoom;
    }

    public void setRooms(Room room, int index){
        rooms.set(index, room);
    }

    public ArrayList<Room> getAllRooms() {
        return rooms;
    }

    public int size() {
        return rooms.size();
    }
}