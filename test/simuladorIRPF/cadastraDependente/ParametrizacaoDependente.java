package simuladorIRPF.cadastraDependente;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import simuladorIRPF.SimuladorIRPF;

@RunWith(Parameterized.class)
public class ParametrizacaoDependente {

	 SimuladorIRPF SimuladorIRPF;
	 @Before
	public void setuUp() {
		 SimuladorIRPF = new SimuladorIRPF();
	}

	//Atributos
	Object[][] dependentes;
	float valueOk;

	//Construtor
	public ParametrizacaoDependente(Object[][] dependentes, float valueOk) {
		this.dependentes=dependentes;
		this.valueOk=valueOk;
	}

	@Parameters
	public static Collection<Object[]>getParametres(){
		Object[][]res = new Object[][] {
			{new Object[][]{{"Ailton", "01/10/1990"}}, 299.99f },

			{new Object[][]{{"Ailton", "01/10/1990"},{"Aires", "01/10/1990"},}, 599.98f },

			{new Object[][]{{"Ailton", "01/10/1990"},{"Aires", "01/10/1990"},{"Amado", "01/10/1990"},}, 899.97f }, 

		};	
		return Arrays.asList(res);
	}

	@Test
	public void cadastraDependente() throws Exception {
		for(Object[]dependente:dependentes) {
			SimuladorIRPF.cadastroDependente((String)dependente[0], (String)dependente[1]);
		}
		assertEquals(valueOk, SimuladorIRPF.getDependente(),0f);
	}
}