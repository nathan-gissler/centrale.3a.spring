package com.centrale.rest.pierrefeuilleciseaux;
/* cf pattern visitor */
public class Main {
    public static void main(String[] args) {
        Pierre pierre = new Pierre();
        Feuille feuille = new Feuille();
        Ciseaux ciseaux = new Ciseaux();
        int res = pierre.playWith(feuille);

        Jeu jeu = new Jeu();
        jeu.play("pierre", "feuille");
        int score1 = jeu.getScoreJoueur1();
        int score2 = jeu.getScoreJoueur2();
    }
}