package simuladorIRPF.cadastraRendimento;

import simuladorIRPF.SimuladorIRPF;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class CadastrarRendimentoTest {

	SimuladorIRPF simuladorIRPF;
	private Object[][] rendimentos;
	private float expected;
	
	
	@Before
	public void setUp() {
		simuladorIRPF = new SimuladorIRPF();
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		Object[][] data = new Object[][] {
			{ new Object[][] {
				{"Salario", 5000f },
			}, 5000f },
			{ new Object[][] {
				{"Aluguel", 700f },
			}, 700f },
			{ new Object[][] {
				{"Aluguel", 1000f },
				{"Aposentadoria", 3000f },
			}, 4000f },
			{ new Object[][] {
				{"dividendos", 2000f },
				{"participaçao de lucro", 1100f },
			}, 3100f },
			{ new Object[][] {
				{"Hora extra", 250f },
			}, 250f },
			{ new Object[][] {
				{ "bolsa estagio", 800f },
				{ "Pensão" , 400f },
			}, 1200f }
		};
		
		return Arrays.asList(data);
	}
	
	public CadastrarRendimentoTest(Object[][] rendimentos, float expected) {
		this.rendimentos = rendimentos;
		this.expected = expected;
	}
	
	@Test
	public void Test() {
		for (Object[] rendimento : rendimentos) {
			simuladorIRPF.cadastrarRendimento((String)rendimento[0], (float)rendimento[1]);
		}
		assertEquals(this.expected , simuladorIRPF.getTotalRendimento(), 0f);
	}

}
