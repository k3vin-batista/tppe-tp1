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
	public void testPensaoAlimenticiaUnica() {
		simuladorIRPF.cadastrarPensaoAlimenticia("Pensao", 250f);
		assertEquals(250f, simuladorIRPF.getPensaoAlimenticia(), 0f);
	}
}
