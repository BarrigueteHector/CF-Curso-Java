import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Operador ternario
        // condicion ? valorSiVerdadero : valorSiFalso
        int edad = 20;
        String estado = (edad >= 18 ) ? "Adulto" : "Menor";
        System.out.println(estado);

        // Switch case
        int dia = 3;
        switch (dia) {
            case 1: System.out.println("Lunes");
                    break;
            case 2: System.out.println("Martes");
                    break;
            case 3: System.out.println("Miércoles");
                    break;
            default: System.out.println("Día invalido");
                    break;
        }

        // Ciclos
        // for (inicialización; condición; actualización)
        for (int i = 1; i <= 5; i++){
            System.out.println("Iteración: " + i);
        }

        /* while(condicion){
            código a repetir
        }*/
        int contador = 1;
        while (contador <= 5){
            System.out.println("Contador: " + contador);
            contador++;
        }

        /*
        do {
            código a repetir
        } while(condición); 
        */

        int numero;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Ingresa un número positivo: ");
            numero = scanner.nextInt();
        } while (numero <= 0);
        
        // Control de ciclos: break y continue
        for (int i = 0; i < 10; i++){
            if (i == 5) break;
            System.out.println(i);
        }

        for (int i = 0; i < 5; i++){
            if (i == 2) continue; // Salta, pero no se sale del for
            System.out.println(i);
        }

        // CONTINUACION DEL PROYECTO
        int opcion;
        int totalPrioridad = 0;

        do {
            System.out.println("*** Gestos de tareas ***\n1. Agregar tarea\n2. Ver tareas (PENDIENTE)\n3. Salir\n-> Selecciona una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: System.out.println("Nombre de la tarea: ");
                        String nombre = scanner.nextLine();

                        System.out.println("Prioridad (1 a 5): ");
                        int prioridad = scanner.nextInt();

                        if (prioridad >= 1 && prioridad <= 5){
                            totalPrioridad += prioridad;
                            System.out.println("Tarea '" + nombre + "' con prioridad" + prioridad + "agregada");
                            System.out.println("Total acumulado de prioridades: " + totalPrioridad);
                        }else{
                            System.out.println("Prioridad no valida");
                        }
                        break;
                case 2: System.out.println("Funcionalidad aún no implementada");
                        break;
                case 3: System.out.println("Hasta luego");
                        break;
                default: System.out.println("Opción inválida. Intenta de nuevo");
                    break;
            }
        } while (opcion != 3);

        scanner.close();
    }
}