package com.patrixxx;

import java.util.*;

public class ShoppingCartServiceImpl {

    static Map<Integer, List<Item>> shoppingCartMap = new HashMap();

    public void addItemToShoppingCart(int userId, Item item) {
        if (shoppingCartMap.containsKey(userId)) {
            List<Item> itemList = shoppingCartMap.get(userId);
            itemList.add(item);
            shoppingCartMap.put(userId, itemList);
        } else {
            List<Item> itemList = new ArrayList<>();
            itemList.add(item);
            shoppingCartMap.put(userId, itemList);
        }
    }

    public List<Item> fetchCartItemsOfUser(int userId) {
        return shoppingCartMap.get(userId);
    }

    public int fetchTotalItemCount(int userId) {
        List<Item> itemList = shoppingCartMap.get(userId);
        return itemList.size();
    }

    public int fetchDeliverableQuantity(int userId) {
        List<Item> itemList = shoppingCartMap.get(userId);
        return itemList.stream().mapToInt(value -> value.quantity).sum();
    }
}
