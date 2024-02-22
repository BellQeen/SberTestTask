package dao;

import model.ShoppingItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса ShoppingListDAO для выполнения CRUD операций над списком покупок.
 */
public class ShoppingListDAOImpl implements ShoppingListDAO {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingListDAOImpl.class);
    private List<ShoppingItem> shoppingList = new ArrayList<>();

    @Override
    public List<ShoppingItem> getAllItems() {
        logger.info("Получен весь текущий список покупок:");
        return new ArrayList<>(shoppingList);
    }

    @Override
    public ShoppingItem getItemById(int id) {
        for (ShoppingItem item : shoppingList) {
            if (item.getId() == id) {
                logger.info("Найден товар с id=" + id);
                return item;
            }
        }
        return null;
    }

    @Override
    public void addItem(ShoppingItem item) {
        logger.info("Товар " + item.getName() + " добавлен в список покупок\n");
        shoppingList.add(item);
    }

    @Override
    public void updateItem(ShoppingItem item) {
        for (int i = 0; i < shoppingList.size(); i++) {
            if (shoppingList.get(i).getId() == item.getId()) {
                logger.info("Товар с id=" + item.getId() + " был изменён\n");
                shoppingList.set(i, item);
                return;
            }
        }
    }

    @Override
    public void deleteItem(int id) {
        for (int i = 0; i < shoppingList.size(); i++) {
            if (shoppingList.get(i).getId() == id) {
                logger.info("Товар " + shoppingList.get(i).getName() + " был удалён из списка покупок\n");
                shoppingList.remove(i);
                return;
            }
        }
    }
}

