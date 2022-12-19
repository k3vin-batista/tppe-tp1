package simuladorIRPF.cadastraRendimento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import simuladorIRPF.SimuladorIRPF;

class CadastrarRendimentoTest {

	@Test
	void testCadastrarRendimento() {
		assertEquals(3000f, SimuladorIRPF.cadastrarRendimento("salario", 3000f), 0);
	}

}
