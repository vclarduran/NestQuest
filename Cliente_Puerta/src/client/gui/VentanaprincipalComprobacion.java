package client.gui;

import javax.swing.JOptionPane;

import java.io.FileInputStream;
import java.util.Properties;

import client.controller.SMSController_Door;

public class VentanaprincipalComprobacion {

    private SMSController_Door controller = null;

    Properties properties = new Properties();
    FileInputStream inputStream = new FileInputStream("../../properties/config.properties"); 
    properties.load(inputStream);

    //TODOS LOS COMPONENTES Y ASI

    //Action listener
    
    int codAlojamiento = Integer.parseInt(properties.getProperty("codAlojamiento"))
    boolean comprobacion = controller.comprobarReserva(codAlojamiento, codReserva);

    if(comprobacion){
        JOptionPane.showMessageDialog(null, "Bienvenido a su apartamento", "Reserva comprobada", 0);
    }else{
        JOptionPane.showMessageDialog(null, "La reserva no es correcta, está no es la habitación de su estancia", "Reserva incorrecta", 0);
    }
        

}
