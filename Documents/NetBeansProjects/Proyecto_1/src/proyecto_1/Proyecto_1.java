/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1;
 
import EDD.Usuarios;
import EDD.Grafo; 
import EDD.Lista; 
/**
 *
 * @author drali
 */
public class Proyecto_1 {

    /**
     * @param args the comman line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Usuarios usuario = new Usuarios(); 
        Lista NombreUsuarios = new Lista();
        
        String texto = usuario.OpenTxt();
        int Numnodos = Integer.parseInt(usuario.DefineNumNodos(texto)); 
        Lista UserNames = usuario.UserNames(texto, NombreUsuarios);
        Object[] NUsers = UserNames.getAllInfo(Numnodos, UserNames);
        
        Grafo graph = new Grafo(Numnodos); 
        graph.printGraph(NUsers);
        
    
       




//        ClaseFrame miVentana = new ClaseFrame();
//		miVentana.setVisible(true);
    }
    
}
