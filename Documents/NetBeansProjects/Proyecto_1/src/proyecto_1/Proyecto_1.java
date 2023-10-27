/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1;
 
import EDD.Usuarios;
import EDD.Grafo; 
/**
 *
 * @author drali
 */
public class Proyecto_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Usuarios usuario = new Usuarios(); 
        int Numnodos = Integer.parseInt(usuario.DefineNumNodos()); 
        
        Grafo graph = new Grafo(Numnodos); 
        graph.printGraph();
        
    
       




//        ClaseFrame miVentana = new ClaseFrame();
//		miVentana.setVisible(true);
    }
    
}
