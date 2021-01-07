public class BoxOfficeArbre extends BoxOffice {
    private FilmArbre elements;


    public BoxOfficeArbre(String listing) {
        super(listing);
        //TO DO
    }

    public void addFilm(String titre, String realisateur, int annee, int nbEntrees) {
        if (elements != null) {
            elements.insert(new Film(titre, realisateur, annee, nbEntrees));
            nbFilms++;
        } else {
            elements = new FilmArbre(new Film(titre, realisateur, annee, nbEntrees));
        }

    }

    public void affichage(){
        System.out.println("Nombre de lignes : " + nbLignes);
        System.out.println("Nombre de films : " + nbFilms);
        System.out.println("------------");
        System.out.println("Films  comptabilisant le plus grand nombre d'entrees : ");

    }


    public static void main(String[] args) throws Exception{
        if (args.length<1) System.err.println("nom de fichier manquant");
        else {
            System.out.println("Fichier : "+args[0]);
            BoxOfficeArbre boa = new BoxOfficeArbre(args[0]);
            boa.affichage();


        }
    }
}
