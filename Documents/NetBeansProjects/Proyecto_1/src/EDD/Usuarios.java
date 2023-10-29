/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDD;
import ventana.ClaseFrame; 
/**
 *
 * @author drali
 */
public class Usuarios {
    
    public String openTxt(){
        ClaseFrame info =  new ClaseFrame();
       
        String texto = info.abrirArchivo(); 
       
       return texto;
    }
    
    public int defineNumNodos(String texto){
       
       String[] lineas = texto.split("\n");
        int contadorUsuarios = 0;
        boolean enUsuarios = false;

        for (String linea : lineas) {
            if (linea.equals("usuarios")) {
                enUsuarios = true;
            }
            else if (enUsuarios && linea.startsWith("@")) {
                contadorUsuarios++;
            } else if (linea.equals("relaciones")) {
                enUsuarios = false;
            }
        }
        return contadorUsuarios;
    } 
    
    public int defineNumRelaciones(String texto){
       
       String[] lineas = texto.split("\n");
        int contadorRelaciones = 0;
        boolean enRelaciones = false;

        for (String linea : lineas) {
            if (linea.equals("relaciones")) {
                enRelaciones = true;
            }
            else if (enRelaciones && linea.startsWith("@")) {
                contadorRelaciones++;
            }
        }
        return contadorRelaciones;
    } 
   
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

 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public int Size(){ 
//    return Usuarios.getSize();
//    
    
    
    
    
//    }
//} 
    
