/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;
import ventana.ClaseFrame; 
/**
 * Permite la adquisición del contenido en el TxT, así como el número de nodos y relaciones que se formarán. Además, provee la lista de usuarios 
 * utilizada para la creación del ArrayList de nodos y las coordenadas de las relaciones.  
 * @author Carlos De Freitas
 * @version 29/10/2023
 */
public class Usuarios {
    /** 
     * Retorna el contenido del TXT
     * @author Carlos De Freitas
     * @return texto
     * @version 29/10/2023
     */
    public String openTxt(){
        ClaseFrame info =  new ClaseFrame();
       
       String texto = info.abrirArchivo();
       
       return texto;
    }
    /**
     * Retorna el número de nodos necesario para el ArrayList 
     * @author Carlos De Freitas
     * @param texto
     * @return contadorUsuarios
     */
    
    public int defineNumNodos(String texto){
       
       String[] lineas = texto.split("\n");
        int contadorUsuarios = 0;
        boolean enUsuarios = false;

        for (String linea : lineas) {
            if (linea.equals("usuarios")) {
                enUsuarios = true;
                continue;
            }
            else if (enUsuarios && linea.startsWith("@")) {
                contadorUsuarios++;
            } else if (linea.equals("relaciones")) {
                enUsuarios = false;
            }
        }
        return contadorUsuarios;
    } 
    
    /**
     * Retorna el número de relaciones que existen en el TxT
     * @author Carlos De Freitas
     * @param texto
     * @return contadorRelaciones
     */
    
    public int defineNumRelaciones(String texto){
       
       String[] lineas = texto.split("\n");
        int contadorRelaciones = 0;
        boolean enRelaciones = false;

        for (String linea : lineas) {
            if (linea.equals("relaciones")) {
                enRelaciones = true;
                continue;
            }
            else if (enRelaciones && linea.startsWith("@")) {
                contadorRelaciones++;
            }
        }
        return contadorRelaciones;
    } 
   
    /**
     * Retorna una lista de nodos enlazada con value de nombres
     * @param texto
     * @param NombreUsuarios
     * @return NombreUsuarios
     */
    
    public Lista userNames(String texto, Lista NombreUsuarios){ 
       
       String[] lineas = texto.split("\n");
        boolean enUsuarios = false;

        for (String linea : lineas) {
            if (linea.equals("usuarios")) {
                enUsuarios = true;
            }
            else if (enUsuarios && linea.startsWith("@")) {
                NombreUsuarios.addToTheFinal(linea);
            }else if (linea.equals("relaciones")) {
                enUsuarios = false;
            }
        } 
        return NombreUsuarios;

    } 
    
    /**
     * Retona los usuarios iniciales 
     * @param texto
     * @param numRelaciones
     * @param Elements
     * @return resultados
     */
public int[] obtenerUsuariosInicio(String texto, int numRelaciones, Object[] Elements ) {
    
    String[] lineas = texto.split("\n");
    boolean enUsuarios = false;
    int contadorUsuarios = 0;
    int[] usuariosIndices = new int[100]; // Establece un tamaño máximo, ajusta según sea necesario

    // Primero, construye el arreglo de índices
    for (String linea : lineas) {
        if (linea.equals("usuarios")) {
            enUsuarios = true;
        } else if (enUsuarios && linea.startsWith("@")) {
            usuariosIndices[contadorUsuarios] = contadorUsuarios;
            contadorUsuarios++;
        } else if (linea.equals("relaciones")) {
            enUsuarios = false;
        }
    }

    // Luego, procesa las relaciones
    boolean enRelaciones = false;
    int contadorRelaciones = 0;
    int[] usuariosInicio = new int[100]; // Establece un tamaño máximo, ajusta según sea necesario

    for (String linea : lineas) {
        if (linea.equals("relaciones")) {
            enRelaciones = true;
        } else if (enRelaciones && linea.contains(", ")) {
            String[] usuarios = linea.split(", ");
            if (usuarios.length == 2) {
                int indiceInicio = usuariosIndices[contadorRelaciones];
                usuariosInicio[contadorRelaciones] = indiceInicio;
                contadorRelaciones++;

            }
        }
    }

    // Crea un nuevo arreglo con el tamaño exacto
    int[] resultado = new int[contadorRelaciones];
    System.arraycopy(usuariosInicio, 0, resultado, 0, contadorRelaciones);

    return resultado;
}

    /**
     * Retorna los ususarios finales 
     * @author Carlos De Freitas
     * @param texto
     * @param numRelaciones
     * @param Elements
     * @return resultado
     */
    public int[] obtenerUsuariosFinal(String texto,int numRelaciones, Object[] Elements ) {
        String[] lineas = texto.split("\n");
        boolean enUsuarios = false;
        int contadorUsuarios = 0;
        int[] usuariosIndices = new int[100]; // Establece un tamaño máximo, ajusta según sea necesario

        // Primero, construye el arreglo de índices
        for (String linea : lineas) {
            if (linea.equals("usuarios")) {
                enUsuarios = true;
            } else if (enUsuarios && linea.startsWith("@")) {
                usuariosIndices[contadorUsuarios] = contadorUsuarios;
                contadorUsuarios++;
            } else if (linea.equals("relaciones")) {
                enUsuarios = false;
            }
        }

        // Luego, procesa las relaciones para obtener los usuarios finales
        boolean enRelaciones = false;
        int contadorRelaciones = 0;
        int[] usuariosFinales = new int[100]; // Establece un tamaño máximo, ajusta según sea necesario

        for (String linea : lineas) {
            if (linea.equals("relaciones")) {
                enRelaciones = true;
            } else if (enRelaciones && linea.contains(", ")) {
                String[] usuarios = linea.split(", ");
                if (usuarios.length == 2) {
                    int indiceFinal = usuariosIndices[contadorRelaciones];
                    usuariosFinales[contadorRelaciones] = indiceFinal;
                    contadorRelaciones++;
 
                }
            }
        }

        // Crea un nuevo arreglo con el tamaño exacto
        int[] resultado = new int[contadorRelaciones];
        System.arraycopy(usuariosFinales, 0, resultado, 0, contadorRelaciones);

        return resultado;
}

}