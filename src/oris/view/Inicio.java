
package oris.view;


import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Inicio extends javax.swing.JFrame {
    private static Inicio instance = null;
        
    /**
     * Creates new form Inicio
     */
    private Inicio() {
        
        try {
          
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
            this.pack();
            this.setIconImage(new ImageIcon(getClass().getResource("air_tickets.png")).getImage());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error.");
        }
         
        initComponents();
        this.setTitle("Oris-TKT");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        //this.setIconImage(new ImageIcon(getClass().getResource("avion.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        menuOris = new javax.swing.JMenu();
        menuItemEditarRegistro = new javax.swing.JMenuItem();
        menuItemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setLayout(new java.awt.CardLayout());

        menuOris.setText("Opciones");

        menuItemEditarRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oris/view/database.png"))); // NOI18N
        menuItemEditarRegistro.setText("Registros");
        menuItemEditarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEditarRegistroActionPerformed(evt);
            }
        });
        menuOris.add(menuItemEditarRegistro);

        menuItemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oris/view/salir.png"))); // NOI18N
        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        menuOris.add(menuItemSalir);

        menuBar.add(menuOris);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemEditarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEditarRegistroActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                panelPrincipal.add(new BuscarRegistro(),"menu1"); 
                CardLayout paletas = (CardLayout)panelPrincipal.getLayout();
                paletas.show(panelPrincipal, "menu1");
            }
        });
    }//GEN-LAST:event_menuItemEditarRegistroActionPerformed

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        System.exit(0);       
    }//GEN-LAST:event_menuItemSalirActionPerformed
    
    
    public static Inicio getInstance(){
        if (instance==null) {
            instance = new Inicio();
        }
        return instance;
    }
 
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemEditarRegistro;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JMenu menuOris;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
