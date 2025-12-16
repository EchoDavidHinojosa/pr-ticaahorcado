/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado;

/**
 *
 * @author Echo
 */

public class Jugador {


    public int vida;
    public int puntos;

   
    public Jugador() {
        this.vida = 6;
        this.puntos = 0;
    }


    public void aumentar_puntos() {
        this.puntos++;
    }
}

