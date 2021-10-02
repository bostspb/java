package lesson06.items;

import lesson06.model.Animal;

public class Cat extends Animal {
    private static int objectsCount;

    public Cat(String name) {
        super(name, "Кот", 200, 0);
        objectsCount++;
    }

    public static void getObjectsCount() {
        System.out.println("Количество котов: " + objectsCount);
    }
}
