package Calculadora;

public class CalculadoraClass {
    private double valorAnterior;
    public String operadorActual;
    private boolean nuevaEntrada;
    private String displayText;

    public CalculadoraClass() {
        valorAnterior = 0;
        operadorActual = "";
        nuevaEntrada = true;
        displayText = "";
    }

    public void ingresarNumero(String numero) {
        if (nuevaEntrada) {
            displayText = numero;
            nuevaEntrada = false;
        } else {
            displayText += numero;
        }
    }

    public void ingresarOperador(String operador) {
        if (!operadorActual.isEmpty()) {
            calcularResultado();
        }
        operadorActual = operador;
        valorAnterior = Double.parseDouble(displayText);
        nuevaEntrada = true;
    }

    public void calcularResultado() {
        if (!operadorActual.isEmpty()) {
            double valorActual = Double.parseDouble(displayText);
            switch (operadorActual) {
                case "+":
                    valorAnterior += valorActual;
                    break;
                case "-":
                    valorAnterior -= valorActual;
                    break;
                case "*":
                    valorAnterior *= valorActual;
                    break;
                case "/":
                    if (valorActual != 0) {
                        valorAnterior /= valorActual;
                    } else {
                        displayText = "Error: División por cero";
                        operadorActual = "";
                        return;
                    }
                    break;
            }
            displayText = String.valueOf(valorAnterior);
            operadorActual = "";
            nuevaEntrada = true;
        }
    }

    public void borrar() {
        displayText = "";
        valorAnterior = 0;
        operadorActual = "";
        nuevaEntrada = true;
    }

    public String getDisplayText() {
        return displayText;
    }

    public String getOperadorActual() {
        return operadorActual;
    }
}
