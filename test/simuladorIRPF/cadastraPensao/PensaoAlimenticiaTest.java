package simuladorIRPF.cadastraPensao;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import simuladorIRPF.SimuladorIRPF;

class PensaoAlimenticiaTest {

	private SimuladorIRPF simuladorIRPF;
	
	@Before
	public void setup() {
		simuladorIRPF = new SimuladorIRPF();
	}
	
	@Test
	public void testCadastroUmaPensaoAlimenticia() {
		simuladorIRPF.cadastrarPensaoAlimenticia("Primeira Pensão", 250f);
		assertEquals(250f, simuladorIRPF.getPensaoAlimenticia(), 0f);
	}
	
	@Test
	public void testCadastroUmaPensaoAlimenticiaSegunda() {
		simuladorIRPF.cadastrarPensaoAlimenticia("Primeira Pensão", 480f);
		assertEquals(480f, simuladorIRPF.getPensaoAlimenticia(), 0f);
	}
}
