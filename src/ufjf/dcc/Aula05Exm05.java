/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.dcc;

import javax.swing.JFrame;

/**
 *
 * @author ice
 */
public class Aula05Exm05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CalcImposto calcImposto = new CalcImposto();
        calcImposto.setSize(400, 200);
        calcImposto.setLocationRelativeTo(null);
        calcImposto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcImposto.setVisible(true);
    }
    
}
