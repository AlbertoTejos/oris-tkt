package oris.view;

import java.awt.CardLayout;
import oris.view.models.TableModelTicket;
import oris.view.models.DetalleWListener;
import oris.view.models.ComboModelLineaAerea;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import oris.directorio.Directorio;
import oris.model.db.Conexion;
import oris.model.dto.Ticket;
import oris.statics;

public class BuscarRegistro extends javax.swing.JPanel {

    TableModelTicket tableTicketModel;
    ComboModelLineaAerea comboLineasModel;
    Directorio dir = null;
    Inicio ini = Inicio.getInstance();
    private final JPanel panelPrincipal = ini.getPanel();
               
    

    public BuscarRegistro() {
        initComponents();
        dir = Directorio.getInstance();
        //Botón nuevo
        this.btn_nuevo.setToolTipText("Agregar un ticket");
        //Botón buscar
        this.btn_buscar.setToolTipText("Iniciar búsqueda");
        //Botón excel
        this.btnExcel.setEnabled(false);
        this.btnExcel.setToolTipText("Exportar a Excel");
        //Botón eliminar
        this.btn_eliminar.setEnabled(false);
        this.btn_eliminar.setToolTipText("Eliminar ticket");
        //Botón reporte
        this.btnReporte.setEnabled(false);
        this.btnReporte.setToolTipText("Reporte análisis de ventas");
        
        
        //Testing nuevo menu item
        this.btnExaminar.setVisible(false);
        this.txtExaminar.setVisible(false);
        this.btnGuardar.setVisible(false);
        
        tableTicketModel = new TableModelTicket();
        list_lineaerea.setEnabled(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    comboLineasModel = new ComboModelLineaAerea();
                    list_lineaerea.setModel(comboLineasModel);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar las lineas aereas.");
                }
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        list_lineaerea.setEnabled(true);
                    }
                });
            }
        }).start();

        java.util.Date fecha = new Date();

        this.table_ticket.setModel(tableTicketModel);
        table_ticket.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        this.txt_fechadesde.setToolTipText("DD/MM/AAAA");
        this.txt_fechahasta.setToolTipText("DD/MM/AAAA");
        this.progress_bar.setIndeterminate(true);
        this.progress_bar.setVisible(false);
        this.txt_fechadesde.setDate(fecha);
        this.txt_fechahasta.setDate(fecha);
        this.txtExaminar.setText(dir.getRuta_excel());

        ajutarTabla();
        table_ticket.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }

    public void ajutarTabla() {
        table_ticket.setDefaultRenderer(Object.class, new TableCellRenderer() {
            private final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (column == 10 || column == 11 || column == 12) {
                    DEFAULT_RENDERER.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

                } else {
                    DEFAULT_RENDERER.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
                }

                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    if (tableTicketModel.getTicket(row).getNumFile().equals("")) {
                        c.setBackground(new Color(255, 171, 158));
                    } else {
                        c.setBackground(Color.WHITE);
                    }
                }
                return c;
            }
        });

        table_ticket.getColumn(table_ticket.getColumnName(0)).setPreferredWidth(35);
        table_ticket.getColumn(table_ticket.getColumnName(1)).setPreferredWidth(50);
        table_ticket.getColumn(table_ticket.getColumnName(2)).setPreferredWidth(60);
        table_ticket.getColumn(table_ticket.getColumnName(3)).setPreferredWidth(80);
        table_ticket.getColumn(table_ticket.getColumnName(4)).setPreferredWidth(80);
        table_ticket.getColumn(table_ticket.getColumnName(5)).setPreferredWidth(80);
        table_ticket.getColumn(table_ticket.getColumnName(6)).setPreferredWidth(70);
        table_ticket.getColumn(table_ticket.getColumnName(7)).setPreferredWidth(200);
        table_ticket.getColumn(table_ticket.getColumnName(8)).setPreferredWidth(120);
        table_ticket.getColumn(table_ticket.getColumnName(9)).setPreferredWidth(45);
        table_ticket.getColumn(table_ticket.getColumnName(10)).setPreferredWidth(60);
        table_ticket.getColumn(table_ticket.getColumnName(11)).setPreferredWidth(65);
        table_ticket.getColumn(table_ticket.getColumnName(12)).setPreferredWidth(60);
        table_ticket.getColumn(table_ticket.getColumnName(13)).setPreferredWidth(50);
        table_ticket.getColumn(table_ticket.getColumnName(14)).setPreferredWidth(80);
        table_ticket.getColumn(table_ticket.getColumnName(15)).setPreferredWidth(30);
        table_ticket.getColumn(table_ticket.getColumnName(16)).setPreferredWidth(30);
    }

    public void detalleTicket(int row) {
        System.out.println(tableTicketModel.getTicket(row));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_ticket = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        list_lineaerea = new javax.swing.JComboBox();
        btn_nuevo = new javax.swing.JButton();
        txt_fechadesde = new com.toedter.calendar.JDateChooser();
        txt_fechahasta = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        btn_eliminar = new javax.swing.JButton();
        progress_bar = new javax.swing.JProgressBar();
        txt_nfile = new javax.swing.JTextField();
        btnExcel = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        lblNumeroTicket = new javax.swing.JLabel();
        txtNumeroTicket = new javax.swing.JTextField();
        btnExaminar = new javax.swing.JButton();
        txtExaminar = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search-icon.png"))); // NOI18N
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        table_ticket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_ticket.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_ticket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ticketMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_ticket);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Fecha desde :");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Fecha hasta :");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Linea aérea :");

        list_lineaerea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cargando..." }));
        list_lineaerea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_lineaereaActionPerformed(evt);
            }
        });

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new-icon.png"))); // NOI18N
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        txt_fechadesde.setDateFormatString("dd/MM/yyyy");
        txt_fechadesde.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_fechadesdeFocusLost(evt);
            }
        });

        txt_fechahasta.setDateFormatString("dd/MM/yyyy");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("N° file :");

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete-icon.png"))); // NOI18N
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excel-icon.png"))); // NOI18N
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reporte_final.png"))); // NOI18N
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        lblNumeroTicket.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNumeroTicket.setText("N° ticket :");

        btnExaminar.setText("Examinar...");
        btnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarActionPerformed(evt);
            }
        });

        txtExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExaminarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/guardar.png"))); // NOI18N
        btnGuardar.setToolTipText("");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oris/view/salir_grande.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_fechahasta, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fechadesde, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_nfile, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNumeroTicket)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumeroTicket))
                            .addComponent(list_lineaerea, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_buscar)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExaminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(427, 427, 427)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(progress_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_eliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btn_nuevo)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcel))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(list_lineaerea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_fechadesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txt_nfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNumeroTicket)
                                .addComponent(txtNumeroTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_fechahasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(btn_buscar))
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progress_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExaminar)
                            .addComponent(txtExaminar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_nuevo)
                            .addComponent(btn_eliminar)
                            .addComponent(btnExcel))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table_ticketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ticketMouseClicked
        if (evt.getClickCount() == 2) {
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            final DetalleRegistro a = new DetalleRegistro(tableTicketModel.getTicket(row), Inicio.getInstance(), true);
            a.addWindowListener(new DetalleWListener() {
                @Override
                public void windowClosed(WindowEvent e) {
                    if (a.isModificado()) {
                        btn_buscarActionPerformed(null);
                    }

                }
            });

        }
    }//GEN-LAST:event_table_ticketMouseClicked

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");

        String desde = "01/01/1990";
        try {
            desde = sdf.format(txt_fechadesde.getDate());
        } catch (Exception e) {
            desde = "01/01/1990";
        }

        String hasta = "01/01/2020";
        try {
            hasta = sdf.format(txt_fechahasta.getDate());
        } catch (Exception e) {
            hasta = "01/01/2020";
        }

        if (this.txt_fechadesde.getDateFormatString().equals("") || this.txt_fechahasta.getDateFormatString().equals("")) {
        }

        final String desde_ = desde;
        final String hasta_ = hasta;
        this.progress_bar.setVisible(true);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    tableTicketModel.getTickets(desde_, hasta_, comboLineasModel.getCodigoLinea(list_lineaerea.getSelectedIndex()), txt_nfile.getText(), txtNumeroTicket.getText());
                    actualizarTabla();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error , intente nuevamente.");
                    System.out.println(ex);
                }
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        progress_bar.setVisible(false);
                        setCursor(Cursor.getDefaultCursor());
                    }
                });
            }
        }).start();

        //table_ticket.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //ajutarTabla();
        // 01/02/2014    
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        DetalleRegistro det = new DetalleRegistro(null, Inicio.getInstance(), true);

    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void txt_fechadesdeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_fechadesdeFocusLost
    }//GEN-LAST:event_txt_fechadesdeFocusLost

    private void actualizarTabla() {
        tableTicketModel.actualizaTabla();
        table_ticket.setModel(tableTicketModel);
        
        final int row = this.table_ticket.getRowCount();
        if(row > 0){
            this.btnExcel.setEnabled(true);
            this.btnReporte.setEnabled(true);
            this.btn_eliminar.setEnabled(true);
        }
 
    }

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        final int row = this.table_ticket.getSelectedRow();
        if (row >= 0) {
            final Ticket tic = this.tableTicketModel.getTicket(row);
            int i = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el ticket: " +tic.getTicket() + "?", "Eliminar registro", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (i == 0) {
                this.progress_bar.setVisible(true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            tableTicketModel.eliminarTicket(tic, row);
                            actualizarTabla();
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error , el registro no se pudo eliminar.");
                        }
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                progress_bar.setVisible(false);
                            }
                        });
                    }
                }).start();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione el ticket a eliminar");
        }


    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed

        
        final int totalFilas = this.table_ticket.getRowCount();

        if (totalFilas > 0) {

            final String rutaExcel = dir.getRuta_excel();

            final ArrayList<Ticket> tickets = this.tableTicketModel.getArrayTicket(totalFilas);
            final JTable table = this.table_ticket;
            int i = JOptionPane.showConfirmDialog(this, "¿Desea exportar a Excel?", "Informe", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                this.progress_bar.setVisible(true);
                this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");

                            String desde = "01/01/1990";
                            try {
                                desde = sdf.format(txt_fechadesde.getDate());
                                desde = desde.replace("/", "-");
                            } catch (Exception e) {
                                desde = "01/01/1990";
                            }

                            String hasta = "01/01/2020";
                            try {
                                hasta = sdf.format(txt_fechahasta.getDate());
                                hasta = hasta.replace("/", "-");
                            } catch (Exception e) {
                                hasta = "01/01/2020";
                            }

                            tableTicketModel.exportarTicket(table, tickets, rutaExcel, desde, hasta);

                        } catch (IOException ex) {
                            Logger.getLogger(BuscarRegistro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                progress_bar.setVisible(false);
                                setCursor(Cursor.getDefaultCursor());
                            }
                        });
                    }
                }).start();

            }
        }else{
            JOptionPane.showMessageDialog(null, "Primero debe realizar una búsqueda");
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    private void list_lineaereaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_lineaereaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list_lineaereaActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed

        final int totalFilas = this.table_ticket.getRowCount();
        if (totalFilas > 0) {
            this.progress_bar.setVisible(true);
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //Fechas
                        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                        String desde = sdf.format(txt_fechadesde.getDate());
                        desde = desde.replace("/", "-");
                        String hasta = sdf.format(txt_fechahasta.getDate());
                        hasta = hasta.replace("/", "-");
                        String codigoLineaArea = comboLineasModel.getCodigoLinea(list_lineaerea.getSelectedIndex());

                        
                        //String directorioFijo = "C:\\Users\\Alberto\\Desktop\\Proyectos\\oris-tkt\\src\\oris\\reports\\AnalisisVentas.jasper";
                        
                        String directorio = System.getProperty("user.dir");
                        
                        System.out.println("Cargando archivo desde: " + directorio+"\\cargador-reportes\\AnalisisVentas.jasper");
                        JasperReport jr = null;
                        try {
                            jr = (JasperReport) JRLoader.loadObjectFromFile(directorio+"\\cargador-reportes\\AnalisisVentas.jasper");
                        } catch (JRException jrex) {
                            System.out.println("Falla al cargar el reporte: "+jrex.getMessage());
                            JOptionPane.showMessageDialog(null, "Falla al cargar el reporte, archivo en cargador-reporte no encontrado", "Error de carga", JOptionPane.ERROR_MESSAGE, null);
                        }
                        
                        //Parametros
                        Map parametro = new HashMap();
                        parametro.put("fecha_desde", desde);
                        parametro.put("fecha_hasta", hasta);
                        parametro.put("codigo", codigoLineaArea);
                        System.out.println(parametro);
                        
                        
                        Conexion con = new Conexion();
                        System.out.println("Conectandome....");
                        JasperPrint jp = JasperFillManager.fillReport(jr, parametro, con.getConnection());
                        System.out.println("Conectado.");
                        JasperViewer jv = new JasperViewer(jp, false);
                        jv.setVisible(true);
                        jv.setTitle("Reporte");
                        con.closeConnection();

                    } catch (JRException ex) {
                        System.out.println(ex.getMessage());
                    }

                    SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        progress_bar.setVisible(false);
                        setCursor(Cursor.getDefaultCursor());
                    }
                }); 
                }
            }).start();
        } else {
            JOptionPane.showMessageDialog(null, "Primero debe realizar una búsqueda");
        }

    }//GEN-LAST:event_btnReporteActionPerformed

    private void txtExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExaminarActionPerformed
        dir.getRuta_excel();
    }//GEN-LAST:event_txtExaminarActionPerformed

    private void btnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarActionPerformed
       //this.txtExaminar.setText(statics.definirDirectorio(this));
    }//GEN-LAST:event_btnExaminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
//        if (this.txtExaminar.getText().equals("")) {
//            	JOptionPane.showMessageDialog(null, "Debe ingresar todos los campos.");
//            	return;
//        	}
//
//        	dir.setRuta_excel(this.txtExaminar.getText());
//	
//        	dir.guardarCambios();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                panelPrincipal.add(new Logo(), "menu2");
                CardLayout paleta2 = (CardLayout) panelPrincipal.getLayout();
                paleta2.show(panelPrincipal, "menu2");

                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        setCursor(Cursor.getDefaultCursor());
                    }
                });
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNumeroTicket;
    private javax.swing.JComboBox list_lineaerea;
    private javax.swing.JProgressBar progress_bar;
    private javax.swing.JTable table_ticket;
    private javax.swing.JTextField txtExaminar;
    private javax.swing.JTextField txtNumeroTicket;
    private com.toedter.calendar.JDateChooser txt_fechadesde;
    private com.toedter.calendar.JDateChooser txt_fechahasta;
    private javax.swing.JTextField txt_nfile;
    // End of variables declaration//GEN-END:variables
}
