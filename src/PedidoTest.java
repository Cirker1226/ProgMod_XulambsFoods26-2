import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    Pedido pedido;
    Pizza pizzaVazia;
    Pedido pedidoComPizza;
    Pedido pedidoC;

    @BeforeEach 
    public void setUp() {
        //Arrange
        pedido = new Pedido();
        pizzaVazia = new Pizza();
        pedidoComPizza = new Pedido();
        pedidoComPizza.adicionarPizza(pizzaVazia);
    }

/*
    @Test
    public void naoAdicionaPizzaEmPedidoFechado(){
        //Arrange
        Pedido pedido = new Pedido();
        pedido.adicionarPizza(new Pizza());
        pedido.fecharPedido();

        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());
    
        //Assert
        assertEquals(1, quantidade);
    }
*/

    @Test
    public void naoAdicionaPizzaEmPedidosFechados() {
        pedidoComPizza.fecharPedido();

        int quantidade = pedido.adicionarPizza(new Pizza());

        assertEquals(1, quantidade);
    }

    @Test 
    public void adicionarPizzaEmPedidoAberto() {
        int quantidade = pedido.adicionarPizza(new Pizza());
        pedido.fecharPedido();
        
        assertEquals(2, quantidade);
    }

    @Test 
    public void precoPagarPizza() {
        double preco = pedidoComPizza.precoAPagar();

        assertEquals(29, preco, 0.01);
    }

    @Test 
    public void precoPagarPizza2() {        
        double preco = pedido.precoAPagar();

        assertEquals(0, preco, 0.01);

    }

    @Test
    public void precoPagarPizza3() {
        pizzaVazia.adicionarIngredientes(5);
        pedido.adicionarPizza(pizzaVazia);

        double preco = pedido.precoAPagar();

        assertEquals(54, preco, 0.01);
    }

    @Test 
    public void TestRelatorio() {
        pizzaVazia.adicionarIngredientes(5);
        pedido.adicionarPizza(pizzaVazia);

        //Act
        String cupom = pedido.relatorio();

        //Assert
        assertTrue( 
            cupom.contains("1 Pizza(s)") &&
            cupom.contains("54,00")
        );
    }

}
