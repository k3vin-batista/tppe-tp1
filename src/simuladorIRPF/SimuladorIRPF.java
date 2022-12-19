package simuladorIRPF;

import java.util.ArrayList;
import java.util.List;

public class SimuladorIRPF {

	private static List<Rendimento> rendimentos;
	
	public SimuladorIRPF() {
		rendimentos = new ArrayList<Rendimento>();
	}

	public float cadastrarRendimento(String descricao, float valor) {
		
		float totalRendimentos = 0;
		Rendimento temp = new Rendimento(descricao, valor);
		
		Boolean adicionado = rendimentos.add(temp);
		
		if(adicionado) {
			for (Rendimento r : rendimentos)
				totalRendimentos += r.getValor();
		}
		
		return totalRendimentos;
	}

}
