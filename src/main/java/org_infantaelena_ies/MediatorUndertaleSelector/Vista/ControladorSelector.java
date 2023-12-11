package org_infantaelena_ies.MediatorUndertaleSelector.Vista;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import org_infantaelena_ies.MediatorUndertaleSelector.Mediator.Mediador;
import org_infantaelena_ies.MediatorUndertaleSelector.Modelo.Personaje;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ControladorSelector {

    @FXML
    private VBox vbox;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;

    @FXML
    private Label personajeVotado;
    private Mediador mediador;

    private MediaView mediaView2 = new MediaView(new MediaPlayer(new Media(new File("src/main/resources/mp3s/menu.mp3").toURI().toString())));

    public ControladorSelector() {
    }


    public void cargarPanel(Personaje[] personajes, GridPane gridpane, VBox vBox){
        Image imagenDeFondo = new Image(new File("src/main/resources/img/castleBackground.png").toURI().toString());
        vBox.setStyle("-fx-background-image: url('" + imagenDeFondo.getUrl() + "'); -fx-background-position: center ; -fx-background-size: 1100px 946px; ");
        int i = 0;
        for (Node node : gridpane.getChildren()) {
            if (node instanceof Button) {
                if (i < personajes.length) {
                    Button button = (Button) node;
                    ImageView imagen1 = new ImageView(personajes[i].getImagen());
                    ImageView imagen2 = new ImageView(personajes[i].getImagen2());
                    imagen1.setFitWidth(300);
                    imagen1.setFitHeight(380);
                    imagen1.setPreserveRatio(true);
                    imagen2.setFitWidth(300);
                    imagen2.setFitHeight(380);
                    imagen2.setPreserveRatio(true);
                    button.setGraphic(imagen1);
                    button.setText(personajes[i].getNombre());
                    button.setStyle("-fx-text-fill: transparent");
                    button.setOnMouseEntered(mouseEvent -> {

                        button.setGraphic(imagen2);
                    });
                    button.setOnMouseExited(mouseEvent -> {
                        button.setGraphic(imagen1);
                    });
                    i++;
                }

            }
        }
    }

    public void personajeClickado(MouseEvent mouseEvent) throws IOException {
        String nombre = ((Button) mouseEvent.getSource()).getText();
        mediador.personajeSeleccionado(nombre);
        MediaView mediaViewSelecc = new MediaView(new MediaPlayer(new Media(new File("src/main/resources/mp3s/selectSound.mp3").toURI().toString())));
        mediaViewSelecc.getMediaPlayer().play();
        mediaView2.getMediaPlayer().stop();
    }

    public void reproducirSonidoUndertale(){
        try{
            String rutaMP3 = "src/main/resources/mp3s/undertaleSound.mp3";
            Media sonidoUndertale = new Media(new File(rutaMP3).toURI().toString());
            MediaView mediaView = new MediaView();
            mediaView.setMediaPlayer(new MediaPlayer(sonidoUndertale));
            mediaView.getMediaPlayer().play();
            //Canción del menú.
            mediaView2.getMediaPlayer().play();
        } catch (IllegalArgumentException e){
            System.out.println("Error con la reproducción de audio");
            e.printStackTrace();
        }

    }

    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void setPersonajeVotado(Label personajeVotado) {
        this.personajeVotado = personajeVotado;
    }
    public Label getPersonajeVotado() {
        return personajeVotado;
    }
    public GridPane getGridPane() {
        return gridPane;
    }
}
