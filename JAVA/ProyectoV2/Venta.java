package ProyectoV2;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private String idVenta;
    private List<Producto> productos;
    private double total;

    public Venta(String idVenta) {
        this.idVenta = idVenta;
        this.productos = new ArrayList<>();
        this.total = 0;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            this.productos.add(producto);
        }
        calcularTotal();
    }

    private void calcularTotal() {
        this.total = productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public double getTotal() {
        return total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public String getIdVenta() {
        return idVenta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta ID: ").append(idVenta).append("\n");
        for (Producto p : productos) {
            sb.append(p.toString()).append("\n");
        }
        sb.append("Total: ").append(String.format("%.2f", total));
        return sb.toString();
    }
}
