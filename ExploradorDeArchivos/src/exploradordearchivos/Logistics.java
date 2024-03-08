package exploradordearchivos;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josue
 */
public class Logistics {
    private File Seleccionado;
    private File Copy;
    
    public Logistics(){
        Seleccionado = new File("Root");
    }
    
    public void setFile(String root){
        Seleccionado = new File(root);
    }
    
    public void CreateTXTFile(String root, String name){
        try {
            new File(root + "\\" + name + ".txt").createNewFile();
        } catch (IOException ex) {
            System.out.println("Error al crear el archivo de texto");
        }
    }
    
    public void CreateComercialFile(String root, String name){
        try {
            new File(root + "\\" + name + ".bin").createNewFile();
        } catch (IOException ex) {
            System.out.println("Error en el archivo comercial");
        }
    }
    
    public void CreateDir(String root, String name){
        new File(root + "\\" + name).mkdir();
    }
    
    public void CopyFile(){
        Copy = new File(Seleccionado.getAbsolutePath());
    }
    
    public File PasteFile(){
        return Copy;
    }
    
}
