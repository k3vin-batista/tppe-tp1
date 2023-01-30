package simuladorIRPF;

public class CalculaImposto {
	private SimuladorIRPF simulador;
	//private Imposto impostoTemp;
	//private float baseCalculo;
	private static final float LIMITE_1_FAIXA = 1903.98f;
	private static final float LIMITE_2_FAIXA = 922.67f;
	private static final float LIMITE_3_FAIXA = 924.40f;
	private static final float LIMITE_4_FAIXA = 913.63f;
	private static final float ALIQUOTA_1_FAIXA = 7.5f/100;
	private static final float ALIQUOTA_2_FAIXA = 15f/100;
	private static final float ALIQUOTA_3_FAIXA = 22.5f/100;
	private static final float ALIQUOTA_4_FAIXA = 27.5f/100;
	private float baseCalculo1Faixa;
	private float baseCalculo2Faixa;
	private float baseCalculo3Faixa;
	private float baseCalculo4Faixa;
	private float baseCalculo5Faixa;
	

	public CalculaImposto(SimuladorIRPF simuladorFonte) {
		this.simulador = simuladorFonte;
		this.baseCalculo1Faixa = this.simulador.getBaseCalculo();
		this.baseCalculo2Faixa = baseCalculo1Faixa - LIMITE_1_FAIXA;
		this.baseCalculo3Faixa = baseCalculo2Faixa - LIMITE_2_FAIXA;
		this.baseCalculo4Faixa = baseCalculo3Faixa - LIMITE_3_FAIXA;
		this.baseCalculo5Faixa = baseCalculo4Faixa - LIMITE_4_FAIXA;
	}


	public void calcularImposto() {
		if (this.baseCalculo1Faixa > LIMITE_1_FAIXA) {
			// segunda faixa
			this.simulador.adicionaImposto(new Imposto((Math.min(this.baseCalculo2Faixa, LIMITE_2_FAIXA) * ALIQUOTA_1_FAIXA), 2));
			
			if (this.baseCalculo2Faixa > LIMITE_2_FAIXA) {
				// terceira faixa
				this.simulador.adicionaImposto(new Imposto((Math.min(this.baseCalculo3Faixa, LIMITE_3_FAIXA) * ALIQUOTA_2_FAIXA), 3));
				
				if (this.baseCalculo3Faixa > LIMITE_3_FAIXA) {
					// quarta faixa
					this.simulador.adicionaImposto(new Imposto((Math.min(this.baseCalculo4Faixa, LIMITE_4_FAIXA) * ALIQUOTA_3_FAIXA), 4));
					
					if (this.baseCalculo4Faixa > 913.63f) {
						// quinta faixa
						this.simulador.adicionaImposto(new Imposto((this.baseCalculo5Faixa * ALIQUOTA_4_FAIXA), 5));

					}
				}
			}
		}
	}
}
