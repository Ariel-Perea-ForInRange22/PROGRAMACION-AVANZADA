package ProyectoV2;
import java.util.Objects;

public class Cproducto implements Producto {

    private String id, producto, precio, cantidad;

    public String getId() {
        return this.id;
    }

    public String getProducto() {
        // TODO Auto-generated method stub
        return this.producto;
    }

    
    public String getPrecio() {
        // TODO Auto-generated method stub
        return this.precio;
    }

    
    public String getCantidad() {
        // TODO Auto-generated method stub
        return this.cantidad;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public void setProducto(String producto) {
        this.producto = producto;
    }

    
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Oerride
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        String codigo = String.format("%1$-" + 5 + "s", this.getId());
        String producto = String.format("%1$-" + 38 + "s", this.getProducto());
        String precio = String.format("%1$-" + 10 + "s", this.getPrecio());
        String cantidad = String.format("%1$-" + 10 + "s", this.getCantidad());
        String cadena = codigo.concat(producto + precio + cantidad);
        return cadena;
    }
    public Cproducto(String id, String producto, String precio, String cantidad) {
        super();
        this.id = id;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, producto);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cproducto other = (Cproducto) obj;
        return Objects.equals(id, other.id) && Objects.equals(producto, other.producto);
    }

}

