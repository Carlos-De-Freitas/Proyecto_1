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
    
    public String OpenTxt(){
        ClaseFrame info =  new ClaseFrame();
       
       String texto = info.abrirArchivo(); 
       
       return texto;
    }
    
    public String DefineNumNodos(String texto){
       
       String[] lineas = texto.split("\n");
        int contadorUsuarios = 0;
        boolean enUsuarios = false;

        for (String linea : lineas) {
            if (linea.equals("usuarios")) {
                enUsuarios = true;
                continue;
            }

            if (enUsuarios && linea.startsWith("@")) {
                contadorUsuarios++;
            } else if (linea.equals("relaciones")) {
                enUsuarios = false;
            }
        }
        return Integer.toString(contadorUsuarios);
    } 
    
    public Lista UserNames(String texto, Lista NombreUsuarios){ 
       
       String[] lineas = texto.split("\n");
        boolean enUsuarios = false;

        for (String linea : lineas) {
            if (linea.equals("usuarios")) {
                enUsuarios = true;
            }

            if (enUsuarios && linea.startsWith("@")) {
                NombreUsuarios.Addtothefinal(linea);

            }else if (linea.equals("relaciones")) {
                enUsuarios = false;
            }
        } 
        return NombreUsuarios;

    } 
    
} 
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public int Size(){ 
//    return Usuarios.getSize();
//    
    
    
    
    
//    }
//} 
    
