## Actividad 4

**Enunciado**  
En una escuela, los directivos necesitan crear un programa para control escolar que permita manejar profesores, alumnos, cursos y materias. Los datos que se registran para cada caso son los siguientes:
Profesores. Nombre, número de nómina, sueldo por hora y materia que imparten. Un profesor solo puede impartir una materia, pero puede darse de alta antes de tener una ya asignada; además, el sueldo semanal de cada docente depende del número de horas que imparte su materia, así como de su sueldo por hora.
Alumnos. Matrícula, nombre, edad y el curso en el que está inscrito.
Materias y cursos. Las materias cuentan con nombre, clave, número de créditos que amparan y cantidad de horas semanales que se imparten. Por su parte, cada curso tiene un nombre y está formado siempre por tres materias, cuyos créditos se suman para obtener el del curso que integran.

**Codigo**  
````java
package actividad_4;

import java.util.Scanner;

public class Act4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Materia[] materias = new Materia[20];
        Curso[] cursos = new Curso[20];
        Profesor[] profesores = new Profesor[20];
        Alumno[] alumnos = new Alumno[20];

        int cm = 0, cc = 0, cp = 0, ca = 0;


        materias[cm++] = new Materia("Programacion","PRO",5,6);
        materias[cm++] = new Materia("Matematicas","MAT",4,5);
        materias[cm++] = new Materia("Fisica","FIS",3,4);

        cursos[cc++] = new Curso("Curso 0", materias[0], materias[1], materias[2]);
        cursos[cc++] = new Curso("Curso 1", materias[1], materias[2], materias[0]);
        cursos[cc++] = new Curso("Curso 2", materias[2], materias[0], materias[1]);

        profesores[cp++] = new Profesor("Ana Lopez","P1",150);
        profesores[cp++] = new Profesor("Luis Perez","P2",180);
        profesores[cp++] = new Profesor("Maria Cruz","P3",170);

        profesores[0].setMateria(materias[0],6);
        profesores[1].setMateria(materias[1],5);
        profesores[2].setMateria(materias[2],4);

        alumnos[ca++] = new Alumno("A1","Carlos",19,cursos[0]);
        alumnos[ca++] = new Alumno("A2","Laura",20,cursos[1]);
        alumnos[ca++] = new Alumno("A3","Miguel",18,cursos[2]);



        int opcion;

        do {
            System.out.println("\n=== MENÚ ESCUELA ===");
            System.out.println("1. Administrar Alumnos");
            System.out.println("2. Administrar Profesores");
            System.out.println("3. Administrar Cursos");
            System.out.println("4. Administrar Materias");
            System.out.println("5. Salir");
            System.out.print("Que opcion quieres elegir: ");
            opcion = sc.nextInt();

            switch (opcion) {


            case 1:
                int opcionA;
                do {
                    System.out.println("\n=== MENÚ ALUMNOS ===");
                    System.out.println("1 Mostrar Alumnos");
                    System.out.println("2 Añadir Alumnos");
                    System.out.println("3 Eliminar ALumnos");
                    System.out.println("4 Modificar Alumnos");
                    System.out.println("5 Salir");
                    System.out.print("Que opcion quieres elegir: ");
                    opcionA = sc.nextInt();

                    switch (opcionA) {

                    case 1:
                        System.out.println("Mostrando alumnos");
                        for(int i=0;i<ca;i++){
                            System.out.print(i+" -> ");
                            alumnos[i].mostrar();
                        }
                        break;

                    case 2:
                        sc.nextLine();
                        System.out.println("Añadiendo Alumno");
                        System.out.print("Matricula:");
                        String mat=sc.nextLine();
                        System.out.print("Nombre:");
                        String nom=sc.nextLine();
                        System.out.print("Edad:");
                        int edad=sc.nextInt();
                        alumnos[ca++] = new Alumno(mat,nom,edad,cursos[0]);
                        break;

                    case 3:
                        System.out.println("Eliminando alumno");
                        System.out.println("Alumnos disponibles:");
                        for(int i=0;i<ca;i++){
                            System.out.print(i+" -> ");
                            alumnos[i].mostrar();
                        }

                        System.out.print("Cual quieres eliminar?: ");
                        int idx=sc.nextInt();
                        if(idx<ca){
                            alumnos[idx]=alumnos[ca-1];
                            ca--;
                        }
                        break;

                    case 4:
                        System.out.println("Modificando alumnos");
                        System.out.println("Alumnos disponibles:");
                        for(int i=0;i<ca;i++){
                            System.out.print(i+" -> ");
                            alumnos[i].mostrar();
                        }

                        System.out.print("Cual quieres modificar?: ");
                        int im=sc.nextInt();
                        sc.nextLine();

                        if(im<ca){
                            System.out.print("Nueva matricula: ");
                            alumnos[im].setMatricula(sc.nextLine());

                            System.out.print("Nuevo nombre: ");
                            alumnos[im].setNombre(sc.nextLine());

                            System.out.print("Nueva edad: ");
                            alumnos[im].setEdad(sc.nextInt());

                            System.out.println("Cursos disponibles:");
                            for(int j=0;j<cc;j++){
                                System.out.print(j+" -> ");
                                cursos[j].mostrar();
                            }

                            System.out.print("Selecciona curso: ");
                            int ic=sc.nextInt();
                            if(ic<cc){
                                alumnos[im].setCurso(cursos[ic]);
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opcion invalida");
                        break;

                    }
                } while(opcionA!=5);
                
                break;


            case 2:
                int opcionB;
                do {
                    System.out.println("\n=== MENÚ PROFESORES ===");
                    System.out.println("1 Mostrar Profesores");
                    System.out.println("2 Añadir Profesores");
                    System.out.println("3 Eliminar Profesores");
                    System.out.println("4 Modificar Profesores");
                    System.out.println("5 Salir");
                    System.out.print("Que opcion quieres elegir: ");
                    opcionB=sc.nextInt();

                    switch(opcionB){

                    case 1:
                        System.out.println("Mostrando Profesores");
                        for(int i=0;i<cp;i++){
                            System.out.print(i+" -> ");
                            profesores[i].mostrar();
                        }
                        break;

                    case 2:
                        sc.nextLine();
                        System.out.println("Añadiendo Profesor");
                        System.out.print("Nombre:");
                        String n=sc.nextLine();
                        System.out.print("Nomina:");
                        String no=sc.nextLine();
                        System.out.print("SueldoHora:");
                        double s=sc.nextDouble();
                        profesores[cp++]=new Profesor(n,no,s);
                        break;

                    case 3:
                        System.out.println("Eliminando Profesor");
                         System.out.println("Profesores disponibles:");
                        for(int j=0;j<cp;j++){
                            System.out.print(j+" -> ");
                            profesores[j].mostrar();
                        }
                        System.out.print("Cual quieres eliminar?: ");
                        int i=sc.nextInt();
                        if(i<cp){ profesores[i]=profesores[cp-1]; cp--; }
                        break;

                    case 4:
                        System.out.println("Modificando profesores");
                        System.out.println("Profesores disponibles:");
                        for(int j=0;j<cp;j++){
                            System.out.print(j+" -> ");
                            profesores[j].mostrar();
                        }

                        System.out.print("Cual quieres modificar?: ");
                        int ip=sc.nextInt();
                        sc.nextLine();

                        if(ip<cp){
                            System.out.print("Nuevo nombre: ");
                            profesores[ip].setNombre(sc.nextLine());

                            System.out.print("Nueva nomina: ");
                            profesores[ip].setNomina(sc.nextLine());

                            System.out.print("Nuevo sueldo hora: ");
                            profesores[ip].setSueldoHora(sc.nextDouble());

                            System.out.println("Materias disponibles:");
                            for(int j=0;j<cm;j++){
                                System.out.print(j+" -> ");
                                materias[j].mostrar();
                            }

                            System.out.print("Materia a asignar: ");
                            int imat=sc.nextInt();

                            System.out.print("Horas semanales: ");
                            int horas=sc.nextInt();

                            if(imat<cm){
                                profesores[ip].setMateria(materias[imat],horas);
                            }
                        }
                        break;

                    case 5:
                        System.out.println("saliendo...");
                        break;
                    
                    default:
                        System.out.println("Opcion invalida");
                        break;
                    }

                } while(opcionB!=5);
                break;


            case 3:
                int opcionC;
                do{
                    System.out.println("\n=== MENÚ CURSOS ===");
                    System.out.println("1 Mostrar Cursos");
                    System.out.println("2 Añadir Cursos");
                    System.out.println("3 Modificar Cursos");
                    System.out.println("4 Eliminar Cursos");
                    System.out.println("5 Salir");
                    System.out.print("Que opcion quieres elegir: ");
                    opcionC=sc.nextInt();

                    switch(opcionC){

                   
                    case 1:
                        System.out.println("Mostrando cursos");
                        for(int i=0;i<cc;i++){
                            System.out.print(i+" -> ");
                            cursos[i].mostrar();
                        }
                        break;

                  
                    case 2:
                        System.out.println("Añadiendo cursos");

                        if(cm < 3){
                            System.out.println("Necesitas al menos 3 materias");
                            break;
                        }

                        sc.nextLine();
                        System.out.print("Nombre del curso: ");
                        String nc = sc.nextLine();

                        System.out.println("Selecciona 3 materias (indices):");

                        for(int j=0;j<cm;j++){
                            System.out.print(j+" -> ");
                            materias[j].mostrar();
                        }

                        int a = sc.nextInt();
                        int b = sc.nextInt();
                        int c = sc.nextInt();

                        if(a<cm && b<cm && c<cm){
                            cursos[cc++] = new Curso(
                                nc,
                                materias[a],
                                materias[b],
                                materias[c]
                            );
                            System.out.println("Curso agregado");
                        } else {
                            System.out.println("Indices invalidos");
                        }
                        break;

                    
                    case 3:
                        System.out.println("Modificando cursos");

                        for(int j=0;j<cc;j++){
                            System.out.print(j+" -> ");
                            cursos[j].mostrar();
                        }

                        System.out.print("Cual quieres modificar?: ");
                        int icur=sc.nextInt();
                        sc.nextLine();

                        if(icur<cc){

                            System.out.print("Nuevo nombre: ");
                            cursos[icur].setNombre(sc.nextLine());

                            System.out.println("Selecciona 3 materias:");

                            for(int j=0;j<cm;j++){
                                System.out.print(j+" -> ");
                                materias[j].mostrar();
                            }

                            int m1=sc.nextInt();
                            int m2=sc.nextInt();
                            int m3=sc.nextInt();

                            if(m1<cm && m2<cm && m3<cm){
                                cursos[icur].setMaterias(
                                    materias[m1],
                                    materias[m2],
                                    materias[m3]
                                );
                            }
                        }
                        break;

                  
                    case 4:
                        System.out.println("Eliminar curso");

                        for(int j=0;j<cc;j++){
                            System.out.print(j+" -> ");
                            cursos[j].mostrar();
                        }

                        System.out.print("Cual quieres eliminar?: ");
                        int ie = sc.nextInt();

                        if(ie < cc){
                            cursos[ie] = cursos[cc-1];
                            cc--;
                            System.out.println("Curso eliminado");
                        }
                        break;

                    case 5:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opcion invalida");
                    }

                }while(opcionC!=5);
                break;


            case 4:
                int opcionD;
                do{
                    System.out.println("\n=== MENÚ MATERIAS ===");
                    System.out.println("1 Mostrar Materias");
                    System.out.println("2 Añadir Materias");
                    System.out.println("3 Eliminar Materias");
                    System.out.println("4 Modificar Materias");
                    System.out.println("5 Salir");
                    System.out.print("Que opcion quieres elegir: ");
                    opcionD=sc.nextInt();

                    switch(opcionD){

                    case 1:
                        System.out.println("Mostrando materias");
                        for(int i=0;i<cm;i++){
                            System.out.print(i+" -> ");
                            materias[i].mostrar();
                        }
                        break;

                    case 2:
                        sc.nextLine();
                        System.out.println("Añadiendo materia");
                        System.out.print("Nombre:");
                        String nm=sc.nextLine();
                        System.out.print("Clave:");
                        String cl=sc.nextLine();
                        System.out.print("Creditos:");
                        int cr=sc.nextInt();
                        System.out.print("Horas:");
                        int h=sc.nextInt();
                        materias[cm++]=new Materia(nm,cl,cr,h);
                        break;

                    case 3:
                        System.out.println("Eliminando materia");
                        System.out.println("Materias disponibles:");
                        for(int j=0;j<cm;j++){
                            System.out.print(j+" -> ");
                            materias[j].mostrar();
                        }
                        System.out.print("Que materia quieres eliminar?: ");
                        int i=sc.nextInt();
                        if(i<cm){ materias[i]=materias[cm-1]; cm--; }
                        break;

                    case 4:
                        System.out.println("Materias disponibles:");
                        for(int j=0;j<cm;j++){
                            System.out.print(j+" -> ");
                            materias[j].mostrar();
                        }

                        System.out.print("Cual quieres modificar?: ");
                        int imat=sc.nextInt();
                        sc.nextLine();

                        if(imat<cm){
                            System.out.print("Nuevo nombre: ");
                            materias[imat].setNombre(sc.nextLine());

                            System.out.print("Nueva clave: ");
                            materias[imat].setClave(sc.nextLine());

                            System.out.print("Nuevos creditos: ");
                            materias[imat].setCreditos(sc.nextInt());

                            System.out.print("Nuevas horas: ");
                            materias[imat].setHoras(sc.nextInt());
                        }
                        break;
                    
                    case 5:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opcion invalida");
                        break;
                    }
            

                }while(opcionD!=5);
                break;
            }

        } while(opcion!=5);

    sc.close();
    }
}
````

