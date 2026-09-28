/**
 * Representa un árbol binario de búsqueda.
 *
 * El árbol organiza los valores de la siguiente manera:
 * - Los valores menores van a la izquierda.
 * - Los valores mayores van a la derecha.
 */
public class ArbolBinario {

    // Referencia al primer nodo del árbol
    private Nodo raiz;

    /**
     * Constructor del árbol.
     *
     * Inicialmente el árbol está vacío.
     */
    public ArbolBinario() {
        raiz = null;
    }

    /**
     * Inserta un nuevo valor en el árbol.
     *
     * @param valor valor que se desea insertar
     */
    public void insertar(int valor) {

        // Creamos el nuevo nodo
        Nodo nuevo = new Nodo(valor);

        // Si el árbol está vacío,
        // el nuevo nodo se convierte en la raíz.
        if (raiz == null) {
            raiz = nuevo;
            return;
        }

        // Comenzamos a recorrer desde la raíz
        Nodo actual = raiz;

        while (true) {

            // Si el valor es menor, vamos a la izquierda
            if (valor < actual.valor) {

                // Si no existe hijo izquierdo,
                // colocamos allí el nuevo nodo.
                if (actual.izquierdo == null) {
                    actual.izquierdo = nuevo;
                    return;
                }

                // Si ya existe, continuamos recorriendo
                actual = actual.izquierdo;

            } else {

                // Si el valor es mayor o igual,
                // vamos hacia la derecha.
                if (actual.derecho == null) {
                    actual.derecho = nuevo;
                    return;
                }

                // Si ya existe, continuamos recorriendo
                actual = actual.derecho;
            }
        }
    }

    /**
     * Devuelve la raíz del árbol.
     *
     * @return nodo raíz
     */
    public Nodo getRaiz() {
        return raiz;
    }

    /**
     * Realiza un recorrido In-Orden del árbol.
     *
     * El recorrido sigue:
     * izquierda → raíz → derecha
     */
    public void inOrden() {
        inOrdenRecursivo(raiz);
        System.out.println();
    }

    /**
     * Método auxiliar para realizar el recorrido In-Orden.
     *
     * @param nodo nodo actual
     */
    private void inOrdenRecursivo(Nodo nodo) {

        if (nodo != null) {

            // Primero recorremos el lado izquierdo
            inOrdenRecursivo(nodo.izquierdo);

            // Luego mostramos el nodo
            System.out.print(nodo.valor + " ");

            // Finalmente recorremos el lado derecho
            inOrdenRecursivo(nodo.derecho);
        }
    }
}
