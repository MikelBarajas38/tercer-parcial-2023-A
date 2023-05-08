package edu.uaslp.objetos.shoppingcart;

import java.util.*;

public class ShoppingCart {

    private ShoppingItemCatalog shoppingItemCatalog;
    private List<String> shoppingCartList;

    public ShoppingCart(ShoppingItemCatalog shoppingItemCatalog) {
        this.shoppingItemCatalog = shoppingItemCatalog;
        this.shoppingCartList = new ArrayList<>();
    }

    public void add(String code) throws ItemNotFoundException{
        ShoppingItem testItem = shoppingItemCatalog.getItem(code);
        shoppingCartList.add(code);
    }

    public int getTotalCostInCents() {
        Iterator<String> iterator = shoppingCartList.iterator();
        int totalCost = 0;
        while(iterator.hasNext()) {
            ShoppingItem item = shoppingItemCatalog.getItem(iterator.next());
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
        List<ShoppingItem> itemsInList = new ArrayList<>();
        Iterator<String> iterator = shoppingCartList.iterator();
        while(iterator.hasNext()) {
            ShoppingItem item = shoppingItemCatalog.getItem(iterator.next());
            itemsInList.add(item);
        }
        return itemsInList;
    }

    public Collection<ShoppingItem> getDistinctItems() {
        Set<ShoppingItem> distinctItems = new HashSet<>();
        List<ShoppingItem> distinctItemsList = new ArrayList<>();

        Iterator<String> iterator = shoppingCartList.iterator();
        while(iterator.hasNext()) {
            ShoppingItem item = shoppingItemCatalog.getItem(iterator.next());
            if(!distinctItems.contains(item)) {
                distinctItemsList.add(item);
            }
            distinctItems.add(item);
        }

        return distinctItemsList;
    }
}
