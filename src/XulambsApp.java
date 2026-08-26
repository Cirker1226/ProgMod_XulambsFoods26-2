import java.util.LinkedList;
import java.util.List;

public class XulambsApp {
    void main() {
        int opcao;
        listaPizzas = new LinkedList<>();

        do {
            opcao = exibirMenu();
            switch (opcao) {
                case 1 -> comprarPizza();
                case 2 -> MostrarPizzas();
                case 0 -> IO.println("Sistema Encerrado!");
                default -> IO.println("Opção Inválida!");
            }
            pausa();
        } while (opcao != 0);
    }

    private void pausa() {
        IO.println("-------------------------------");
        IO.readln("Digite <ENTER> para continuar");
        limparTela();
    }

    private void limparTela() {
        IO.print("\033[H\033[2J");
    }

    private void cabecalho() {
        IO.println("-------------------------------");
        IO.println("XULAMBS PIZZA - v0.1");
        IO.println("-------------------------------");
    }

    private int exibirMenu() {
        cabecalho();
        IO.println("1 - Comprar Pizza");
        IO.println("2 - Mostrar Pizza");
        IO.println("0 - Sair");
        IO.println("-------------------------------");
        return Integer.parseInt(IO.readln("Escolha uma opção: "));
    }
    
    void comprarPizza() {
        int ingredientes = Integer.parseInt(IO.readln("Quantidade de Ingredientes: "));
        Pizza nova = new Pizza(ingredientes);
        ExibirNota(nova);
        listaPizzas.add(nova);
    }

    private List<Pizza> listaPizzas;
    
    void ExibirNota(Pizza pizza) {
        IO.println("-------------------------------");
        IO.println("Pizza Comprada! Obrigado(a)!");
        IO.println("-------------------------------");
        IO.println(pizza.gerarCupom());
    }

    void MostrarPizzas() {
        for (Pizza pizza : listaPizzas) {
            ExibirNota(pizza);
        }
    }
}
