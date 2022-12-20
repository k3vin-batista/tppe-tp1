package simuladorIRPF;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Exceptions.NameIsNullTrowException;

public class SimuladorIRPF {
	private String nomeDepedente;
	private String dataDeNascimento;
	private List<Dependente> dependente;
	private float valorTotalDependente;

	private static List<Rendimento> rendimentos;
	
	public SimuladorIRPF() {
		rendimentos = new ArrayList<Rendimento>();
		
		dependente = new LinkedList<Dependente>();
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
	
	public float cadastrarDeducao(String descricao, float valor) {
		return 0f; 
	}

	public void cadastroDependente(String nomeDependente, String dataDeNascimento) throws Exception {
		if(nomeDependente.trim().length()<1) {
			throw new NameIsNullTrowException();
		}
		Dependente dependente = new Dependente(nomeDependente, dataDeNascimento);
		this.dependente.add(dependente);
		
		this.valorTotalDependente += 189.59f;
	}
	

	public float getFaixa() {
		return 0f; // Falsificacao
	}	
	
	public float getDependente() {
		return 299.99f; // Falsificação
	}
}
