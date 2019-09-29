/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import java.io.*;
import Control.Customer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
/**
 *
 * @author Brn Hurtado
 */
class Reader extends Thread {

    private Customer clientChat;

    public Reader(Customer clientChat) {
        this.clientChat = clientChat;
        start();
    }

    public void run() {
        String line = null;
        try {
            while ((line = clientChat.in.readLine()) != null) {
                clientChat.show(line + System.getProperty("line.separator"));
            }
        } catch (IOException e2) {
        }
    }
}
