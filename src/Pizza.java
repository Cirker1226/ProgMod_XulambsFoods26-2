public class Pizza {
    private static final double PRECO_BASE;
	private static final int MAXIMO_INGREDIENTES;
	private static final double VALOR_INGREDIENTE;

    private static int pizzasVendidas;
    
    private int quantidadeIngredientes;

    static{
        PRECO_BASE = 29;
	    MAXIMO_INGREDIENTES = 8;
	    VALOR_INGREDIENTE = 5;
        pizzasVendidas = 0;
    }

    public static int getPizzasVendidas(){
        return pizzasVendidas;
    }

    private void init(int adicionais) {
		 adicionarIngredientes(adicionais);
         pizzasVendidas++;
    }

	public Pizza() {
		init(0);
    }

	public Pizza(int adicionais) {
		init(adicionais);
    }

	public double calcularValorFinal() {
		return PRECO_BASE + calcularValorAdicionais();
	}

	private double calcularValorAdicionais() {
		return quantidadeIngredientes * VALOR_INGREDIENTE;
	}

	public String gerarCupom() {
		String cupom = "Xulambs Pizza!!!\n";
        
        cupom += String.format("Pizza com %d ingredientes\n",      quantidadeIngredientes);

        cupom += String.format("\tPreço base: R$ %.2f\n", PRECO_BASE);
        cupom += String.format("\tAdicionais: R$ %.2f\n", calcularValorAdicionais());
        cupom += String.format("VALOR A PAGAR: R$ %.2f", calcularValorFinal());

        return cupom;
	}

    /**
     * Verifica se a quantidade de ingredientes passada pode
     * ser adicionada na pizza, retornando true/false 
     * confore o resultado.
     * @param quantidade Ingredientes a serem adicionados
     * @return TRUE se a quantidade for >=0 e o total <=8, FALSE para casos contrários.
     */
	private boolean podeAdicionar(int quantidade) {
        return quantidade >=0
               && quantidade + quantidadeIngredientes <= MAXIMO_INGREDIENTES;
    }

    /**
     * Tenta adicionar a quantidade de ingredientes na pizza.
     * Em caso de valores inválidos, ignora a operação.
     * @param quantidade Inteiro não negativo
     * @return A quantatidade de adicionais na pizza após a execução do método.
     */
	public int adicionarIngredientes(int quantidade) {
		if(podeAdicionar(quantidade)){
            quantidadeIngredientes += quantidade;
        }
        return quantidadeIngredientes;
	}
}
