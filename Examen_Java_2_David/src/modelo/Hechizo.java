package modelo;

import java.util.Random;

public class Hechizo {
    private static  String[] hechizos = {
        "¡Accio! (Atrayendo objetos)",
        "¡Alohomora! (Abriendo puertas)",
        "¡Incendio! (Creando fuego)",
        "¡Invisibilidad! (Volviéndome invisible)",
        "¡Expecto Patronum! (Contra dementores)"
    };

    public static String realizarHechizoAleatorio() {
        Random random = new Random();
        int indice = random.nextInt(hechizos.length);
        return hechizos[indice];
    }
}