package ProyectoV2;

import java.util.ArrayList;
import java.util.List;

public class Lista<T> {
    private List<T> lista;

    public Lista() {
        lista = new ArrayList<>();
    }

    public void insertar(T elemento) {
        lista.add(elemento);
    }

    public void eliminar(T elemento) {
        lista.remove(elemento);
    }

    public boolean existe(T elemento) {
        return lista.contains(elemento);
    }

    public String listado() {
        StringBuilder sb = new StringBuilder();
        for (T elemento : lista) {
            sb.append(elemento.toString()).append("\n");
        }
        return sb.toString();
    }

    public String MostrarLista() {
        return listado();
    }
}