module com.cs622.bmi_midterm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.cs622.bmi_midterm to javafx.fxml;
    exports com.cs622.bmi_midterm;
}