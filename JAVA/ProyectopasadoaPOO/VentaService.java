package ProyectopasadoaPOO;

import java.text.SimpleDateFormat;
import java.util.*;

public class VentaService {
    private Inventario inventario;
    private List<Venta> ventas;

    public VentaService(Inventario inventario) {
        this.inventario = inventario;
        this.ventas = new ArrayList<>();
    }

    public void realizarVenta(List<Producto> productosVendidos) {
        for (Producto producto : productosVendidos) {
            inventario.reducirStock(producto.getCodigo(), 1); 
        }

        String fechaActual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());

        Venta venta = new Venta(generarIdTicket(), fechaActual, productosVendidos);
        ventas.add(venta);
    }

    public List<Venta> obtenerVentas() {
        return ventas;
    }

    private String generarIdTicket() {
        return "TICKET-" + (ventas.size() + 1);
    }
}