public class BoxOfficeTableauTest extends BoxOffice {
    public BoxOfficeTableauTest(String listing) {
        super(listing);
    }

    public static void main(String args[]) {
        if (args.length<1) System.err.println("nom de fichier manquant");
        else new BoxOfficeTest(args[0]);
    }
    public void addFilm(String titre, String realisateur, int annee, int nbEntrees) {
        System.out.println("Films comptabilisant le plus grand nombre d’entrées : \n");
        System.out.println("("+annee+")"+" "+titre+"         entrées : "+nbEntrees);
    }
}
