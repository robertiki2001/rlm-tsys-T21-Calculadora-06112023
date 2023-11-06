package CalculadoraTest;
import org.junit.Test;

import Calculadora.CalculadoraClass;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;

public class CalculadoraClassTest {
	
	private CalculadoraClass calculadora;
	
   @Before
    public void setUp() { // Configuración inicial antes de ejecutar cada prueba
        calculadora = new CalculadoraClass();
    }

    @After
    public void tearDown() { //Limpieza después de cada prueba 
        calculadora = null;
    }

    @Test
    public void testIngresarNumero() {
        calculadora.ingresarNumero("5");
        assertEquals("5", calculadora.getDisplayText());
    }
    
    @Test
    public void testIngresarOperador() {
        CalculadoraClass calculadora = new CalculadoraClass();
        calculadora.ingresarNumero("5");
        calculadora.ingresarOperador("+");
        String operadorAntes = calculadora.getOperadorActual();

        calculadora.ingresarOperador("-");
        String operadorDespues = calculadora.getOperadorActual();

        assertNotEquals(operadorAntes, operadorDespues);

        calculadora.ingresarOperador("*");
        operadorAntes = calculadora.getOperadorActual();

        calculadora.ingresarOperador("/");
        operadorDespues = calculadora.getOperadorActual();

        assertNotEquals(operadorAntes, operadorDespues);
    }
    
    
    @Test
    public void testIngresarNumeroCuandoNuevaEntradaEsFalse() {
        calculadora.ingresarNumero("5");
        calculadora.ingresarNumero("7");
        assertEquals("57", calculadora.getDisplayText());
    }

    @Test
    public void testSuma() {
        calculadora.ingresarNumero("5");
        calculadora.ingresarOperador("+");
        assertEquals("5", calculadora.getDisplayText());
        assertEquals("+", calculadora.getOperadorActual());
    }

    @Test
    public void testCalcularResultado() {
        calculadora.ingresarNumero("5");
        calculadora.ingresarOperador("+");
        calculadora.ingresarNumero("3");
        calculadora.calcularResultado();
        assertEquals("8.0", calculadora.getDisplayText());
        assertEquals("", calculadora.getOperadorActual());
    }
    
    @Test
    public void testCalcularResta() {
        calculadora.ingresarNumero("5");
        calculadora.ingresarOperador("-");
        calculadora.ingresarNumero("3");
        calculadora.calcularResultado();
        assertEquals("2.0", calculadora.getDisplayText());
        assertEquals("", calculadora.getOperadorActual());
    }
    
    @Test
    public void testCalcularDivision() {
        calculadora.ingresarNumero("6");
        calculadora.ingresarOperador("/");
        calculadora.ingresarNumero("3");
        calculadora.calcularResultado();
        assertEquals("2.0", calculadora.getDisplayText());
        assertEquals("", calculadora.getOperadorActual());
    }
    
    @Test
    public void testCalcularMultiplicacion() {
        calculadora.ingresarNumero("6");
        calculadora.ingresarOperador("*");
        calculadora.ingresarNumero("3");
        calculadora.calcularResultado();
        assertEquals("18.0", calculadora.getDisplayText());
        assertEquals("", calculadora.getOperadorActual());
    }
    
    
    @Test
    public void testDivisionPorCero() {
        calculadora.ingresarNumero("5");
        calculadora.ingresarOperador("/");
        calculadora.ingresarNumero("0");
        calculadora.calcularResultado();
        assertEquals("Error: División por cero", calculadora.getDisplayText());
        assertEquals("", calculadora.getOperadorActual());
    }

    @Test
    public void testBorrar() {
        calculadora.ingresarNumero("5");
        calculadora.borrar();
        assertEquals("", calculadora.getDisplayText());
    }
}
