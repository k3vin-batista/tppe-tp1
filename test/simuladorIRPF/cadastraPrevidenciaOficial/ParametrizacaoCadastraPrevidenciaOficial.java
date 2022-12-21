package simuladorIRPF.cadastraPrevidenciaOficial;

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
public class ParametrizacaoCadastraPrevidenciaOficial {

	 SimuladorIRPF simulador;
	 @Before
	public void setuUp() {
		 simulador = new SimuladorIRPF();
	}

	Object[][] previdenciasOficiais;
	float valueOk;

	public ParametrizacaoCadastraPrevidenciaOficial(Object[][] previdenciasOficiais, float valueOk) {
		this.previdenciasOficiais = previdenciasOficiais;
		this.valueOk = valueOk;
	}

	@Parameters
	public static Collection<Object[]>getParametres(){

		
		Object[][]resposta = new Object[][] {
			{ new Object[][]{
				{"Previdencia Oficial 1", 100f}
							}, 100f }, 

			{new Object[][]{
				{"Previdencia Oficial 2", 80f},
			}, 80f  },
			
			{ new Object[][]{
				{"Previdencia Oficial 3", 120f},
				{"Previdencia Oficial 4", 220f},
			}, 340f },
			
			{ new Object[][]{
				{"Previdencia Oficial 5", 500f},
				{"Previdencia Oficial 6", 120f},
				{"Previdencia Oficial 7", 80f},
			}, 700f },
			
		};
		
		return Arrays.asList(resposta);
	}

	@Test
	public void cadastraPrevidenciasOficiais() throws Exception {
		for(Object[]previdenciaOficial:previdenciasOficiais) {
			simulador.cadastrarPrevidenciaOficial((String)previdenciaOficial[0], (float)previdenciaOficial[1]);
		}
		assertEquals(valueOk, simulador.getValorTotalPrevidenciasOficiais(), 0f);
	}
}