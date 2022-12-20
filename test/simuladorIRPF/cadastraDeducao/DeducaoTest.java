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
    
//	@Test
//    public void testeCadastraDeducaoUm() {
//        simul.cadastrarDeducao("Previdencia privada", 1500f);
//        
//        assertEquals(1500f, simul.getDeducao(),0f);
//    }
//
//	@Test
//    public void testeCadastraDeducaoDois() {
//        simul.cadastrarDeducao("Previdencia privada", 1200f);
//        
//        assertEquals(1200f, simul.getDeducao(),0f);
//    }
	
	@Test
    public void testeCadastraDuasDeducao() throws Exception {
        simul.cadastrarDeducao("Previdencia privada", 1500f);
        simul.cadastrarDeducao("Funpresp", 1200f);
        
        assertEquals(2700f, simul.getDeducao(),0f);
    }
	
}
