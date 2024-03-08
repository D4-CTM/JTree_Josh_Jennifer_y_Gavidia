/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploradordearchivos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author jenniferbueso
 */
public class FileBrowserOrganizer extends JFrame {
    private JTree fileTree;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode rootNode;

    public FileBrowserOrganizer() {
        setTitle("Navegador y Organizador de Archivos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        rootNode = new DefaultMutableTreeNode("Root");
        treeModel = new DefaultTreeModel(rootNode);
        fileTree = new JTree(treeModel);
        
        JScrollPane scrollPane = new JScrollPane(fileTree);
        getContentPane().add(scrollPane);

        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem organizeItem = new JMenuItem("Organizar Documentos");
        organizeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //organizeDocuments();
            }
        });
        popupMenu.add(organizeItem);
        fileTree.setComponentPopupMenu(popupMenu);
    }
    
}