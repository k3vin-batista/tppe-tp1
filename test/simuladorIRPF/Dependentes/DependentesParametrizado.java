package simuladorIRPF.Dependentes;

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
class DependentesParametrizado {
		
	private SimuladorIRPF simuladorIRPF;
	
	@Before
	public void setup() {
		simuladorIRPF = new SimuladorIRPF();
	}
	
	// Atributos necessários para o teste
	Object[][] dependentes;
	float valorEsperado;
	
	// Construtor necessário para o objeto de teste
	public DependentesParametrizado(
			Object[][] dependentes,
			float valorEsperado
	) {
		this.dependentes = dependentes;
		this.valorEsperado = valorEsperado;
	}
	
	@Parameters
	public static Collection<Object[]>getParameters() {
		Object[][]resposta = new Object[][] {
 			{ new Object[][]{
 				{"Ana Lís", "12/10/2000"}
 							}, 223.12f }, // Caso1

 			{new Object[][]{
 				{"Lana Albuquerque", "22/08/2004"},
 			}, 189.59f  }, // Caso2

 			{ new Object[][]{
 				{"Luiz Inácio", "01/01/2002"},
 				{"Amílio Silva", "10/01/2000"},
 			}, 402.11f }, // Caso3

 			{ new Object[][]{
 				{"Larissa de Machado", "13/06/2010"},
 				{"Carla Almeida", "11/04/2013"},
 				{"Neymar", "12/02/2004"},
 			}, 568.77f }, // Caso4

 		};
 		return Arrays.asList(resposta);
	}
	
	@Test
	public void cadastrarDependente() throws Exception {
		for(Object[] dependente: dependentes) {
			simuladorIRPF.cadastroDependente((String)dependente[0], (String)dependente[1]);
		}
		assertEquals(valorEsperado, simuladorIRPF.getDependente(), 0f);
	}
}
