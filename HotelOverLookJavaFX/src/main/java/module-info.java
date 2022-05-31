module com.example.hoteloverlookjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jakarta.xml.bind;

    opens com.example.hoteloverlookjavafx.Models to jakarta.xml.bind;
    exports com.example.hoteloverlookjavafx;
    exports com.example.hoteloverlookjavafx.Controllers;
    opens com.example.hoteloverlookjavafx.Controllers to javafx.fxml;
}