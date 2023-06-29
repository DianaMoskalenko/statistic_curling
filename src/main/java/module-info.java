module com.curling.statistic {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;


    opens com.curling.statistic to javafx.fxml;
    exports com.curling.statistic;
}