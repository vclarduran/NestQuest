package client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import client.controller.SMSController_Book;

public class VentanaPpal extends JFrame {

	private SMSController_Book controller;
	private JPanel contentPane;

	public VentanaPpal(SMSController_Book controller) {

		this.controller=controller;
		 setTitle("VentanaPpal");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        JPanel panel = new JPanel(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.fill = GridBagConstraints.VERTICAL;
	        gbc.insets = new Insets(10, 10, 10, 10); 

	        JLabel imageLabel = new JLabel(new ImageIcon("client/gui/imagenes/Logo.png")); // Reemplaza con la ruta de tu imagen
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.gridwidth = 1;
	        panel.add(imageLabel, gbc);

	        JLabel textLabel = new JLabel("\u00A1Reserva tu aventura!");
	        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        gbc.gridwidth = 1;
	        textLabel.setFont(new Font("Arial", Font.BOLD, 20));
	        textLabel.setForeground(Color.BLACK);
	        panel.add(textLabel, gbc);

	        JButton button = new JButton("Comenzar");
	        button.setAlignmentX(Component.CENTER_ALIGNMENT); 
	        button.setPreferredSize(new Dimension(150, 30)); 
	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        gbc.gridwidth = 1;
	        button.setPreferredSize(new Dimension(200, 40));
	        panel.add(button, gbc);
	        
	        getContentPane().add(panel, BorderLayout.CENTER);

	        pack();
	        setLocationRelativeTo(null); 
	        setVisible(true);
	        
	        button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            
	                VentanaLogin loginWindow = new VentanaLogin();
	                loginWindow.setVisible(true);
	                dispose(); 
	            }
	        });

    }


}
