package simuladorIRPF;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Exceptions.NameIsNullTrowException;
import Exceptions.DescricaoEmBrancoException;
import Exceptions.ValorDeducaoInvalidoException;

public class SimuladorIRPF {

	private List<Dependente> dependente;
	private String descricaoDeducao;
	private float valorDeducao;
	private float valorTotalDependente;
	private List<Deducao> deducoes;
	private float valorTotalDeducao;
	private float valorTotalDependenteTriangulacao;
	private float valorDependente = 299.99f;
	

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
	
	public void cadastroDependente(String nomeDependente, String dataDeNascimento) throws Exception {
		if(nomeDependente.trim().length()<1) {
			throw new NameIsNullTrowException();
		}
		Dependente dependente = new Dependente(nomeDependente, dataDeNascimento);
		this.dependente.add(dependente);
		this.valorTotalDependenteTriangulacao += valorDependente;
	}
	

	public float getFaixa() {
		return 0f; // Falsificacao
	}	
	
	public float getDependente() {
		return this.valorTotalDependenteTriangulacao; // Teste de Triangulacao
	}

	public void cadastrarDeducao(String descricaoDeducao, float valorDeducao) throws Exception  {
		if(descricaoDeducao.trim().length()<1) {
			throw new DescricaoEmBrancoException();
		}
		if(valorDeducao<=0) {
			throw new ValorDeducaoInvalidoException();
		}
		
		Deducao deducao = new Deducao(descricaoDeducao,valorDeducao);
		this.valorTotalDeducao += valorDeducao;	
	}

	public float getDeducao() {
		return this.valorTotalDeducao ; //Duplicacao
	}
	
}
