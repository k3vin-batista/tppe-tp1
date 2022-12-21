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
	public void testCadastroUmaPensaoAlimenticia() throws Exception {
		simuladorIRPF.cadastrarPensaoAlimenticia("Primeira Pensão", 250f);
		assertEquals(250f, simuladorIRPF.getPensaoAlimenticia(), 0f);
	}
	
	@Test
	public void testCadastroUmaPensaoAlimenticiaSegunda() throws Exception {
		simuladorIRPF.cadastrarPensaoAlimenticia("Primeira Pensão", 480f);
		assertEquals(480f, simuladorIRPF.getPensaoAlimenticia(), 0f);
	}
	
	@Test
	public void testCadastroDuasPensaoAlimenticia() throws Exception {
		simuladorIRPF.cadastrarPensaoAlimenticia("Primeira Pensão", 480f);
		simuladorIRPF.cadastrarPensaoAlimenticia("Segunda Pensão", 250f);
		assertEquals(730f, simuladorIRPF.getPensaoAlimenticia(),0f);
	}
}
