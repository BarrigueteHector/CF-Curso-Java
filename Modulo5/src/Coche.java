// * Subclase
public class Coche extends Vehiculo{
    private int puertas;

    public Coche(String marca, int anio, int puertas){
        super(marca, anio); // Hereda atributos de la superclase
        this.puertas = puertas;
    }

    public void mostrarCantidadPuertas(){
        System.out.println("Puertas: " + puertas);
    }

    // * Polimorfismo
    @Override
    public void mover(){
        System.out.println("El coche avanza por la carretera");
    }

    // * Metodo abstracto, por ser hija de Vehiculo, la clase está obligada a implementar el método abstracto de la clase padres
    @Override
    public void encender(){
        System.out.println("El coche se enciende con la llave");
    }

    // String marca;
    // int anio;

    // // Constructor
    // // * Por ser publico se peude usar en cualquier archivo
    // public Coche(String marca, int anio){
    //     this.marca = marca;
    //     this.anio = anio;
    // }

    // void arrancar(){
    //     System.out.println("El coche arranca");
    // }

    // /*
    //  * Getters y setters: se utilizan para proteger sus datos.
    //  * Getter: devuelve su valor
    //  * Setter: lo establece o actualiza
    //  */

    // public String getMarca(){
    //     return marca;
    // }
    
    // public int getAnio(){
    //     return anio;
    // }

    // public void setMarca(String marca){
    //     this.marca = marca;
    // }
    
    // public void setAnio(int anio){
    //     this.anio = anio;
    // }
}