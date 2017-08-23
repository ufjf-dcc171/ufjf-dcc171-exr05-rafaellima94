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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ice
 */
public class CalcImposto extends JFrame {
    private final JTextField valorProduto = new JTextField(25);
    private final JLabel valorDolar = new JLabel();
    private final JCheckBox tributado = new JCheckBox("Tributar");
    private final JCheckBox icms = new JCheckBox("ICMS");
    private final JButton calcular = new JButton("Calcular");
    private final double realDolar = 3.15;
    private final double tributadoVal = 1.6;
    private final double icmsVal = 1.18;
    
    public CalcImposto() throws HeadlessException {
        super("Imposto");
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        valorDolar.setText("<html>Cotação do Dolar<br>$1.00 = R$"+realDolar+"</html>");
        
        add(valorProduto);
        add(valorDolar);
        add(tributado);
        add(icms);
        add(calcular);
        
        CalcularValor calcularValor = new CalcularValor();
        calcular.addItemListener(calcularValor);
    }
    
    private class CalcularValor implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            Integer valor = Integer.parseInt(valorProduto.getText());
            double valorTotal = 0, valorEmDolar = valor*realDolar;
            
            if(tributado.isSelected() && icms.isSelected()) {
                valorTotal = valor*tributadoVal*icmsVal;
            } else if(tributado.isSelected()) {
                valorTotal = valor*tributadoVal;
            } else if(icms.isSelected()) {
                valorTotal = valor*icmsVal;
            } else {
                valorTotal = valor;
            }
            JOptionPane.showMessageDialog(null, "Valor do produto em Dolar"+valorEmDolar+"Valor total:"+valorTotal, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        }
        
    }

}
