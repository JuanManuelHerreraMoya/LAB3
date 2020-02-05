package edu.eci.cvds.tdd.aerodescuentos;

import edu.eci.cvds.tdd.aerodescuentos.CalculadorDescuentos;
import org.junit.Assert;
import org.junit.Test;

public class TarifaTest {
	private CalculadorDescuentos descuentos = new CalculadorDescuentos();
	@Test 
	public void descuentoDeEdad() {
		double valorMenorEdad = descuentos.calculoTarifa(100000.0,1,17);
		Assert.assertEquals(95000.0,valorMenorEdad,0.5);

		
	}
	@Test
	public void descuentoTerceraEdadYDiasAntelacion(){
		double valorInferior = descuentos.calculoTarifa(100000.0,25,64);
		double valorLimite = descuentos.calculoTarifa(100000.0,25,65);
		double valorSuperior = descuentos.calculoTarifa(100000.0,25,66);
		Assert.assertEquals(85000.0,valorInferior,0.5);
		Assert.assertEquals(85000.0,valorLimite,0.5);
		Assert.assertEquals(77000.0,valorSuperior,0.5);
	}
	
	
	@Test
	public void descuentoDiasAntelacion(){
		double valorInferior = descuentos.calculoTarifa(100000.0,19,25);
		double valorLimite = descuentos.calculoTarifa(100000.0,20,25);
		double valorSuperior = descuentos.calculoTarifa(100000.0,21,25);
		Assert.assertEquals(100000.0,valorInferior,0.5);
		Assert.assertEquals(100000.0,valorLimite,0.5);
		Assert.assertEquals(85000.0,valorSuperior,0.5);	
	}
	
	@Test
	public void descuentoDiasAntelacionYMenorDeEdad(){
		double valorInf = descuentos.calculoTarifa(100000.0,30,17);
		Assert.assertEquals(80000.0,valorInf,0.5);
	}
	
	@Test
	public void descuentoDiasAntelacionYMayorDeEdad(){
		double valorMayorEdad = descuentos.calculoTarifa(100000.0,30,18);
		double valorSup = descuentos.calculoTarifa(100000.0,30,19);
		Assert.assertEquals(85000.0,valorMayorEdad,0.5);
		Assert.assertEquals(85000.0,valorSup,0.5);
	}
	
}