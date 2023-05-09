package edu.uaslp.objetos.shoppingcart;

import java.util.*;

public class ShoppingCart {

    private final ShoppingItemCatalog shoppingItemCatalog;
    private List<ShoppingItem> shoppingCartList;

    public ShoppingCart(ShoppingItemCatalog shoppingItemCatalog) {
        this.shoppingItemCatalog = shoppingItemCatalog;
        this.shoppingCartList = new ArrayList<>();
    }

    public void add(String code) throws ItemNotFoundException{
        ShoppingItem testItem = shoppingItemCatalog.getItem(code);
        shoppingCartList.add(testItem);
    }

    public int getTotalCostInCents() {
        Iterator<ShoppingItem> iterator = shoppingCartList.iterator();
        int totalCost = 0;
        while(iterator.hasNext()) {
            ShoppingItem item = iterator.next();
            totalCost += item.getUnitCostInCents();
        }
        return totalCost;
    }

    public int getDistinctItemsCount() {
        return getDistinctItems().size();
    }

    public int getTotalItemsCount() {
        return shoppingCartList.size();
    }

    public List<ShoppingItem> getItems() {
        return shoppingCartList;
    }

    public Collection<ShoppingItem> getDistinctItems() {
        Set<ShoppingItem> distinctItems = new HashSet<>();
        List<ShoppingItem> distinctItemsList = new ArrayList<>();

        Iterator<ShoppingItem> iterator = shoppingCartList.iterator();
        while(iterator.hasNext()) {
            ShoppingItem item = iterator.next();
            if(!distinctItems.contains(item)) {
                distinctItemsList.add(item);
            }
            distinctItems.add(item);
        }

        return distinctItemsList;
    }
}
