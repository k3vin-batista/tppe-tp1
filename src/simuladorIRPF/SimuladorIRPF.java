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
	private float valorTotalPrevidenciasOficiaisTriangulacao = 0f;
	private List<PrevidenciaOficial> previdenciasOficiais;
	private float valorTotalPensaoAlimenticia;
	private List<PensaoAlimenticia> pensoesAlimenticias;

	private static List<Rendimento> rendimentos;
	private float totalRendimento;;

	private float totalImposto;
	private float baseCalculo;
	private List<Imposto> impostos;


	private float aliquota;

	public SimuladorIRPF() {
		rendimentos = new ArrayList<Rendimento>();
		this.totalRendimento = 0;

		dependente = new LinkedList<Dependente>();

		pensoesAlimenticias = new LinkedList<PensaoAlimenticia>();

		previdenciasOficiais = new LinkedList<PrevidenciaOficial>();

		this.totalImposto = 0;
		this.baseCalculo = 0;
		impostos = new ArrayList<Imposto>();

		this.aliquota = 0;
	}

	public void cadastrarRendimento(String descricao, float valor) {

		Rendimento temp = new Rendimento(descricao, valor);

		Boolean adicionado = rendimentos.add(temp);

		if (adicionado) {
			this.totalRendimento += valor;
		}

	}

	public float getTotalRendimento() {
		return totalRendimento;
	}

	public float cadastrarPrevidenciaOficial(String descricao, float valorPrevidencia)
			throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {

		// -=-=-=-=-=-=- Validations -=-=-=-=-=-=-

		if (descricao.trim().length() < 1) {
			throw new DescricaoEmBrancoException();
		}

		if (valorPrevidencia <= 0) {
			throw new ValorDeducaoInvalidoException();
		}

		// -=-=-=-=-=-=- Business Rules -=-=-=-=-=-=-

		PrevidenciaOficial novaPrevidenciaOficial = new PrevidenciaOficial(descricao, valorPrevidencia);

		this.previdenciasOficiais.add(novaPrevidenciaOficial);

		this.valorTotalPrevidenciasOficiaisTriangulacao += novaPrevidenciaOficial.valor;

		return novaPrevidenciaOficial.valor;
	}

	public float getValorTotalPrevidenciasOficiais() {
		return this.valorTotalPrevidenciasOficiaisTriangulacao; // Teste de triangulação
	}

	public void cadastroDependente(String nomeDependente, String dataDeNascimento) throws Exception {
		if (nomeDependente.trim().length() < 1) {
			throw new NameIsNullTrowException();
		}
		Dependente dependente = new Dependente(nomeDependente, dataDeNascimento);
		this.dependente.add(dependente);
		this.valorTotalDependenteTriangulacao += valorDependente;
	}

	public void setarBaseCalculo(float baseCalculo) {
		this.baseCalculo = baseCalculo;
	}

	public float getBaseCalculo() {
		return this.baseCalculo;
	}

	public void calculaImposto() {

		new CalculaImposto(this).calcularImposto();

	}

	public float getTotalImposto() {
		for (Imposto i : impostos) {
			this.totalImposto += i.getValor();
		}
		return this.totalImposto;
	}

	public float getDependente() {
		return this.valorTotalDependenteTriangulacao; // Teste de Triangulacao
	}

	public void cadastrarDeducao(String descricaoDeducao, float valorDeducao) throws Exception {
		if (descricaoDeducao.trim().length() < 1) {
			throw new DescricaoEmBrancoException();
		}
		if (valorDeducao <= 0) {
			throw new ValorDeducaoInvalidoException();
		}

		Deducao deducao = new Deducao(descricaoDeducao, valorDeducao);
		this.valorTotalDeducao += valorDeducao;
	}

	public float getDeducao() {
		return this.valorTotalDeducao; // Duplicacao
	}

	public void cadastrarPensaoAlimenticia(String descricaoPensaoAlimenticia, float valorPensaoAlimenticia)
			throws Exception {
		if (descricaoPensaoAlimenticia.trim().length() < 1) {
			throw new DescricaoEmBrancoException();
		}

		if (valorPensaoAlimenticia <= 0) {
			throw new ValorDeducaoInvalidoException();
		}

		PensaoAlimenticia novaPensao = new PensaoAlimenticia(descricaoPensaoAlimenticia, valorPensaoAlimenticia);
		this.pensoesAlimenticias.add(novaPensao);

		this.valorTotalPensaoAlimenticia += valorPensaoAlimenticia;
	}

	public float getPensaoAlimenticia() {
		return this.valorTotalPensaoAlimenticia; // Triangulação
	}

	public float getAliquota() {
		return this.aliquota;
	}

	public void setarAliquota() {
		this.aliquota = (this.getTotalImposto() / this.getTotalRendimento()) * 100;
	}

	public void adicionaImposto(Imposto imposto) {
		this.impostos.add(imposto);
	}
}
