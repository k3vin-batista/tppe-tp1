package simuladorIRPF.aliquota;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import simuladorIRPF.SimuladorIRPF;

class AliquotaTest {



		SimuladorIRPF simuladorIRPF;

		@BeforeEach
		public void setUp() {
			simuladorIRPF = new SimuladorIRPF();
		}

		@Test
		public void Test() throws Exception{ 
			simuladorIRPF.cadastrarRendimento("dividendos", 1f);
			simuladorIRPF.cadastrarDeducao("dividendos", 1f);
			simuladorIRPF.setarBaseCalculo(simuladorIRPF.getTotalRendimento() - simuladorIRPF.getDeducao());
			simuladorIRPF.calculaImposto();
			simuladorIRPF.setAliquota( (simuladorIRPF.getTotalImposto()/simuladorIRPF.getTotalRendimento() )* 100);
			assertEquals(0, simuladorIRPF.getAliquota(), 2f);
		}

	}


