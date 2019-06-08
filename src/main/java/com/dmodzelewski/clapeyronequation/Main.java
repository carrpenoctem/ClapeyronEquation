package com.dmodzelewski.clapeyronequation;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This app is to count certain values of Ideal Gas equation which is: PV = nRT
 *
 * @author D.Modzelewski
 */
public class Main {

    /* Pressure, Volume, number of Moles, Temperature and Gas constant */
    private static float P;     // [hPa]
    private static float V;     // [dm^3]
    private static float n;     // [mol]
    private static float T;     //[K]
    private static final float R = 8.314f; // [J/mol*K]
    /* Logger, for logging errors */
    private static final Logger classLogger = Logger.getLogger(Main.class.getCanonicalName());
    /* A convenient way to receive input from the user */
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("What shall be calculated? \n input: P,V,n or T");
            String selectedVariable = input.nextLine();
            if (selectedVariable.equalsIgnoreCase("p")) {
                // calculate P
            } else if (selectedVariable.equalsIgnoreCase("v")) {
                // calculate V
            } else if (selectedVariable.equalsIgnoreCase("n")) {
                // calculate n
            } else if (selectedVariable.equalsIgnoreCase("t")) {
                // calculate T
            } else {
                System.out.println("Wrong input");
            }
        }
    }

    private static float parseFloatFixed() {
        boolean running = true;
        float out = 0;
        while (running) {
            String in = input.nextLine();
            try {
                out = Float.parseFloat(in);
                running = false;
            } catch (NumberFormatException e) {
                classLogger.log(Level.WARNING, e.getMessage());
            }
        }
        return out;
    }

}
