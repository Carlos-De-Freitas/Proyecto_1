/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

/**
 *
 * @author drali
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
    
    public void AddEdge(int SrcNode, int EndNode){
    Nodo nuevoNodo = new Nodo(EndNode); 
    nuevoNodo.getpNext() = nodos[SrcNode]; 
    nodos[SrcNode] = nuevoNodo; 
    
    } 
    
    public void printGraph(){ 
        for (int i = 0; i < nodos.length; i++){      
            Nodo nodoActual = nodos[i];
                System.out.print("Nodo " + i + ": ");
                while (nodoActual != null) {
                    System.out.print(nodoActual.getElement() + " -> ");
                    nodoActual = nodoActual.getpNext();
            }
            System.out.println("null");
        }
    
    }
}

            
            
        
                
    
    
    

