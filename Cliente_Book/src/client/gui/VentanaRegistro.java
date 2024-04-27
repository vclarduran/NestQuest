package client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.rmi.RemoteException;

import client.controller.SMSController_Book;
import objetos.*;

public class VentanaRegistro extends JFrame {

    private SMSController_Book controller;

    private JPanel contentPane;
    
    public VentanaRegistro(SMSController_Book controller) {
        this.controller = controller;
        
        setTitle("Registro");
        setSize(600, 500); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelIcono = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        ImageIcon icono = new ImageIcon("src/client/gui/imagenes/Logo.png"); 
        Image imagen = icono.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH); 
        ImageIcon iconoRedimensionado = new ImageIcon(imagen);
        
        JLabel labelImagen = new JLabel(iconoRedimensionado);
        
        panelIcono.add(labelImagen);
        
        panelPrincipal.add(panelIcono, BorderLayout.NORTH);
        
        JPanel panelRegistro = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        panelRegistro.setBackground(Color.WHITE);
        
        JLabel labelRegistro = new JLabel("Registro");
        labelRegistro.setFont(new Font("Arial", Font.BOLD, 28)); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelRegistro.add(labelRegistro, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panelRegistro.add(new JLabel("Nombre:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        JTextField campoNombre = new JTextField(20);
        panelRegistro.add(campoNombre, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panelRegistro.add(new JLabel("Apellido:"), gbc);
        
        gbc.gridx = 1;
        JTextField campoApellido = new JTextField(20);
        panelRegistro.add(campoApellido, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panelRegistro.add(new JLabel("Usuario:"), gbc);
        
        gbc.gridx = 1;
        JTextField campoUsuario = new JTextField(20);
        panelRegistro.add(campoUsuario, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panelRegistro.add(new JLabel("Contraseña:"), gbc);
        
        gbc.gridx = 1;
        JTextField campoContrasenya = new JPasswordField(20);
        panelRegistro.add(campoContrasenya, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panelRegistro.add(new JLabel("Email:"), gbc);
        
        gbc.gridx = 1;
        JTextField campoEmail = new JTextField(20);
        panelRegistro.add(campoEmail, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton botonRegistro = new JButton("Registrarse");
        panelRegistro.add(botonRegistro, gbc);
        botonRegistro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String apellido = campoApellido.getText();
                String usuario = campoUsuario.getText();
                String contrasenya = campoContrasenya.getText();
                String email = campoEmail.getText();
                Usuario usuarioRegistrar = new Usuario(nombre, apellido, usuario, contrasenya, email);

                try{
                    // Usuario usuarioRespuesta = controller.comprobarUsuario(usuario, contrasenya);
                    boolean registradoCorrecto = controller.crearUsuario(usuarioRegistrar);

                    if (registradoCorrecto){
                        //ACCEDER A LA VENTANA DE FILTROS
                        System.out.println("Registro exitoso. "+ usuarioRegistrar);
                        dispose();
                    }else{
                        System.out.println("Registro fallido");

                    }
                    
                }catch (RemoteException ex){
                    ex.printStackTrace();
                }
                
            }
        });
        
        JButton botonVolver = new JButton("Volver Atrás");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panelRegistro.add(botonVolver, gbc);
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaLogin ventanaLogin = new VentanaLogin(controller);
                ventanaLogin.setVisible(true);
                dispose();
            }
        });
        
        panelPrincipal.add(panelRegistro, BorderLayout.CENTER);
                
        add(panelPrincipal);
    }

}
