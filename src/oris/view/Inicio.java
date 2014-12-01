package oris.view;

import java.awt.CardLayout;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import oris.directorio.Directorio;
import oris.statics;


public class Inicio extends javax.swing.JFrame{

    private static Inicio instance = null;

    /**
     * Creates new form Inicio
     */

    private Inicio() {
        
        //this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);  

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
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuOris = new javax.swing.JMenu();
        menuItemEditarRegistro = new javax.swing.JMenuItem();
        menuItemSalir = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        menuDirectorio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setLayout(new java.awt.CardLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oris/view/oris-avion.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelPrincipal.add(jLabel1, "card2");

        menuOris.setText("Menú");

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

        jMenu1.setText("Opciones");

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oris/view/excel_menuitem.png"))); // NOI18N
        jMenu2.setText("Excel");

        menuDirectorio.setText("Definir directorio...");
        menuDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDirectorioActionPerformed(evt);
            }
        });
        jMenu2.add(menuDirectorio);

        jMenu1.add(jMenu2);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemEditarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEditarRegistroActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                panelPrincipal.add(new BuscarRegistro(), "menu1");
                CardLayout paleta1 = (CardLayout) panelPrincipal.getLayout();
                paleta1.show(panelPrincipal, "menu1");

                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        setCursor(Cursor.getDefaultCursor());
                    }
                });
            }
        });
    }//GEN-LAST:event_menuItemEditarRegistroActionPerformed

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemSalirActionPerformed

    private void menuDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDirectorioActionPerformed
        String resultado = statics.definirDirectorio(this);
        if(!resultado.equals("")){
            Directorio.getInstance().setRuta_excel(resultado);
            Directorio.getInstance().guardarCambios();
        }else{
            Directorio.getInstance().getRuta_excel();
        }

    }//GEN-LAST:event_menuDirectorioActionPerformed

    public static Inicio getInstance() {
        if (instance == null) {
            instance = new Inicio();
        }
        return instance;
    }
    
    public JPanel getPanel(){
        return this.panelPrincipal;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuDirectorio;
    private javax.swing.JMenuItem menuItemEditarRegistro;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JMenu menuOris;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

}
