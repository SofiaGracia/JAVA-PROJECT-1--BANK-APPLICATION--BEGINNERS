package com.sumanth.project;

import java.util.Scanner;

/**
 * Aquesta classe representa una aplicació bancària simple que permet realitzar operacions
 * com consultar saldo, dipositar, retirar fons i veure transaccions anteriors.
 */
public class BankingApplication {

    /**
     * Mètode principal que crea una instància de CompteBancari i mostra el menú de l'aplicació.
     * @param args Els arguments de la línia de comandes (no s'utilitzen en aquest cas).
     */
    public static void main(String[] args) {
        CompteBancari primer = new CompteBancari("Dr Siddalinga Murthy", "SD1234");
        primer.mostrarMenu();
    }
}

/**
 * Classe per representar un compte bancari amb saldo, transaccions i detalls del client.
 */
class CompteBancari {

    int saldo;
    int transaccioAnterior;
    String nomClient;
    String idClient;

    /**
     * Constructor per inicialitzar una instància de CompteBancari amb el nom del client i el seu ID.
     * @param nom El nom del client.
     * @param id L'ID del client.
     */
    CompteBancari(String nom, String id) {
        nomClient = nom;
        idClient = id;
    }

    /**
     * Mètode per realitzar un dipòsit al compte bancari.
     * @param quantitat La quantitat a dipositar.
     */
    void dipositar(int quantitat) {
        saldo = saldo + quantitat;
        transaccioAnterior = quantitat;
    }

    /**
     * Mètode per realitzar un reintegrament del compte bancari.
     * @param quantitat La quantitat a retirar.
     */
    void retirar(int quantitat) {
        saldo = saldo - quantitat;
        transaccioAnterior = -quantitat;
    }
        
    /**
     * Mètode per obtenir l'última transacció realitzada al compte.
     */
    void obtenirTransaccioAnterior() {
        if (transaccioAnterior > 0) {
            System.out.println("Ingressat: " + transaccioAnterior);
        } else if (transaccioAnterior < 0) {
            System.out.println("Tret: " + Math.abs(transaccioAnterior));
        } else {
            System.out.println("Sense transaccions");
        }
    }

    /**
     * Mètode per mostrar el menú d'opcions de l'aplicació bancària.
     */
    void mostrarMenu() {

        char opcio = '\0';
        Scanner scn = new Scanner(System.in);

        System.out.println("Benvingut " + nomClient);
        System.out.println("El teu ID és: " + idClient);
        System.out.println("\n");
        System.out.println("A. Consultar Saldo");
        System.out.println("B. Reintegrament");
        System.out.println("C. Dipòsit");
        System.out.println("D. Transacció Anterior");
        System.out.println("E. Sortir");

        do {
            System.out.println("=====================================================");
            System.out.println("Introdueixi l'opció (A-Saldo, B-Reintegrament, C-Dipòsit, D-Transaccions, E-Sortir):");
            System.out.println("=====================================================");
            opcio = scn.next().charAt(0);
            System.out.println("\n");

            switch (opcio) {
                case 'A':
                    System.out.println("======================================================");
                    System.out.println("Saldo: " + saldo);
                    System.out.println("======================================================");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("======================================================");
                    System.out.println("Introdueixi la quantitat a retirar:");
                    int quantitat = scn.nextInt();
                    retirar(quantitat);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("======================================================");
                    System.out.println("Introdueixi la quantitat a dipositar:");
                    int quantitat1 = scn.nextInt();
                    dipositar(quantitat1);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("======================================================");
                    System.out.println("La teva última transacció és:");
                    obtenirTransaccioAnterior();
                    break;

                case 'E':
                    System.out.println("******************************************************");
                    break;

                default:
                    System.out.println("Opció invàlida. Si us plau, torna-ho a intentar.");
                    break;
            }

        } while (opcio != 'E');
        
        System.out.println("Gràcies. Que tinguis un bon dia!");
    }
}