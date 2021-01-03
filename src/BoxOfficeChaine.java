public class BoxOfficeChaine extends BoxOffice {
    static FilmChaine first=null,element=null;
    public static final int NBMAX=3;

    public BoxOfficeChaine(String listing) throws Exception {
        super(listing);
    }

    public void addFilm(String titre, String realisateur, int annee, int nbEntrees) {
        if (first == null) {
            first = new FilmChaine(titre, realisateur, annee, nbEntrees);
            nbFilms++; // ne pas oublier d'incrémenter le premier film qui est ajouté !

        }
        else {
            boolean trouve=false;
            element = first;
            while(element!=null){
                if(element.getTitre().equals(titre) && element.getAnnee()==annee && element.getRealisateur().equals(realisateur) ){
                    trouve=true;
                    element.addEntrees(nbEntrees);
                    if(element.getPrec()!=null && element.getNext()!=null){
                        if(element.getPrec().getNbEntrees() < element.getNbEntrees()){
                            element.getPrec().setNext(element.getNext());
                            element.getNext().setPrec(element.getPrec());
                            element.setPrec(element.getPrec().getPrec());
                            boolean pos=false;
                            while (element.getPrec()!=null){
                                if(element.getPrec().getNbEntrees()<element.getNbEntrees()){
                                    element.setPrec(element.getPrec().getPrec());
                                }
                                else {
                                    element.setNext(element.getPrec().getNext());
                                    element.getPrec().getNext().setPrec(element);
                                    element.getPrec().setNext(element);
                                    pos=true;
                                    break;
                                }

                            }
                            if(!pos){
                                element.setNext(first);
                                first.setPrec(element);
                                first=element;
                            }
                        }
                        break;
                    }
                    break;
                }
                element=element.getNext();
            }
            if(!trouve){
                element=first;
                boolean pos=false;
                while (element.getNext()!=null){
                    if(element.getNbEntrees()>nbEntrees){
                        element=element.getNext();
                    }
                    else {
                        if(element.getPrec()!=null){
                            element.getPrec().setNext(new FilmChaine(titre,realisateur,annee,nbEntrees));
                            element.getPrec().getNext().setPrec(element.getPrec());
                            element.setPrec(element.getPrec().getNext());
                            element.getPrec().setNext(element);

                        }
                        else {
                            first.setPrec(new FilmChaine(titre,realisateur,annee,nbEntrees));
                            first.getPrec().setNext(first);
                            first=first.getPrec();
                        }
                        pos=true;
                        nbFilms++;
                        break;
                    }

                }
                if(!pos) {
                    element.setNext(new FilmChaine(titre, realisateur, annee, nbEntrees));
                    element.getNext().setPrec(element);
                    nbFilms++;
                }
            }

        }
    }
    public void affichage(){
        System.out.println("Nombre de lignes : " + nbLignes);
        System.out.println("Nombre de films : " + nbFilms);
        System.out.println("------------");
        System.out.println("Films  comptabilisant le plus grand nombre d'entrees : ");
        element=first;

        for (int i=0;i<NBMAX;i++){
            if(element!=null){
                System.out.println(element.toString());
                element=element.getNext();
            }
            else break;
        }
        System.out.println(" ");
    }
    public static void main(String[] args) throws Exception{
        if (args.length<1) System.err.println("nom de fichier manquant");
        else {
            System.out.println("Fichier : "+args[0]);
            BoxOfficeChaine boc = new BoxOfficeChaine(args[0]);
            boc.affichage();


        }
    }
}
