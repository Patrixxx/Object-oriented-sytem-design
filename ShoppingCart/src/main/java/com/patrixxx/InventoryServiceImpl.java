package com.patrixxx;
import java.util.HashSet;
import java.util.Set;

public class InventoryServiceImpl {

    Set<LineItem> lineItems = new HashSet<>();

    public void addItemToInventory(LineItem lineItem){
        lineItems.add(lineItem);
    }

    public Set<LineItem> fetchInventoryItems(){
        return lineItems;
    }
}
