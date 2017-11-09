/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magiemagie.MagieMagie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Administrateur
 */
public class Jeu {

    protected ArrayList<Joueur> joueurs = new ArrayList<>();
    protected Joueur joueurEnCours;

    public void menuAction() {
        // 1. afficher menu

        System.out.println("A vous de jouer " + this.joueurEnCours.getNom());
        System.out.println("Vos cartes : " + this.joueurEnCours.getCartes());
        System.out.println("Actions possibles : [1] Lancer un sort [2] Passer son tour. Votre choix : ");
        Scanner scan = new Scanner(System.in);
        String choix = scan.nextLine();

        //2. lance sort ou passe son tour 
        switch (choix) {

            case "1":
                this.lancerSort();
                break;

            case "2":
                this.passerTour();
                break;
                
            default:
                System.out.println("Commande invalide");
                
        }

    }
    

    public void passerTour() {

    }

    public Joueur getJoueurEnCours() {
        return joueurEnCours;
    }

    public void setJoueurEnCours(Joueur joueurEnCours) {
        this.joueurEnCours = joueurEnCours;
    }

    public Jeu() {
        this.joueurs = new ArrayList<>();

    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public void afficheMenuNouveauJoueur() {

        // 1.saisie nom joueur
        System.out.print("Nom nouveau joueur:");
        Scanner s = new Scanner(System.in);
        String nomJoueur = s.nextLine();

        // 2.créer un joueur et lui set le nom
        Joueur joueur = new Joueur();
        joueur.setNom(nomJoueur);

        // 3.Ajouts ds liste joueur
        this.joueurs.add(joueur);

    }

    public void demarrerPartie() {

        // 1. Distribue 7 cartes par joueur
        for (Joueur joueur : joueurs) {

            for (int i = 0; i < 7; i++) {

                Carte carte = new Carte();

                // Distribue 7 cartes pour le joueur actuel
                Random random = new Random();
                int nb = random.nextInt(5);
                switch (nb) {
                    case 0:
                        carte.setType(Carte.TypeCarte.AILE_DE_CHAUVE_SOURIS);
                        break;

                    case 1:
                        carte.setType(Carte.TypeCarte.BAVE_DE_CRAPAUD);
                        break;
                    case 2:
                        carte.setType(Carte.TypeCarte.CORNE_DE_LICORNE);

                        break;
                    case 3:
                        carte.setType(Carte.TypeCarte.LAPIS_LAZULI);
                        break;
                    case 4:
                        carte.setType(Carte.TypeCarte.MANDRAGORE);
                        break;

                }

                joueur.getCartes().add(carte);

                // 2. Donne la main au 1er joueur
                this.joueurEnCours = this.joueurs.get(0);

                // 3.Affiche menu d'action
                this.menuAction();

            }
        }
    }

    public void afficherMenuPrincipal() {

        boolean quitter = false;
        while (quitter == false) {

            System.out.println("MENU:");
            System.out.println("-------------");
            System.out.println("1 NOUVEAU JOUEUR");
            System.out.println("2 DEMARRER PARTIE");
            System.out.println("L. Liste des joueurs");
            System.out.println("3 QUITTER");

            Scanner scanner = new Scanner(System.in);
            String choixUtil = scanner.nextLine();

            switch (choixUtil) {
                case "L":
                    System.out.println(this.joueurs);
                    break;
                case "1":
                    afficheMenuNouveauJoueur();
                    break;
                case "2":
                    demarrerPartie();
                    break;
                case "3":
                    quitter = true;
                    break;
                default:
                    System.out.println("Commande inconnue");
                    break;
            }

        }
    }

    private void lancerSort() {
    }
}
