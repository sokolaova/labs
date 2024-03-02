class Animal {
    String name;
    String food;
    String location;

    public Animal(String name, String food, String location) {
        this.name = name;
        this.food = food;
        this.location = location;
    }

    public void makeNoise() {
        System.out.println(name + " издает звук");
    }

    public void eat() {
        System.out.println(name + " ест " + food);
    }

    public void sleep() {
        System.out.println(name + " спит в/на " + location);
    }
}

class Dog extends Animal {
    String breed;

    public Dog(String name, String food, String location, String breed) {
        super(name,
                food,
                location);
        this.breed = breed;
    }

    public void makeNoise() {
        System.out.println("Собака " + name + " лает");
    }

    public void eat() {
        System.out.println("Собака" + name + " ест " + food);
    }
}

class Cat extends Animal {
    String color;

    public Cat(String name, String food, String location, String color) {
        super(name, food, location);
        this.color = color;
    }

    public void makeNoise() {
        System.out.println("Кошка" + name + " мяукает");
    }

    public void eat() {
        System.out.println("Кошка " + name + " ест " + food);
    }
}

class Humster extends Animal {
    String size;

    public Humster(String name, String food, String location, String size) {
        super(name, food, location);
        this.size = size;
    }

    public void makeNoise() {
        System.out.println(size + "хомяк " + name + " шуршит");
    }

    public void eat() {
        System.out.println(size + "хомяк " + name + " ест " + food);
    }
}

class Veterinarian {
    public void treatAnimal(Animal animal) {
        System.out.println("Имя: " + animal.name);
        System.out.println("Еда: " + animal.food);
        System.out.println("Местоположение: " + animal.location);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog( "Здоровяк", "кость", "улица", "дворняга");
        Cat cat = new Cat("Чепуха", "Whiskas", "дом", "трехцветная");
        Humster humster = new Humster("Мелкий", "зерна", "клетка", "маленький");

        Veterinarian veterinarian = new Veterinarian();
        veterinarian.treatAnimal(dog);
        System.out.println();
        veterinarian.treatAnimal(cat);
        System.out.println();
        veterinarian.treatAnimal(humster);
    }
}
