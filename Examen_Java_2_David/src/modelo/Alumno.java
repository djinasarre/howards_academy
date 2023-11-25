package modelo;

import java.util.HashMap;
import java.util.Map;


public class Alumno extends Mago {
    private String asignaturaFavorita;
    private Map<String, Double> asignaturas;

    public Alumno(String nombre, int fuerza, int inteligencia, int rapidez, int destreza, String asignaturaFavorita) {
        super(nombre, fuerza, inteligencia, rapidez, destreza);
        this.asignaturaFavorita = asignaturaFavorita;
        this.asignaturas = new HashMap<>();
    }

    public void presentarse() {
        System.out.println("Hola, soy " + nombre + " y mi asignatura favorita es " + asignaturaFavorita + ".");
        realizarHechizo();
        System.out.println(" -------------------------------------------------------------------------------");
    }

    private void realizarHechizo() {
        System.out.println(Hechizo.realizarHechizoAleatorio());
    }

    // Creamos un generador de números aleatorios que multiplicamos a la media de fuerza, inteligencia, rapidez y detreza
    // Calculamos la nota final. Si la asignatura es la favorita del alumno, añade 1 punto extra a la nota ("media").
    // Guardamos la nota final en el mapa de asignaturas del alumno.
    public void evaluarAsignatura(String asignatura) {
        double media = ((fuerza + inteligencia + rapidez + destreza) / 4) * (Math.random()) + 1;  
        media = (double) Math.round(media * 10d) / 10d;
        double nota = asignatura.equals(asignaturaFavorita) ? media + 1 : media;
        asignaturas.put(asignatura, nota);
        
    
    }
    
    
 /* Inicializamos variables para almacenar la mejor asignatura y la nota más alta encontrada.
    Iteramos sobre todas las asignaturas del alumno y sus respectivas notas,
    si la nota de la asignatura actual es mayor que la mejor nota encontrada hasta ahora,
    actualiza la mejor asignatura y la mejor nota.
    Retornamos el nombre de la asignatura con la nota más alta.*/
    
    public static String encontrarMejorAsignatura(Alumno alumno) {
        String mejorAsignatura = "";
        Double mejorNota = -1.0;
        for (Map.Entry<String, Double> asignatura : alumno.getAsignaturas().entrySet()) {
            if (asignatura.getValue() > mejorNota) {
                mejorNota = asignatura.getValue();
                mejorAsignatura = asignatura.getKey();
            }
        }
        return mejorAsignatura;
    }
    
    public static void mostrarMejoresAsignaturas(Alumno[] alumnos) {
        for (Alumno alumno : alumnos) {
            String mejorAsignatura = encontrarMejorAsignatura(alumno);
            System.out.println(alumno.getNombre() + " tiene su mejor puntuación en la asignatura: " + mejorAsignatura + " con una nota de " + alumno.getAsignaturas().get(mejorAsignatura));
        }
    }

	public String getAsignaturaFavorita() {
		return asignaturaFavorita;
	}

	public void setAsignaturaFavorita(String asignaturaFavorita) {
		this.asignaturaFavorita = asignaturaFavorita;
	}

	public Map<String, Double> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Map<String, Double> asignaturas) {
		this.asignaturas = asignaturas;
	}

	
	public void saludar() {
		System.out.println("Hola, soy " + nombre + " y mi asignatura favorita es " + asignaturaFavorita + ".");
	}

    
}