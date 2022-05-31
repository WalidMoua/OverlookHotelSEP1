package com.example.hoteloverlookjavafx.Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@XmlRootElement(name = "rooms")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomList
{
  @XmlElement(name = "room")
  public ArrayList<Room> rooms;

  public RoomList() throws FileNotFoundException {
    rooms = new ArrayList<Room>();

  }

  public void add(Room room) throws IOException{
    rooms.add(room);
  }

  public Room getRoom(int index){
    return rooms.get(index);
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