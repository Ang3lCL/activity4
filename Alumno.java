package actividad_4;

public class Alumno {

    private String matricula;
    private String nombre;
    private int edad;
    private Curso curso;

    public Alumno(){}

    public Alumno(String m,String n,int e,Curso c){
        matricula=m; nombre=n; edad=e; curso=c;
    }

    public Alumno(Alumno a){
        this(a.matricula,a.nombre,a.edad,a.curso);
    }

    public void mostrar(){
        System.out.println(matricula+" "+nombre+" "+edad);
    }

    public void setMatricula(String x){ matricula=x; }
    public void setNombre(String x){ nombre=x; }
    public void setEdad(int x){ edad=x; }
    public void setCurso(Curso c){ curso=c; }
}

