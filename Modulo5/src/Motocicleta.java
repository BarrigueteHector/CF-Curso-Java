public class Motocicleta extends Vehiculo{
    public Motocicleta(String marca, int anio){
        super(marca, anio); // Hereda atributos de la superclase
    }
    
    // * Polimorfismo
    @Override
    public void mover(){
        System.out.println("La motocicleta acelera entre el tráfico");
    }   

    // * Metodo abstracto, por ser hija de Vehiculo, la clase está obligada a implementar el método abstracto de la clase padre
    @Override
    public void encender(){
        System.out.println("La motocicleta se enciende con el botón");
    }
}
