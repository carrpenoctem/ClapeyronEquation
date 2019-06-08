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
    private static float P;     // [Pa]
    private static float V;     // [m^3]
    private static float n;     // [mol]
    private static float T;     // [K]
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
                calculateP();
                running = false;
            } else if (selectedVariable.equalsIgnoreCase("v")) {
                calculateV();
                running = false;
            } else if (selectedVariable.equalsIgnoreCase("n")) {
                calculateN();
                running = false;
            } else if (selectedVariable.equalsIgnoreCase("t")) {
                calculateT();
                running = false;
            } else {
                System.out.println("Wrong input");
            }
        }
        System.out.println("Enter anything to exit...");
        input.nextLine();
    }

    /**
     * This method causes a loop which ends when an input can be parsed to float
     * @return parsed float value
     */
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

    /* Simple methods for calculating variables */
    private static void calculateP() {
        System.out.println("Enter V value [m^3]");
        V = parseFloatFixed();
        System.out.println("Enter n value [mol]");
        n = parseFloatFixed();
        System.out.println("Enter T value [K]");
        T = parseFloatFixed();

        /* processing */
        P = (n * R * T) / V;
        System.out.println("P = " + P + " Pa \n"
                + "for: V = " + V + " m^3 ; n = " + n + " mol ; T = " + T + " K");
    }

    private static void calculateV() {
        System.out.println("Enter P value [Pa]");
        P = parseFloatFixed();
        System.out.println("Enter n value [mol]");
        n = parseFloatFixed();
        System.out.println("Enter T value [K]");
        T = parseFloatFixed();

        /* processing */
        V = (n * R * T) / P;
        System.out.println("V = " + V + " m^3 \n"
                + "for: P = " + P + " Pa ; n = " + n + " mol ; T = " + T + " K");
    }

    private static void calculateN() {
        System.out.println("Enter V value [m^3]");
        V = parseFloatFixed();
        System.out.println("Enter P value [Pa]");
        P = parseFloatFixed();
        System.out.println("Enter T value [K]");
        T = parseFloatFixed();

        /* processing */
        n = (P * V) / R * T;
        System.out.println("n = " + n + " mol \n"
                + "for: V = " + V + " m^3 ; P = " + P + " Pa ; T = " + T + " K");
    }

    private static void calculateT() {
        System.out.println("Enter V value [m^3]");
        V = parseFloatFixed();
        System.out.println("Enter P value [Pa]");
        P = parseFloatFixed();
        System.out.println("Enter n value [mol]");
        n = parseFloatFixed();

        /* processing */
        T = (P * V) / R * n;
        System.out.println("T = " + T + " K \n"
                + "for: V = " + V + " m^3 ; P = " + P + " Pa ; T = " + n + " mol");
    }
}
