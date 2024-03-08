/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package exploradordearchivos;

import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Josue Gavidia
 */
public class TREE extends javax.swing.JFrame {

    /**
     * Creates new form TREE
     */
    File root = new File("Root");
    DefaultMutableTreeNode Raiz;
    DefaultTreeModel model;

    public TREE() {
        initComponents();
        createRoot();
    }
    
    public final JTree createTree(){
        Raiz = new DefaultMutableTreeNode(root.getName()); // root node
        
        DirectoryTree(new File("Root"), Raiz);
        
        model = new DefaultTreeModel(Raiz);
        return new JTree(model);
    }
    
     private void DirectoryTree(File Archivo, DefaultMutableTreeNode Raiz){
        for (File Branches : Archivo.listFiles()){
            if (Branches.isDirectory()){
                DefaultMutableTreeNode TreeBranch = new DefaultMutableTreeNode(Branches.getName()); // level 1 node
                DirectoryTree(Branches, TreeBranch);
                Raiz.add(TreeBranch);
            } else{
                Raiz.add(new DefaultMutableTreeNode(Branches.getName()));
            }
        }
    }
    

    private void createRoot() {
        if (!root.exists()) {
            root.mkdir();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        arbolito = createTree();
        create = new javax.swing.JButton();
        cambiarName = new javax.swing.JButton();
        path = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(arbolito);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 510));

        create.setText("Crear Carpeta");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        jPanel1.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 140, 40));

        cambiarName.setText("Cambiar Nombre");
        cambiarName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarNameActionPerformed(evt);
            }
        });
        jPanel1.add(cambiarName, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 130, 40));

        path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathActionPerformed(evt);
            }
        });
        jPanel1.add(path, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        DefaultMutableTreeNode Folder = new DefaultMutableTreeNode("Nueva Carpeta");
        model.insertNodeInto(Folder, Raiz, Raiz.getChildCount());
        model.reload();
    }//GEN-LAST:event_createActionPerformed

    private void cambiarNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarNameActionPerformed
        changeName(arbolito);
    }//GEN-LAST:event_cambiarNameActionPerformed

    private void pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathActionPerformed

    private void changeName(JTree arbol) {
        TreePath oldName = arbol.getSelectionPath(); 
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) oldName.getLastPathComponent();
        String nuevo = JOptionPane.showInputDialog(null, "Nuevo nombre");
        selectedNode.setUserObject(nuevo);
        model.nodeChanged(selectedNode);
        model.reload();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TREE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TREE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TREE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TREE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TREE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolito;
    private javax.swing.JButton cambiarName;
    private javax.swing.JButton create;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField path;
    // End of variables declaration//GEN-END:variables
}
