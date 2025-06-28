import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Tarea> listaTareas = new ArrayList<>();
    private static final HashMap<String, Tarea> mapaTareas = new HashMap<>();
    private static int acumuladorPrioridades = 0;    

    public static void main(String[] args) throws Exception {
        /*  
        Arreglos unidimensionales
         * Array: estructura que almacena elementos del mismo tipo en una secuencia contigua de memoria

        Declaración e inicialización:
        Tipo de datos y nombre del array
        int[] numeros;
        int[] numeros = new int[5]; -> Array de 5 enteros
        int[] numeros = {1,2,3,4,5}; -> Array con valores
        */

        int[] numeros = {10, 20, 30};
        String[] palabras = new String[3];
        palabras[0] = "Hola";
        System.out.println(numeros[1]);

        int[] edades = new int[3];
        edades[0] = 25;
        edades[1] = 30;
        edades[2] = 22;
        
        for(int i = 0; i < edades.length; i++){
            System.out.println("Edad " + i + ": " + edades[i]);
        }

        /* 
         * Arreglos multidimensionales: tienen más de una dimensión. 
        
        Declaración y acceso a valores

        int[][] matriz = new int[3][3];
        String[][] nombresApellidos= {{"Ana", "Perez"}. {"Juan", "Gomez"}}

        matriz[0][0] = 1; -> Primera fila, primera columna
        matriz[1][2] = 5; -> Segunda fila, tercera columna
        */

        int[][] calificacion = {
            {8 , 9, 7},
            {6, 10, 9}
        };

        for (int i = 0; i < calificacion.length; i++) {
            System.out.println("Fila " + i + ": " + java.util.Arrays.toString(calificacion[i]));
        }

        for (int i = 0; i < calificacion.length; i++) {
            for (int j = 0; j < calificacion[i].length; j++) {
                System.out.println("Fila " + i + ", columna " + j + ": " + calificacion[i][j]);
            }
        }

        /*
         * ArrayList y List: permite modificar y almacenar dinámicamente una colección de objetos
         * List: contrato (qué puede hacer una lista)
         * ArrayList: herramienta concreta
        
        List<String> nombres = new ArrayList<>();
        List<String> nombres = new LinkedList<>();
         */

        // * Formas de declarar
        List<String> nombres = new ArrayList<>();
        ArrayList<Integer> numeros2 = new ArrayList<>();

        List<String> tareas = new ArrayList<>();
        tareas.add("Estudiar");
        tareas.add("Practicar");
        tareas.add("Descansar");
        
        System.out.println("Primera tarea: " + tareas.get(0));
        System.out.println("¿Está 'Practicar'?: " + tareas.contains("Practicar"));

        tareas.add(1, "Repasar");
        System.out.println(tareas);

        tareas.remove("Practicar");
        System.out.println(tareas);
        System.out.println("Cantidad de tareas: " + tareas.size());

        /*
         * Mapas/Diccionarios: estructuras de datos que almacenan pares clave - valor, donde cada clave es única y se mapea a un valor específico.
         */

        HashMap<String, String> telefonos = new HashMap<>();
        telefonos.put("Mamá", "1122334455");
        telefonos.put("Tatiana", "0099887766");

        System.out.println(telefonos.get("Tatiana"));

        // * Para recorrerlos
        Map<String, Integer> edadesMap = new HashMap<>();
        edadesMap.put("Ana", 25);
        edadesMap.put("Carlos", 30);
        edadesMap.put("Maria", 28);

        for(Map.Entry<String, Integer> entrada : edadesMap.entrySet()){
            System.out.println(entrada.getKey() + ": " + entrada.getValue() + " años");
        }

        /*
         * Operaciones comunes
        
         put(clave, valor) -> añade o actualiza
         get(clave) -> Obtiene valor
         remove(clave) -> Elimina entrada
         constainsKey (clave) -> Verifica existencia
         KeySet() -> Devuelve todos los valores
         entrySet() -> Devuelve pares clave - valor
         */
        
        /* 
         * ForEach: Recorrer colecciones de objetos
        
        Sintaxis basica

        for (Tipo elemento : coleccion){
            Código ...
        }
        */

        String[] frutas = {"Manzana", "Banana", "Naranja"};
        for(String fruta : frutas){
            System.out.println(fruta);
        }

        ArrayList<String> frutasArray = new ArrayList<>();
        frutasArray.add("Fresa");
        frutasArray.add("Mango");
        frutasArray.add("Uva");

        for(String frutaArray : frutasArray){
            System.out.println(frutaArray);
        }

        /*
         * Lambdas simples
        
        Sintaxis:
        (parametros) -> {cuerpo} / (parametros) -> {expresión}
         */
        
        ArrayList<String> lenguajes = new ArrayList<>();
        lenguajes.add("Java");
        lenguajes.add("Python");
        lenguajes.add("Javascript");

        lenguajes.forEach(leng -> System.out.println(leng));

        /* 
         * ¿Cuando usar cada uno?
         * ForEach -> recorrer y operar uno a uno
         * Lambda -> recorrer rápido y elegante con funciones cortitas
         */

        // * COTNINUANDO CON EL PROYECTO
        
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

    private static void mostrarMenu(){
        System.out.print("*** Gestos de tareas ***\n1. Agregar tarea\n2. Listar tareas\n3. Buscar tarea por ID\n4. Eliminar tarea por ID\n5. Ver total acumulado de prioridades\n6. Salir\n-> Elegir una opcion: ");
    }

    private static void agregarTarea(){
        System.out.print("Id de la tarea: ");
        String id = sc.nextLine();

        if(mapaTareas.containsKey(id)){
            System.out.println("Ya existe una tarea con ese ID");
            return;
        }

        System.out.print("Nombre de la tarea: ");
        String nombre = sc.nextLine();

        System.out.print("Prioridad (1 a 5): ");
        int prioridad = Integer.parseInt(sc.nextLine());

        if(prioridad < 1 || prioridad > 5){
            System.out.println("Prioridad no valida");
            return;
        }

        Tarea nueva = new Tarea(nombre, prioridad);
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
        for (Map.Entry<String, Tarea> entrada : mapaTareas.entrySet()){
            System.out.println("ID: " + entrada.getKey());
            entrada.getValue().ejecutar();
        }
    }

    private static void buscarTarea(){
        System.out.print("Ingrese el ID de la tarea a buscar: ");
        String id = sc.nextLine();

        Tarea t = mapaTareas.get(id);

        if(t != null){
            System.out.print("Tarea encontrada: ");
            t.ejecutar();
        }else{
            System.out.println("No se encontró ninguna tarea con ese ID");
        }
    }

    private static void eliminarTarea(){
        System.out.print("Ingrese el ID de la tarea a eliminar: ");
        String id = sc.nextLine();

        Tarea eliminada = mapaTareas.remove(id);
        
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
