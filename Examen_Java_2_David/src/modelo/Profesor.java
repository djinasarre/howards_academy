package modelo;

public class Profesor extends Mago {
    private String especializacion;

    public Profesor(String nombre, int fuerza, int inteligencia, int rapidez, int destreza, String especializacion) {
        super(nombre, fuerza, inteligencia, rapidez, destreza);
        this.especializacion = especializacion;
    }

    public void saludar() {
        System.out.println("Hola, soy el Profesor " + nombre + ", especializado en " + especializacion + ".");
        System.out.println(" -------------------------------------------------------------------------------");
    }
    
    public boolean esMago() {
        return true;
    }

	public String getEspecializacion() {
		return especializacion;
	}

	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
	}

    
}