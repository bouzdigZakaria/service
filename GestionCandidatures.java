package services;
import beans.Candidat;
import beans.Candidature;
import beans.Master;
import database.Connexion;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class GestionCandidatures {
    private Connection cn = Connexion.getInstance().getCn();
    private List<Master> masters = new ArrayList<>();
    private List<Candidat> candidats = new ArrayList<>();
    private List<Candidature> candidatures = new ArrayList<>();
    public void ajouterMaster(Master master) {
        masters.add(master);
    }

    public void enregistrerCandidature(Candidature candidature) {
        candidatures.add(candidature);
    }
    public List<Candidature> filtrerParFiliere(String filiere) {
        List<Candidature> result = new ArrayList<>();
        for (Candidature c : candidatures) {
            for (Master m : masters) {
                if (m.getId() == c.getMasterId() && m.getFiliere().equalsIgnoreCase(filiere)) {
                    result.add(c);
                }
            }
        }
        return result;
    }

    public Candidat rechercherCandidat(String nom) {
        for (Candidat c : candidats) {
            if (c.getNom().equalsIgnoreCase(nom)) {
                return c;
            }
        }
        return null;
    }
}
