import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javazoom.jl.player.Player;

public class Dado {

    private int numero;

    public void lanzar(Random r) {
        // asignarle al numero del dado un valor al azar entr 1 y 6
        numero = r.nextInt(6) + 1;
    }

    public void mostrar(JLabel lbl) {
        String nombreArchivo = "/imagenes/" + numero + ".jpg";
        ImageIcon imgDado = new ImageIcon(getClass().getResource(nombreArchivo));

        lbl.setIcon(imgDado);
    }

    public int getNumero() {
        return numero;
    }

    public void sonar() {

        // cargar el archivo MP3 de audio
        String nombreArchivoSonido = System.getProperty("user.dir") +
                "/src/sonidos/DadosLanzados.mp3";
        try {
            FileInputStream fis = new FileInputStream(nombreArchivoSonido);
            BufferedInputStream bis = new BufferedInputStream(fis);
            Player reproductor = new Player(bis);
            reproductor.play();
        } catch (Exception ex) {
        }

    }

}
