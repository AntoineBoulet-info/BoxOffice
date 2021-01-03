public class FilmChaine extends Film{
    protected FilmChaine next=null,prec=null;
    public FilmChaine(String titre, String realisateur, int annee, int nbEntrees) {
        super(titre, realisateur, annee, nbEntrees);
    }

    public FilmChaine getNext() {
        return next;
    }

    public void setNext(FilmChaine next) {
        this.next = next;
    }

    public FilmChaine getPrec() {
        return prec;
    }

    public void setPrec(FilmChaine prec) {
        this.prec = prec;
    }
}
