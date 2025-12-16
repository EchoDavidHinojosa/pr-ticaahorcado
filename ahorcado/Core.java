/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado;


/**
 *
 * @author Echo
 */


import java.util.Scanner;

public class Core {

    private int ronda;
    public char[] palabra_secreta;
    public char[] palabra_visible;

    private Scanner sc = new Scanner(System.in);

  
    public static void main(String[] args) {
        Core juego = new Core();
        juego.iniciar();
    }

    public Core() {
        this.ronda = 1;
    }

    public void iniciar() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
       
        while (ronda <= 5) {
            
            System.out.println("\n=== RONDA " + ronda + " ===");
            //Juega uno u otro jugador dependiendo de la ronda
            Jugador escribe = (ronda % 2 == 1) ? jugador1 : jugador2;
            Jugador adivina = (ronda % 2 == 1) ? jugador2 : jugador1;

            System.out.print("Jugador escribe la palabra secreta: ");
            String palabra = sc.nextLine().toLowerCase();

            palabra_secreta = palabra.toCharArray();
            palabra_visible = new char[palabra_secreta.length];

            for (int i = 0; i < palabra_visible.length; i++) {
                palabra_visible[i] = '_';
            }

            adivina.vida = 6;

            while (adivina.vida > 0 && !comprobar_palabra()) {
                mostrar_palabra();

                System.out.print("Introduce una letra: ");
                char letra = sc.nextLine().toLowerCase().charAt(0);

                char[] copia = palabra_visible.clone();

                meter_letra(letra);

                if (String.valueOf(copia).equals(String.valueOf(palabra_visible))) {
                    adivina.vida--;
                    System.out.println("Fallaste. Vida restante: " + adivina.vida);
                }
            }

            if (comprobar_palabra()) {
                adivina.aumentar_puntos();
                System.out.println("¡Has ganado la ronda!");
            } else {
                System.out.println("Has perdido. La palabra era: " + palabra);
                escribe.aumentar_puntos();
            }

            ronda++;
        }

        System.out.println("\n=== RESULTADO FINAL ===");
        System.out.println("Jugador 1 puntos: " + jugador1.puntos);
        System.out.println("Jugador 2 puntos: " + jugador2.puntos);
    }

  
    private void mostrar_palabra() {
        for (char c : palabra_visible) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    
    public void meter_letra(char x) {
       
        for (int i = 0; i < palabra_secreta.length; i++) {
            if (palabra_secreta[i] == x) {
                palabra_visible[i] = x;
            }
        }
    }

    public boolean comprobar_palabra() {
        for (char c : palabra_visible) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}

