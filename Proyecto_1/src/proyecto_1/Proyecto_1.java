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
import EDD.GrafoPanel;
import java.awt.*;
import javax.swing.JFrame;
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
        int numNodos = usuario.DefineNumNodos(texto); 
        int numRelaciones = usuario.DefineNumRelaciones(texto); 
        Lista UserNames = usuario.UserNames(texto, NombreUsuarios);
        Object[] nUsers = UserNames.getAllInfo(numNodos, UserNames);
        int [] relacionante = usuario.obtenerUsuariosInicio(texto, numRelaciones, nUsers);
        int [] relacionado = usuario.obtenerUsuariosFinal(texto,numRelaciones, nUsers);
        
        
        Grafo graph = new Grafo(numNodos); 
        for(int i = 0; i < numNodos  ; i++){
            graph.addVertex(i, nUsers[i]);
        }
        
        for (int i = 0; i < numNodos; i++) { 
            graph.addEdge(relacionante[i], relacionado[i]);
            
            
        }
        // Crear una instancia de GrafoPanel
        GrafoPanel grafoPanel = new GrafoPanel(graph);

        // Definir el número de nodos por fila y el espacio entre nodos
        int nodosPorFila = 4;
        int espacioEntreNodos = 100;

        // Definir las coordenadas iniciales para el primer nodo
        int x = 100; // Posición X inicial
        int y = 100; // Posición Y inicial

        // Recorrer todos los nodos y establecer sus coordenadas
        for (int i = 0; i < numNodos; i++) {
            grafoPanel.setNodePosition(nUsers[i], new Point(x, y));

            // Calcular las coordenadas para el siguiente nodo en la misma fila
            x += espacioEntreNodos;

            // Saltar a la siguiente fila después de 'nodosPorFila' nodos
            if (i % nodosPorFila == nodosPorFila - 1) {
                x = 100; // Restablecer X a la posición inicial
                y += espacioEntreNodos; // Moverse a la siguiente fila
            }
        }

        // Crear una instancia de JFrame
        JFrame frame = new JFrame("Visualización de Grafo");

        // Agregar GrafoPanel al JFrame
        frame.add(grafoPanel);

        // Configurar la ventana y hacerla visible
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}