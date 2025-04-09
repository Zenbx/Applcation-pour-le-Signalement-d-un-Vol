module com.appvol {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.base;
    requires transitive java.sql;

    opens com.appvol to javafx.controls, javafx.graphics, javafx.fxml;
    opens com.appvol.ui.view to javafx.controls, javafx.graphics, javafx.fxml;
    exports com.appvol;
    exports com.appvol.ui.view;
    exports com.appvol.ui.handlers;
}
