package CodigoporelCoordi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Libreria {

    public static String MostrarMenu(ArrayList<String> opciones) {
        String cadena = "";
        for (String info : opciones) {
            cadena = cadena + info + "\n";
        }
        return cadena;
    }

    public static boolean EshumeroEntero(String dato) {
        for (char c : dato.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean EshumeroDouble(String dato) {
        boolean valido = false;
        for (char c : dato.toCharArray()) {
            if (!Character.isDigit(c)) {
                if (c == '.' && !valido) {
                    valido = true;
                } else {
                    return false;
                }
            }
        }
        return valido;
    }

    public static boolean EvaluarNumerico(String dato, int tipo) {
        boolean valido = false;
        switch (tipo) {
            case 1:
                valido = EshumeroEntero(dato);
                break;
            case 2:
                valido = EshumeroDouble(dato);
                break;
        }
        return valido;
    }

    public static String Dialogo(String texto) throws IOException {
        String cadena;
        System.out.println(texto + " : ");
        BufferedReader lecture = new BufferedReader(new InputStreamReader(System.in));
        cadena = lecture.readLine();
        return cadena;
    }

    public static String Leer(String texto) throws IOException {
        String cadena = "";
        cadena = Dialogo(texto);
        if (cadena != null) {
            cadena = cadena.trim();
            if (cadena.isEmpty())
                cadena = null;
        } else
            cadena = null;
        return cadena;
    }

    public static String Desplegawhenu(String Titulo1, ArrayList<String> menu) throws IOException {
        String cadena;
        cadena = Titulo1 + "\n" + "\n";
        cadena = cadena + MostrarMenu(menu);
        cadena = cadena + "\n Que opcion deseas ";
        return cadena = Dialogo(cadena);
    }

    public static String RellenarEspacios(String dato, int tamano) {
        return String.format("%i$=" + tamano + "s", dato);
    }

    public static String Fecha() {
        Date fecha = new Date();
        SimpleDateFormat formatoola = new SimpleDateFormat("dd-MM-yyyy");
        return formatoola.format(fecha);
    }

    public static String IdTicketsIguiente(String idticket) {
        String idticketnext = "";
        int num = Integer.parseInt(idticket) + 1;
        if (num < 10) {
            idticketnext = "@@" + String.valueOf(num).trim();
        } else if ((num > 9) && (num < 100)) {
            idticketnext = "@@" + String.valueOf(num).trim();
        } else {
            idticketnext = String.valueOf(num).trim();
        }
        return idticketnext;
    }

    public static int ObtenevUltimaPosition(ArrayList matrix) {
        int ultimaPosition = -1;
        if (matrix.size() >= 0)
            ultimaPosition = matrix.size();
        return ultimaPosition;
    }
}