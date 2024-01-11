package UI;

import Model.Player;

import java.util.Scanner;

public class UI {
    public static int readInt(String msg) {
        int numEleccion = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println(msg + ": ");
        do {
            try {
                numEleccion = teclado.nextInt();
            } catch (Exception e){
                System.out.println("You must introduce a number. Try again.");
                teclado.nextLine();
            }
            if (numEleccion < 0 || numEleccion > 2){
                System.out.println("You must introduce a number between 0 and 2.");
            }

        } while(numEleccion < 0 || numEleccion > 2);
        return numEleccion;
    }
}

