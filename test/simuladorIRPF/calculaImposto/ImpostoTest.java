package simuladorIRPF.calculaImposto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import simuladorIRPF.SimuladorIRPF;

class ImpostoTest {
	
SimuladorIRPF simuladorIRPF;
	
	@BeforeEach
	public void setUp() {
		simuladorIRPF = new SimuladorIRPF();
	}


	@Test
	public void Test() throws Exception{
		simuladorIRPF.cadastrarRendimento("Aluguel", 1f);
		simuladorIRPF.cadastrarDeducao("Aluguel Deducao", 1f);
		assertEquals(0f , simuladorIRPF.getFaixaDeImposto(), 0f); // falsificacao
	}

}
