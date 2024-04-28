package client.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import objetos.Habitacion;
import objetos.Usuario;
import client.controller.SMSController_Book;
import client.gui.VentanaFiltros;

public class VentanaAlojamientos extends JFrame {
    private Usuario haciendoConsulta;
    private SMSController_Book controller;

    public VentanaAlojamientos(Usuario u, SMSController_Book controller, List<Habitacion> lista) {
        this.haciendoConsulta = u;
        this.controller = controller;

        // Configuración de la ventana principal
        setTitle("Detalles de Alojamientos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Creación del panel principal
        JPanel panel = new JPanel(new GridLayout(lista.size(), 1)); // Un GridLayout para mostrar los alojamientos en una columna

        // Iterar sobre la lista de habitaciones para agregarlas al panel
        for (Habitacion habitacion : lista) {
            // Crear un panel para cada alojamiento
            JPanel alojamientoPanel = new JPanel(new GridLayout(3, 1)); // Un GridLayout para mostrar los detalles en 3 filas

            // Agregar nombre
            JLabel nombreLabel = new JLabel("Nombre: " + habitacion.getNombre());
            alojamientoPanel.add(nombreLabel);

            // Agregar descripción
            JLabel descripcionLabel = new JLabel("Descripción: " + habitacion.getDescripcion());
            alojamientoPanel.add(descripcionLabel);

            // Agregar aforo
            JLabel aforoLabel = new JLabel("Aforo: " + habitacion.getAforo());
            alojamientoPanel.add(aforoLabel);

            // Agregar el panel de alojamiento al panel principal
            panel.add(alojamientoPanel);
        }

        // Crear un JScrollPane y agregar el panel principal
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Agregar el JScrollPane a la ventana
        add(scrollPane);
    }

    // Método para mostrar la ventana
    public void mostrarVentana() {
        setVisible(true);
    }
}
