package simuladorIRPF.cadastraPrevidencia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import simuladorIRPF.SimuladorIRPF;

class PrevidenciaOficialTest {
	
	SimuladorIRPF sim;

	@BeforeEach
	public void setUp() {
		sim = new SimuladorIRPF();
	}

	@Test
	void test() {
		assertEquals(1,1);
	}

	
	@Test
	void testCadastraPrevidenciaOficial() {
		assertEquals(300f, sim.cadastrarPrevidenciaOficial(300f), 0);
	}

}


