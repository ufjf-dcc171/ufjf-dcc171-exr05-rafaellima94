/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.dcc;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ice
 */
public class CalcImposto extends JFrame {
    private final JTextField valorProduto = new JTextField(25);
    private final JLabel valorProdutoDolar = new JLabel();
    private final JLabel valorDolar = new JLabel();
    private final JCheckBox foiTributado = new JCheckBox("Tributar");
    private final JCheckBox icms = new JCheckBox("ICMS");
    private final JButton calcular = new JButton("Calcular");
    private final double realDolar = 3.15;
    
    public CalcImposto() throws HeadlessException {
        super("Imposto");
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        valorDolar.setText("<html>Cotação do Dolar<br>$1.00 = R$"+realDolar+"</html>");
        
        add(valorProduto);
        add(valorProdutoDolar);
        add(valorDolar);
        add(foiTributado);
        add(icms);
        add(calcular);
        
        CalcularValor calcularValor = new CalcularValor();
        calcular.addItemListener(calcularValor);
        //chkNegrito.addItemListener(trocaFonte);
        //chkItalico.addItemListener(trocaFonte);
    }
    
    private class CalcularValor implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            Integer valor = Integer.parseInt(valorProduto.getText());
            valorProdutoDolar.setText("<html>Valor do produto em Dolar<br>$"+valor*realDolar);
        }
        
    }

}
