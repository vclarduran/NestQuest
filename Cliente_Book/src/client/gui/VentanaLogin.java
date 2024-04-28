package client.gui;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.rmi.RemoteException;

import client.controller.SMSController_Book;
import objetos.*;


public class VentanaLogin extends JFrame {

    private SMSController_Book controller;

	private JPanel contentPane;
    
	public VentanaLogin(SMSController_Book controller) {
        this.controller=controller;

		setTitle("Login");
        setSize(600, 500); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelIcono = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
        
        ImageIcon icono = new ImageIcon("src/client/gui/imagenes/Logo.png"); 
        // Image imagen = icono.habitImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH); 
        Image imagen = icono.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagen);
        
        JLabel labelImagen = new JLabel(iconoRedimensionado);
        
        panelIcono.add(labelImagen);
        
        panelPrincipal.add(panelIcono, BorderLayout.NORTH);
        
        JPanel panelLogin = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        panelLogin.setBackground(Color.WHITE);
        
        JLabel labelLogin = new JLabel("Login");
        labelLogin.setFont(new Font("Arial", Font.BOLD, 28)); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelLogin.add(labelLogin, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panelLogin.add(new JLabel("Usuario:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        JTextField campoUsuario = new JTextField(20);
        panelLogin.add(campoUsuario, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panelLogin.add(new JLabel("Contraseña:"), gbc);
        
        gbc.gridx = 1;
        JTextField campoContrasenya = new JPasswordField(20);
        panelLogin.add(campoContrasenya, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton botonLogin = new JButton("Login");
        panelLogin.add(botonLogin, gbc);
        botonLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String contrasenya = campoContrasenya.getText();
                try{
                    Usuario usuarioRespuesta = controller.comprobarUsuario(usuario, contrasenya);
                
                    if(usuarioRespuesta != null){
                        VentanaFiltros filtrado = new VentanaFiltros(controller, usuarioRespuesta);
                        filtrado.setVisible(true);
                        System.out.println("Inicio de sesión exitoso");
                    }else{
                        System.out.println("Usuario no existe");
                    }
                }catch (RemoteException ex){
                    ex.printStackTrace();
                }
                

            }
        });
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel labelNoCuenta = new JLabel("¿No tienes cuenta?");
        panelLogin.add(labelNoCuenta, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton botonCrearCuenta = new JButton("Crear cuenta");
        botonCrearCuenta.setForeground(Color.RED);
        panelLogin.add(botonCrearCuenta, gbc);
        //
        botonCrearCuenta.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRegistro ventanaRegistro = new VentanaRegistro(controller);
                ventanaRegistro.setVisible(true);
                dispose();
            }
        });
               
        panelPrincipal.add(panelLogin, BorderLayout.CENTER);
                
        add(panelPrincipal);
    }
}