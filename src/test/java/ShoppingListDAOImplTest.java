import dao.ShoppingListDAO;
import dao.ShoppingListDAOImpl;
import model.ShoppingItem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для тестирования CRUD операций.
 */
class ShoppingListDAOImplTest {

    private ShoppingListDAO shoppingListDAO;

    @BeforeEach
    void setUp() {
        shoppingListDAO = new ShoppingListDAOImpl();
    }

    // Тест добавления товара в список покупок
    @Test
    void testAddItem() {
        ShoppingItem item = new ShoppingItem( "Сок", 70);
        shoppingListDAO.addItem(item);

        List<ShoppingItem> items = shoppingListDAO.getAllItems();
        assertEquals(1, items.size());
        assertEquals("Сок", items.get(0).getName());
        assertEquals(70, items.get(0).getPrice());
    }

    // Тест получения товара по его id
    @Test
    void testGetItemById() {
        ShoppingItem item = new ShoppingItem("Гречка", 90);
        shoppingListDAO.addItem(item);

        ShoppingItem retrievedItem = shoppingListDAO.getItemById(1);
        assertNotNull(retrievedItem);
        assertEquals("Гречка", retrievedItem.getName());
        assertEquals(90, retrievedItem.getPrice());
    }

    // Тест изменения всех характеристик товара
    @Test
    void testUpdateItem() {
        ShoppingItem item = new ShoppingItem("Конфеты", 50);
        shoppingListDAO.addItem(item);

        item.setName("Шоколад");
        item.setPrice(100);
        shoppingListDAO.updateItem(item);

        ShoppingItem updatedItem = shoppingListDAO.getItemById(item.getId());
        assertNotNull(updatedItem);
        assertEquals("Шоколад", updatedItem.getName());
        assertEquals(100, updatedItem.getPrice());
    }

    // Тест изменения названия товара
    @Test
    void testUpdateItemName() {
        ShoppingItem item = new ShoppingItem("Конфеты", 50);
        shoppingListDAO.addItem(item);

        item.setName("Шоколад");
        shoppingListDAO.updateItem(item);

        ShoppingItem updatedItem = shoppingListDAO.getItemById(item.getId());
        assertNotNull(updatedItem);
        assertEquals("Шоколад", updatedItem.getName());
        assertEquals(50, updatedItem.getPrice());
    }

    // Тест изменения цены товара
    @Test
    void testUpdateItemPrice() {
        ShoppingItem item = new ShoppingItem("Конфеты", 50);
        shoppingListDAO.addItem(item);

        item.setPrice(100);
        shoppingListDAO.updateItem(item);

        ShoppingItem updatedItem = shoppingListDAO.getItemById(item.getId());
        assertNotNull(updatedItem);
        assertEquals("Конфеты", updatedItem.getName());
        assertEquals(100, updatedItem.getPrice());
    }

    // Тест удаления товара
    @Test
    void testDeleteItem() {
        ShoppingItem item = new ShoppingItem("Газировка", 75);
        shoppingListDAO.addItem(item);

        shoppingListDAO.deleteItem(item.getId());

        List<ShoppingItem> items = shoppingListDAO.getAllItems();
        assertEquals(0, items.size());
    }
}