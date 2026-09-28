import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

/**
 * Cliente del programa.
 *
 * Genera 30 números enteros de dos cifras y los envía
 * uno por uno al servidor mediante un socket.
 */
public class Cliente {

    // Dirección del servidor.
    // Como trabajamos en el mismo computador usamos localhost.
    private static final String HOST = "localhost";

    // Debe ser el mismo puerto utilizado por el servidor.
    private static final int PUERTO = 45679;

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("       CLIENTE - ARBOL BINARIO");
        System.out.println("======================================");

        try {

            // Nos conectamos al servidor
            Socket socket = new Socket(HOST, PUERTO);

            System.out.println("Conectado al servidor.");
            System.out.println();

            // Permite enviar datos al servidor
            PrintWriter salida = new PrintWriter(
                    socket.getOutputStream(),
                    true
            );

            // Objeto para generar números aleatorios
            Random random = new Random();

            System.out.println("Números enviados al servidor:");

            // Generamos y enviamos 30 números
            for (int i = 1; i <= 30; i++) {

                // Genera números entre 10 y 99
                int numero = random.nextInt(90) + 10;

                // Enviamos el número
                salida.println(numero);

                System.out.println(
                        "Dato " + i + ": " + numero
                );
            }

            System.out.println();
            System.out.println("Los 30 números fueron enviados.");

            // Cerramos la comunicación
            salida.close();
            socket.close();

            System.out.println("Cliente finalizado.");

        } catch (IOException e) {

            System.out.println(
                    "Error en el cliente: " + e.getMessage()
            );
        }
    }
}