package simuladorIRPF.cadastraDeducao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import simuladorIRPF.SimuladorIRPF;

public class DeducaoTest {

	private SimuladorIRPF simul;

    @Before
    public void setup(){
        simul = new SimuladorIRPF();
    }
    
	@Test
    public void testeCadastraDeducao() {
        simul.cadastrarDeducao("Previdencia privada", 1500f);
        
        assertEquals(1500f, simul.getDeducao(),0f);
    }

}
