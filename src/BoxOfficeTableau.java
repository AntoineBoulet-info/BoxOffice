import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BoxOfficeTableau extends BoxOffice {

    public final static int TAILLE_INITIALE= 100;
    public static int TAILLE_TMP = TAILLE_INITIALE;
    private Film[] elements = new Film[TAILLE_INITIALE];//contient les infos d'un Film
    private static int nbFilms;
    private static int nbLignes;


    //méthode Film
    public void addFilm(String titre, String realisateur, int annee, int nbEntrees) {
            if (nbFilms == TAILLE_TMP) {
                //augmente la taille si le nombre de films dépasse la taille du tableau
                TAILLE_TMP = TAILLE_TMP * 2;
                Film[] tab = elements;
                elements = new Film[TAILLE_TMP];
                for(int i=0;i< tab.length ;i++) {
                    Film film = new Film(titre, realisateur, annee, nbEntrees);
                    elements[i++] = film;
                }

        }
        elements[nbFilms++] = new Film(titre, realisateur, annee, nbEntrees);


    }
    //constructeur
    public BoxOfficeTableau(String listing) {
        super(listing);
    }

    //compte le nombre de film
    public static int compterFilm(String line) {
        int cpt = 0;
        try {
            for (int i=0;i<line.length()-1;i++) // s'arrête sur l'avant derniere case avant la fin de la ligne
                if (line.charAt(i) !=  line.charAt(i) + 1)
                    cpt++;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cpt;
    }

    public static int maxEntrees(int tab[]) {
        int sumEntrees = 0;
        for (int i=0;i<tab.length;i++) {

        }


        return sumEntrees;
    }


    public static void main(String[] args) throws IOException {
        if (args.length<1) System.err.println("nom de fichier manquant");
        else new BoxOfficeTest(args[0]);
        try {
            Scanner in = new Scanner(new File(args[0]));
            String line;
            String tmp_titre;
            String titre;
            String realisateur;
            int annee;
            int nbEntrees;
            ArrayList<String> data_titre = new ArrayList<>(); // liste composée des titres de films
            String[] tab;
            String[] tmp = new String[3];
            while(in.hasNextLine()) {
                line = in.nextLine();
                tab = line.split("FILM : |\\tREALISATEUR : |\\tANNEE : |\\tVILLE : |\\tENTREES :"); //regex
                titre = tab[1];
                annee = Integer.parseInt(tab[3]);
                nbEntrees = Integer.parseInt(tab[5]);

                //nbFilms
                if(!data_titre.contains(titre)) { //si le titre n'est pas dans la liste
                    data_titre.add(titre); //ajoute le titre
                    nbFilms++; // incrémente le nombre de Films de la liste
                }
                //liste 3 films le plus vus






                nbLignes++;
                //System.out.println(data_titre);

            }

            in.close();

        }



        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Fichier : "+ args[0]);
        System.out.println("Nombre de lignes : " + nbLignes);
        System.out.println("Nombre de films : " + nbFilms );
        System.out.println("------------");
        System.out.println("Films comptabilisant le plus grand nombre d'entrees :");
        //System.out.println("("+annee+")" + " " + titre + "        entrees :" + " "+ nbEntrees);




    }
}
