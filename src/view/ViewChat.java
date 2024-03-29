/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Control.Customer;
import Dates.DataManager;
//import edu.unicauca.datos.GestionArchivo;
import java.awt.Image;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;

/**
 *
 * @author Brn Hurtado
 */
public class ViewChat extends javax.swing.JFrame {

     
    public ViewChat(Customer customer) {
        this.customer = customer;
        initComponents();
        jLabel2.setText(customer.name);
        image();
    }
    
    public void image (){
        ImageIcon img1 = new ImageIcon ("C:\f.jpg");
        Icon icon1 = new ImageIcon(img1.getImage().getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_DEFAULT));
        jLabel4.setIcon(icon1);
        this.repaint();
    }

    public void upDateMessaje(String chat) {
        DataManager date = new  DataManager();
        
        if (!(taPrincipal.getText().isEmpty()) && (taPrincipal.getText().length() > 0)){
            try {
                taPrincipal.append("\n"+chat);
                Document document = taPrincipal.getDocument();
                Element rootElem = document.getDefaultRootElement();
                int numLines = rootElem.getElementCount();
                Element lineElem = rootElem.getElement(numLines-1);
                int lineStart = lineElem.getStartOffset();
                int lineEnd = lineElem.getEndOffset();
                String lineText = document.getText(lineStart, lineEnd - lineStart);
                  
                try {      
                    date.saveChat(taPrincipal.getText(),customer.name);
                    
                    
                    //datos.guardarChat(taPrincipal.getText(), cliente.nombre);
                } catch (IOException ex) {
                    Logger.getLogger(ViewChat.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (BadLocationException ex) {
                Logger.getLogger(ViewChat.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        } else{
            
            try {
                taPrincipal.append(" ");
                taPrincipal.setSelectionStart(0);
                taPrincipal.append("\n"+chat);
                taPrincipal.setSelectionEnd(taPrincipal.getText().length());
                
                date.saveChat(taPrincipal.getSelectedText(),customer.name);
                //datos.guardarChat(taPrincipal.getText(), cliente.nombre);
            } catch (IOException ex) {
                Logger.getLogger(ViewChat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void getTaPrincipal(){
          
    
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
        btEnviar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        spPrincipal = new javax.swing.JScrollPane();
        taPrincipal = new javax.swing.JTextArea();
        btBorrar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        taEnviar = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(null);

        btEnviar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEnviar.setText("Enviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });
        jPanel1.add(btEnviar);
        btEnviar.setBounds(360, 270, 90, 23);

        taPrincipal.setEditable(false);
        taPrincipal.setBackground(new java.awt.Color(204, 204, 255));
        taPrincipal.setColumns(20);
        taPrincipal.setRows(5);
        spPrincipal.setViewportView(taPrincipal);

        jScrollPane3.setViewportView(spPrincipal);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(30, 90, 360, 160);

        btBorrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btBorrar.setText("Borrar");
        btBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(btBorrar);
        btBorrar.setBounds(360, 310, 90, 23);

        jScrollPane4.setBackground(new java.awt.Color(204, 204, 255));

        taEnviar.setBackground(new java.awt.Color(204, 204, 255));
        taEnviar.setColumns(20);
        taEnviar.setRows(5);
        jScrollPane2.setViewportView(taEnviar);

        jScrollPane4.setViewportView(jScrollPane2);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(30, 270, 300, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/s.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(410, 90, 130, 140);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Usuario");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(440, 240, 110, 14);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText(" Bienvenidos al chat de usuario");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 20, 370, 60);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 550, 380);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBorrarActionPerformed
        taEnviar.setText("");
    }//GEN-LAST:event_btBorrarActionPerformed

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        /*cliente.escribirMensaje(taEnviar.getText());
        actualizarMensajes(cliente.nombre + " dice > " + taEnviar.getText());
        taEnviar.setText("");*/
 
        customer.writeMessaje(sdf.format(new Date())+ customer.name + " _wrote_> "+taEnviar.getText());
        taEnviar.setText("");
    }//GEN-LAST:event_btEnviarActionPerformed

    /**
     * @param args the command line arguments
     */
    Customer customer;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy" + "\n"+ "hh:mm"+"  ");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBorrar;
    private javax.swing.JButton btEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane spPrincipal;
    private javax.swing.JTextArea taEnviar;
    private javax.swing.JTextArea taPrincipal;
    // End of variables declaration//GEN-END:variables

}
