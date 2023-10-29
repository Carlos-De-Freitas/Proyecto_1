/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1;
 
import EDD.Usuarios;
import EDD.Grafo; 
import EDD.Lista;
import ventana.ClaseFrame;
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

        
        
        String texto = usuario.openTxt();
        int numNodos = usuario.defineNumNodos(texto); 
        int numRelaciones = usuario.defineNumRelaciones(texto); 
        Lista UserNames = usuario.userNames(texto, NombreUsuarios);
        Object[] nUsers = UserNames.getAllInfo(numNodos, UserNames);
//        int [] relacionante = usuario.obtenerUsuariosInicio(texto, numRelaciones, nUsers);
//        int [] relacionado = usuario.obtenerUsuariosFinal(texto,numRelaciones, nUsers);
        
        
        Grafo graph = new Grafo(numNodos);
        
        
//        for(int i = 0; i < numNodos  ; i++){
//            graph.addVertex(i, nUsers[i]);
//        }
        
//        for (int i = 0; i < numNodos; i++) { 
//            graph.addEdge(relacionante[i], relacionado[i]);
        
        graph.printGraph(nUsers);
    }
    
    }

