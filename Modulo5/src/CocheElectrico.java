// * Hereda de la clase cose e implementa la interfaz Electrico
public class CocheElectrico extends Coche implements Electrico{
    public CocheElectrico(String marca, int anio, int puertas){
        super(marca, anio, puertas); // Hereda atributos de la superclase
    }
    
    @Override
    public void cargarBateria(){
        System.out.println("Cargando bateria del coche");
    }    
}