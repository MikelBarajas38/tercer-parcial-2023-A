package edu.uaslp.objetos.shoppingcart;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise3ShoppingItemCatalog {

    @Test
    public void givenAValidCode_whenGetItem_thenShoppingItemIsReturned(){
        //given
        ShoppingItemCatalog shoppingItemCatalog = new ShoppingItemCatalog();

        //when
        ShoppingItem testItem = shoppingItemCatalog.getItem("ABC1000");

        //then
        assertThat(testItem.getCode()).isEqualTo("ABC1000");
        assertThat(testItem.getName()).isEqualTo("Escoba");
    }

    @Test
    public void givenANotValidCode_whenGetItem_thenNullIsReturned(){
        //given
        ShoppingItemCatalog shoppingItemCatalog = new ShoppingItemCatalog();

        //when
        ShoppingItem testItem = shoppingItemCatalog.getItem("notValid");

        //then
        assertThat(testItem).isEqualTo(null);
    }
}
