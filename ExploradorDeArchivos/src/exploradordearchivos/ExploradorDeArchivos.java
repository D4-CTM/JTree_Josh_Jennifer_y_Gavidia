package exploradordearchivos;

import java.io.File;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ExploradorDeArchivos extends javax.swing.JFrame{
    public JTree Arbol;
    
    public static void main(String[] args) {
        new ExploradorDeArchivos().setVisible(true);
    }
    
    public ExploradorDeArchivos(){
        setDefaultCloseOperation(3);
        setSize(500,500);

        setLocationRelativeTo(null);
        Arbol = createTree();
        add(Arbol);
    }
    
    public final JTree createTree(){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root"); // root node
        
        DirectoryTree(new File("Root"), root);
        
        DefaultTreeModel model = new DefaultTreeModel(root);
        return new JTree(model);
    }
    
    private void DirectoryTree(File Archivo, DefaultMutableTreeNode Raiz){
        for (File Branches : Archivo.listFiles()){
            if (Branches.isDirectory()){
                DirectoryTree(Branches, new DefaultMutableTreeNode(Branches.getName()));
            } else{
                Raiz.add(new DefaultMutableTreeNode(Branches.getName()));
            }
        }
    }
    
}
