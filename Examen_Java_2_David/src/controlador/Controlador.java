package controlador;

import modelo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.InputMismatchException;

public class Controlador {
    private Alumno[] alumnos;
    private List<String> asignaturas;
    private Object[] personajes;

    public Controlador() {
        inicializarDatos();
        crearPersonajes();
    }

 // Inicializamos los datos de asignaturas y creamos los alumnos.
    private void inicializarDatos() {
        asignaturas = new ArrayList<>();
        asignaturas.add("Pociones");
        asignaturas.add("Cuidado de Criaturas Mágicas");
        asignaturas.add("Clases de Duelo Mágico");
        asignaturas.add("Vuelo sobre escoba voladora");

        alumnos = crearAlumnos();
    }

 // Creamos un array de personajes, incluyendo alumnos, profesores y muggles.
    private void crearPersonajes() {
        personajes = new Object[] {
            new Alumno("Harry Potter", 8, 8, 9, 10, "Vuelo sobre escoba voladora"),
            new Profesor("Minerva McGonagall", 8, 9, 7, 8, "Transformaciones"),
            new Muggle("Maria"),
            new Alumno("Hermione Garnger", 6, 10, 6, 8, "Clases de Duelo Mágico"),
            new Muggle("Pepe"),
            new Alumno("Ron Weasly", 7, 7, 7, 8, "Cuidado de Criaturas Mágicas"),
            new Profesor("Severus Snape", 9, 10, 8, 9, "Pociones"),
            new Muggle("Antonio"),
            new Alumno("Draco Malfoy", 7, 8, 9, 10, "Pociones"),
            new Alumno("Luna Lovewood", 6, 9, 9, 8, "Cuidado de Criaturas Mágicas")
        };
    }

 // Presentamos a todos los personajes y limitamos la presentación de alumnos a 5.
    public void presentarPersonajes() {
        int contadorAlumnos = 0;
        for (Object personaje : personajes) {
            if (personaje instanceof Muggle) {
                System.out.println(((Muggle) personaje).getNombre() + " intenta entrar a la academia.");
                System.out.println("¡Alerta! Un Muggle ha sido detectado. Acceso denegado.");
            } else if (personaje instanceof Profesor) {
                ((Profesor) personaje).saludar();
            } else if (personaje instanceof Alumno) {
                ((Alumno) personaje).presentarse();
                contadorAlumnos++;
                if (contadorAlumnos >= 5) {
                    break;
                }
            }
            System.out.println(" -------------------------------------------------------------------------------");
        }
    }

 // Evalúamos a todos los alumnos en sus asignaturas.
    public void evaluarAlumnos(Scanner scanner) {
        for (Alumno alumno : alumnos) {
            evaluarAlumnoIndividual(alumno, scanner);
        }
    }

 // Evalúamos a un alumno individual en asignaturas que aún no ha tomado. La comentamos linea por linea.
    private void evaluarAlumnoIndividual(Alumno alumno, Scanner scanner) {
        // Este bucle se ejecuta mientras el alumno no haya sido evaluado en todas las asignaturas.
        while (!alumno.getAsignaturas().keySet().containsAll(asignaturas)) {
            // Solicita al usuario que seleccione una asignatura para evaluar al alumno.
            System.out.println("Seleccione una asignatura para evaluar a " + alumno.getNombre() + ":");
            // Lista para almacenar asignaturas que aún no han sido evaluadas por el alumno.
            List<String> asignaturasDisponibles = new ArrayList<>();
            // Itera sobre todas las asignaturas y agrega a la lista las que aún no han sido evaluadas por el alumno.
            for (String asignatura : asignaturas) {
                if (!alumno.getAsignaturas().containsKey(asignatura)) {
                    asignaturasDisponibles.add(asignatura);
                    // Muestra las asignaturas disponibles para la evaluación.
                    System.out.println((asignaturasDisponibles.size()) + ". " + asignatura);
                }
            }

            // Variable para asegurar que la entrada del usuario sea válida.
            boolean entradaValida = false;
            while (!entradaValida) {
                try {
                    // Lee la elección de asignatura del usuario.
                    int opcionAsignatura = scanner.nextInt();
                    // Verifica si la opción está dentro del rango válido.
                    if (opcionAsignatura < 1 || opcionAsignatura > asignaturasDisponibles.size()) {
                        System.out.println("Número fuera de rango. Por favor, seleccione una opción válida.");
                        continue;
                    }
                    // Obtiene la asignatura seleccionada de la lista.
                    String asignaturaSeleccionada = asignaturasDisponibles.get(opcionAsignatura - 1);
                    // Evalúa al alumno en la asignatura seleccionada.
                    alumno.evaluarAsignatura(asignaturaSeleccionada);
                    // Muestra la nota obtenida por el alumno en la asignatura evaluada.
                    System.out.println("Nota en " + asignaturaSeleccionada + ": " + alumno.getAsignaturas().get(asignaturaSeleccionada));
                    System.out.println(" -------------------------------------------------------------------------------");
                    entradaValida = true;
                    
                } catch (InputMismatchException e) {
                    // Captura errores si el usuario no introduce un número entero.
                    System.out.println("Error: Debe ingresar un número entero.");
                    scanner.nextLine(); // Limpia el escáner para evitar errores en la entrada.
                }
            }
        }
    }
 // Creamos y retornamos un array de alumnos.
    public static Alumno[] crearAlumnos() {
        return new Alumno[]{
            new Alumno("Harry Potter", 8, 8, 9, 10, "Vuelo sobre escoba voladora"),
            new Alumno("Hermione Garnger", 6, 10, 6, 8, "Clases de Duelo Mágico"),
            new Alumno("Ron Weasly", 7, 7, 7, 8, "Cuidado de Criaturas Mágicas"),
            new Alumno("Draco Malfoy", 7, 8, 9, 10, "Pociones"),
            new Alumno("Luna Lovewood", 6, 9, 9, 8, "Cuidado de Criaturas Mágicas")
        };
    }
    
