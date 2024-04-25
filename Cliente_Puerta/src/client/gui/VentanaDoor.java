package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Door extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Door frame = new Door();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Door() {
        setTitle("Door");
        setSize(500, 400); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelIcono = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));

        ImageIcon icono = new ImageIcon("src/gui/Imagenes/Logo.png"); 
        Image imagen = icono.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH); 
        ImageIcon iconoRedimensionado = new ImageIcon(imagen);

        JLabel labelImagen = new JLabel(iconoRedimensionado);

        panelIcono.add(labelImagen);

        panelPrincipal.add(panelIcono, BorderLayout.NORTH);

        JPanel panelLogin = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        panelLogin.setBackground(Color.WHITE);

        
        JLabel labelCodigoReserva = new JLabel("Introduzca su código de reserva:");
        labelCodigoReserva.setFont(new Font("Arial", Font.BOLD, 16)); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelLogin.add(labelCodigoReserva, gbc);

       
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        JTextField campoCodigoReserva = new JTextField(20);
        panelLogin.add(campoCodigoReserva, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton botonComprobar = new JButton("Comprobar");
        panelLogin.add(botonComprobar, gbc);

        panelPrincipal.add(panelLogin, BorderLayout.CENTER);

        add(panelPrincipal);
    }
}