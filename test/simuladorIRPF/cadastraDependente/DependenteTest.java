package simuladorIRPF.cadastraDependente;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simuladorIRPF.SimuladorIRPF;

class DependenteTest {

	 SimuladorIRPF SimuladorIRPF;

	 @BeforeEach
    public void setup(){
		 SimuladorIRPF = new SimuladorIRPF();
    }

	@Test
    public void testeCadastraDependente() throws Exception{
		SimuladorIRPF.cadastroDependente("Ailton", "01/10/1990");
        assertEquals(299.99f, SimuladorIRPF.getDependente(),0f);
    }
	
	@Test
    public void testeCadastraDependente2() throws Exception{
		SimuladorIRPF.cadastroDependente("Ailton Aires", "01/10/1990");
        assertEquals(299.99f, SimuladorIRPF.getDependente(),0f);
    }

}
