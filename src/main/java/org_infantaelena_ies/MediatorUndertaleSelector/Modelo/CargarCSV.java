package org_infantaelena_ies.MediatorUndertaleSelector.Modelo;

import java.io.FileWriter;
import java.io.IOException;

public class CargarCSV {

    public static void convertToCSV(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Nombre,Imagen,Imagen2,Descripcion,Residencia,Voz,Musica,ImagenResidencia\n");
            writer.write("Frisk,src/main/resources/img/Frisk.png,src/main/resources/img/Frisk.png,Extremely determined human. The protagonist. The fallen angel. Might poke you with a stick or flirt.,The Ruins,vacio,src/main/resources/mp3s/friskSong.mp3,src/main/resources/img/friskBackground.png,\n");
            writer.write("Flowey,src/main/resources/img/Flowey1.png,src/main/resources/img/Flowey2.png,EXTREMELY rude. Little devil. It wants all the power. It's kill or be killed.,The Ruins,src/main/resources/mp3s/floweyVoice.mp3,src/main/resources/mp3s/floweySong.mp3,src/main/resources/img/friskBackground.png,\n");
            writer.write("Toriel,src/main/resources/img/Toriel1.png,src/main/resources/img/Toriel2.png,Known to community as 'Goat mom'. Makes amazing butterscotch cinnamon pie. Perfect for mommy issues. Used to be queen.,The Ruins,src/main/resources/mp3s/torielVoice.mp3,src/main/resources/mp3s/torielSong.mp3,src/main/resources/img/torielBackground.png,\n");
            writer.write("Sans,src/main/resources/img/Sans1.gif,src/main/resources/img/Sans2.gif,The man of the hour. The MEME. Sans the Skeleton himself. Doesn't play by the rules. CAN and WILL destroy you if you cross the line. Just don't. Seriously. It will end bad for you. And for everyone else if you've crossed the line. Just don't. Please.,Snowdin,src/main/resources/mp3s/sansVoice.mp3,src/main/resources/mp3s/sansSong.mp3,src/main/resources/img/forestBackground.png,\n");
            writer.write("Papyrus,src/main/resources/img/Papyrus1.png,src/main/resources/img/Papyrus2.png,The Great Papyrus. Enthusiastic and full of energy. Dreams of joining the Royal Guard. Loves spaghetti. Watch out for his special attack: a non-threatening bone-shaped gift.,Snowdin,src/main/resources/mp3s/papyrusVoice.mp3,src/main/resources/mp3s/papyrusSong.mp3,src/main/resources/img/forestBackground.png,\n");
            writer.write("Undyne,src/main/resources/img/Undyne1.gif,src/main/resources/img/Undyne2.gif,The Undying. Head of the Royal Guard. Fierce and determined. Will do anything to protect monsters. Loves challenges. Spear of justice is ready.,Waterfall,src/main/resources/mp3s/undyneVoice.mp3,src/main/resources/mp3s/undyneSong.mp3,src/main/resources/img/undyneBackground.png,\n");
            writer.write("Alphys,src/main/resources/img/Alphys1.png,src/main/resources/img/Alphys2.png,Nerdy and shy royal scientist. Loves anime and manga. Has a crush on Undyne. Enjoys creating puzzles and robots. Secretly watches anime in her lab.,Hotland,src/main/resources/mp3s/alphysVoice.mp3,src/main/resources/mp3s/alphysSong.mp3,src/main/resources/img/alphysBackground.png,\n");
            writer.write("Mettaton,src/main/resources/img/Mettaton1.gif,src/main/resources/img/Mettaton2.gif,The glamorous robot. Loves the spotlight. Host of 'Mettaton's Live Show'. His legs are fabulous. Will turn you into a star. Rated 'M' for Mettaton.,Hotland,src/main/resources/mp3s/mettatonVoice.mp3,src/main/resources/mp3s/mettatonSong.mp3,src/main/resources/img/mettatonBackground.png,\n");
            writer.write("Asgore,src/main/resources/img/Asgore1.png,src/main/resources/img/Asgore2.png,King of the Underground. Gentle giant with a tragic past. Holds the key to the barrier. Loves golden flowers. Be prepared for a heartwarming battle.,New Home,src/main/resources/mp3s/asgoreVoice.mp3,src/main/resources/mp3s/asgoreSong.mp3,src/main/resources/img/asgoreBackground.png,\n");
            writer.write("Gaster,src/main/resources/img/Gaster1.png,src/main/resources/img/Gaster2.png,vacio,vacio,src/main/resources/mp3s/gasterSound.mp3,src/main/resources/mp3s/gasterSong.mp3,src/main/resources/img/gasterText.gif,\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// \" \" para poder poner cosas "prohibidas" entre "" en un csv
    public static void main(String[] args) {
        convertToCSV("src/main/resources/personajesCSV.csv");
    }
}