**Salida Real**
````text
=== MENÚ ESCUELA ===
1. Administrar Alumnos
2. Administrar Profesores
3. Administrar Cursos
4. Administrar Materias
5. Salir
Que opcion quieres elegir: 1

=== MENÚ ALUMNOS ===
1 Mostrar Alumnos
2 Añadir Alumnos
3 Eliminar ALumnos
4 Modificar Alumnos
5 Salir
Que opcion quieres elegir: 1
Mostrando alumnos
0 -> A1 Carlos 19
1 -> A2 Laura 20
2 -> A3 Miguel 18

=== MENÚ ALUMNOS ===
1 Mostrar Alumnos
2 Añadir Alumnos
3 Eliminar ALumnos
4 Modificar Alumnos
5 Salir
Que opcion quieres elegir: 2
Añadiendo Alumno
Matricula:A4
Nombre:Angel
Edad:18

=== MENÚ ALUMNOS ===
1 Mostrar Alumnos
2 Añadir Alumnos
3 Eliminar ALumnos
4 Modificar Alumnos
5 Salir
Que opcion quieres elegir: 4
Modificando alumnos
Alumnos disponibles:
0 -> A1 Carlos 19
1 -> A2 Laura 20
2 -> A3 Miguel 18
3 -> A4 Angel 18
Cual quieres modificar?: 3
Nueva matricula: A4
Nuevo nombre: angel
Nueva edad: 19
Cursos disponibles:
0 -> Curso:Curso 0 Creditos:12
1 -> Curso:Curso 1 Creditos:12
2 -> Curso:Curso 2 Creditos:12
Selecciona curso: 1

