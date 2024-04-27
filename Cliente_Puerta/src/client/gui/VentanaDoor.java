package client.gui;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

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
import javax.swing.JOptionPane;

import java.util.Properties;
import java.io.FileInputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;


import client.controller.SMSController_Puerta;
import objetos.*;

public class VentanaDoor extends JFrame {

    private JPanel contentPane;
    SMSController_Puerta controller = null;

    public VentanaDoor(SMSController_Puerta controller) {

        this.controller = controller;

        Properties properties = new Properties();
        try {
            String currentDir = System.getProperty("user.dir");
            FileInputStream inputStream = new FileInputStream(currentDir + "/properties/config.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            // Manejo de la excepción FileNotFoundException
            e.printStackTrace(); // O cualquier otra acción que desees realizar
        } catch (IOException e) {
            // Manejo de la excepción IOException
            e.printStackTrace(); // O cualquier otra acción que desees realizar
}   

        setTitle("Door");
        setSize(500, 400); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelIcono = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
        
        ImageIcon icono = new ImageIcon("src/client/gui/imagenes/Logo.png"); 
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

        botonComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codAlojamiento = Integer.parseInt(properties.getProperty("codAlojamiento"));
                String codReserva = campoCodigoReserva.getText();
                Reserva reserva = new Reserva(0, 0, null, 0);
                try{
                    reserva = controller.comprobarReserva(codAlojamiento, codReserva);
                }
                catch(RemoteException ex){
                    ex.printStackTrace();
                }

                if(reserva != null){
                    System.out.println(reserva.getIdReserva());
                    JOptionPane.showMessageDialog(null, "Bienvenido a su apartamento", "Reserva comprobada", 0);
                }else{
                    JOptionPane.showMessageDialog(null, "La reserva no es correcta, está no es la habitación de su estancia", "Reserva incorrecta", 0);
                }
            }
        });

        panelPrincipal.add(panelLogin, BorderLayout.CENTER);

        add(panelPrincipal);
    }
}