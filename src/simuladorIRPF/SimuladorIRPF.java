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
	private float totalRendimento;;
	
	private float totalImposto;
	private float baseCalculo;
	private static List<Imposto> impostos;

	
	public SimuladorIRPF() {
		rendimentos = new ArrayList<Rendimento>();
		this.totalRendimento = 0;
		
		dependente = new LinkedList<Dependente>();
		
		pensoesAlimenticias = new LinkedList<PensaoAlimenticia>();
		
		this.totalImposto = 0;
		this.baseCalculo = 0;
		impostos = new ArrayList<Imposto>();
	}
	
	

	public void cadastrarRendimento(String descricao, float valor) {
		
		
		Rendimento temp = new Rendimento(descricao, valor);
		
		Boolean adicionado = rendimentos.add(temp);
		
		if(adicionado) {
			this.totalRendimento += valor;
		}
	
	}
	
	public float getTotalRendimento() {
		return totalRendimento;
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
	
	public void setarBaseCalculo(float baseCalculo) {
		this.baseCalculo = baseCalculo;
	}

	public float getBaseCalculo() {
		return this.baseCalculo;
	}
	
	public void calculaImposto() {
		
		Imposto imp;
		float base = this.baseCalculo;

		if (base > 1903.98f){
            
			// segunda faixa
            base -= 1903.98f;
            imp = new Imposto((Math.min(base, 922.67f) * 7.5f/100), 2); 
            impostos.add(imp);
            if(base > 922.67f) {
                
            	// terceira faixa
                base -= 922.67f;
                imp = new Imposto((Math.min(base, 924.40f) * 15f/100), 3); 
                impostos.add(imp);
                if (base > 924.40f) {
                    
                	// quarta faixa
                    base -= 924.40f;
                    imp = new Imposto((Math.min(base, 913.63f) * 22.5f/100), 4);
                    impostos.add(imp);
                    if(base > 913.63f) {
                        
                    	// quinta faixa
                        base -= 913.63f;
                        imp = new Imposto(( base * 27.5f/100), 5);
                        impostos.add(imp);

                    }
                }
            }    
        }
	}

	public float getTotalImposto() {
		for(Imposto i : impostos){
			this.totalImposto += i.getValor();
		}
		return this.totalImposto;
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
