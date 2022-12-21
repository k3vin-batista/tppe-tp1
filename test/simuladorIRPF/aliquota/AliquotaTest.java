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
		public void TestaAliquotaEfetiva1() throws Exception{ 	
			simuladorIRPF.cadastrarRendimento("dividendos", 2903.98f);
			simuladorIRPF.cadastrarDeducao("dividendos", 1000f);
			simuladorIRPF.setarBaseCalculo(simuladorIRPF.getTotalRendimento() - simuladorIRPF.getDeducao());
			simuladorIRPF.calculaImposto();
			simuladorIRPF.setarAliquota();
			assertEquals(0f, simuladorIRPF.getAliquota(), 2f);
		}
		
		@Test
		public void TestaAliquotaEfetiva2() throws Exception{ 
			simuladorIRPF.cadastrarRendimento("dividendos", 6456.54f);
			simuladorIRPF.cadastrarDeducao("dividendos", 1000f);
			simuladorIRPF.setarBaseCalculo(simuladorIRPF.getTotalRendimento() - simuladorIRPF.getDeducao());
			simuladorIRPF.calculaImposto();
			simuladorIRPF.setarAliquota();
			assertEquals(9.77, simuladorIRPF.getAliquota(), 2f);
		}
		
		@Test
		public void TestaAliquotaEfetiva3() throws Exception{ 
			simuladorIRPF.cadastrarRendimento("Aluguel", 4664.68f);
			simuladorIRPF.cadastrarDeducao("Aluguel", 800f);
			simuladorIRPF.setarBaseCalculo(simuladorIRPF.getTotalRendimento() - simuladorIRPF.getDeducao());
			simuladorIRPF.calculaImposto();
			simuladorIRPF.setarAliquota();
			assertEquals(5.00f, simuladorIRPF.getAliquota(), 2f);
		}

	}


