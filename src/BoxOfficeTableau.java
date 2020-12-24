import java.io.IOException;
import java.util.Arrays;

public class BoxOfficeTableau extends BoxOffice {

    public final static int TAILLE_INITIALE= 100;
    private Film[] elements = new Film[TAILLE_INITIALE];//contient les infos d'un Film
    private static int nbFilms;
    private static int nbLignes;


    public Film[] duplication(Film[] tab){
        Film[] tmp = new Film[tab.length*2];
        System.arraycopy(tab,0,tmp,0,tab.length); //copie les data de Film & agrandit le tableau
        return tmp;
    }
    public boolean search(String titre,int annee,Film[] tab) {
        for (Film f : tab) {
            if(f==null) break;
            if (f.getTitre().equals(titre) && f.getAnnee()==annee) return true;
        }
        return false;
    }
    public void SommeNbEntrees(String titre, int nbEntrees, Film[] tab) {
        for (Film f : tab) {
            if (f==null) break;
            if(f.getTitre().equals(titre)) {
                nbEntrees += f.getNbEntrees();
            }
        }
    }

    //méthode Film
    public void addFilm(String titre, String realisateur, int annee, int nbEntrees) {
        if(elements==null) elements = new Film[TAILLE_INITIALE];
        if(elements.length <= nbFilms){
            elements=duplication(elements);
        }
        if(search(titre,annee, elements)){
            SommeNbEntrees(titre, nbEntrees, elements);
        }
        else{
            elements[nbFilms]=new Film(titre, realisateur, annee, nbEntrees);
            nbFilms++;
        }
        nbLignes++;
    }

    public Film[] maxEntrees(){
       Film[] tab = new Film[3];
       int i = 0;
       if (elements == null) elements = new Film[TAILLE_INITIALE];
        for(Film e : elements ){
            tab[i] = e;
            i++;
            if(i>=3)
                break;

        }
        return tab;

    }


    public void affichage(){
        System.out.println("Nombre de lignes : " + nbLignes);
        System.out.println("Nombre de films : " + nbFilms);
        System.out.println("------------");
        System.out.println("Films  comptabilisant le plus grand nombre d'entrees : ");
        System.out.println(Arrays.toString(maxEntrees()));
    }


    //constructeur
    public BoxOfficeTableau(String listing) {
        super(listing);
    }


    public static void main(String[] args) throws IOException {
        if (args.length<1) System.err.println("nom de fichier manquant");
        else {
            BoxOfficeTableau tmp =  new BoxOfficeTableau(args[0]);
            System.out.println("Fichier : "+args[0]);
            tmp.affichage();
        }




    }

}