=== MENÚ ALUMNOS ===
1 Mostrar Alumnos
2 Añadir Alumnos
3 Eliminar ALumnos
4 Modificar Alumnos
5 Salir
Que opcion quieres elegir: 3
Eliminando alumno
Alumnos disponibles:
0 -> A1 Carlos 19
1 -> A2 Laura 20
2 -> A3 Miguel 18
3 -> A4 angel 19
Cual quieres eliminar?: 3

=== MENÚ ALUMNOS ===
1 Mostrar Alumnos
2 Añadir Alumnos
3 Eliminar ALumnos
4 Modificar Alumnos
5 Salir
Que opcion quieres elegir: 5
Saliendo...

=== MENÚ ESCUELA ===
1. Administrar Alumnos
2. Administrar Profesores
3. Administrar Cursos
4. Administrar Materias
5. Salir
Que opcion quieres elegir: 2

=== MENÚ PROFESORES ===
1 Mostrar Profesores
2 Añadir Profesores
3 Eliminar Profesores
4 Modificar Profesores
5 Salir
Que opcion quieres elegir: 1
Mostrando Profesores
0 -> Ana Lopez P1 $900.0 Programacion
1 -> Luis Perez P2 $900.0 Matematicas
2 -> Maria Cruz P3 $680.0 Fisica

