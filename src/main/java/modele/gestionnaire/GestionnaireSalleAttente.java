package modele.gestionnaire;

import modele.client.stub.salleattente.ListenerSalleAttenteIF;
import modele.implementation.salleattente.SalleAttente;

import java.rmi.RemoteException;
import java.util.HashMap;

public class GestionnaireSalleAttente {

    /*
     * Singleton Design Pattern
     */
    private static GestionnaireSalleAttente instance = null;
    public static GestionnaireSalleAttente getInstance() {
        if (instance == null) instance = new GestionnaireSalleAttente();
        return instance;
    }

    private HashMap<String, SalleAttente> mapSalleAttente;

    /*
     * Permet de ranger les salles d'attentes qui sont crees dans une table de hachage
     * Elles sont indexees par nom de salle
     */
    private GestionnaireSalleAttente() {
        this.mapSalleAttente = new HashMap<String, SalleAttente>();
    }

    public SalleAttente enregistrerSalleAttente(String pseudoProprietaire, String nomSalle, String motDePasse, boolean publique)
            throws RemoteException, IllegalArgumentException, IllegalAccessException {
        if(nomSalle.equals("")) throw new IllegalArgumentException("Le nom de la salle doit etre preciser");
        if(mapSalleAttente.containsKey(nomSalle)) throw new IllegalArgumentException("Une salle de ce nom existe deja.");
        SalleAttente salleAttente = new SalleAttente(pseudoProprietaire, nomSalle, motDePasse, publique);
        mapSalleAttente.put(nomSalle, salleAttente);
        return salleAttente;
    }

    public SalleAttente rejoindreSalleAttente(String pseudo, ListenerSalleAttenteIF clientListener, String nomSalle, String motDePasse) throws RemoteException, IllegalArgumentException {
        if (!mapSalleAttente.containsKey(nomSalle)) throw new IllegalArgumentException("Cette salle d'attente n'existe pas");
        return mapSalleAttente.get(nomSalle).entrer(pseudo, clientListener, motDePasse);
    }

    public void detruireSalleAttente(String nomSalle) {
        mapSalleAttente.remove(nomSalle);
    }

    public HashMap<String, SalleAttente> getMapSalleAttente() {
        return mapSalleAttente;
    }
}
