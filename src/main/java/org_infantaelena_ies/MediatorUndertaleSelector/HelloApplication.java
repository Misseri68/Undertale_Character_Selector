package org_infantaelena_ies.MediatorUndertaleSelector;
import javafx.application.Application;
import javafx.stage.Stage;
import org_infantaelena_ies.MediatorUndertaleSelector.Mediator.Mediador;
import java.io.IOException;

public class HelloApplication extends Application {
    Mediador mediador = new Mediador();
    @Override
    public void start(Stage stage) throws IOException {
        mediador.iniciarSelectorView();
    }

    public static void main(String[] args) {
        launch();
    }
}