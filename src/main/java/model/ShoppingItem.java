package model;

/**
 * Класс товаров со свойствами <b>id</b>, <b>name</b> и <b>price</b>.
 */
public class ShoppingItem {
    /** Поле id (уникальный идентификатор) */
    private int id;

    /** Поле Имя (название) */
    private String name;

    /** Поле Цена */
    private double price;

    /** Поле Счётчик */
    private static int count = 1;

    /**
     * Конструктор для создания нового объекта с определёнными значениями
     *
     * @param name - имя (название) товара
     * @param price - цена товара
     */
    public ShoppingItem(String name, double price) {
        this.id = count++; // Так как мы не используем БД, вручную присваеваем id каждому товару с помощью счётчика count
        this.name = name;
        this.price = price;
    }

    /**
     * Далее идут геттеры и сеттеры для всех полей этого объекта
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Переопределение метода toString для удобного вывода информации о товаре.
     *
     * @return строковое представление объекта.
     */
    @Override
    public String toString() {
        return "model.ShoppingItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

