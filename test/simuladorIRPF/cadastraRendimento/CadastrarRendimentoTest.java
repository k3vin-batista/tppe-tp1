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
		assertEquals(3000f, simuladorIRPF.cadastrarRendimento("salario", 3000f), 0);
	}
	
	@Test
	void testCadastrarRendimento2() {
		assertEquals(5000f, simuladorIRPF.cadastrarRendimento("aluguel", 5000f), 0);
	}
	
	@Test
	void testCadastrarRendimento3() {
		assertEquals(1000f, simuladorIRPF.cadastrarRendimento("dividendos", 1000f), 0);
		assertEquals(5000f, simuladorIRPF.cadastrarRendimento("dividendos", 4000f), 0);
	}

}
