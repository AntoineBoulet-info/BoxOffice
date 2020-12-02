import java.io.IOException;

public class BoxOfficeTest extends BoxOffice {

    //constructeur
    public BoxOfficeTest(String listing) {
        super(listing);

    }
    //méthode
    public void addFilm(String titre, String realisateur, int annee, int nbEntrees) {
        System.out.println("("+annee+")"+titre+"        Real.: "
        +realisateur+"      Entrees:"+nbEntrees);
    }

    public static void main(String[] args) throws IOException {
        if (args.length<1) System.err.println("nom de fichier manquant");
        else new BoxOfficeTest(args[0]);


    }
}
