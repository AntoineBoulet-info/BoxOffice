import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BoxOfficeTableau extends BoxOffice {

    public final static int TAILLE_INITIALE= 100;
    public static int TAILLE_TMP = TAILLE_INITIALE;
    private Film[] elements = new Film[TAILLE_INITIALE];//contient les infos d'un Film
    private static int nbFilms;
    private static int nbLignes;


    //méthode
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


    public static void main(String[] args) throws IOException {
        if (args.length<1) System.err.println("nom de fichier manquant");
        else new BoxOfficeTest(args[0]);
        try {
            Scanner in = new Scanner(new File(args[0]));
            String line;
            String tmp_titre = "";
            String titre = "";
            String realisateur;
            String[] tab;
            int annee;
            int nbEntrees;
            while(in.hasNextLine()) {
                line = in.nextLine();
                tab = line.split("(\\((.*?)\\))\\tReal.: \\tEntrees:");
                annee = Integer.parseInt(tab[1]);
                titre = tab[1];
                realisateur = tab[2];
                nbEntrees= Integer.parseInt(tab[3]);
                for (int i=0;i< args.length;i++) {
                    if (titre.equals(tmp_titre)) {
                        tmp_titre = in.next();
                        nbFilms++;
                    }


                }
                nbLignes++;


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



    }
}
