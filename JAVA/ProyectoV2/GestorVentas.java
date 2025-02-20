package ProyectoV2;

import java.util.ArrayList;
import java.util.List;

public class GestorVentas {
    private List<Venta> ventas;

    public GestorVentas() {
        this.ventas = new ArrayList<>();
    }

    public void agregarVenta(Venta venta) {
        ventas.add(venta);
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public String mostrarListaVentas() {
        StringBuilder sb = new StringBuilder();
        for (Venta v : ventas) {
            sb.append(v.toString()).append("\n");
        }
        return sb.toString();
    }
}