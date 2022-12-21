package simuladorIRPF.aliquota;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;


import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import simuladorIRPF.SimuladorIRPF;

@RunWith(Parameterized.class)
public class AliquotaTestParametrizado {
	
	SimuladorIRPF simuladorIRPF;
	private Object[][] rendimentos;
	private Object[][] deducoes;
	private float aliquotaEfetivaEsperado;
	
	public AliquotaTestParametrizado(Object[][] rendimentos, Object[][] deducoes, float aliquotaEfetivaEsperado){
		this.rendimentos = rendimentos;
		this.deducoes = deducoes;
		this.aliquotaEfetivaEsperado = aliquotaEfetivaEsperado;
	}
	
	@Before
	public void setUp() {
		simuladorIRPF = new SimuladorIRPF();
	}

	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] dados = new Object[][] {
			{ new Object[][] {
				{"Aluguel", 2903.98f },
			}, new Object[][] {
				{"Aluguel Deducao", 1000f},
			}, 0f },
			{ new Object[][] {
				{"Aluguel", 5664.68f },
			}, new Object[][] {
				{"Aluguel Deducao", 500f},
			}, 9.72f },
			{ new Object[][] {
				{"Aluguel", 5664.68f },
			}, new Object[][] {
				{"Aluguel Deducao", 1000f},
			}, 7.29f },
			{ new Object[][] {
				{"Aluguel", 4751.05f },
			}, new Object[][] {
				{"Aluguel Deducao", 1000f},
			}, 4.37f },
			{ new Object[][] {
				{"Aluguel", 3826.65f },
			}, new Object[][] {
				{"Aluguel Deducao", 1000f},
			}, 1.8f},
			{ new Object[][] {
				{ "Reserva", 1913.33f },
				{ "Imovel" , 1913.32f }
			}, new Object[][] {
				{"Reserva Deducao", 500f},
				{"Imovel Deducao", 500f}
			}, 0f},
		};

		return Arrays.asList(dados);
	}
	
	@Test
	public void Test() throws Exception{ 
		for (Object[] rendimento : rendimentos) {
			simuladorIRPF.cadastrarRendimento((String)rendimento[0], (float)rendimento[1]);
		}
		for (Object[] deducao : deducoes) {
			simuladorIRPF.cadastrarDeducao((String)deducao[0], (float)deducao[1]);
		}
		simuladorIRPF.setarBaseCalculo(simuladorIRPF.getTotalRendimento() - simuladorIRPF.getDeducao());
		simuladorIRPF.calculaImposto();
		simuladorIRPF.setarAliquota();
		assertEquals(this.aliquotaEfetivaEsperado, simuladorIRPF.getAliquota(), 2f);
	}

}
