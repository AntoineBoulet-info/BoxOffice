import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BoxOfficeTableau extends BoxOffice {

    public final static int TAILLE_INITIALE= 100;
    private Film[] elements;//contient les infos d'un Film
    private static int nbFilms;
    private static int nbLignes;



    public void addFilm(String titre, String realisateur, int annee, int nbEntrees) {
        for (int i=0;i<elements.length;i++){
            if (elements.length > TAILLE_INITIALE) {

            }
        }

    }

    public BoxOfficeTableau(String listing) {
        super(listing);
        this.elements = new Film[TAILLE_INITIALE];
    }



    public static void main(String[] args){
        if (args.length<1) System.err.println("nom de fichier manquant");
        else new BoxOfficeTest(args[0]);

        try {
            Scanner in = new Scanner(new File(args[0]));
            String line;
            String titre_film;
            while(in.hasNextLine()) {
                line = in.nextLine();
                nbLignes++;

            }

        }


        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Fichier : "+ args[0]);
        System.out.println("Nombre de lignes : " + nbLignes);
        System.out.println("Nombre de films : " + nbFilms );
        System.out.println("--------");
        System.out.println("Films comptabilisant le plus grand nombre d'entrees :");

    }
}
