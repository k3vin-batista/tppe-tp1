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
		simuladorIRPF.cadastrarRendimento("Aluguel", 2903.98f); // teste duplicacao faixa 1
		simuladorIRPF.cadastrarDeducao("Aluguel Deducao", 1000f);
		simuladorIRPF.calculaImposto();
		assertEquals(0f , simuladorIRPF.getTotalImposto(), 2f);
	}

	@Test
	public void Test2() throws Exception{ 
		simuladorIRPF.cadastrarRendimento("Aluguel", 3826.65f); // teste duplicacao faixa 2
		simuladorIRPF.cadastrarDeducao("Aluguel Deducao", 1000f);
		simuladorIRPF.calculaImposto();
		assertEquals(69.20f , simuladorIRPF.getTotalImposto(), 2f);
	}

	@Test
	public void Test3() throws Exception{ 
		simuladorIRPF.cadastrarRendimento("Aluguel", 4751.05f); // teste duplicacao faixa 3
		simuladorIRPF.cadastrarDeducao("Aluguel Deducao", 1000f);
		simuladorIRPF.calculaImposto();
		assertEquals(207.86f , simuladorIRPF.getTotalImposto(), 2f);
	}

	@Test
	public void Test4() throws Exception{ 
		simuladorIRPF.cadastrarRendimento("Aluguel", 5664.68f); // teste duplicacao faixa 4
		simuladorIRPF.cadastrarDeducao("Aluguel Deducao", 1000f);
		simuladorIRPF.calculaImposto();
		assertEquals(413.42f , simuladorIRPF.getTotalImposto(), 2f);
	}
	
	@Test
	public void Test5() throws Exception{ 
		simuladorIRPF.cadastrarRendimento("Aluguel", 5664.68f); // teste duplicacao faixa 5
		simuladorIRPF.cadastrarDeducao("Aluguel Deducao", 500f);
		simuladorIRPF.calculaImposto();
		assertEquals(550.92f , simuladorIRPF.getTotalImposto(), 2f);
	}

}
