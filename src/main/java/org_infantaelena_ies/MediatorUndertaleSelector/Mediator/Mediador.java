package org_infantaelena_ies.MediatorUndertaleSelector.Mediator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org_infantaelena_ies.MediatorUndertaleSelector.HelloApplication;
import org_infantaelena_ies.MediatorUndertaleSelector.Modelo.Personaje;
import org_infantaelena_ies.MediatorUndertaleSelector.Vista.ControladorPersonaje;
import org_infantaelena_ies.MediatorUndertaleSelector.Vista.ControladorSelector;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Mediador {
    static Path rutaCSV = Paths.get("src/main/resources/personajesCSV.csv");
    static File rutaSelecFXML = new File("src/main/resources/org_infantaelena_ies/MediatorUndertaleSelector/VentanaSelector.fxml");
    static File rutaCharacterFXML = new File("src/main/resources/org_infantaelena_ies/MediatorUndertaleSelector/VentanaPersonaje.fxml");

    ControladorPersonaje ctrlChar = new ControladorPersonaje();
    ControladorSelector controlador;
    Stage stagePersonaje;
    Personaje[] personajes = new Personaje[10];

    public void iniciarSelectorView() throws IOException {
        Font.loadFont(getClass().getResourceAsStream("/fonts/8bitoperator JVE Regular.ttf"), 30);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(rutaSelecFXML.toURI().toURL());
        try{
            Scene scene = new Scene(loader.load(), 927, 946);
            controlador = loader.getController();
            controlador.setMediador(this);
            Stage stage = new Stage();
            stage.setTitle("Undertale Selector");
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
        controlador.reproducirSonidoUndertale();
        leerPersonajes();
        controlador.cargarPanel(personajes, controlador.getGridPane(), controlador.getVbox());
    }


    public void iniciarCharacterView(Personaje personaje) throws IOException {
        Font.loadFont(getClass().getResourceAsStream("/fonts/8bitoperator JVE Regular.ttf"), 30);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(rutaCharacterFXML.toURI().toURL());
        Scene scene = new Scene(loader.load(), 712, 462);
        ctrlChar = loader.getController();
        Stage stage = new Stage();
        stagePersonaje = stage;
        stage.setTitle("Undertale Character Info");
        stage.setScene(scene);
        stage.show();
        ctrlChar.cargarDatosView(personaje, this);
        stage.setOnCloseRequest(windowEvent -> {
            if(ctrlChar.getMediaViewVoz().getMediaPlayer()!=null) {
                ctrlChar.getMediaViewVoz().getMediaPlayer().stop();
            }
            ctrlChar.getMediaViewSong().getMediaPlayer().stop();
            cerrarVentana(stage);
        });
    }



    public static void cerrarVentana(Stage ventana) {
        if (ventana != null) {
            ventana.close();
        }
    }

    public void personajeSeleccionado(String nombreseleccionado) throws IOException {
        Personaje personajeSeleccionado = null;
        for (int i = 0; i < personajes.length; i++) {
            if(personajes[i].getNombre().equals(nombreseleccionado)){
                personajeSeleccionado = personajes[i];
            }
        }
        iniciarCharacterView(personajeSeleccionado);
    }
    public void personajeVotado(Personaje personaje){
        controlador.getPersonajeVotado().setText("You chose to vote...  " + personaje.getNombre() + " !!!");
    }

    public Personaje[] leerPersonajes(){
        try( BufferedReader br = new BufferedReader(new FileReader(new File(String.valueOf(rutaCSV))))) {
            br.readLine(); //para que lea la cabecera y no la cargue como dato
            String[] datos;
            String line;
            for (int i = 0; i < 10; i++) {
                line = br.readLine();
                datos = line.split(",");
                Personaje p = new Personaje();
                try{
                    p.setNombre(datos[0]);
                    p.setImagen(datos[1]);
                    p.setImagen2(datos[2]);
                    p.setDescripcion(datos[3]);
                    p.setResidencia(datos[4]);
                    p.setVoz(datos[5]);
                    p.setMusica(datos[6]);
                    p.setImagenBackground(datos[7]);
                }catch (Exception e){
                    System.out.println("No se han podido establecer los datos del " + i + " personaje. Nombre: " + datos[0]);
                    e.printStackTrace();
                }

                this.personajes[i] = p;
                System.out.println("personaje " + personajes[i].getNombre() + " añadido correctamente");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajes;
    }
    public Personaje[] getPersonajes() {
        return personajes;
    }

    public Stage getStagePersonaje() {
        return stagePersonaje;
    }

    public ControladorPersonaje getCtrlChar() {
        return ctrlChar;
    }

}
