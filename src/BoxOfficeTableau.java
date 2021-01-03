import java.io.IOException;
import java.util.Arrays;

public class BoxOfficeTableau extends BoxOffice {

    public final static int TAILLE_INITIALE= 100;
    private Film[] elements = new Film[TAILLE_INITIALE];//contient les infos d'un Film
    private Film[] topFilms; //tab de 3 films
    public static final int NBTOP=3;
    private int nbTopFilms=0;


    /*public void duplication(Film[] tab){
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
    }*/

    //méthode ajouté dans la méthode addFilm

    //méthode Film
    public void addFilm(String titre, String realisateur, int annee, int nbEntrees) {
        if(elements==null){
            elements=new Film[TAILLE_INITIALE];
        }
        else{
            //duplication de l'array
            if(nbFilms>elements.length-1){
                Film[] tmp=new Film[elements.length*2];
                System.arraycopy(elements, 0, tmp, 0, nbFilms);
                elements=tmp;

            }
        }
        
        if(topFilms==null){
            topFilms=new Film[NBTOP];
        }

        boolean trouve=false;
        for(int i=0;i<nbFilms;i++){
            if(elements[i].getTitre().equals(titre) && elements[i].getAnnee()==annee && elements[i].getRealisateur().equals(realisateur)){
                elements[i].addEntrees(nbEntrees);
                trouve=true;
                maxEntrees(elements[i]);
                break;
            }
        }
        if(!trouve){
            elements[nbFilms]=new Film(titre,realisateur,annee,nbEntrees);
            maxEntrees(elements[nbFilms]);
            nbFilms++;


        }
    }

    public void maxEntrees(Film film){
        if(nbTopFilms==NBTOP)nbTopFilms=NBTOP-1;
        int newPosition=-1,pos=-1;
        for(int i=0;i<nbTopFilms;i++){
            if(topFilms[i].getTitre().equals(film.getTitre())){
                pos=i;
                break;
            }
            if (topFilms[i].getNbEntrees()<film.getNbEntrees()){
                if(newPosition==-1)
                    newPosition=i;

            }
        }
        if(nbTopFilms<NBTOP-1&&pos==-1){
            if(newPosition==-1){
                topFilms[nbTopFilms]=film;
                nbTopFilms++;
            }
        }
        if(pos==-1&&newPosition!=-1){
            if (nbTopFilms - newPosition >= 0)
                System.arraycopy(topFilms, newPosition, topFilms, newPosition + 1, nbTopFilms - newPosition);
            topFilms[newPosition]=film;
            nbTopFilms++;
        }
        else if(pos!=-1&&newPosition!=-1){
            if (pos - newPosition >= 0)
                System.arraycopy(topFilms, newPosition, topFilms, newPosition + 1, pos - newPosition);
            topFilms[newPosition]=film;
        }

    }


    public void affichage(){
        System.out.println("Nombre de lignes : " + nbLignes);
        System.out.println("Nombre de films : " + nbFilms);
        System.out.println("------------");
        System.out.println("Films  comptabilisant le plus grand nombre d'entrees : ");
        for(Film f:topFilms){
            if(f!=null){
                System.out.println(f.toString());
            }
        }

    }


    //constructeur
    public BoxOfficeTableau(String listing) throws Exception {
        super(listing);
    }


    public static void main(String[] args) throws Exception {
        if (args.length<1) System.err.println("nom de fichier manquant");
        else {
            BoxOfficeTableau tmp =  new BoxOfficeTableau(args[0]);
            System.out.println("Fichier : "+args[0]);
            tmp.affichage();
        }




    }

}
