import java.util.ArrayList;
import java.util.List;

public class FilmArbre extends Film {
    private FilmArbre gauche;
    private FilmArbre droite;
    private int cle;
    public FilmArbre(Film f, FilmArbre g, FilmArbre d){
        super(f);
        gauche = g; droite = d;
    }

    public int cle(){
        return cle;
    }
    public FilmArbre gauche() {
        return gauche;
    }
    public FilmArbre droite() {
        return droite;
    }
    public FilmArbre(Film f) {
        this(f,null,null);
    }

    void insert(Film f) {
        if (cle < getNbEntrees()) {
            if (droite == null) droite = new FilmArbre(f);
            else droite.insert(f);

        }else {
            if (gauche==null) gauche = new FilmArbre(f);
            else gauche.insert(f);
        }
    }
    public int maximum() {
        if (droite==null) return cle;
        return droite.maximum();
    }
    public int minimum() {
        if(gauche==null ) return cle;
        return droite.minimum();
    }

    public boolean equals(FilmArbre a) {
        if(a==null) return false;
        if (cle != a.cle()) return false;

        if(gauche==null) return a.gauche() == null;
        if(droite==null) return a.droite() ==null;

        if(!gauche.equals(a.gauche())) return false;
        if(!droite.equals(a.droite())) return false;

        return true;
    }


    public List<FilmArbre> collect(int level)
    {
        if(level == 0)
        {
            List<FilmArbre> ret = new ArrayList<FilmArbre>();
            ret.add(this);
            return ret;
        }

        List<FilmArbre> l;
        if(gauche != null) l = gauche.collect(level - 1);
        else l = new ArrayList<FilmArbre>();

        List<FilmArbre> r;
        if(droite != null) r = droite.collect(level - 1);
        else r = new ArrayList<FilmArbre>();

        l.addAll(r);
        return l;
    } // collect

    public int size() {
        if (gauche==null && droite ==null) return 1;
        if (gauche ==null ) return 1+ droite.size();
        if(droite==null) return 1 + gauche.size();
        return 1+gauche.size() + droite.size();
    }

    

    


}