=== MENÚ PROFESORES ===
1 Mostrar Profesores
2 Añadir Profesores
3 Eliminar Profesores
4 Modificar Profesores
5 Salir
Que opcion quieres elegir: 2
Añadiendo Profesor
Nombre:Angel
Nomina:P4
SueldoHora:50

=== MENÚ PROFESORES ===
1 Mostrar Profesores
2 Añadir Profesores
3 Eliminar Profesores
4 Modificar Profesores
5 Salir
Que opcion quieres elegir: 4
Modificando profesores
Profesores disponibles:
0 -> Ana Lopez P1 $900.0 Programacion
1 -> Luis Perez P2 $900.0 Matematicas
2 -> Maria Cruz P3 $680.0 Fisica
3 -> Angel P4 $0.0
Cual quieres modificar?: 3
Nuevo nombre: Angel
Nueva nomina: P4
Nuevo sueldo hora: 100
Materias disponibles:
0 -> Programacion PRO Cred:5 Horas:6
1 -> Matematicas MAT Cred:4 Horas:5
2 -> Fisica FIS Cred:3 Horas:4
Materia a asignar: 1
Horas semanales: 5

=== MENÚ PROFESORES ===
1 Mostrar Profesores
2 Añadir Profesores
3 Eliminar Profesores
4 Modificar Profesores
5 Salir
Que opcion quieres elegir: 1
Mostrando Profesores
0 -> Ana Lopez P1 $900.0 Programacion
1 -> Luis Perez P2 $900.0 Matematicas
2 -> Maria Cruz P3 $680.0 Fisica
3 -> Angel P4 $500.0 Matematicas

