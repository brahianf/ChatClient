/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import view.RegistryCustomer;
import view.Signin;
import view.ViewChat;
/**
 *
 * @author Brn Hurtado
 */
public class Customer {

    protected Socket socketCustomer;
    protected PrintStream out;
    public BufferedReader in;
    public String IP = "localhost";
    public String name;
    public String pass;
    private Signin sig;
    private ViewChat viewChat;
    private RegistryCustomer registry;
    private String User;
    private ArrayList<Customer> lstCustomers;
    

    
    public void registryCustomer(String name, String User, String pass) {
        lstCustomers = new ArrayList<>();
        Customer cl = new Customer(name, User, pass);
        lstCustomers.add(cl);
    }

    public boolean searchCustomer(String user) {

        boolean existe = false;
        Customer oCl;
        Iterator<Customer> oIt = lstCustomers.iterator();
        while (oIt.hasNext()) {
            oCl = (Customer) oIt.next();
            existe = oCl.getUser().equals(user);
        }
        return existe;
    }

    public boolean login(String user, String pass, int attempts) {
        Customer oCl;
        boolean login = false;
        
        Iterator<Customer> oIt = lstCustomers.iterator();
        while (oIt.hasNext()) {
            oCl = (Customer) oIt.next();
            login = (oCl.getUser().equals(user)) && (oCl.getPass().equals(pass));
        }
        
        if (attempts == 0) {
            //intentos=0;
            //garchivo.borrarChat(usuario);
            JOptionPane.showMessageDialog(viewChat, "failed attempts");
            sig.setVisible(false);
        }
        return login;
    }

    public Customer(String name, String User, String pass) {

        this.name = name;
        this.User = User;
        this.pass = pass;
    }

    public Customer() {
    }

    public void start() {
        //Mostrar la ventana de inicio de sesion
        sig = new Signin(this);
        sig.setVisible(true);
        
        registryCustomer("Brn Hurtado","admin","1234");  
    }

    public boolean connect() {
        boolean retorno = false;
        try {
            //Abre el socket en el mismo puerto que el servidor
            socketCustomer = new Socket(IP, 9002);
            out = new PrintStream(socketCustomer.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socketCustomer.getInputStream()));

            //si la conexion es exitosa entonces:
            //Oculta la ventana de inicio de sesion
            sig.setVisible(false);
            //Muestra la vista principal del chat
            viewChat = new ViewChat(this);
            viewChat.setVisible(true);
            //Inicia la clase que recibe mensajes
            new Reader(this);
            //Envia el nombre ingresado al servidor
            out.println(name);
            retorno = true;
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public void registry() {
        sig.setVisible(false);
        registry = new RegistryCustomer(this);
        registry.setVisible(true);
 
    }

    public void back() {
        sig.setVisible(true);
        registry.setVisible(false);
    }

    //Este metodo permite enviar mensajes a un cliente
    public void writeMessaje(String msj) {
        show(msj);
        out.println(msj);
    }

    //Este metodo actualiza los mensajes que se muestran en la ventana del chat
    public void show(String msj) {
        viewChat.upDateMessaje(msj);
    }

    private String getUser() {
        return User;
    }

    private String getPass() {
        return pass;
    }

    private String getNombre() {
        return name;
    }

    public static void main(String[] args) throws IOException, ConnectException {
        Customer cust = new Customer();
        cust.start();//Crea al cliente
    }

}
