/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;

/**
 * Permite la adquisición del grafo dirigido para representarlo visualmente mediante las librerías Swing
 * @author Daniel
 * @version: 29/10/23
 */
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

public class GrafoPanel extends JPanel {
    private Grafo grafo;
    private Map<Object, Point> nodePositions;

    public GrafoPanel(Grafo grafo) {
        this.grafo = grafo;
        this.nodePositions = new HashMap<>();
    }

    @Override
    
    /**
    * Dibuja las aristas y nodos del grafo dirigido
    * @author Daniel
    * @version: 29/10/23
    */
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja las aristas del grafo
        for (int i = 0; i < grafo.getNumNodos(); i++) {
            Object nodo = grafo.getNodo(i);
            Point nodoPosition = nodePositions.get(nodo);

            if (nodoPosition != null) {
                for (Nodo adyacente : grafo.getAdyacentes(nodo)) {
                    Point adyacentePosition = nodePositions.get(adyacente.getElement());
                    if (adyacentePosition != null) {
                        g.drawLine(nodoPosition.x, nodoPosition.y, adyacentePosition.x, adyacentePosition.y);
                    }
                }
            }
        }

        // Dibuja los nodos del grafo
        for (int i = 0; i < grafo.getNumNodos(); i++) {
            Object nodo = grafo.getNodo(i);
            Point position = nodePositions.get(nodo);

            if (position != null) {
                int radio = 20;
                g.setColor(Color.BLUE);
                g.fillOval(position.x - radio, position.y - radio, 2 * radio, 2 * radio);
                g.setColor(Color.BLACK);
                g.drawString(nodo.toString(), position.x - 10, position.y - radio - 5);
            }
        }
    }
    /**
    * Establece la posición de los nodos
    * @author Daniel
    * @version: 29/10/23
    */
    public void setNodePosition(Object nodo, Point position) {
        nodePositions.put(nodo, position);
    }
}