import dao.ShoppingListDAO;
import dao.ShoppingListDAOImpl;
import model.ShoppingItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Основной класс приложения для демонстрации CRUD операций над списком покупок.
 *
 * @author Булаев Максим
 * @version 1.0
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // Создаём экземпляр DAO
        ShoppingListDAO shoppingListDAO = new ShoppingListDAOImpl();

        // Создаём несколько товаров и добавляем их в список покупок
        ShoppingItem item1 = new ShoppingItem("Молоко", 100);
        ShoppingItem item2 = new ShoppingItem("Хлеб", 30);

        shoppingListDAO.addItem(item1);
        shoppingListDAO.addItem(item2);

        // Выводим текущий список покупок
        for (ShoppingItem item : shoppingListDAO.getAllItems()) {
            logger.info(item.toString());
        }
        System.out.println();

        // Обновляем цену молока
        ShoppingItem updatedItem = shoppingListDAO.getItemById(1);
        if (updatedItem != null) {
            updatedItem.setPrice(50);
            shoppingListDAO.updateItem(updatedItem);
        }

        // Выводим обновленный товар
        ShoppingItem shoppingItem = shoppingListDAO.getItemById(1);
        logger.info(shoppingItem.toString());
        System.out.println();

        // Удаляем товар "Хлеб"
        shoppingListDAO.deleteItem(2);

        // Выводим окончательный список покупок
        for (ShoppingItem item : shoppingListDAO.getAllItems()) {
            logger.info(item.toString());
        }
        System.out.println();

        logger.info("Приложение завершило работу!");
    }
}

