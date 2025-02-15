/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Models.Controlls;
import Models.PackageDestinatory;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Fabricio
 */
public class ClientView extends javax.swing.JFrame implements Runnable {

    ArrayList<Controlls> lista2=new ArrayList<Controlls>(); 
    private static int puertoF;
    private static String nombre;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getPuerto() {
        return puertoF;
    }

    public void setPuerto(int puerto) {
        this.puertoF = puerto;
    }
    
    /**
     * Creates new form ClientView
     */
    public ClientView(){
        try {
            String nombre2 = JOptionPane.showInputDialog("nombre: ");
            System.out.println("print 1");
            Socket misocket = new Socket("192.168.0.134",1024);
            System.out.println("print 1");
            ServerSocket auxiliar = new ServerSocket(0);
            int puertoDisponible=auxiliar.getLocalPort();
            auxiliar.close();
            
            PackageDestinatory datos = new PackageDestinatory();
            nombre=nombre2;
            datos.setNick2(nombre);
            datos.setPuerto(puertoDisponible);
            puertoF=puertoDisponible;
            System.out.println(puertoF);
            datos.setMensaje(" Online");
            
            ObjectOutputStream salida = new ObjectOutputStream(misocket.getOutputStream());
            salida.writeObject(datos);
            misocket.close();
        } catch (IOException ex) {
            jtxtHistoryMessage.append(ex.getMessage());
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        };
        
        
        initComponents();
        this.setLocationRelativeTo(null);
        
        jScrollHistory.setOpaque(false);
        jScrollHistory.getViewport().setOpaque(false);
        jScrollHistory.setBorder(null);
        jScrollHistory.setViewportBorder(null);
        jtxtHistoryMessage.setBorder(null);
        jtxtHistoryMessage.setBackground(new Color(0,0,0,64));
        jUserConnect.setText(nombre);
        
        Thread mihilo = new Thread(this);
        mihilo.start();
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
        jLabel1 = new javax.swing.JLabel();
        jUserConnect = new javax.swing.JLabel();
        cbUsersConnect = new javax.swing.JComboBox<>();
        jScrollHistory = new javax.swing.JScrollPane();
        jtxtHistoryMessage = new javax.swing.JTextArea();
        jtxtMessage = new javax.swing.JTextField();
        btnSendMessage = new javax.swing.JButton();
        num = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Online");

        jUserConnect.setForeground(new java.awt.Color(255, 255, 255));

        jtxtHistoryMessage.setEditable(false);
        jtxtHistoryMessage.setColumns(20);
        jtxtHistoryMessage.setRows(5);
        jScrollHistory.setViewportView(jtxtHistoryMessage);

        btnSendMessage.setText("Send");
        btnSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMessageActionPerformed(evt);
            }
        });

        num.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtxtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSendMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jUserConnect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(num)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbUsersConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUserConnect)
                    .addComponent(cbUsersConnect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(num))
                .addGap(18, 18, 18)
                .addComponent(jScrollHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(btnSendMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

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

    private void btnSendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMessageActionPerformed
               // InetAddress direccion;

        /*
        direccion = InetAddress.getLocalHost(); //para obtener la ip de nuestro dispositivo
        String ip = direccion.getHostAddress();*/
        //  String ipdes = ipserver.getText();

        try {                //nuestra ip del servidor y el puerto que va a estar abierto
            Socket miSocket =new Socket("192.168.0.134",1024);
            PackageDestinatory datos = new PackageDestinatory();
            datos.setNick2(jUserConnect.getText());
            datos.setDestinatario(cbUsersConnect.getSelectedItem().toString());
            String aux;
            aux=cbUsersConnect.getSelectedItem().toString();
            for(int i=0;i<lista2.size();i++){
                if(aux.equalsIgnoreCase(lista2.get(i).getNombrecontrol())){
                    datos.setIp(lista2.get(i).getIpcontrol());
                }

            }
            // datos.setIp(ipdestino.getSelectedItem().toString()); //pasar en String el objeto que devuelve el jcombobox
            jtxtHistoryMessage.append("\n  -"+ jtxtMessage.getText());
            datos.setMensaje(jtxtMessage.getText());

            ObjectOutputStream salida = new ObjectOutputStream(miSocket.getOutputStream());
            salida.writeObject(datos);
            jtxtMessage.setText(null);
            miSocket.close();
            //el flujo se conducira por el socket previamente creado
            /* DataOutputStream salida = new DataOutputStream(miSocket.getOutputStream());
            salida.writeUTF(mensaje.getText());  //escribe en el flujo el texto del mensaje

            salida.close();*/
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            // Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSendMessageActionPerformed

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
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendMessage;
    private javax.swing.JComboBox<String> cbUsersConnect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollHistory;
    private javax.swing.JLabel jUserConnect;
    private javax.swing.JTextArea jtxtHistoryMessage;
    private javax.swing.JTextField jtxtMessage;
    private javax.swing.JLabel num;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            System.out.println(puertoF);
            ServerSocket servidor_cliente = new ServerSocket(puertoF);
            
            
            ArrayList<String> ipsMenu = new ArrayList<String>();
            Socket cliente;
            PackageDestinatory paquete_recibido;
            while(true){
                cliente = servidor_cliente.accept();
                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
                paquete_recibido= (PackageDestinatory) entrada.readObject();
                System.out.println("9999999999"+paquete_recibido.getMensaje());
            if(!paquete_recibido.getMensaje().equalsIgnoreCase(" Online")){
           /*     String aux3;
            for(int i=0;i<lista2.size();i++){
               if(){
               
               }
            }*/
            jtxtHistoryMessage.append("\n\t\t\t"+paquete_recibido.getNick2()+ ": "+ paquete_recibido.getMensaje());
            } else{
                 System.out.println("hereee");
            //historial.append(paquete_recibido.getDirIps().toString());
            Controlls hola = new Controlls ();
            ipsMenu=paquete_recibido.getDirIps();
            String nombre=paquete_recibido.getNick2();
            lista2=paquete_recibido.getControl();
            System.out.println("hereee 2222");
            
            String conected = String.valueOf(lista2.size());
            num.setText(conected);
         /*   for(String z:ipsMenu){
          //    hola.setIpcontrol(z);
            //   hola.setNombrecontrol(nombre);
               lista2.add(hola);
               
            
        //  ipdestino.addItem(z);
            }*/
         cbUsersConnect.removeAllItems();//borra el arrayList desactualizado
        System.out.println("hereee uuuu");
            for(int i=0;i<lista2.size();i++){
            cbUsersConnect.addItem(lista2.get(i).getNombrecontrol());
            }
            }
            
            
            }
            } catch (IOException ex) {
            Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    } 
        
    class EnvioOnline extends WindowAdapter{ //implementa todas los metodos pertenecistentes a una interfaz(listener)
        String nickx,ipserver;
        public void hola (String s){
          nickx=s;
        }
        public void hola2 (String e){
          ipserver=e;
        }

        public void windowOpened(WindowEvent e){
            try {
                //ip del server

                System.out.println("print 1");
                Socket misocket = new Socket("192.168.0.134",1024);
                System.out.println("print 1");
                PackageDestinatory datos = new PackageDestinatory();

                datos.setNick2(nickx);
                datos.setMensaje(" Online");

                ObjectOutputStream salida = new ObjectOutputStream(misocket.getOutputStream());
                salida.writeObject(datos);
                misocket.close();
              //  System.out.println("hola");
            } catch (IOException ex) {
                Logger.getLogger(EnvioOnline.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}


