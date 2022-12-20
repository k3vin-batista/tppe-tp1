package simuladorIRPF.cadastraPrevidenciaOficial;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import simuladorIRPF.SimuladorIRPF;

import org.junit.jupiter.api.BeforeEach;

class CadastrarPrevidenciaOficial {
	
	SimuladorIRPF sim;

	@BeforeEach
	public void setUp() {
		sim = new SimuladorIRPF();
	}

	@Test
	void testCadastraPrevidenciaOficial() {
		assertEquals(350f, sim.getValorTotalPrevidenciasOficiais(), 0);
	}

}


