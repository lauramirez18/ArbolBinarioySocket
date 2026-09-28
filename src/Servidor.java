import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Servidor del programa.
 *
 * El servidor recibe 30 números enviados por el cliente
 * mediante un socket y los inserta uno a uno en un
 * árbol binario de búsqueda.
 */
public class Servidor {

    // Puerto utilizado para la comunicación
    private static final int PUERTO = 45679;

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("       SERVIDOR - ARBOL BINARIO");
        System.out.println("======================================");

        try {

            // Creamos el servidor y lo ponemos a escuchar
            ServerSocket servidor = new ServerSocket(PUERTO);

            System.out.println("Servidor iniciado.");
            System.out.println("Esperando conexión del cliente...");
            System.out.println();

            // Esperamos la conexión del cliente
            Socket socket = servidor.accept();

            System.out.println("Cliente conectado.");
            System.out.println();

            // Permite recibir información del cliente
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            // Creamos el árbol vacío
            ArbolBinario arbol = new ArbolBinario();

            // Recibiremos exactamente 30 números
            for (int i = 1; i <= 30; i++) {

                // Recibimos un número como texto
                String mensaje = entrada.readLine();

                // Convertimos el texto a entero
                int numero = Integer.parseInt(mensaje);

                // Insertamos el número en el árbol
                arbol.insertar(numero);

                System.out.println(
                        "Dato " + i + " recibido: " + numero
                );
            }

            System.out.println();
            System.out.println("======================================");
            System.out.println("     LOS 30 DATOS FUERON RECIBIDOS");
            System.out.println("======================================");

            System.out.println();
            System.out.println("Recorrido In-Orden del árbol:");

            // Mostramos el árbol en orden
            arbol.inOrden();

            // Cerramos la comunicación
            entrada.close();
            socket.close();
            servidor.close();

            System.out.println();
            System.out.println("Servidor finalizado.");

        } catch (IOException e) {

            System.out.println(
                    "Error en el servidor: " + e.getMessage()
            );
        }
    }
}