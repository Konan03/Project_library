/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gestor;
import java.sql.Connection;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Konan
 */
public class LIbreria extends javax.swing.JFrame {
    
    public final static String URL = "jdbc:mysql://localhost:3306/libreria";
    public final static String USER = "root";
    public final static String PASSWORD = "admin";
    
    DefaultTableModel modelo;
    

    /**
     * Creates new form LIbreria
     */
    public LIbreria() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Titulo");
        modelo.addColumn("Autor");
        modelo.addColumn("Genero");
        
        mostrarDatos();
    }
    
    public void mostrarDatos(){
        
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conexion = DriverManager.getConnection(URL,USER,PASSWORD);
            String sql = "SELECT id, titulo, autor, genero FROM libro";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String genero = rs.getString("genero");
                
                modelo.addRow(new Object[]{id, titulo, autor, genero});
            }
            
            jtDatos.setModel(modelo);
            rs.close();
            ps.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public Connection getConnection(){
        Connection conexion = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return conexion;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contenedor = new javax.swing.JPanel();
        vistaIngreso = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jLId = new javax.swing.JLabel();
        jLTitulo = new javax.swing.JLabel();
        jLAutor = new javax.swing.JLabel();
        jLGenero = new javax.swing.JLabel();
        jTid = new javax.swing.JTextField();
        jTTitulo = new javax.swing.JTextField();
        jTAutor = new javax.swing.JTextField();
        jTGenero = new javax.swing.JTextField();
        BtnAgregar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        vistaDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Contenedor.setBackground(new java.awt.Color(255, 255, 255));
        Contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vistaIngreso.setBackground((new Color(255,255,255,1)));

        titulo.setBackground(new java.awt.Color(255, 51, 51));
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Libreria Unibague");

        jLId.setBackground(new java.awt.Color(98, 171, 130));
        jLId.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLId.setForeground(new java.awt.Color(255, 255, 255));
        jLId.setText("Id:");

        jLTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLTitulo.setText("Titulo:");

        jLAutor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLAutor.setForeground(new java.awt.Color(255, 255, 255));
        jLAutor.setText("Autor:");

        jLGenero.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLGenero.setForeground(new java.awt.Color(255, 255, 255));
        jLGenero.setText("Genero:");

        jTid.setEnabled(false);

        jTTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTTituloActionPerformed(evt);
            }
        });

        BtnAgregar.setBackground(new java.awt.Color(98, 171, 130));
        BtnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vistaIngresoLayout = new javax.swing.GroupLayout(vistaIngreso);
        vistaIngreso.setLayout(vistaIngresoLayout);
        vistaIngresoLayout.setHorizontalGroup(
            vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaIngresoLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(vistaIngresoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(vistaIngresoLayout.createSequentialGroup()
                        .addComponent(jLGenero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(vistaIngresoLayout.createSequentialGroup()
                        .addComponent(jLAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaIngresoLayout.createSequentialGroup()
                        .addComponent(jLTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaIngresoLayout.createSequentialGroup()
                        .addComponent(jLId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(jTid, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(BtnAgregar)
                .addGap(36, 36, 36))
        );
        vistaIngresoLayout.setVerticalGroup(
            vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaIngresoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vistaIngresoLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jTAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaIngresoLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLId)
                            .addComponent(jTid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(vistaIngresoLayout.createSequentialGroup()
                                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLTitulo)
                                    .addComponent(jTTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLAutor))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaIngresoLayout.createSequentialGroup()
                                .addComponent(BtnAgregar)
                                .addGap(19, 19, 19)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLGenero)
                    .addComponent(jTGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        Contenedor.add(vistaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 450, 450));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos.Imagenes/fondo.jpg"))); // NOI18N
        Contenedor.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 450, 450));

        vistaDatos.setBackground(new java.awt.Color(98, 171, 130));

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Titulo", "Autor", "Genero"
            }
        ));
        jScrollPane1.setViewportView(jtDatos);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de datos");

        javax.swing.GroupLayout vistaDatosLayout = new javax.swing.GroupLayout(vistaDatos);
        vistaDatos.setLayout(vistaDatosLayout);
        vistaDatosLayout.setHorizontalGroup(
            vistaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaDatosLayout.createSequentialGroup()
                .addGroup(vistaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vistaDatosLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1))
                    .addGroup(vistaDatosLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        vistaDatosLayout.setVerticalGroup(
            vistaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaDatosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        Contenedor.add(vistaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTituloActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
         // TODO add your handling code here:
         Connection conexion = getConnection();
         PreparedStatement ps = null;
         
         String sql = "insert into libro(titulo,autor,genero) value(?,?,?);";
         try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, jTTitulo.getText());
            ps.setString(2, jTAutor.getText());
            ps.setString(3, jTGenero.getText());
            ps.executeUpdate();
            
            conexion.close();
            JOptionPane.showMessageDialog(null, "Libro guardado");
        } catch (Exception e) {
             System.out.println("Error" + e);
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(LIbreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LIbreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LIbreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LIbreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LIbreria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JPanel Contenedor;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLAutor;
    private javax.swing.JLabel jLGenero;
    private javax.swing.JLabel jLId;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTAutor;
    private javax.swing.JTextField jTGenero;
    private javax.swing.JTextField jTTitulo;
    private javax.swing.JTextField jTid;
    private javax.swing.JTable jtDatos;
    private javax.swing.JLabel titulo;
    private javax.swing.JPanel vistaDatos;
    private javax.swing.JPanel vistaIngreso;
    // End of variables declaration//GEN-END:variables
}
