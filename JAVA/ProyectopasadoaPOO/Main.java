package ProyectopasadoaPOO;

import ProyectopasadoaPOO.*;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        ProductoService productoService = new ProductoService(inventario);
        VentaService ventaService = new VentaService(inventario);

        MenuPrincipal menuPrincipal = new MenuPrincipal(productoService, ventaService);
        menuPrincipal.mostrarMenu();
    }
}