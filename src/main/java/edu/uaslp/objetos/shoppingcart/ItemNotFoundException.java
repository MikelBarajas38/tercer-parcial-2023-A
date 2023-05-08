package edu.uaslp.objetos.shoppingcart;

public class ItemNotFoundException extends ShoppingCartException{
    public ItemNotFoundException(String message) {
        super(message);
    }
}
