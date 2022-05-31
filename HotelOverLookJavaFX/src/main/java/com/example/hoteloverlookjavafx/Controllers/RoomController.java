package com.example.hoteloverlookjavafx.Controllers;

import com.example.hoteloverlookjavafx.Models.*;
import com.example.hoteloverlookjavafx.OverLookApplication;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class RoomController implements Initializable
{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private RoomList rooms;

    @FXML TableColumn<Room, String> typeColumn;
    @FXML TableColumn<Room, String> bedsColumn;
    @FXML TableColumn<Room, String> guestAmountColumn;
    @FXML TableColumn<Room, String> roomNumberColumn;
    @FXML TableColumn<Room, String> priceColumn;
    @FXML TableColumn<Room, String> extrasColumn;
    @FXML TableView<Room> table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(RoomList.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        File file = new File("src\\main\\resources\\rooms.xml");
        Unmarshaller unmarshaller = null;
        try
        {
            if (jaxbContext != null) {
                unmarshaller = jaxbContext.createUnmarshaller();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try
        {
            if (unmarshaller != null) {
                rooms = (RoomList) unmarshaller.unmarshal(file);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        ObservableList<Room> oL = FXCollections.observableArrayList();
        oL.addAll(rooms.getAllRooms());
        typeColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(features.getValue().getType()));
        bedsColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(features.getValue().getBeds()));
        guestAmountColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(String.valueOf(features.getValue().getGuestAmount())));
        roomNumberColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(String.valueOf(features.getValue().getNumber())));
        priceColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(String.valueOf(features.getValue().getPrice())));
        extrasColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(features.getValue().getExtras()));
        table.getItems().addAll(oL);
    }

    public RoomController(){
        JAXBContext jaxbContext = null;
        try
        {
            jaxbContext = JAXBContext.newInstance(RoomList.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        File file = new File("src\\main\\resources\\rooms.xml");
        Unmarshaller unmarshaller = null;
        try
        {
            if (jaxbContext != null) {
                unmarshaller = jaxbContext.createUnmarshaller();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            if (unmarshaller != null) {
                rooms = (RoomList) unmarshaller.unmarshal(file);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void switchToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(OverLookApplication.class.getResource("home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAddUser(ActionEvent event) throws IOException {
        root = FXMLLoader.load(OverLookApplication.class.getResource("addRoom.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAddRoom(ActionEvent event) throws IOException {
        root = FXMLLoader.load(OverLookApplication.class.getResource("addRoom.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}