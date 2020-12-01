import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.*;


//abstract class
public abstract class BoxOffice {
        private String listing;
        public abstract void addFilm(String titre,String realisateur,int annee, int nbEntrees);
        public BoxOffice(String listing) {
            ArrayList<String> data = new ArrayList<>();
            try{
                Scanner in = new Scanner(new File(listing));
                String line;
                String titre;
                String realisateur;
                int annee;
                int nbEntrees;
                String[] tab;

                //découper la ligne et reprendre les données

                while(in.hasNextLine()) {
                    line = in.nextLine();
                    tab = line.split("FILM : |\\tREALISATEUR : |\\tANNEE : |\\tVILLE : |\\tENTREES :");
                    //place les attributs dans le tableau
                    titre = tab[1];
                    realisateur = tab[2];
                    annee =Integer.parseInt(tab[3]);
                    nbEntrees = Integer.parseInt(tab[5]);

                    //ajoute les données dans addFilm qui sera appelé dans le Test
                    addFilm(titre,realisateur,annee,nbEntrees);
                }

                in.close();

            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }











}
