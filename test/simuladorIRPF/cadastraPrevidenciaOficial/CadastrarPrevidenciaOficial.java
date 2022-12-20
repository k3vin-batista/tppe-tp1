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
		assertEquals(300f, sim.cadastrarPrevidenciaOficial(300f), 0);
	}
	
	@Test
	void testCadastraPrevidenciaOficialCase2() {
		assertEquals(150f, sim.cadastrarPrevidenciaOficial(150f), 0);
	}
	
	@Test
	void testCadastraPrevidenciaOficialCase3() {
		sim.cadastrarPrevidenciaOficial(150f);
		float valorPrevidenciaOficial = sim.getValorPrevidenciaOficial();
		
		assertEquals(150f, valorPrevidenciaOficial, 0);
	}
	
	@Test
	void testCadastraPrevidenciaOficialCase4() {
		sim.cadastrarPrevidenciaOficial(1100f);
		float valorPrevidenciaOficial = sim.getValorPrevidenciaOficial();
		
		assertEquals(1100f, valorPrevidenciaOficial, 0);
	}

}


