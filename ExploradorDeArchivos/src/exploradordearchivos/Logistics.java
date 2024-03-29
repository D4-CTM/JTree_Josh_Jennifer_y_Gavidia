package exploradordearchivos;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
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
    
    public void CopyFile(){
        Copy = new File(Seleccionado.getAbsolutePath());
    }
    
    public void PasteFile(){
        
    }
    
    public void RenameFile(String root, String name){
        File oldName = new File(root);
        String[] neoName = oldName.getAbsolutePath().split("[\\\\]");
        String newPath = "";
        for (int i = 0; i < neoName.length - 1; i++){
            newPath += neoName[i] + "\\";
        }
        
        String[] Ext = neoName[neoName.length - 1].split("[.]");
        
        if (!neoName[neoName.length - 1].equals("Root")){
            newPath += name;
            oldName.renameTo(new File(newPath + "." + Ext[1]));
        }
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
            JOptionPane.showMessageDialog(null, "Se ha creado la carpeta \"" + name + "\"", "Carpeta creada", JOptionPane.INFORMATION_MESSAGE, null);
        } else JOptionPane.showMessageDialog(null, "No se ha podido crear \"" + name + "\"", "Error", JOptionPane.WARNING_MESSAGE, null);
    }
    
}
