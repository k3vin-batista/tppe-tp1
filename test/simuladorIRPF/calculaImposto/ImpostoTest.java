package simuladorIRPF.calculaImposto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import simuladorIRPF.SimuladorIRPF;

class ImpostoTest {
	
SimuladorIRPF simuladorIRPF;
	
	@BeforeEach
	public void setUp() {
		simuladorIRPF = new SimuladorIRPF();
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void Test() throws Exception{
		simuladorIRPF.cadastrarRendimento("Aluguel", 0f);
		simuladorIRPF.cadastrarDeducao("Aluguel Deducao", 0f);
		assertEquals(0f , simuladorIRPF.getFaixa(), 0f);
	}

}