 // Mostramos los resultados de los alumnos, incluimos la nota media y premios. Comentamos la función linea a linea.
    public void mostrarResultados() {
        // Variable para almacenar la máxima media de notas entre todos los alumnos.
        double maxMedia = 0;
        // Referencia para almacenar el alumno con la mejor nota media.
        Alumno alumnoDestacado = null;

        // Itera sobre cada alumno en el arreglo de alumnos.
        for (Alumno alumno : alumnos) {
            // Suma acumulativa de las notas de un alumno.
            double sumaNotas = 0;
            // Muestra el nombre del alumno y comienza a listar sus resultados.
            System.out.println("Resultados de " + alumno.getNombre() + ":");
            // Itera sobre cada asignatura que el alumno ha cursado.
            for (String asignatura : asignaturas) {
                // Obtiene la nota del alumno en la asignatura actual.
                double nota = alumno.getAsignaturas().get(asignatura);
                // Acumula la nota en la suma total.
                sumaNotas += nota;
                // Muestra la nota del alumno en la asignatura actual.
                System.out.println("  " + asignatura + ": " +  nota);
            }
            // Calcula la media de notas del alumno.
            double media = sumaNotas / asignaturas.size();
            // Muestra la media de notas del alumno.
            media = (double) Math.round(media * 10d) / 10d;
            System.out.println("Nota media: " + media);

            // Verifica si la media del alumno es igual o superior a 6.
            if (media >= 6) {
                // Si es así, anuncia que el alumno recibe un certificado.
                System.out.println(alumno.getNombre() + " recibe un certificado de profesionalidad del mundo mágico");
            }

            // Verifica si la media del alumno es la más alta hasta ahora.
            if (media > maxMedia) {
                // Actualiza la máxima media y el alumno destacado.
                maxMedia = media;
                alumnoDestacado = alumno;
            }
            // Imprime una línea separadora.
            System.out.println(" -------------------------------------------------------------------------------");
        }

        // Verifica si hay un alumno destacado.
        if (alumnoDestacado != null) {
            // Anuncia al alumno con la mejor nota media.
            System.out.println(alumnoDestacado.getNombre() + " ha obtenido el Premio por Méritos Destacados con una nota media de " + maxMedia);
            // Imprime una línea separadora.
            System.out.println(" -------------------------------------------------------------------------------");
        }
    }
    
   
 // Encontramos la mejor asignatura de todos los alumnos.
    public String encontrarMejorAsignatura() {
        String mejorAsignatura = null;
        double notaMaxima = -1.0;

        for (Map.Entry<String, Double> asignatura : ((Map<String, Double>) this.asignaturas).entrySet()) {
            if (asignatura.getValue() > notaMaxima) {
                notaMaxima = asignatura.getValue();
                mejorAsignatura = asignatura.getKey();
            }
        }

        return mejorAsignatura;
    }
    
 // Mostramos las asignaturas favoritas de cada alumno.
    public void mostrarAsignaturasFavoritas() {
        for (Alumno alumno : alumnos) {
            String mejorAsignatura = Alumno.encontrarMejorAsignatura(alumno);
            System.out.println(alumno.getNombre() + ": 'Mi asignatura favorita es " + mejorAsignatura
                    + "' con una nota de " + alumno.getAsignaturas().get(mejorAsignatura));
        }
    }
    }
    
   
