/**
 * Создать перечисление, содержащее размеры одежды (XXS, XS, S, M, L). Перечисление содержит метод getDescription, возвращающий строку "Взрослый размер". Переопределить метод getDescription - для константы XXS метод должен возвращать строку “Детский размер”. Также перечисление должно содержать числовое значение euroSize(32, 34, 36, 38, 40), соответствующее каждому размеру. Создать конструктор, принимающий на вход euroSize. * • Создать интерфейсы "Мужская Одежда" с методом "одетьМужчину" и "Женская Одежда" с методом "одетьЖенщину".
 * • Создать абстрактный класс Одежда, содержащий переменные - размер одежды, стоимость, цвет. * • Создать классы наследники Одежды - Футболка (реализует интерфейсы "Мужская Одежда" и "Женская Одежда"), Штаны (реализует интерфейсы "Мужская Одежда" и "Женская Одежда"), Юбка (реализует интерфейсы "Женская Одежда"), Галстук (реализует интерфейсы "Мужская Одежда").
 * • Создать массив, содержащий все типы одежды. Создать класс Ателье, содержащий методы одетьЖенщину, одетьМужчину, на вход которых будет поступать массив, содержащий все типы одежды. Метод одетьЖенщину выводит на консоль всю информацию о женской одежде. То же самое для метода одетьМужчину
 *
 * @author Ольга Соколова*/
/**
 * Перечисления (enum) в Java представляют собой набор констант, которые обычно используются для определения некоторого ограниченного набора значений.
 * Enum, представляющий размеры одежды.
 */
enum Size {
    /** Константа XXS со значением 32 */
    XXS(32) {
        public String getDescription() {
            return "Детский размер";
        }
    },
    /** Константа XS со значением 34 */
    XS(34) {
        public String getDescription() {
            return "Взрослый размер";
        }
    },
    /** Константа S со значением 36 */
    S(36) {
        public String getDescription() {
            return "Взрослый размер";
        }
    },
    /** Константа M со значением 38 */
    M(38) {
        public String getDescription() {
            return "Взрослый размер";
        }
    },
    /** Константа L со значением 40 */
    L(40) {
        public String getDescription() {
            return "Взрослый размер";
        }
    };

    /** Поле европейского размера */
    public int euroSize;

    /**
     * Конструктор - создание нового объекта
     *
     * @param euroSize - европейский размер
     */
    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    /**
     * Возвращает описание размера.
     *
     * @return описание размера
     */
    public String getDescription() {
        return "Взрослый размер";
    }
}

/**
 * Интерфейс для мужской одежды.
 */
interface MenClothing {
    /**
     * Метод для одевания мужчины.
     */
    void dressMan();
}

/**
 * Интерфейс для женской одежды.
 */
interface WomenClothing {
    /**
     * Метод для одевания женщины.
     */
    void dressWoman();
}

/**
 * Абстрактный класс, представляющий одежду.
 */
abstract class Clothing {
    Size size;
    double price;
    String color;

    /**
     * Конструктор - создание нового объекта одежды.
     *
     * @param size  - размер одежды
     * @param price - цена одежды
     * @param color - цвет одежды
     */
    public Clothing(Size size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    /**
     * Возвращает информацию об одежде.
     *
     * @return строка с информацией об одежде
     */
    public String Information() {
        return "Размер: " + size + " (" + size.getDescription() + "), Цена: " + price + ", Цвет: " + color;
    }
}

/**
 * Класс, представляющий футболку.
 */
class TShirt extends Clothing implements MenClothing, WomenClothing {

    /**
     * Конструктор - создание новой футболки.
     *
     * @param size  - размер футболки
     * @param price - цена футболки
     * @param color - цвет футболки
     */
    public TShirt(Size size, double price, String color) {
        super(size, price, color);
    }

    /**
     * Одевает мужчину в футболку.
     */
    public void dressMan() {
        System.out.println("Одеваем мужчину в футболку: " + Information());
    }

    /**
     * Одевает женщину в футболку.
     */
    public void dressWoman() {
        System.out.println("Одеваем женщину в футболку: " + Information());
    }
}

/**
 * Класс, представляющий брюки.
 */
class Trousers extends Clothing implements MenClothing, WomenClothing {

    /**
     * Конструктор - создание новых брюк.
     *
     * @param size  - размер брюк
     * @param price - цена брюк
     * @param color - цвет брюк
     */
    public Trousers(Size size, double price, String color) {
        super(size, price, color);
    }

    /**
     * Одевает мужчину в брюки.
     */
    public void dressMan() {
        System.out.println("Одеваем мужчину в брюки: " + Information());
    }

    /**
     * Одевает женщину в брюки.
     */
    public void dressWoman() {
        System.out.println("Одеваем женщину в брюки: " + Information());
    }
}

/**
 * Класс, представляющий юбку.
 */
class Skirt extends Clothing implements WomenClothing {

    /**
     * Конструктор - создание новой юбки.
     *
     * @param size  - размер юбки
     * @param price - цена юбки
     * @param color - цвет юбки
     */
    public Skirt(Size size, double price, String color) {
        super(size, price, color);
    }

/**
 * Одевает женщину в юбку.
 */
public void dressWoman() {
    System.out.println("Одеваем женщину в юбку: " + Information());
}
}

/**
 * Класс, представляющий галстук.
 */
class Tie extends Clothing implements MenClothing {

    /**
     * Конструктор - создание нового галстука.
     *
     * @param size  - размер галстука
     * @param price - цена галстука
     * @param color - цвет галстука
     */
    public Tie(Size size, double price, String color) {
        super(size, price, color);
    }

    /**
     * Одевает мужчину в галстук.
     */
    public void dressMan() {
        System.out.println("Одеваем мужчину в галстук: " + Information());
    }
}

/**
 * Класс ателье для одевания людей.
 */
class Atelier {

    /**
     * Одевает женщин из предоставленного массива одежды.
     *
     * @param clothes - массив одежды
     */
    public void dressWoman(Clothing[] clothes) {
        System.out.println("Одеваем женщину:");
        for (Clothing c : clothes) {
            if (c instanceof WomenClothing) {
                ((WomenClothing) c).dressWoman();
            }
        }
    }

    /**
     * Одевает мужчин из предоставленного массива одежды.
     *
     * @param clothes - массив одежды
     */
    public void dressMan(Clothing[] clothes) {
        System.out.println("Одеваем мужчину:");
        for (Clothing c : clothes) {
            if (c instanceof MenClothing) {
                ((MenClothing) c).dressMan();
            }
        }
    }
}

/**
 * Главный класс приложения.
 */
public class Main {

    /**
     * Точка входа в приложение.
     *
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Clothing[] clothes = {
                new TShirt(Size.S, 15.99, "Красный"),
                new Trousers(Size.M, 29.99, "Черный"),
                new Skirt(Size.L, 24.99, "Синий"),
                new Tie(Size.XS, 12.99, "Зеленый")
        };

        Atelier atelier = new Atelier();
        atelier.dressWoman(clothes);
        System.out.println();
        atelier.dressMan(clothes);
    }
}
