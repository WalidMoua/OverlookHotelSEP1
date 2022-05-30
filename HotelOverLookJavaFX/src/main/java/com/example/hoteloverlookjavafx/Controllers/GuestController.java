package com.example.hoteloverlookjavafx.Controllers;

import com.example.hoteloverlookjavafx.Models.Date;
import com.example.hoteloverlookjavafx.Models.Guest;
import com.example.hoteloverlookjavafx.Models.GuestList;
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
    private GuestList guests;

    @FXML TableColumn<Guest, String> birthdayColumn;
    @FXML TableColumn<Guest, String> nameColumn;
    @FXML TableColumn<Guest, String> phoneColumn;
    @FXML TableColumn<Guest, String> addressColumn;
    @FXML TableColumn<Guest, String> nationalityColumn;
    @FXML TableView<Guest> table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(GuestList.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        File file = new File("src\\main\\resources\\student.xml");
        Unmarshaller unmarshaller = null;
        try {
            if (jaxbContext != null) {
                unmarshaller = jaxbContext.createUnmarshaller();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            if (unmarshaller != null) {
                guests = (GuestList) unmarshaller.unmarshal(file);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        ObservableList<Guest> oL = FXCollections.observableArrayList();
        oL.addAll(guests.getAllGuest());
        nameColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(features.getValue().getName()));
        phoneColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(features.getValue().getPhone()));
        addressColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(features.getValue().getAddress()));
        nationalityColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(features.getValue().getNationality()));
        birthdayColumn.setCellValueFactory(features -> new ReadOnlyStringWrapper(features.getValue().getBirthday().toString()));
        table.getItems().addAll(oL);
    }

    public GuestController(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(GuestList.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        File file = new File("src\\main\\resources\\student.xml");
        Unmarshaller unmarshaller = null;
        try {
            unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            guests = (GuestList) unmarshaller.unmarshal(file);
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