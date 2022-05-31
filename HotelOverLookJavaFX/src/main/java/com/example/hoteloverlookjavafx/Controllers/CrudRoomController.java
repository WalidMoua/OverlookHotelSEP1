package com.example.hoteloverlookjavafx.Controllers;

import com.example.hoteloverlookjavafx.Models.Room;
import com.example.hoteloverlookjavafx.Models.RoomList;
import com.example.hoteloverlookjavafx.OverLookApplication;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class CrudRoomController
{
    @FXML TextField typeField;
    @FXML TextField bedField;
    @FXML TextField guestAmountField;
    @FXML TextField numberField;
    @FXML TextField priceField;
    @FXML TextField extrasField;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private RoomList rooms;



    public CrudRoomController() {
        JAXBContext jaxbContext = null;
        try
        {
            jaxbContext = JAXBContext.newInstance(RoomList.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        File file = new File("src\\main\\resources\\rooms.xml");
        Unmarshaller unmarshaller = null;
        try{
                unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try
        {
                rooms = (RoomList) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    //Change to Home view
    public void switchToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(OverLookApplication.class.getResource("home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Change to add room
    public void switchToAddRoom(ActionEvent event) throws IOException {
        root = FXMLLoader.load(OverLookApplication.class.getResource("addRoom.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addRoom(ActionEvent event) throws IOException, JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(RoomList.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = new File("src\\main\\resources\\rooms.xml");
        rooms.add(new Room(typeField.getText(), bedField.getText(),Integer.parseInt(guestAmountField.getText()), Integer.parseInt(numberField.getText()), Integer.parseInt(priceField.getText()), extrasField.getText()));
        marshaller.marshal(rooms, file);

        root = FXMLLoader.load(OverLookApplication.class.getResource("rooms.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}