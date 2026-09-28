/**
 * Representa un nodo del árbol binario de búsqueda.
 *
 * Cada nodo almacena:
 * - Un valor entero.
 * - Una referencia al hijo izquierdo.
 * - Una referencia al hijo derecho.
 */
public class Nodo {

    // Valor almacenado en el nodo
    int valor;

    // Referencia al hijo izquierdo
    Nodo izquierdo;

    // Referencia al hijo derecho
    Nodo derecho;

    /**
     * Constructor del nodo.
     *
     * @param valor valor que almacenará el nodo
     */
    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}