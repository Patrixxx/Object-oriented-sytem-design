import com.patrixxx.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Set;

public class TestCart {

    private InventoryServiceImpl inventoryserviceImpl;
    private ShoppingCartServiceImpl shoppingCartServiceImpl;

    @BeforeEach
    void setup() {
        inventoryserviceImpl = new InventoryServiceImpl();
        shoppingCartServiceImpl = new ShoppingCartServiceImpl();
    }

    @Test
    void test_add_item_in_inventory() {
        LineItem item1 = new LineItem(1, "ItemName", ItemType.BOOK);
        LineItem item2 = new LineItem(2, "ItemName", ItemType.ELECTRONIC);
        inventoryserviceImpl.addItemToInventory(item1);
        inventoryserviceImpl.addItemToInventory(item2);
        Set<LineItem> inventoryItems = inventoryserviceImpl.fetchInventoryItems();
        Assertions.assertEquals(2, inventoryItems.size());
    }

    @Test
    void test_add_item_in_cart() {

        LineItem lineItem1 = new LineItem(1, "ItemName", ItemType.BOOK);
        LineItem lineItem2 = new LineItem(2, "ItemName", ItemType.ELECTRONIC);
        inventoryserviceImpl.addItemToInventory(lineItem1);
        inventoryserviceImpl.addItemToInventory(lineItem2);

        Set<LineItem> inventoryItems = inventoryserviceImpl.fetchInventoryItems();

        Item item1 = new Item(1, 2);
        Item item2 = new Item(1, 1);
        shoppingCartServiceImpl.addItemToShoppingCart(1, item1);
        shoppingCartServiceImpl.addItemToShoppingCart(1, item2);

        List<Item> items = shoppingCartServiceImpl.fetchCartItemsOfUser(1);
        Assertions.assertEquals(2, items.size());

        //count total items in cart
        int count = shoppingCartServiceImpl.fetchTotalItemCount(1);
        Assertions.assertEquals(2, count);

        //count total items for dispatch
        int deliverableQuantity = shoppingCartServiceImpl.fetchDeliverableQuantity(1);
        Assertions.assertEquals(3, deliverableQuantity);

    }
}
