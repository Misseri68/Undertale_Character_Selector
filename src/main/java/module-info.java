module org_infantaelena_ies.ventanasmediador {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens org_infantaelena_ies.MediatorUndertaleSelector to javafx.fxml;
    exports org_infantaelena_ies.MediatorUndertaleSelector;
    exports org_infantaelena_ies.MediatorUndertaleSelector.Vista;
    opens org_infantaelena_ies.MediatorUndertaleSelector.Vista to javafx.fxml;
}