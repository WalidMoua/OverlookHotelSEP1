package com.example.hoteloverlookjavafx.Controllers;

import com.example.hoteloverlookjavafx.Models.*;
import com.example.hoteloverlookjavafx.OverLookApplication;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import com.example.hoteloverlookjavafx.Models.Booking;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CrudBookingController implements Initializable {
    @FXML TextField nameField;
    @FXML TextField phoneField;
    @FXML DatePicker birthdayField;
    @FXML TextField addressField;
    @FXML TextField nationalityField;
    @FXML TextArea extraInfoField;
    @FXML TextField guestsField;
    @FXML DatePicker arrivalField;
    @FXML DatePicker departureField;
    @FXML TextArea extrasField;
    @FXML TextField priceField;
    @FXML ChoiceBox<String> stateBox;
    @FXML ComboBox<Room> stateRoom;
    @FXML CheckBox extrasCheck;
    private BookingList bookings = new BookingList();
    private Stage stage;
    private Scene scene;
    Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stateBox.getItems().add("BOOKED");
        stateBox.getItems().add("ARRIVED");
        stateBox.getItems().add("CLOSED");

    }


    public CrudBookingController(){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(BookingList.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        File file = new File("src\\main\\resources\\bookings.xml");
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
                bookings = (BookingList) unmarshaller.unmarshal(file);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public void switchBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(OverLookApplication.class.getResource("bookings.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void clickExtras(ActionEvent actionEvent) {
        if(extrasCheck.isSelected()){
            extrasField.setDisable(false);
            priceField.setDisable(false);
        }else{
            extrasField.setText("");
            priceField.setText("");
            extrasField.setDisable(true);
            priceField.setDisable(true);
        }
    }


    public void addBooking(ActionEvent event) throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(BookingList.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        Room room =  new Room(1,100,"ALWDWALDAW",1,2);

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = new File("src\\main\\resources\\bookings.xml");
        if(extrasCheck.isSelected()){
            bookings.add(new Booking(new Guest(nameField.getText(),phoneField.getText(),new Date(birthdayField.getValue().getDayOfMonth(),birthdayField.getValue().getMonth().getValue(),birthdayField.getValue().getYear())),new DateInterval(new Date(arrivalField.getValue().getDayOfMonth(), arrivalField.getValue().getMonth().getValue(),arrivalField.getValue().getYear()),new Date(departureField.getValue().getDayOfMonth(),departureField.getValue().getMonth().getValue(),departureField.getValue().getYear())),room,Integer.parseInt(guestsField.getText()),extraInfoField.getText(),stateBox.getSelectionModel().getSelectedItem().toString(),new Extra(Float.parseFloat(priceField.getText()), extrasField.getText())));
            marshaller.marshal(bookings, file);
        }else{
            bookings.add(new Booking(new Guest(nameField.getText(),phoneField.getText(),new Date(birthdayField.getValue().getDayOfMonth(),birthdayField.getValue().getMonth().getValue(),birthdayField.getValue().getYear())),new DateInterval(new Date(arrivalField.getValue().getDayOfMonth(), arrivalField.getValue().getMonth().getValue(),arrivalField.getValue().getYear()),new Date(departureField.getValue().getDayOfMonth(),departureField.getValue().getMonth().getValue(),departureField.getValue().getYear())),room,Integer.parseInt(guestsField.getText()),extraInfoField.getText(),stateBox.getSelectionModel().getSelectedItem().toString()));
            marshaller.marshal(bookings, file);
        }
        root = FXMLLoader.load(OverLookApplication.class.getResource("bookings.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onClickComboBox(MouseEvent mouseEvent) {
        if(bookings.getAllBookings()!=null){
            for(Booking booking : bookings.getAllBookings()){
                LocalDate start = new LocalDate(booking.getDateInterval().getStartDate().getYear(),booking.getDateInterval().getStartDate().getMonth(),booking.getDateInterval().getStartDate().getDay());
                LocalDate end = new LocalDate(booking.getDateInterval().getEndDate().getYear(),booking.getDateInterval().getEndDate().getMonth(),booking.getDateInterval().getEndDate().getDay());
                if((arrivalField.getValue().isBefore(start)) && (arrivalField.getValue().isBefore(end))){

                }
                booking.getDateInterval();
            }
        }
    }
}
