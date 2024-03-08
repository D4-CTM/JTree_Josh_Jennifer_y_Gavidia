/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploradordearchivos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author jenniferbueso
 */
public class EscribirenArchivos extends JFrame {
    private JTree fileTree;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode rootNode;

    public EscribirenArchivos() {
    setTitle("Navegador y Organizador de Archivos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        rootNode = new DefaultMutableTreeNode("Root");
        
        treeModel = new DefaultTreeModel(rootNode);
        fileTree = new JTree(treeModel);

        //Agregar Carpeta
        DefaultMutableTreeNode notas = new DefaultMutableTreeNode("Notas");
        rootNode.add(notas);
        
        DefaultMutableTreeNode Text1 = new DefaultMutableTreeNode("Hola.txt");
        notas.add(Text1);
        
        JScrollPane scrollPane = new JScrollPane(fileTree);
        getContentPane().add(scrollPane);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        JButton btnRegistrarDatos = new JButton("Registrar Datos en Archivo");
        btnRegistrarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarDatosEnArchivo();
            }
        });
        buttonPanel.add(btnRegistrarDatos);

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }
    
    private void registrarDatosEnArchivo() {
        // Obtener el nodo seleccionado en el JTree
        TreePath selectedPath = fileTree.getSelectionPath();
        if (selectedPath == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un archivo.");
            return;
        }

        // Obtener el último nodo del camino seleccionado
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectedPath.getLastPathComponent();

        // Verificar si el nodo seleccionado es un archivo
        if (selectedNode.isLeaf()) {
            // Obtener el archivo seleccionado
            String fileName = selectedNode.getUserObject().toString();
            File selectedFile = new File(fileName);

            // Obtener la ruta absoluta del archivo
            String filePath = selectedFile.getAbsolutePath();

            // Permitir al usuario ingresar el texto a registrar
            String texto = JOptionPane.showInputDialog(this, "Ingrese el texto a registrar:");
            if (texto == null || texto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se ha ingresado ningún texto.");
                return;
            }

            // Escribir el texto en el archivo seleccionado
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(texto);
                writer.newLine();
                JOptionPane.showMessageDialog(this, "Texto registrado correctamente en el archivo.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al escribir en el archivo: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un archivo, no una carpeta.");
        }
    }
}            
    
    

