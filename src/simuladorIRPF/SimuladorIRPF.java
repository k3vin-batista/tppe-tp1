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
	private float valorTotalPrevidenciasOficiais = 0f;
	private List<PrevidenciaOficial> previdenciasOficiais;
	private float valorTotalPensaoAlimenticia;
	private List<PensaoAlimenticia> pensoesAlimenticias;

	private static List<Rendimento> rendimentos;
	
	public SimuladorIRPF() {
		rendimentos = new ArrayList<Rendimento>();
		
		dependente = new LinkedList<Dependente>();
		
		pensoesAlimenticias = new LinkedList<PensaoAlimenticia>();
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
	
	public float cadastrarPrevidenciaOficial(String descricao, float valorPrevidencia) throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {
		
		// -=-=-=-=-=-=- Validations -=-=-=-=-=-=-

		if (descricao.trim().length() < 1) {
			throw new DescricaoEmBrancoException();
		}
		
		if (valorPrevidencia <= 0) {
			throw new ValorDeducaoInvalidoException();
		}
		
		// -=-=-=-=-=-=- Business Rules -=-=-=-=-=-=-
		
		PrevidenciaOficial novaPrevidenciaOficial = new PrevidenciaOficial(descricao, valorPrevidencia);
		
		this.valorTotalPrevidenciasOficiais += novaPrevidenciaOficial.valor;
		
		return novaPrevidenciaOficial.valor;
	}

	
	public float getValorTotalPrevidenciasOficiais() {
		return this.valorTotalPrevidenciasOficiais; // teste de duplicação
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
	
	public void cadastrarPensaoAlimenticia(
			String descricaoPensaoAlimenticia, 
			float valorPensaoAlimenticia) throws Exception
	{
		if(descricaoPensaoAlimenticia.trim().length() < 1) {
			throw new DescricaoEmBrancoException();
		}
		
		if(valorPensaoAlimenticia <= 0) {
			throw new ValorDeducaoInvalidoException();
		}
		
		PensaoAlimenticia novaPensao = new PensaoAlimenticia(descricaoPensaoAlimenticia, valorPensaoAlimenticia);
		this.pensoesAlimenticias.add(novaPensao);
		
		this.valorTotalPensaoAlimenticia += valorPensaoAlimenticia;
	}
	
	public float getPensaoAlimenticia() {
		return this.valorTotalPensaoAlimenticia; // Triangulação
	}
	
}
