package com.centrale.rest.pierrefeuilleciseaux;

public class Ciseaux implements Objet {
    public Ciseaux() {
    }

    public int playWith(Objet objet) {
        return -objet.playWith(this);
    }

    public int playWith(Pierre pierre) {
        return -1;
    }

    public int playWith(Feuille feuille) {
        return 1;
    }

    public int playWith(Ciseaux ciseaux) {
        return 0;
    }
}
