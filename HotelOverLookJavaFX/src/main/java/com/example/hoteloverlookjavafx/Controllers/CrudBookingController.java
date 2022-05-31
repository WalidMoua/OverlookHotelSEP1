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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CrudBookingController implements Initializable {
    @FXML Label price;
    @FXML Label extras;
    @FXML Label beds;
    @FXML Label type;
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
    @FXML ComboBox<Integer> stateRoom;
    @FXML CheckBox extrasCheck;
    private BookingList bookings = new BookingList();
    private Stage stage;
    private Scene scene;
    Parent root;
    private RoomList rooms = new RoomList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stateBox.getItems().add("BOOKED");
        stateBox.getItems().add("ARRIVED");
        stateBox.getItems().add("CLOSED");
        stateRoom.setCellFactory(lv->{
            ListCell<Integer> cell = new ListCell<>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    if(item != null) {
                        setText(String.valueOf(item));
                    }else{
                        setText("");
                    }
                }
            };
            cell.hoverProperty().addListener((obs, wasHovered, isNowHovered) -> {
                if (cell.isEmpty()) {
                    price.setText("");
                    extras.setText("");
                    beds.setText("");
                    type.setText("");
                } else {
                    price.setText((rooms.getRoomByNumber(cell.getItem()).getPrice()+"€"));
                    extras.setText(rooms.getRoomByNumber(cell.getItem()).getExtras());
                    beds.setText(rooms.getRoomByNumber(cell.getItem()).getBeds());
                    type.setText(rooms.getRoomByNumber(cell.getItem()).getType());
                }
            });
            return cell;
        });
    }


    public CrudBookingController() throws JAXBException {
        unmarshallRooms();
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

    public void unmarshallRooms() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(RoomList.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file = new File("src\\main\\resources\\rooms.xml");
        rooms = (RoomList) unmarshaller.unmarshal(file);
    }

    public void addBooking(ActionEvent event) throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(BookingList.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = new File("src\\main\\resources\\bookings.xml");
        if(extrasCheck.isSelected()){
            bookings.add(new Booking(new Guest(nameField.getText(),phoneField.getText(),new Date(birthdayField.getValue().getDayOfMonth(),birthdayField.getValue().getMonth().getValue(),birthdayField.getValue().getYear())),new DateInterval(new Date(arrivalField.getValue().getDayOfMonth(), arrivalField.getValue().getMonth().getValue(),arrivalField.getValue().getYear()),new Date(departureField.getValue().getDayOfMonth(),departureField.getValue().getMonth().getValue(),departureField.getValue().getYear())),rooms.getRoomByNumber(stateRoom.getValue()),Integer.parseInt(guestsField.getText()),extraInfoField.getText(),stateBox.getSelectionModel().getSelectedItem().toString(),new Extra(Float.parseFloat(priceField.getText()), extrasField.getText())));
            marshaller.marshal(bookings, file);
        }else{
            bookings.add(new Booking(new Guest(nameField.getText(),phoneField.getText(),new Date(birthdayField.getValue().getDayOfMonth(),birthdayField.getValue().getMonth().getValue(),birthdayField.getValue().getYear())),new DateInterval(new Date(arrivalField.getValue().getDayOfMonth(), arrivalField.getValue().getMonth().getValue(),arrivalField.getValue().getYear()),new Date(departureField.getValue().getDayOfMonth(),departureField.getValue().getMonth().getValue(),departureField.getValue().getYear())),rooms.getRoomByNumber(stateRoom.getValue()),Integer.parseInt(guestsField.getText()),extraInfoField.getText(),stateBox.getSelectionModel().getSelectedItem().toString()));
            marshaller.marshal(bookings, file);
        }
        root = FXMLLoader.load(OverLookApplication.class.getResource("bookings.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onClickComboBox(MouseEvent mouseEvent) throws JAXBException {
        unmarshallRooms();
        stateRoom.getItems().clear();
        ArrayList<Room> roomsFilter = rooms.getAllRooms();
        if(bookings.getAllBookings()!=null){
            for(Booking booking : bookings.getAllBookings()){
                LocalDate start = LocalDate.of(booking.getDateInterval().getStartDate().getYear(),booking.getDateInterval().getStartDate().getMonth(),booking.getDateInterval().getStartDate().getDay());
                LocalDate end = LocalDate.of(booking.getDateInterval().getEndDate().getYear(),booking.getDateInterval().getEndDate().getMonth(),booking.getDateInterval().getEndDate().getDay());
                if(arrivalField.getValue().isBefore(end) && start.isBefore(departureField.getValue())){
                    System.out.println("Overlaps");
                    roomsFilter.remove(rooms.getRoomByNumber(booking.getRoom().getNumber()));
                }
            }
            for(Room r : roomsFilter){
                stateRoom.getItems().add(r.getNumber());
            }
        }else{
            for(Room r : rooms.getAllRooms()){
                stateRoom.getItems().add(r.getNumber());
            }
        }
    }
}
