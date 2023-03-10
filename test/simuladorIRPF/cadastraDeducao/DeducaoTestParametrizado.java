package simuladorIRPF.cadastraDeducao;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import simuladorIRPF.SimuladorIRPF;

@RunWith(Parameterized.class)
public class DeducaoTestParametrizado {
	
	private SimuladorIRPF simul;

    @Before
    public void setup(){
        simul = new SimuladorIRPF();
    }
	
	//Atributos do obj de teste
	Object[][] deducoes;
	float valorEsperado;
	
	
	//construtor obj de teste
	public DeducaoTestParametrizado(Object[][] deducao,float valorEsperado) {
		this.deducoes=deducao;
		this.valorEsperado=valorEsperado;
	}
	
	@Parameters
	public static Collection<Object[]>getParametres(){

		
		Object[][]resposta = new Object[][] {
			{ new Object[][]{
				{"Previdencia Privada",1000f}
							}, 1000f },// caso1

			{new Object[][]{
				{"Previdencia Privada",800f},
			}, 800f  },// caso2
			
			{ new Object[][]{
				{"Previdencia Privada",1000f},
				{"Funpresp",800f},
			}, 1800f },// caso3
			
			{ new Object[][]{
				{"Previdencia Privada",1000f},
				{"Funpresp",800f},
				{"Funpresp 2",200f},
			}, 2000f },// caso4
			
		};
		
		return Arrays.asList(resposta);
	}
	
	
	
	
	@Test
	public void cadastroDeducoes() throws Exception {
		for(Object[]deducao:deducoes) {
			simul.cadastrarDeducao((String)deducao[0], (Float)deducao[1]);
		}
		assertEquals(valorEsperado, simul.getDeducao(),0f);
	}

}