=== MENÚ PROFESORES ===
1 Mostrar Profesores
2 Añadir Profesores
3 Eliminar Profesores
4 Modificar Profesores
5 Salir
Que opcion quieres elegir: 3
Eliminando Profesor
Profesores disponibles:
0 -> Ana Lopez P1 $900.0 Programacion
1 -> Luis Perez P2 $900.0 Matematicas
2 -> Maria Cruz P3 $680.0 Fisica
3 -> Angel P4 $500.0 Matematicas
Cual quieres eliminar?: 3

=== MENÚ PROFESORES ===
1 Mostrar Profesores
2 Añadir Profesores
3 Eliminar Profesores
4 Modificar Profesores
5 Salir
Que opcion quieres elegir: 5
saliendo...

=== MENÚ ESCUELA ===
1. Administrar Alumnos
2. Administrar Profesores
3. Administrar Cursos
4. Administrar Materias
5. Salir
Que opcion quieres elegir: 4

=== MENÚ MATERIAS ===
1 Mostrar Materias
2 Añadir Materias
3 Eliminar Materias
4 Modificar Materias
5 Salir
Que opcion quieres elegir: 1
Mostrando materias
0 -> Programacion PRO Cred:5 Horas:6
1 -> Matematicas MAT Cred:4 Horas:5
2 -> Fisica FIS Cred:3 Horas:4

=== MENÚ MATERIAS ===
1 Mostrar Materias
2 Añadir Materias
3 Eliminar Materias
4 Modificar Materias
5 Salir
Que opcion quieres elegir: 2
Añadiendo materia
Nombre:Ingles
Clave:igl
Creditos:2
Horas:6

=== MENÚ MATERIAS ===
1 Mostrar Materias
2 Añadir Materias
3 Eliminar Materias
4 Modificar Materias
5 Salir
Que opcion quieres elegir: 4
Materias disponibles:
0 -> Programacion PRO Cred:5 Horas:6
1 -> Matematicas MAT Cred:4 Horas:5
2 -> Fisica FIS Cred:3 Horas:4
3 -> Ingles igl Cred:2 Horas:6
Cual quieres modificar?: 3
Nuevo nombre: Ingles
Nueva clave: IGL
Nuevos creditos: 2
Nuevas horas: 6

=== MENÚ MATERIAS ===
1 Mostrar Materias
2 Añadir Materias
3 Eliminar Materias
4 Modificar Materias
5 Salir
Que opcion quieres elegir: 5
Saliendo...

