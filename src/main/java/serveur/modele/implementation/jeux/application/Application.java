package serveur.modele.implementation.jeux.application;

import serveur.modele.client.stub.jeux.JeuxListenerIF;
import serveur.modele.gestionnaire.GestionnaireSession;
import serveur.modele.implementation.jeux.application.allumettes.AllumettesApp;
import serveur.modele.implementation.jeux.application.allumettes.AllumettesParams;
import serveur.modele.implementation.jeux.application.morpion.MorpionApp;
import serveur.modele.implementation.jeux.application.morpion.MorpionParams;
import serveur.modele.implementation.jeux.application.pendu.PenduApp;
import serveur.modele.implementation.jeux.application.pendu.PenduParams;
import serveur.modele.stub.jeux.application.JeuxIF;

import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.Unreferenced;

public abstract class Application extends UnicastRemoteObject implements JeuxIF, Runnable, Unreferenced {

    protected boolean reference = true;

    protected String dernierePersonneJouee = null;
    protected boolean partieLancer = false;

    protected ResultatPartieEnum resultat = null;

    protected Application() throws RemoteException { }

    public abstract JeuxIF rejoindrePartie(String pseudo, JeuxListenerIF clientListener) throws RemoteException;
    public abstract void lancerPartie() throws RemoteException;
    public boolean autokick(String pseudo) throws RemoteException {
        try {
            GestionnaireSession.getInstance().getSessionFromPseudo(pseudo);
            return false;
        } catch (IllegalArgumentException iae) {
            return true;
        }
    }

    public static Application creerApplication(JeuxEnum jeu, Parametres parametres) throws RemoteException, IllegalArgumentException {
        switch (jeu) {
            case MORPION : return new MorpionApp((MorpionParams) parametres);
            case PENDU : return new PenduApp((PenduParams) parametres);
            case ALLUMETTES : return new AllumettesApp((AllumettesParams) parametres);
            default : throw new IllegalArgumentException("should never occur.");
        }
    }

    public boolean isReference() {
        return reference;
    }
}