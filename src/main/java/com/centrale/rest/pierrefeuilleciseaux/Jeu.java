package com.centrale.rest.pierrefeuilleciseaux;

public class Jeu {

    private int scoreJoueur1;
    private int scoreJoueur2;

    public Jeu() {
        this.scoreJoueur1 = 0;
        this.scoreJoueur2 = 0;
    }

    public void play(Objet objet1, Objet objet2) {
        this.scoreJoueur1 += objet1.playWith(objet2);
        this.scoreJoueur2 += objet2.playWith(objet1);
    }

    public void play(String choix1, String choix2) {
        Objet objet1 = this.createObjet(choix1);
        Objet objet2 = this.createObjet(choix2);
        this.play(objet1, objet2);
    }

    private Objet createObjet(String choix) {
        if (choix.equals("pierre")) {
            return new Pierre();
        }
        if (choix.equals("feuille")) {
            return new Feuille();
        }
        return new Ciseaux();
    }

    public int getScoreJoueur1() {
        return scoreJoueur1;
    }

    public int getScoreJoueur2() {
        return scoreJoueur2;
    }
}
