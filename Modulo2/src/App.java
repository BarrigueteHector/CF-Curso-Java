import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // ----- CLASE #1 -----
        
        /*
        Tipos de datos primitivos: váriables que representan valores simples valores lógicos, nímeros enteros, caracteres y decimales), no tienen metodos (no son objetos), son inmutables, tamaño fijo y almacenamiento directos
        Byte. short, int, long, float, double, char, boolean

        Tipos de datos no primitivos: son objetos o tipos de referencia, no almacenan valores directamente, pueden tener métodos, comienzan con mayúscula y clases personalizadas
        String, array, clases personalizadas
        */

        // ----- CLASE #3 -----
        // Conversión entre datos primitivos
        double z = 10.5;
        int n = (int) z; // n = 10
        System.out.println("n: " + n);

        // Casos comunes de casting
        // Upcasting (automático): un objeto de una subclase pasa a una super clase
        // Downcasting (explícito): un objeto de una superclase pasa a una subclase

        // Conversión entre string y tipos numéricos
        String edadTexto = "25";
        int edad = Integer.parseInt(edadTexto);
        System.out.println("Edad: " + edad);

        int numero = 123;
        String texto = String.valueOf(numero);
        System.out.println("Texto: " + texto);

        // ----- CLASE 4 -----
        // Entrada de datos
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa tu nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Nombre: " + nombre);

        // sc.close();

        // Lectura de diferentes tipos de datos
        // nextLine (linea completa), next (una sola palabra), nextInt (entero), nextDouble (decimal)

        // ----- CLASE 5 -----
        /* usar nombres descriptivos
         evitar comentarios innecesarios que repitan lo que el código ya menciona
        Identar correctamente */

        // ----- CLASE 6 -----
        // Scanner sc2 = new Scanner(System.in);
        int totalPrioridad = 0;

        System.out.println("*** Gestos de tareas ***\n1. Agregar tarea\n2. Ver tareas (PENDIENTE)\n3. Salir\n-> Selecciona una opción: ");

        int opcion = sc.nextInt();
        sc.nextLine(); //Limpiar

        if (opcion >= 1 && opcion <= 3){
            if (opcion == 1){
                System.out.println("Nombre de la tarea: ");
                String nombreTarea = sc.nextLine();
                System.out.println("Prioridad (1 a 5): ");
                int prioridad = sc.nextInt();

                // Validación básica con operador lógico
                boolean esValida = prioridad >= 1 && prioridad <= 5;
                System.out.println("¿Prioridad válida?: " + esValida);

                // Operación aritmética: suma de prioridades
                totalPrioridad += prioridad;

                System.out.println("Tarea agregada: " + nombreTarea + " (prioridad " + prioridad + ")\nSuma total de prioridades: " + totalPrioridad);
            }else if(opcion == 2){
                System.out.println("Función 'ver tareas' aún no implementada");
            }else{
                System.out.println("Hasta luego");
            }
        }else{
            System.out.println("Opción inválida");
        }

        sc.close();
    }
}