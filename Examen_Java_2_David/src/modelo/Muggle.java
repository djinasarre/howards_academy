package modelo;

public class Muggle {
    private String nombre;

    public Muggle(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarIgnoranciaMagica() {
        System.out.println("Hola, soy " + nombre + " y no tengo idea de magia.");
    }

    public boolean esMago() {
        return false; 
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}