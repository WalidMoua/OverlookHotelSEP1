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

public class GuestController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private BookingList bookings;
    @FXML TableColumn<Booking, String> idColumn;
    @FXML TableColumn<Booking, String> nameColumn;
    @FXML TableColumn<Booking, String> arrivalColumn;
    @FXML TableColumn<Booking, String> departureColumn;
    @FXML TableColumn<Booking, String> phoneColumn;
    @FXML TableColumn<Booking, String> roomColumn;
    @FXML TableView<Booking> table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(BookingList.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        File file = new File("src\\main\\resources\\bookings.xml");
        Unmarshaller unmarshaller = null;
        try {
            unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            bookings = (BookingList) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        ObservableList<Booking> oL = FXCollections.observableArrayList();
        oL.addAll(bookings.getAllBookingsCheckIn());
        idColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(String.valueOf(features.getValue().getId())));
        nameColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(features.getValue().getGuest().getName()));
        arrivalColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(features.getValue().getDateInterval().getStartDate().toString()));
        departureColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(features.getValue().getDateInterval().getEndDate().toString()));
        phoneColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(features.getValue().getGuest().getPhone()));
        roomColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(features.getValue().getRoom().getType()));

        table.getItems().addAll(oL);
    }
    //name phone room
    public GuestController(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(BookingList.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        File file = new File("src\\main\\resources\\bookings.xml");
        Unmarshaller unmarshaller = null;
        try {
            unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            bookings = (BookingList) unmarshaller.unmarshal(file);
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

    //Change to AddUser view
    public void switchToAddUser(ActionEvent event) throws IOException {
        root = FXMLLoader.load(OverLookApplication.class.getResource("addGuest.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
