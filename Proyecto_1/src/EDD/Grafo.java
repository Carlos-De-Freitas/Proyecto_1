/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

/**
 * Crea grafos dirigidos tomando el txt como referencia
 * @author drali
 * @version 29/10/23
 */
public class Grafo {
    
     private Nodo[] nodos;


    public Grafo(Nodo[] nodos) {
        this.nodos = nodos;

    }
    
    public Grafo (int numNodos){
        nodos = new Nodo[numNodos]; 
        for (int i = 0; i < numNodos; i++ ){
            nodos[i] = null; 
        } 
          
    } 
    
    public void addVertex(int vertex, Object data) {
        if (vertex < 0 || vertex >= nodos.length) {
            throw new IllegalArgumentException("Índice de vértice fuera de rango");
        }
        nodos[vertex] = new Nodo(data);
       
    }
        
        public void addEdge(int srcNode, int endNode) {
            if (srcNode < 0  || srcNode >= nodos.length || endNode < 0 || endNode >= nodos.length) {
                throw new IllegalArgumentException("Nodos fuente o destino fuera de rango");
        }

        Nodo nuevoNodo = new Nodo(endNode);
        nuevoNodo.setpNext(nodos[srcNode]);
        nodos[srcNode] = nuevoNodo;
    }
        
    public void removeVertex(int vertex) {
    if (vertex < 0 || vertex >= nodos.length) {
        throw new IllegalArgumentException("Índice de vértice fuera de rango");
    }

    // Eliminar el vértice (nodo) y todas las aristas que lo involucran
    nodos[vertex] = null;

    // Recorrer todos los otros vértices y eliminar las aristas que apuntan al vértice eliminado
    for (int i = 0; i < nodos.length; i++) {
        if (nodos[i] != null) {
            Nodo nodoActual = nodos[i];
            Nodo nodoAnterior = null;
            while (nodoActual != null) {
                if (nodoActual.getElement() == nodos[vertex].getElement()) {
                    if (nodoAnterior != null) {
                        nodoAnterior.setpNext(nodoActual.getpNext()); 
                    } else {
                        nodos[i] = nodoActual.getpNext();
                    }
                }
                nodoAnterior = nodoActual;
                nodoActual = nodoActual.getpNext();
            }
        }
    }
}

    public void removeEdge(int srcNode, int endNode) {
        if (srcNode < 0  |srcNode >= nodos.length|  endNode < 0 || endNode >= nodos.length) {
            throw new IllegalArgumentException("Nodos fuente o destino fuera de rango");
    }

    // Eliminar la arista entre srcNode y endNode
    if (nodos[srcNode] != null) {
        Nodo nodoActual = nodos[srcNode];
        Nodo nodoAnterior = null;
        while (nodoActual != null) {
            if ((nodoActual.getElement()) == nodos[endNode].getElement()) {
                if (nodoAnterior != null) {
                    nodoAnterior.setpNext(nodoActual.getpNext());
                } else {
                    nodos[srcNode] = nodoActual.getpNext();
                }
                break; // Se encontró y eliminó la arista
            }
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.getpNext();
        }
    }
    }
    
    public int getNumNodos() {
        return nodos.length;
    }

    public Object getNodo(int i) {
        if (i < 0 || i >= nodos.length) {
            throw new IllegalArgumentException("Índice de nodo fuera de rango");
        }
        return nodos[i].getElement();
    }
    
    public Nodo[] getAdyacentes(Object nodo) {
    int contador = 0;
    
    // Contar el número de nodos adyacentes al nodo dado
    for (int i = 0; i < nodos.length; i++) {
        Nodo actual = nodos[i];
        while (actual != null) {
            if (actual.getElement().equals(nodo)) {
                contador++;
            }
            actual = actual.getpNext();
        }
    }

    // Crear un array para almacenar los nodos adyacentes
    Nodo[] adyacentes = new Nodo[contador];
    contador = 0; // Reiniciamos el contador para llenar el array

    // Almacenar los nodos adyacentes en el array
    for (int i = 0; i < nodos.length; i++) {
        Nodo actual = nodos[i];
        while (actual != null) {
            if (actual.getElement().equals(nodo)) {
                adyacentes[contador] = actual;
                contador++;
            }
            actual = actual.getpNext();
        }
    }

    return adyacentes;
}
    
    public void printGraph(Object[] UserNames){ 
        for (int i = 0; i < nodos.length; i++){ 
            Nodo nodoActual = new Nodo(null);
            nodos[i] = nodoActual;
            nodoActual.setElement(UserNames[i]);
                System.out.print("Nodo " + i + ": ");
                while (nodoActual != null) {
                    System.out.print(nodoActual.getElement() + " -> ");
                    nodoActual = nodoActual.getpNext();
            }
            System.out.println("null");
        }
     }
}