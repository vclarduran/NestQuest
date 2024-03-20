package objetos;

public class Alojamiento {
	
	private String nombre;
    private String descripcion;
    private String direccion;

    public Alojamiento(String nombre, String descripcion, String direccion){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.direccion=direccion;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getDireccion(){
        return direccion;
    }
    
}
