package simuladorIRPF.calculaImposto;

import static org.junit.jupiter.api.Assertions.*;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import simuladorIRPF.SimuladorIRPF;

@RunWith(Parameterized.class)
public class ImpostoTesteParametrizado {

	SimuladorIRPF simulador;
	Object[][] rendimentos;
	Object[][] deducoes;
	private float totalImpostoEsperado; 
	private float baseCalculoEsperado;
	
	public ImpostoTesteParametrizado(Object[][] rendimentos, Object[][] deducoes, float totalImpostoEsperado, float baseCalculoEsperado){
		this.rendimentos = rendimentos;
		this.deducoes = deducoes;
		this.totalImpostoEsperado = totalImpostoEsperado;
		this.baseCalculoEsperado = baseCalculoEsperado;
	}

	@Before
	public void setUp() {
		simulador = new SimuladorIRPF();
	}

	@Parameters
	public static Iterable getParameters() {
		Object[][] dados = new Object[][] {
			{ new Object[][] {
				{"Aluguel", 3903.98f },
			}, new Object[][] {
				{"Aluguel Deducao", 2000f},
			}, 0f,  1903.98f },
			{ new Object[][] {
				{"Aluguel", 5670.68f },
			}, new Object[][] {
				{"Aluguel Deducao", 1500f},
			}, 300.92f ,  4170.68f },
			{ new Object[][] {
				{"Aluguel", 4594.68f },
			}, new Object[][] {
				{"Aluguel Deducao", 800f},
			}, 217.67f ,  3794.68f },
			{ new Object[][] {
				{"Aluguel", 7840.05f },
			}, new Object[][] {
				{"Aluguel Deducao", 4000f},
			}, 227.86f ,  3840.05f },
			{ new Object[][] {
				{"Aluguel", 3826.65f },
			}, new Object[][] {
				{"Aluguel Deducao", 1000f},
			}, 69.20f ,  2826.65f},
			{ new Object[][] {
				{ "Reserva", 4113.33f },
				{ "Imovel" , 2927.32f }
			}, new Object[][] {
				{"Reserva Deducao", 1900f},
				{"Imovel Deducao", 1500f}
			}, 191.30f ,  3640.65f},
		};

		return Arrays.asList(dados);
	}


	@Test
	public void TestTotalImposto() throws Exception{ 
		for (Object[] rendimento : rendimentos) {
			simulador.cadastrarRendimento((String)rendimento[0], (float)rendimento[1]);
		}
		for (Object[] deducao : deducoes) {
			simulador.cadastrarDeducao((String)deducao[0], (float)deducao[1]);
		}
		simulador.setarBaseCalculo(simulador.getTotalRendimento() - simulador.getDeducao());
		simulador.calculaImposto();
		assertEquals(this.totalImpostoEsperado, simulador.getTotalImposto(), 2f);
	}

	@Test
	public void TestBaseCalculo() throws Exception{ 
		for (Object[] rendimento : rendimentos) {
			simulador.cadastrarRendimento((String)rendimento[0], (float)rendimento[1]);
		}
		for (Object[] deducao : deducoes) {
			simulador.cadastrarDeducao((String)deducao[0], (float)deducao[1]);
		}
		simulador.setarBaseCalculo(simulador.getTotalRendimento() - simulador.getDeducao());
		simulador.calculaImposto();
		assertEquals(this.baseCalculoEsperado, simulador.getBaseCalculo(), 2f);
	}
}
