package dao;

import model.ShoppingItem;

import java.util.List;

/**
 * Интерфейс для выполнения CRUD операций над списком покупок.
 */
public interface ShoppingListDAO {
    /**
     * Функция для получения всех товаров из списка покупок.
     *
     * @return список покупок.
     */
    List<ShoppingItem> getAllItems();

    /**
     * Функция для получения товара из списка по его уникальному идентификатору (id).
     *
     * @param id уникальный идентификатор товара.
     * @return товар из списка покупок.
     */
    ShoppingItem getItemById(int id);

    /**
     * Функция для добавления товара в список покупок.
     *
     * @param item товар.
     */
    void addItem(ShoppingItem item);

    /**
     * Функция для обновления информации о элементе списка покупок.
     *
     * @param item товар из списка покупок.
     */
    void updateItem(ShoppingItem item);

    /**
     * Функция для удаления товара из списка покупок.
     *
     * @param id уникальный идентификатор товара.
     */
    void deleteItem(int id);
}

