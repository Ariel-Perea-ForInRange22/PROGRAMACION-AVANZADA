package ProyectoV2;

import java.util.ArrayList;
import java.util.List;

public class GestorProductos {
    private List<Producto> productos;

    public GestorProductos() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void modificarPrecio(String id, double nuevoPrecio) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null) {
            producto.setPrecio(nuevoPrecio);
        }
    }

    public Producto buscarProductoPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public String mostrarListaProductos() {
        StringBuilder sb = new StringBuilder();
        for (Producto p : productos) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}