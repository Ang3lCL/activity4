package actividad_4;

public class Profesor {

    private String nombre;
    private String nomina;
    private double sueldoHora;
    private Materia materia;
    private int horasSemana;

    public Profesor(){}

    public Profesor(String n,String no,double s){
        nombre=n;
        nomina=no;
        sueldoHora=s;
    }

    public Profesor(Profesor p){
        this(p.nombre,p.nomina,p.sueldoHora);
        materia=p.materia;
        horasSemana=p.horasSemana;
    }

    public void setMateria(Materia m,int horas){
        materia=m;
        horasSemana=horas;
    }

    public double sueldoSemanal(){
        return sueldoHora*horasSemana;
    }

    public void mostrar(){
        System.out.println(nombre+" "+nomina+
            " $" + sueldoSemanal() +
            (materia!=null ? " "+materia.getNombre() : ""));
    }

    public void setNombre(String x){ nombre=x; }
    public void setNomina(String x){ nomina=x; }
    public void setSueldoHora(double x){ sueldoHora=x; }
}
