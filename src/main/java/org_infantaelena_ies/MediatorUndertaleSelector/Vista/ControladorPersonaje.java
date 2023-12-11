package org_infantaelena_ies.MediatorUndertaleSelector.Vista;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import org_infantaelena_ies.MediatorUndertaleSelector.Mediator.Mediador;
import org_infantaelena_ies.MediatorUndertaleSelector.Modelo.Personaje;

import java.io.File;

public class ControladorPersonaje {
    @FXML
    private Label header, nombre, descripcion, residencia;
    @FXML
    private Button boton, btVoz, btMusica;
    @FXML
    private MediaView mediaViewVoz, mediaViewSong;
    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imagen, imgToby, gifText;
    @FXML
    private VBox vBox;

    public void cargarDatosView(Personaje personaje, Mediador mediador) {
        if (!personaje.getNombre().equals("Gaster")) {
            nombre.setText(nombre.getText() + " " + personaje.getNombre());
            descripcion.setText(descripcion.getText() + " " + personaje.getDescripcion());
            descripcion.setMinWidth(Region.USE_PREF_SIZE);
            descripcion.setMaxWidth(Double.MAX_VALUE);
            descripcion.setWrapText(true);
            residencia.setText(residencia.getText() + " " + personaje.getResidencia());
            imagen.setImage(personaje.getImagen());
            establecerImagenDeFondo(root, personaje.getImagenBackground());
            if (personaje.getVoz() != null) {
                mediaViewVoz.setMediaPlayer(new MediaPlayer(personaje.getVoz()));
            } else {
                mediaViewSong.setVisible(false);
                btVoz.setVisible(false);
            }
            mediaViewSong.setMediaPlayer(new MediaPlayer(personaje.getMusica()));
            btVoz.setOnMouseClicked(event -> {
                mediaViewVoz.getMediaPlayer().play();
            });
            btMusica.setOnMouseClicked((event -> {
                mediaViewSong.getMediaPlayer().play();
            }));
            boton.setOnMouseClicked(event -> {
                mediador.personajeVotado(personaje);
            });
        } else {
            invisibilizarHijos(vBox);
            imagen.setVisible(false);
            header.setVisible(false);
            stackPane.setVisible(false);
            imgToby.setVisible(true);
            //Hago una nueva imagen en vez de cargarla del personaje ya que el gif está pensado para que solo se repita una vez, y al  leer el personaje la iamgen se "carga" y ya se inicia.
            imgToby.setImage(new Image(new File("src/main/resources/img/AnnoyingDog.gif").toURI().toString()));
            gifText.setVisible(true);
            gifText.setImage(new Image(new File("src/main/resources/img/gasterText.gif").toURI().toString()));
            boton.setText("Accept this fate.");
            mediaViewVoz.setMediaPlayer(new MediaPlayer(personaje.getVoz()));
            mediaViewVoz.getMediaPlayer().play();
            mediaViewSong.setMediaPlayer(new MediaPlayer(personaje.getMusica()));
            mediaViewSong.getMediaPlayer().play();
            boton.setOnMouseClicked(event -> {
                mediador.personajeVotado(new Personaje("B̶̶̡̢̙̦̟̻̣̯̺̮͖͗͆̊̓̈́ͫ̈͌̽̂͝E̶̴̸̡͔̘͔̘̹̱̭͙̹̒ͮ͊̊͐ͯ͒̎̎͝W̫̽͛̂ͥ̚Ä͙̬̖̥̹̒ͣͨ͑Ȓ̡̭̜̬͍͎͍̼̱̣̲̻͙̰ͣ̂ͤ̈̓ͧ͘̚͜E̵̲̲̪̣̝̝̬̮̣͎̪͛̅̌ͩ̑̓̒̎̚͢_̤̝ͮ N̵̶̛̩͍̩͇̭̮̼̞ͭ͂̎̾͛ͩ̀̏͘͘Ư͇̩̞̯͎ͫ͗͌̂̽̎̉ͩ̌ͣ̚̕̕͘͟͡L̼̲̝͍̪͇̆̔͝L̛̗̪̣̻̜̑ͫ̑͂͘͟ C̨̛̣̖̝̲̟̬͖̐̓͌̃̊ͩ͛ͯ̃̆͛̑ͭ̏͜͜͝H̡̡̳̜̲͎͍ͩ̀̆͂̀ͨ̓ͤ̚͟A̖̅R̢̤͖͇̝͍̭͙̤̼̝̽̋̈̑́͂͆ͥ̋̑̐ͤ͘͟͟A͖͍͙͍͍͕̱̍͋̽̇̋̕͝Ç̵̵̥̲̻͇̤͇̗̥̼̤̰͎ͤͪ̽ͮ͐̋́ͪ͟ͅͅT̬͚̰́_͊__͓̦͇̗̖̲ͬ̏ͬͭ̆ͭ͋_͌͠Ě̵̵̥̥̮̙̳̗̠̈ͤͤ́̈́ͦ̐͘͜R̘̥ͧ"));
                mediaViewSong.getMediaPlayer().stop();
                mediaViewVoz.getMediaPlayer().play();
                Mediador.cerrarVentana(mediador.getStagePersonaje());

            });
        }

    }

    public static void establecerImagenDeFondo(AnchorPane anchorPane, Image imagenDeFondo) {
        String estiloDeFondo = String.format("-fx-background-image: url('%s'); -fx-background-repeat: no-repeat; -fx-background-position: center;", imagenDeFondo.getUrl());
        anchorPane.setStyle(estiloDeFondo);
    }


    public MediaView getMediaViewVoz() {
        return mediaViewVoz;
    }

    public MediaView getMediaViewSong() {
        return mediaViewSong;
    }

    // Método para establecer la visibilidad en false para todos los hijos de un nodo
    public static void invisibilizarHijos(Parent padre) {
        padre.setVisible(false);
        for (Node child : padre.getChildrenUnmodifiable()) {
            child.setVisible(false);

            // Si el hijo también es un contenedor, llamamos recursivamente al método
            if (child instanceof Parent) {
                invisibilizarHijos((Parent) child);
            }
        }
    }

    public ImageView getGifText() {
        return gifText;
    }
}