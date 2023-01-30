package simuladorIRPF;

public class CalculaImposto {
	private SimuladorIRPF simulador;
	private Imposto impostoTemp;
	private float baseCalculo;

	public CalculaImposto(SimuladorIRPF simuladorFonte) {
		this.simulador = simuladorFonte;
	}

	public void calcularImposto() {
		this.baseCalculo = this.simulador.getBaseCalculo();
		this.calcularFaixa(this.baseCalculo);
	}

	public void calcularFaixa(Float base) {
		if (base > 1903.98f) {
			// segunda faixa
			base -= 1903.98f;
			this.impostoTemp = new Imposto((Math.min(base, 922.67f) * 7.5f / 100), 2);
			this.simulador.adicionaImposto(this.impostoTemp);
			if (base > 922.67f) {

				// terceira faixa
				base -= 922.67f;
				this.impostoTemp = new Imposto((Math.min(base, 924.40f) * 15f / 100), 3);
				this.simulador.adicionaImposto(this.impostoTemp);
				if (base > 924.40f) {

					// quarta faixa
					base -= 924.40f;
					this.impostoTemp = new Imposto((Math.min(base, 913.63f) * 22.5f / 100), 4);
					this.simulador.adicionaImposto(this.impostoTemp);
					if (base > 913.63f) {

						// quinta faixa
						base -= 913.63f;
						this.impostoTemp = new Imposto((base * 27.5f / 100), 5);
						this.simulador.adicionaImposto(this.impostoTemp);

					}
				}
			}
		}
	}
}
