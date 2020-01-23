/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualizacjaswiata;

import java.awt.EventQueue;

public class WirtualizacjaSwiata {

    public static void main(String[] args) {
       
        EventQueue.invokeLater(() -> {
            new NewJFrame().setVisible(true);
        });
    }
    
}
