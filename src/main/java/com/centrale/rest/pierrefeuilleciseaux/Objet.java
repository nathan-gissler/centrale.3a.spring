package com.centrale.rest.pierrefeuilleciseaux;

public interface Objet {
    public int playWith(Objet objet);
    public int playWith(Pierre pierre);
    public int playWith(Feuille feuille);
    public int playWith(Ciseaux ciseaux);
}
