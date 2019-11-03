/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dates;

import Control.Customer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author BrnH
 */
public class DataManager {
    
     private String path;

    public void setPath(String path) {
        this.path = path;
    }
    
    public void saveChat(String chat, String customer) throws IOException {

        File archivo = new File("C:/Users/USER/Desktop/" + customer + ".txt");
        String Path = archivo.getCanonicalPath();
        setPath(Path);
        FileWriter flwriter = null;
        try {
            FileOutputStream fos = new FileOutputStream(archivo.getAbsoluteFile(), true); //agrega el texto al contenido
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bfwriter = new BufferedWriter(osw);
            //Escribe el mensaje en el archivo
            bfwriter.write(chat + "\r\n");
            //cierra el buffer intermedio
            bfwriter.close();
            osw.close();
            fos.close();
            System.gc();
            //System.out.println("Archivo creado satisfactoriamente..");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void deleteChat(String user) {
        File files = new File("C:/Users/USER/Desktop/" + user + ".txt");
        files.delete();

    }

    public void saveCustomer(ArrayList<Customer> lstCustomer) {

        File arch = new File("C:/Users/USER/Desktop/admin.txt");

        FileWriter flwriter = null;

        try {
            //crea el flujo para escribir en el archivo
            FileOutputStream fos = new FileOutputStream(arch.getAbsoluteFile(), true); //agrega el texto al contenido

            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bfwriter = new BufferedWriter(osw);

            for (Customer cl : lstCustomer) {
                //escribe los datos en el archivo
                bfwriter.write(cl + "\n");
            }

            //cierra el buffer intermedio
            //cierra el buffer intermedio
            bfwriter.close();
            osw.close();
            fos.close();
            System.gc();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
