package client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import client.controller.SMSController_Book;

public class Filtros extends JFrame {
    private SMSController_Book controller;

    private JPanel contentPane;


    public Filtros(SMSController_Book controller) {
        this.controller=controller;
        
        setTitle("Filtros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        JPanel panelIcono = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ImageIcon icono = new ImageIcon("src/gui/Imagenes/Logo.png");
        Image imagen = icono.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagen);
        JLabel labelImagen = new JLabel(iconoRedimensionado);
        panelIcono.setBackground(Color.white);
        panelIcono.add(labelImagen);

        JPanel panelIcono1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        ImageIcon icono1 = new ImageIcon("src/gui/Imagenes/Persona.png");
        Image imagen1 = icono1.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado1 = new ImageIcon(imagen1);
        JButton botonIcono = new JButton(iconoRedimensionado1);
        botonIcono.setBackground(Color.white);
        panelIcono1.setBackground(Color.white);
        panelIcono1.add(botonIcono);

        panelPrincipal.add(panelIcono, BorderLayout.WEST);
        panelPrincipal.add(panelIcono1, BorderLayout.EAST);

        JPanel panelLogin = new JPanel(new GridBagLayout());
        panelPrincipal.add(panelLogin, BorderLayout.CENTER);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 20, 5);

        JLabel labelInic = new JLabel("INICIA TU AVENTURA");
        labelInic.setFont(new Font("Arial", Font.BOLD, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelLogin.add(labelInic, gbc);

        JLabel labelInic1 = new JLabel("respondiendo a las siguientes preguntas");
        labelInic1.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridy = 1;
        panelLogin.add(labelInic1, gbc);

        gbc.gridy = 2;
        panelLogin.add(Box.createVerticalStrut(20), gbc);

        JLabel labelDatePicker1 = new JLabel("Fecha llegada:");
        labelDatePicker1.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panelLogin.add(labelDatePicker1, gbc);

        UtilDateModel model1 = new UtilDateModel();
        Properties p1 = new Properties();
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p1);
        datePanel1.setPreferredSize(new Dimension(150, 180));
        JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, null);
        
        JLabel labelFechaSeleccionada = new JLabel("                    ");
        panelLogin.add(labelFechaSeleccionada, gbc);
        datePanel1.addActionListener(e -> {
            Date selectedDate = (Date) datePanel1.getModel().getValue();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Formato de fecha deseado
            String dateString = (selectedDate != null) ? sdf.format(selectedDate) : ""; // Evita NPE si no se selecciona ninguna fecha
            labelFechaSeleccionada.setText("                                        " + dateString);
            
        });
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panelLogin.add(datePicker1, gbc);
     

        JLabel labelDatePicker2 = new JLabel("Fecha salida:");
        labelDatePicker2.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panelLogin.add(labelDatePicker2, gbc);

        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p2);
        datePanel2.setPreferredSize(new Dimension(150, 180));
        JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, null);
        
        JLabel labelFechaSeleccionada2 = new JLabel("                    ");
        panelLogin.add(labelFechaSeleccionada2, gbc);
        datePanel2.addActionListener(e -> {
            Date selectedDate1 = (Date) datePanel2.getModel().getValue();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Formato de fecha deseado
            String dateString = (selectedDate1 != null) ? sdf.format(selectedDate1) : ""; // Evita NPE si no se selecciona ninguna fecha
            labelFechaSeleccionada2.setText("                                        " + dateString);
            
        });
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panelLogin.add(datePicker2, gbc);

        JLabel labelSpinner = new JLabel("Numero de viajeros:");
        labelSpinner.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        panelLogin.add(labelSpinner, gbc);

        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        JSpinner spinner = new JSpinner(spinnerModel);
        Dimension spinnerSize = spinner.getPreferredSize();
        spinnerSize.width = 50;
        spinner.setPreferredSize(spinnerSize);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panelLogin.add(spinner, gbc);

        JLabel labelTransporte = new JLabel("Método de transporte:");
        labelTransporte.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        panelLogin.add(labelTransporte, gbc);

        String[] opcionesTransporte = {"Coche", "Tren", "Avión"};
        JComboBox<String> comboBoxTransporte = new JComboBox<>(opcionesTransporte);
        comboBoxTransporte.setSelectedIndex(-1);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panelLogin.add(comboBoxTransporte, gbc);

        JLabel labelSpinner1 = new JLabel("Cercania (horas max):");
        labelSpinner1.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 7; // Ajuste de coordenada gridy para colocar debajo del JComboBox
        gbc.anchor = GridBagConstraints.WEST;
        panelLogin.add(labelSpinner1, gbc);

        SpinnerModel spinnerModel1 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        JSpinner spinner1 = new JSpinner(spinnerModel1);
        Dimension spinnerSize1 = spinner1.getPreferredSize();
        spinnerSize1.width = 50;
        spinner1.setPreferredSize(spinnerSize1);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panelLogin.add(spinner1, gbc);
        
        JLabel labelSlider = new JLabel("Precio minimo: ");
        labelSlider.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 8; // Nueva fila para el JSlider
        gbc.anchor = GridBagConstraints.WEST;
        panelLogin.add(labelSlider, gbc);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 600, 0); // Rango de 0 a 1000 en incrementos de 100
        slider.setMajorTickSpacing(100);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        Dimension sliderSize = new Dimension(250, slider.getPreferredSize().height); // Ajusta el tamaño horizontal del JSlider
        slider.setPreferredSize(sliderSize);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panelLogin.add(slider, gbc);
        
        JLabel labelValorSlider2 = new JLabel("0");
        gbc.gridy= 9;
        gbc.anchor = GridBagConstraints.EAST;
        panelLogin.add(labelValorSlider2, gbc);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valor = slider.getValue();
                labelValorSlider2.setText(String.valueOf(valor));
            }
        });
        
        JLabel labelSlider1 = new JLabel("Precio maximo: ");
        labelSlider1.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 10; // Nueva fila para el JSlider
        gbc.anchor = GridBagConstraints.WEST;
        panelLogin.add(labelSlider1, gbc);

        JSlider slider1 = new JSlider(JSlider.HORIZONTAL, 0, 600, 0); // Rango de 0 a 1000 en incrementos de 100
        slider1.setMajorTickSpacing(100);
        slider1.setMinorTickSpacing(10);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        Dimension sliderSize1 = new Dimension(250, slider1.getPreferredSize().height); // Ajusta el tamaño horizontal del JSlider
        slider1.setPreferredSize(sliderSize1);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panelLogin.add(slider1, gbc);
        
        JLabel labelValorSlider1 = new JLabel("0");
        gbc.gridy= 11;
        gbc.anchor = GridBagConstraints.EAST;
        panelLogin.add(labelValorSlider1, gbc);

        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valor = slider1.getValue();
                labelValorSlider1.setText(String.valueOf(valor));
            }
        });
        
        JButton button = new JButton("Comprobar");
        
        button.setPreferredSize(new Dimension(150, 30)); // Establece un tamaño más pequeño
        gbc.gridy = 12;
       
       
        button.setPreferredSize(new Dimension(200, 40));
        gbc.anchor = GridBagConstraints.CENTER;
        panelLogin.add(button, gbc);
        
        
        
        setLocationRelativeTo(null); 
        getContentPane().add(panelPrincipal);
    }
}
