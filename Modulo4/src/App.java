import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Métodos y estructuras básicas

        /*
         * Método
         * modificador tipoRetorno nombreMétodo(parámetros){
         *  cuerpo del método
         *  return valor;
         * }
         * 
         * modifivador: public, private, protected
         */

        saludarPersona("Héctor");

        int resultado = sumer(5, 3);
        System.out.println(resultado);

        saludar();

        validarEdad(18);

        // Continuando con el proyecto ...
        Scanner sc = new Scanner(System.in);

        int opcion;
        int totalPrioridad = 0;

        do{
            mostrarMenu();
            opcion = leerOpcion(sc);
            totalPrioridad = ejecutarOpcion(opcion, sc, totalPrioridad);
        } while (opcion != 3);

        sc.close();
    }

    // Métodos con parámetros
    public static void saludarPersona(String nombre){
        System.out.println("Hola " + nombre);
    }

    // Métodos con retorno
    public static int sumer (int a, int b){
        return a + b;
    }

    // Métodos sin retorno
    public static void saludar(){
        System.out.println("Hola desde un método");
    }

    public static void validarEdad(int edad){
        if (edad < 0){
            System.out.println("Edad invalida");
            return; //sale del método
        }

        System.out.println("Edad valida");
    }

    // Overloading: se pueden definir varios métodos con el mismo nombre, siempre y cuando tengan diferentes parámetros. Estos métodos comparten el mismo nombre, la diferencia radica en los tipos, número o el orden de los parámetros
    public static int sumar(int a, int b){
        return a + b;
    }

    public static double sumar (double a, double b){
        return a + b;
    }

    public static int sumar (int a, int b, int c){
        return a + b + c;
    }

    /*
    Sería inscorrecto si fuera ...
    public static int restar(int a, int b) 
    public static double restar (int a, int b) 
    */

    public static void mostrarMenu(){
        System.out.println("*** Gestos de tareas ***\n1. Agregar tarea\n2. Ver tareas (PENDIENTE)\n3. Salir");
    }

    public static int leerOpcion(Scanner sc){
        System.out.print("Elige una opción: ");

        return sc.nextInt();
    }

    public static int ejecutarOpcion(int opcion, Scanner sc, int totalPrioridad){
        sc.nextLine();

        switch(opcion){
            case 1: totalPrioridad = agregarTarea(sc, totalPrioridad);
                    break;
            case 2: System.out.println("Funcionalidad en desarrollo ...");
                    break;
            case 3: System.out.println("Bye");
                    break;
            default: System.out.println("Opción inválida. Intenta de nuevo");
                    break;
        }

        return totalPrioridad;
    }

    public static int agregarTarea(Scanner sc, int totalPrioridad){
        System.out.print("Nombre de la tarea: ");
        String nombre = sc.nextLine();

        System.out.print("Prioridad (1 a 5): ");
        int prioridad = sc.nextInt();
        sc.nextLine();

        if(prioridad >= 1 && prioridad <= 5){
            totalPrioridad += prioridad;
            System.out.println("Tarea '" + nombre +  "' agregada con prioridad " + prioridad);
            System.out.println("Total acumulado de prioridades: " + totalPrioridad);
        }else{
            System.out.println("Prioridad no válida");
        }

        return totalPrioridad;
    }
}