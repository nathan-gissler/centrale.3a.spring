package com.centrale.rest.pierrefeuilleciseaux;

public class Feuille implements Objet {
    public Feuille() {
    }

    public int playWith(Objet objet) {
        return -objet.playWith(this);
    }

    public int playWith(Pierre pierre) {
        return 1;
    }

    public int playWith(Feuille feuille) {
        return 0;
    }

    public int playWith(Ciseaux ciseaux) {
        return -1;
    }
}
