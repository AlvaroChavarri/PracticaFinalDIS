package back;


public class Actor {
    private String nombreAct;
    private String enlaceWiki;
    public Actor(){
        this.nombreAct = null;
        this.enlaceWiki = null;
    }
    public Actor(String nombreAct, String enlaceWiki) {
        this.nombreAct = nombreAct;
        this.enlaceWiki = enlaceWiki;
    }

    public String getNombreAct() {
        return nombreAct;
    }

    public void setNombreAct(String nombreAct) {
        this.nombreAct = nombreAct;
    }

    public String getEnlaceWiki() {
        return enlaceWiki;
    }

    public void setEnlaceWiki(String enlaceWiki) {
        this.enlaceWiki = enlaceWiki;
    }

    public String toString() {
        return "Nombre Actor/Actriz=" + nombreAct + ", EnlaceWiki=" + enlaceWiki;
    }
}