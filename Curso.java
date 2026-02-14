package actividad_4;

public class Curso {

    private String nombre;
    private Materia m1,m2,m3;

    public Curso(){}

    public Curso(String n,Materia a,Materia b,Materia c){
        nombre=n; m1=a; m2=b; m3=c;
    }

    public Curso(Curso c){
        this(c.nombre,c.m1,c.m2,c.m3);
    }

    public int getCreditos(){
        return m1.getCreditos()+m2.getCreditos()+m3.getCreditos();
    }

    public void setNombre(String n){ nombre=n; }

    public void setMaterias(Materia a,Materia b,Materia c){
        m1=a; m2=b; m3=c;
    }

    public void mostrar(){
        System.out.println("Curso:"+nombre+" Creditos:"+getCreditos());
    }
}

