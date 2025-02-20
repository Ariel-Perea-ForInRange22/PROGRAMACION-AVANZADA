package ProyectopasadoaPOO;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void reducirStock(String codigo, int cantidad) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                producto.setCantidad(producto.getCantidad() - cantidad);
                break;
            }
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }
}