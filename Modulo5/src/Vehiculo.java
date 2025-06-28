// * Superclase
// * Las clases abstractas están obligdos a implementar un método abstracto
public abstract class Vehiculo {
    private String marca;
    private int anio;

    public Vehiculo(String marca, int anio){
        this.marca = marca;
        this.anio = anio;
    }

    public void mostrarInfo(){
        System.out.println("Marca: " + marca + ", Año: " + anio);
    }

    // * Sobreescritura de métodos: una clase puede implementar una versión especifica de un método que ya está definido en su superclase, adanptándolo a sus necesidades

    public void mover(){
        System.out.println("El vehículo se mueve");
    }

    // * Método abstracto
    // * No tiene cuerpo, solo define que todos los vehículos deberán implementar su propia forma de encenderse
    public abstract void encender(); 

    public void mostrarTipo(){ // Método normal
        System.out.println("Soy un vehículo");
    }
}
