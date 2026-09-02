import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class PizzaTest {

    @Test
    public void adicionaIngredientesCorretamente(){
        //Arrange
        Pizza pizza = new Pizza();

        //Act
        int quantos = 
            pizza.adicionarIngredientes(4);

        //Assert
        assertEquals(4, quantos);
    }

    @Test
    public void naoAdicionarIngredienteNegativo(){
        //Arrange
        Pizza pizza = new Pizza();

        //Act
        int quantos = 
            pizza.adicionarIngredientes(-4);

        //Assert
        assertEquals(0, quantos);
    }

    @Test
    public void naoAdicionarIngredienteEmExcesso(){
        //Arrange
        Pizza pizza = new Pizza();
        int quantos = pizza.adicionarIngredientes(4);

        //Act
        quantos = pizza.adicionarIngredientes(6);

        //Assert
        assertEquals(4, quantos);
    }
    
}
