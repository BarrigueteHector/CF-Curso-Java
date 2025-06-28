import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /* 
        * POO: paradigma que organiza le código en clases que modelan entidades del mundo real

        * Clase: plantilla que define atributos (datos) y métodos (comportamiento)
        * Objeto: instancia concreta de una clase, con valores específicos

        * Constructores: métodos especiales que se utilizan para crear instancias de una clase y (opcionalment) inicializar sus atributos

        * Encapsulamiento: oculta el estado interno de un objeto y expone una interfaz pública para interactuar con él, controlando el acceso a sus datos. 
        * Herencia: permite que una subclase (clase hija) herede los atributos y métodos de otra superclase (clase padre). Se utiliza la palabra clse extends pra indicar la herencia
        * Polimorfismo: un objeto puede tener diferentes comportamientos dependiendo su tipo real en tiempo de ejecución. Se implementa por herencia (sobreescritua de métodos), por interfaces o paramétrico
        * Abstracción: permite simplificar la complejidad de un programa al enfocarse en los aspectos esenciales de los objetos y ocultar los detalles innecesarios de implementación. Se logra por medio de clases abstractas o interfaces, que definen las características generales y comportamientos de un grupo de objetos
        */

        /*     
        * Sin constructor

        Coche miCoche = new Coche();
        miCoche.marca = "Toyota";
        miCoche.anio = 2023;
        miCoche.arrancar();
        */

        // * Con constructor
        // Coche miCoche = new Coche("Toyota", 2023);

        // // Acceder a sus atributos
        // System.out.println("Marca: " + miCoche.marca);
        // System.out.println("Año: " + miCoche.anio);

        // // Llamar a su método
        // miCoche.arrancar();

        // miCoche.setMarca("Ford");
        // miCoche.setAnio(2024);
       
        // System.out.println("Marca: " + miCoche.getMarca());
        // System.out.println("Año: " + miCoche.getAnio());

        // * Herencia
        Coche miCoche = new Coche("Toyota", 2020, 4);
        miCoche.mostrarInfo(); // Método heredado
        miCoche.mostrarCantidadPuertas(); // Método propio

        // * Polimorfismo
        // v1 y v2 declarados como tipo Vehiculo pero instanciados como un objeto de la clase Coche y Motocicleta
        Vehiculo v1 = new Coche("Nissan", 2025, 4);
        Vehiculo v2 = new Motocicleta("Harley", 2025);

        // Aunque ambos son de tipo Vehiculo, se ejecutan con su forma real
        v1.mover();
        v2.mover();

        // * Abstracción
        Vehiculo v3 = new Coche("Jeep", 2020, 4);
        Vehiculo v4 = new Motocicleta("Harley", 2019);

        v3.encender();
        v4.encender();

        CocheElectrico tesla = new CocheElectrico("Tesla", 2024, 2);
        tesla.encender();
        tesla.cargarBateria();

        // * Continuando con el proyecto ...
        Scanner sc = new Scanner(System.in);

        int opcion;
        int totalPrioridad = 0;
        Actividad ultimaTarea = null;

        do{
            mostrarMenu();
            opcion = leerOpcion(sc);
            Resultado resultado = ejecutarOpcion(opcion, sc, totalPrioridad, ultimaTarea);
            totalPrioridad = resultado.totalPrioridad;
            ultimaTarea = resultado.tarea;
        }while(opcion != 3);
    }

    public static void mostrarMenu(){
        System.out.println("*** Gestos de tareas ***\n1. Agregar tarea\n2. Ver última tarea\n3. Salir");
    }

    public static int leerOpcion(Scanner sc){
        System.out.print("Elige una opción: ");

        return sc.nextInt();
    }

    public static Resultado ejecutarOpcion(int opcion, Scanner sc, int totalPrioridad, Actividad tarea){
        sc.nextLine();

        switch(opcion){
            case 1: return agregarTarea(sc, totalPrioridad);
            case 2: if (tarea != null){
                        tarea.ejecutar();
                    }else{
                        System.out.println("Aún no hay tareas registradas");
                    }
                    break;
            case 3: System.out.println("Bye");
                    break;
            default: System.out.println("Opción inválida. Intenta de nuevo");
                    break;
        }

        return new Resultado(totalPrioridad, tarea);
    }

    public static Resultado agregarTarea(Scanner sc, int totalPrioridad){
        System.out.print("Nombre de la tarea: ");
        String nombre = sc.nextLine();

        System.out.print("Prioridad (1 a 5): ");
        int prioridad = sc.nextInt();
        sc.nextLine();

        if(prioridad >= 1 && prioridad <= 5){
            totalPrioridad += prioridad;
            Tarea nueva = new Tarea(nombre, prioridad);
            System.out.println("Tarea agregada");
            System.out.println("Total acumulado de prioridades: " + totalPrioridad);
            return new Resultado(totalPrioridad, nueva);
        }else{
            System.out.println("Prioridad no válida");
            return new Resultado(totalPrioridad, null);
        }
    }

    public static class Resultado{
        int totalPrioridad;
        Actividad tarea;

        public Resultado(int totalPrioridad, Actividad tarea){
            this.totalPrioridad = totalPrioridad;
            this.tarea = tarea;
        }
    }
}