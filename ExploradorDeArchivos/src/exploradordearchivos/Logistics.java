package exploradordearchivos;

import java.io.File;
import java.io.IOException;
import javax.swing.tree.DefaultMutableTreeNode;

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
    
    public String FindFolder(String Target){
        if (Target.equals("Root")){
            return Seleccionado.getAbsolutePath();
        }
        for (File Branches : Seleccionado.listFiles()){
            if (Branches.getName().equals(Target)){
                return Branches.getAbsolutePath();
            }
            if (Branches.isDirectory()){
                FindFolder(Target);
            }
        }
        return "N/A";
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
        if (new File(root + "\\" + name).mkdir()){
            System.out.println("Se creo");
        } else System.out.println("No se creo");
    }
    
    public void CopyFile(){
        Copy = new File(Seleccionado.getAbsolutePath());
    }
    
    public File PasteFile(){
        return Copy;
    }
    
}
