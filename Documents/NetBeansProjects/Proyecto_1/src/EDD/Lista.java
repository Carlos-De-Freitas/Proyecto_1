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
public class Lista {
    
    private Nodo pFirst; 
    private Nodo pLast; 
    private int size; 

    public Lista() {
        this.pFirst = null; 
        this.pLast = null; 
        this.size = 0; 
    }
    
    //reconoce si la lista es vacia 
    public boolean IsEmpty() {
        return getFirst() == null; 
    }
    
    public void Empty() {
        this.setFirst(null); 
        this.setLast(null); 
        this.setSize(0); 
    }
    
    public void Addtothefinal(Object data) { 
        Nodo nuevo = new Nodo(data);  
        if (IsEmpty()){
            pFirst = nuevo; 
        }else{
            Nodo aux = pLast; 
            aux.setpNext(nuevo);
            pLast = nuevo;  
        }size +=1; 
    }
    
    
    public void PrintList(){
        if (!IsEmpty()) { 
            Nodo aux = pFirst; 
            for (int i = 0; i < size; i++){ 
                System.out.println(aux.getElement() + " ");
                aux = aux.getpNext(); 
            }
        }else{ 
            System.out.println("La lista esta vacia");
        }
            
    }
    
    public void DeleteFirst() { 
        if (!IsEmpty()){ 
            pFirst = pFirst.getpNext(); 
            size = size - 1; 
        }
        
    }
    /**
     * @return the first
     */
    public Nodo getFirst() {
        return pFirst;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(Nodo first) {
        this.pFirst = first;
    }

    /**
     * @return the last
     */
    public Nodo getLast() {
        return pLast;
    }

    /**
     * @param last the last to set
     */
    public void setLast(Nodo last) {
        this.pLast = last;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
    
    
}
