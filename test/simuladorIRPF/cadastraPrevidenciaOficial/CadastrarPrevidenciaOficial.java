package simuladorIRPF.cadastraPrevidenciaOficial;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorDeducaoInvalidoException;
import simuladorIRPF.SimuladorIRPF;

import org.junit.jupiter.api.BeforeEach;

class CadastrarPrevidenciaOficial {
	
	SimuladorIRPF sim;

	@BeforeEach
	public void setUp() {
		sim = new SimuladorIRPF();
	}

	@Test
	void testCadastraDuasPrevidenciasOficiais() throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {
		assertEquals(sim.cadastrarPrevidenciaOficial("Previdencia Oficial 1", 150.00f), 150f, 0);
		assertEquals(sim.cadastrarPrevidenciaOficial("Previdencia Oficial 2", 300.00f), 300f, 0);

		assertEquals(450f, sim.getValorTotalPrevidenciasOficiais(), 0f);
	}

}


