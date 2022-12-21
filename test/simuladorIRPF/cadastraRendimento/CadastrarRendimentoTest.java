package simuladorIRPF.cadastraRendimento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import simuladorIRPF.SimuladorIRPF;

class CadastrarRendimentoTest {

	SimuladorIRPF simuladorIRPF;
	
	@BeforeEach
	public void setUp() {
		simuladorIRPF = new SimuladorIRPF();
	}
		
	@Test
	void testCadastrarRendimento1() {
		simuladorIRPF.cadastrarRendimento("salario", 3000f);
		assertEquals(3000f, simuladorIRPF.getTotalRendimento(), 0);
	}
	
	@Test
	void testCadastrarRendimento2() {
		simuladorIRPF.cadastrarRendimento("aluguel", 5000f);
		assertEquals(5000f, simuladorIRPF.getTotalRendimento(), 0);
	}
	
	@Test
	void testCadastrarRendimento3() {
		simuladorIRPF.cadastrarRendimento("dividendos", 1000f);
		simuladorIRPF.cadastrarRendimento("dividendos", 4000f);
		assertEquals(5000f, simuladorIRPF.getTotalRendimento(), 0);
	}

}