=== MENÚ ESCUELA ===
1. Administrar Alumnos
2. Administrar Profesores
3. Administrar Cursos
4. Administrar Materias
5. Salir
Que opcion quieres elegir: 3

=== MENÚ CURSOS ===
1 Mostrar Cursos
2 Añadir Cursos
3 Modificar Cursos
4 Eliminar Cursos
5 Salir
Que opcion quieres elegir: 1
Mostrando cursos
0 -> Curso:Curso 0 Creditos:12
1 -> Curso:Curso 1 Creditos:12
2 -> Curso:Curso 2 Creditos:12

=== MENÚ CURSOS ===
1 Mostrar Cursos
2 Añadir Cursos
3 Modificar Cursos
4 Eliminar Cursos
5 Salir
Que opcion quieres elegir: 2
Añadiendo cursos
Nombre del curso: Curso 3
Selecciona 3 materias (indices):
0 -> Programacion PRO Cred:5 Horas:6
1 -> Matematicas MAT Cred:4 Horas:5
2 -> Fisica FIS Cred:3 Horas:4
3 -> Ingles IGL Cred:2 Horas:6
3
2
0
Curso agregado

=== MENÚ CURSOS ===
1 Mostrar Cursos
2 Añadir Cursos
3 Modificar Cursos
4 Eliminar Cursos
5 Salir
Que opcion quieres elegir: 3
Modificando cursos
0 -> Curso:Curso 0 Creditos:12
1 -> Curso:Curso 1 Creditos:12
2 -> Curso:Curso 2 Creditos:12
3 -> Curso:Curso 3 Creditos:10
Cual quieres modificar?: 3
Nuevo nombre: Curso 3
Selecciona 3 materias:
0 -> Programacion PRO Cred:5 Horas:6
1 -> Matematicas MAT Cred:4 Horas:5
2 -> Fisica FIS Cred:3 Horas:4
3 -> Ingles IGL Cred:2 Horas:6
3
0
2

=== MENÚ CURSOS ===
1 Mostrar Cursos
2 Añadir Cursos
3 Modificar Cursos
4 Eliminar Cursos
5 Salir
Que opcion quieres elegir: 1
Mostrando cursos
0 -> Curso:Curso 0 Creditos:12
1 -> Curso:Curso 1 Creditos:12
2 -> Curso:Curso 2 Creditos:12
3 -> Curso:Curso 3 Creditos:10

=== MENÚ CURSOS ===
1 Mostrar Cursos
2 Añadir Cursos
3 Modificar Cursos
4 Eliminar Cursos
5 Salir
Que opcion quieres elegir: 4
Eliminar curso
0 -> Curso:Curso 0 Creditos:12
1 -> Curso:Curso 1 Creditos:12
2 -> Curso:Curso 2 Creditos:12
3 -> Curso:Curso 3 Creditos:10
Cual quieres eliminar?: 3
Curso eliminado

=== MENÚ CURSOS ===
1 Mostrar Cursos
2 Añadir Cursos
3 Modificar Cursos
4 Eliminar Cursos
5 Salir
Que opcion quieres elegir: 5
Saliendo...

=== MENÚ ESCUELA ===
1. Administrar Alumnos
2. Administrar Profesores
3. Administrar Cursos
4. Administrar Materias
5. Salir
Que opcion quieres elegir: 4

=== MENÚ MATERIAS ===
1 Mostrar Materias
2 Añadir Materias
3 Eliminar Materias
4 Modificar Materias
5 Salir
Que opcion quieres elegir: 3
Eliminando materia
Materias disponibles:
0 -> Programacion PRO Cred:5 Horas:6
1 -> Matematicas MAT Cred:4 Horas:5
2 -> Fisica FIS Cred:3 Horas:4
3 -> Ingles IGL Cred:2 Horas:6
Que materia quieres eliminar?: 3

=== MENÚ MATERIAS ===
1 Mostrar Materias
2 Añadir Materias
3 Eliminar Materias
4 Modificar Materias
5 Salir
Que opcion quieres elegir: 5
Saliendo...

=== MENÚ ESCUELA ===
1. Administrar Alumnos
2. Administrar Profesores
3. Administrar Cursos
4. Administrar Materias
5. Salir
Que opcion quieres elegir: 5
````