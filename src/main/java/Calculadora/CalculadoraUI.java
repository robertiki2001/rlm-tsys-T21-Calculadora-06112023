package Calculadora;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CalculadoraUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField display;
	private JPanel panel;
    private double valorAnterior = 0;
    private String operadorActual = "";
    private boolean nuevaEntrada = true;

    public CalculadoraUI() {
        setTitle("Calculadora");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        panel = new JPanel(new BorderLayout());
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 32));
        display.setHorizontalAlignment(JTextField.LEFT);
        panel.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4));
        panel.add(buttonPanel, BorderLayout.CENTER);

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+","C"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        getContentPane().add(panel);
    }

    private class ButtonClickListener implements ActionListener {
    	private CalculadoraClass calc;
        public void actionPerformed(ActionEvent e) {     	
            String buttonText = e.getActionCommand();
            
            if (buttonText.matches("[0-9]|\\.")) {
                if (nuevaEntrada) {
                    display.setText(buttonText);
                    nuevaEntrada = false;
                } else {
                    display.setText(display.getText() + buttonText);
                }
            } else if (buttonText.equals("=")) {
                calc.calcularResultado();
            } else if (buttonText.equals("C")) {
            	calc.borrar();
            } else {
                if (!operadorActual.isEmpty()) {
                	calc.calcularResultado();
                }
                operadorActual = buttonText;
                valorAnterior = Double.parseDouble(display.getText());
                nuevaEntrada = true;
            }
        }

        
    }
    
    
}
