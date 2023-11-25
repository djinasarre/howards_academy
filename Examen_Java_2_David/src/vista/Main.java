package vista;

import java.util.Scanner;
import controlador.Controlador;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controlador controlador = new Controlador();

        controlador.presentarPersonajes();
        controlador.evaluarAlumnos(scanner);
        controlador.mostrarResultados();
        controlador.mostrarAsignaturasFavoritas();

        scanner.close();
    }
}