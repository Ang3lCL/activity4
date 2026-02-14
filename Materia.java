package actividad_4;

public class Materia {

    private String nombre;
    private String clave;
    private int creditos;
    private int horas;

    public Materia() {}

    public Materia(String n,String c,int cr,int h){
        nombre=n; clave=c; creditos=cr; horas=h;
    }

    public Materia(Materia m){
        this(m.nombre,m.clave,m.creditos,m.horas);
    }

    public void mostrar(){
        System.out.println(nombre+" "+clave+" Cred:"+creditos+" Horas:"+horas);
    }

    public String getNombre(){ return nombre; }
    public String getClave(){ return clave; }
    public int getCreditos(){ return creditos; }
    public int getHoras(){ return horas; }

    public void setNombre(String x){ nombre=x; }
    public void setClave(String x){ clave=x; }
    public void setCreditos(int x){ creditos=x; }
    public void setHoras(int x){ horas=x; }
}
