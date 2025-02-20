package ProyectopasadoaPOO;
public class Producto extends ItemVenta implements ImpuestoAplicable {
    private int cantidad;

    public Producto(String codigo, String nombre, double precio, int cantidad) {
        super(codigo, nombre, precio);
        this.cantidad = cantidad;
    }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    @Override
    public double calcularIVA(double precio) {
        return precio * 0.16; 
    }

    @Override
    public double calcularIEPS(double precio) {
        return precio * 0.08;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cantidad: " + cantidad;
    }
}
//quitar el iva, dejar el producto sol para calcular sin el IVA
//solo servirá para inicializar productos