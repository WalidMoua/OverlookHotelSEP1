package com.example.hoteloverlookjavafx.Controllers;

import com.example.hoteloverlookjavafx.OverLookApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    ImageView image1;

    //Change to Guests view
    public void switchToClients(ActionEvent event) throws IOException {
        root = FXMLLoader.load(OverLookApplication.class.getResource("guests.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Change to Bookings view
    public void switchToBookings(ActionEvent event) throws IOException {
        root = FXMLLoader.load(OverLookApplication.class.getResource("bookings.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Change to Rooms view
    public void switchToRoom(ActionEvent event) throws IOException {
        root = FXMLLoader.load(OverLookApplication.class.getResource("rooms.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Change to Calendar view
    public void switchToCalendar(ActionEvent event) throws IOException {
        root = FXMLLoader.load(OverLookApplication.class.getResource("calendar.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}