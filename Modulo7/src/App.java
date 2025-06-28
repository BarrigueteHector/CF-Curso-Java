import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Tarea> listaTareas = new ArrayList<>();
    private static final HashMap<String, Tarea> mapaTareas = new HashMap<>();
    private static int acumuladorPrioridades = 0;    

    public static void main(String[] args) throws Exception {
        /* 
        * var: declarar variables locales sin especificar su tipo. Solo se puede usar cuando se inicializa la variable y no es dinámico
        
        Antes:
        Map<String, List<Integer>> mapaComplejo = new HashMap<>();
        
        Ahora:
        var mapaComplejo = new HashMap<String, List<Integer>>();

        * Records: clases que se usan para almacenar valores y agruparlos en un único identificador, solo necesitamoos especificar qué atributos nos interesa que tenga un registro. Equivale a una clase con campos private final, constructor, getters, equals, hasCode, toString y sin setters

        Limitaciones: inmutable (sin setters), no se hereda
        ¿Por qué usarlos?: menos código, seguro y legible
        
        Sintaxis
        public record NombreRecord(Tipo campo1, Tipo campo2){
            Métodos adicionales (opcional)
        }
        */

        // Ejemplo records
        Cuenta admin = new Cuenta("admin", "root", true);
        System.out.println(admin.nombre()); // admin
        System.out.println(admin.toString()); // Cuenta[nombre=admin, clave=root, privilediada=true]
        
        /*
         * Pattern Matching: permite verificar si un objeto es de un tipo específico, de serlo extrae los componentes de ese objeto directamente en una variable

        if (obj instanceof String s){
            System.out.println(s.length())
        }
        1. Verifica que obj sea un String
        2. Declara una nueva variable s de tipo String
        3. Le asigna automáticamente el valor de obj
        4. El alcance de s está dentro del if

        * Lambdas y programación funcional básica:  son una forma más concisa y declarativa de escribir código. No mutabilidad, las funciones puras y el uso de funciones de orden superior

        Las lambdas sn funcionales anónimas, osea funciones sin nombre que pueden ser definidas en línea
        */

        // Ejemplo
        Function<String, Integer> longitud = s -> s.length();
        //      <Recibe, Devuelve>           Función lambda

        System.out.println(longitud.apply("Java")); // 4

        /* 
        API Stream: herramienta que permite trabajar con colecciones de datos (listas, arrays, etc.) de una manera más fácil y eficiente, especialmente para operaciones como filtrar, transformar o procesar elementos

        Flujo de datos (Stream): secuencia de elemetnos que se procesan en pipeline (cadena de operaciones) que no almacena datos, solo los procesa

        Ejecución diferita (Lazy): las operaciones solo se ejecutan cuando es necesario

        Operaciones: filter, map, count, forEach

        La programación funcional se enfoca en qué resolver y no en cómo
        */

        // Ejemplo
        List<String> palabras = Arrays.asList("Java", "Ambiente", "Programación", "API", "Música", "Angular");
        palabras.stream() // 1. Convertir la lista a Stream
                .filter(p -> p.startsWith("A")) // 2. Filtrar palabras que empiezan con A
                .map(String :: toUpperCase) // 3. Convertir a mayúsculas
                .forEach (System.out :: println); // 4. Imprimir resultados
        
        /* 
         * try-with-resources
        
        try (RecursoAutoCloseable recurso = new RecursoAutoCloseable()){
            Uso del recurso
        } El recurso se cierra automáticamente
        */

        try(FileInputStream archivo = new FileInputStream("./archivo.txt")){
            System.out.println("Archivo leído correctamente");
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        /*
         * Manejo moderno de errores
        
        Multi-catch: capturar múltiples excepciones en un mismo bloque

        try{
            código
        }catch (IOException | SQLException e){
            System.out.println("Error genérico: " + e.getMessage())
        }

        IOException -> fallo al leer o escribir datos
        SQLException -> fallo al interactuar con una base de datos
         
        Ahora hay excepciones más especifidas (mensajes más claros)
        String texto = null;
        int longitud = texto.length(); // !NullPointerException
        */

        // * CONTINUANDO CON EL PROYECTO
        int opcion;
        
        do{
            mostrarMenu();
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> agregarTarea();
                case 2 -> listarTareas();
                case 3 -> buscarTarea();
                case 4 -> eliminarTarea();
                case 5 ->  mostrarAcumulador();
                case 6 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        }while(opcion != 6);
    }

    // Ejemplo
    public record Cuenta(String nombre, String clave, boolean privilegiada){}

    private static void mostrarMenu(){
        System.out.print("*** Gestos de tareas ***\n1. Agregar tarea\n2. Listar tareas\n3. Buscar tarea por ID\n4. Eliminar tarea por ID\n5. Ver total acumulado de prioridades\n6. Salir\n-> Elegir una opcion: ");
    }

    private static void agregarTarea(){
        System.out.print("Id de la tarea: ");
        var id = sc.nextLine();

        if(mapaTareas.containsKey(id)){
            System.out.println("Ya existe una tarea con ese ID");
            return;
        }

        System.out.print("Nombre de la tarea: ");
        var nombre = sc.nextLine();

        System.out.print("Prioridad (1 a 5): ");
        var prioridad = Integer.parseInt(sc.nextLine());

        if(prioridad < 1 || prioridad > 5){
            System.out.println("Prioridad no valida");
            return;
        }

        var nueva = new Tarea(nombre, prioridad);
        listaTareas.add(nueva);
        mapaTareas.put(id, nueva);
        acumuladorPrioridades += prioridad;

        System.out.println("Tarea agregada con éxito\nTotal acumulado de prioriades: " + acumuladorPrioridades);
    }

    private static void listarTareas(){
        if(mapaTareas.isEmpty()){
            System.out.println("No hay tareas para mostrar");
            return;
        }

        System.out.println("--- Tareas registradas ---");
        
        // lambda foreach 
        mapaTareas.forEach((id, tarea) -> {
            System.out.print("ID: " + id + " - ");
            tarea.ejecutar();
        });
    }

    private static void buscarTarea(){
        System.out.print("Ingrese el ID de la tarea a buscar: ");
        var id = sc.nextLine();

        var t = mapaTareas.get(id);

        if(t != null){
            System.out.print("Tarea encontrada: ");
            t.ejecutar();
        }else{
            System.out.println("No se encontró ninguna tarea con ese ID");
        }
    }

    private static void eliminarTarea(){
        System.out.print("Ingrese el ID de la tarea a eliminar: ");
        var id = sc.nextLine();

        var eliminada = mapaTareas.remove(id);
        
        if(eliminada != null){
            listaTareas.remove(eliminada);
            acumuladorPrioridades -= eliminada.getPrioridad();
            System.out.println("Tarea eliminada correctamente\nTotal acumulado actualizado: " + acumuladorPrioridades);
        }else{
            System.out.println("No se encontró ninguna tarea con ese ID");
        }
    }

    private static void mostrarAcumulador(){
        System.out.println("Acumulador de prioridades: " + acumuladorPrioridades);
    }
}
