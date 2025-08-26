import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class FrmJuego extends JFrame {

    private JLabel lblLanzamientos, lblCenas, lblDado1, lblDado2;
    private Dado dado1, dado2;
    private Random r;
    private int lanzamientos, cenas;

    public FrmJuego() {
        setSize(600, 300);
        setTitle("Juego de dados");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        lblDado1 = new JLabel();
        String archivoImagen = "imagenes/3.jpg";
        ImageIcon imgDado = new ImageIcon(getClass().getResource(archivoImagen));
        lblDado1.setIcon(imgDado);
        lblDado1.setBounds(10, 10, imgDado.getIconWidth(), imgDado.getIconHeight());
        getContentPane().add(lblDado1);

        lblDado2 = new JLabel();
        lblDado2.setIcon(imgDado);
        lblDado2.setBounds(20 + imgDado.getIconWidth(), 10, imgDado.getIconWidth(), imgDado.getIconHeight());
        getContentPane().add(lblDado2);

        JLabel lblTituloLanzamientos = new JLabel("Lanzamientos");
        lblTituloLanzamientos.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloLanzamientos.setBounds(30 + 2 * imgDado.getIconWidth(), 10, 100, 25);
        getContentPane().add(lblTituloLanzamientos);

        JLabel lblTituloCenas = new JLabel("Cenas");
        lblTituloCenas.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloCenas.setBounds(160 + 2 * imgDado.getIconWidth(), 10, 100, 25);
        getContentPane().add(lblTituloCenas);

        lblLanzamientos = new JLabel("0");
        lblLanzamientos.setBounds(30 + 2 * imgDado.getIconWidth(), 40, 100, 100);
        lblLanzamientos.setBackground(new Color(0, 0, 0));
        lblLanzamientos.setForeground(new Color(51, 255, 0));
        lblLanzamientos.setOpaque(true);
        lblLanzamientos.setHorizontalAlignment(SwingConstants.RIGHT);
        lblLanzamientos.setFont(new Font("Tahoma", 1, 72));
        getContentPane().add(lblLanzamientos);

        lblCenas = new JLabel("0");
        lblCenas.setBounds(160 + 2 * imgDado.getIconWidth(), 40, 100, 100);
        lblCenas.setBackground(new Color(0, 0, 0));
        lblCenas.setForeground(new Color(51, 255, 0));
        lblCenas.setOpaque(true);
        lblCenas.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCenas.setFont(new Font("Tahoma", 1, 72));
        getContentPane().add(lblCenas);

        JButton btnIniciar = new JButton("Iniciar Lanzamientos");
        btnIniciar.setBounds(10, 20 + imgDado.getIconHeight(), 200, 25);
        getContentPane().add(btnIniciar);

        JButton btnLanzar = new JButton("Lanzar");
        btnLanzar.setBounds(10, 60 + imgDado.getIconHeight(), 200, 25);
        getContentPane().add(btnLanzar);

        // agregar eventos
        btnIniciar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                iniciar();
            }

        });

        btnLanzar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lanzar();
            }

        });

        // Instanciar los dados y elgenerador de numeros aletorios
        dado1 = new Dado();
        dado2 = new Dado();

        r = new Random();
    }

    private void iniciar() {
        lanzamientos = 0;
        cenas = 0;
        lblLanzamientos.setText(String.valueOf(lanzamientos));
        lblCenas.setText(String.valueOf(cenas));

    }

    private void lanzar() {
        // lanzar los dados
        dado1.lanzar(r);
        dado2.lanzar(r);

        // mostrar los dados
        dado1.mostrar(lblDado1);
        dado2.mostrar(lblDado2);

        // actualizar contadores
        lanzamientos++;
        lblLanzamientos.setText(String.valueOf(lanzamientos));

        if (dado1.getNumero() + dado2.getNumero() >= 11) {
            cenas++;
            lblCenas.setText(String.valueOf(cenas));
        }
    }
}
