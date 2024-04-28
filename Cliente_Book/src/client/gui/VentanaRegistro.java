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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.rmi.RemoteException;

import client.controller.SMSController_Book;
import objetos.*;

public class VentanaRegistro extends JFrame {

    private SMSController_Book controller;
    private JPanel contentPane;

    public VentanaRegistro(SMSController_Book controller) {
        this.controller=controller;
        
        setTitle("Registro");
        setSize(600, 550); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelIcono = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));

        ImageIcon icono = new ImageIcon("src/client/gui/imagenes/Logo.png"); // Reemplaza la ruta con la ubicación de tu imagen descargada
        Image imagen = icono.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH); // Redimensionar la imagen a 50x50 píxeles
        ImageIcon iconoRedimensionado = new ImageIcon(imagen);

        // Crear un JLabel para mostrar la imagen
        JLabel labelImagen = new JLabel(iconoRedimensionado);

        // Agregar el JLabel al panelIcono
        panelIcono.add(labelImagen);

        // Agregar el panelIcono al panel principal en la parte superior izquierda
        panelPrincipal.add(panelIcono, BorderLayout.NORTH);


        // Crear un panel para los componentes de registro
        JPanel panelRegistro = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margen entre componentes
        panelRegistro.setBackground(Color.WHITE);

        // Añadir el label "REGISTRO" encima del campo de usuario
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel labelRegistro = new JLabel("REGISTRO");
        labelRegistro.setFont(new Font("Arial", Font.BOLD, 28)); // Establecer el tamaño y el estilo del texto
        panelRegistro.add(labelRegistro, gbc);

        // Añadir los labels y campos de texto para el registro
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panelRegistro.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        JTextField campoNombre = new JTextField(20);
        panelRegistro.add(campoNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelRegistro.add(new JLabel("Apellido:"), gbc);

        gbc.gridx = 1;
        JTextField campoApellido = new JTextField(20);
        panelRegistro.add(campoApellido, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelRegistro.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        JTextField campoEmail = new JTextField(20);
        panelRegistro.add(campoEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panelRegistro.add(new JLabel("Usuario:"), gbc);

        gbc.gridx = 1;
        JTextField campoUsuario = new JTextField(20);
        panelRegistro.add(campoUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panelRegistro.add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 1;
        JPasswordField campoContrasenya = new JPasswordField(20);
        panelRegistro.add(campoContrasenya, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panelRegistro.add(new JLabel("Repetir Contraseña:"), gbc);

        gbc.gridx = 1;
        JPasswordField campoConfirmarContrasenya = new JPasswordField(20);
        panelRegistro.add(campoConfirmarContrasenya, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton botonRegistrar = new JButton("Registrar");
        panelRegistro.add(botonRegistrar, gbc);
        
        JButton botonVolver = new JButton("Volver Atrás");
        gbc.gridx = 2;
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

        // Agregar el panel de registro al centro del panel principal
        panelPrincipal.add(panelRegistro, BorderLayout.CENTER);

        // Agregar el panel principal a la ventana
        add(panelPrincipal);

        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText().trim();
                String apellido = campoApellido.getText().trim();
                String email = campoEmail.getText().trim();
                String usuario = campoUsuario.getText().trim();
                String contrasenya = new String(campoContrasenya.getPassword()).trim();
                String confirmarContrasenya = new String(campoConfirmarContrasenya.getPassword()).trim();
                
                Usuario usuarioRegistrar = new Usuario(nombre, apellido, usuario, contrasenya, email);


                // Realizar validación de los campos aquí, por ejemplo:
                if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || usuario.isEmpty() || contrasenya.isEmpty() || confirmarContrasenya.isEmpty()) {
                    // Mostrar mensaje de error o realizar alguna acción adecuada
                    // Por ejemplo:
                    JOptionPane.showMessageDialog(VentanaRegistro.this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!contrasenya.equals(confirmarContrasenya)) {
                    // Las contraseñas no coinciden
                    // Mostrar mensaje de error o realizar alguna acción adecuada
                    JOptionPane.showMessageDialog(VentanaRegistro.this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try{
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
    }
}
