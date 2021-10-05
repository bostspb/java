package lesson06.items;

import lesson06.model.Animal;

public class Dog extends Animal {
    private static int objectsCount;

    public Dog(String name) {
        super(name, "Собака", 500, 10);
        objectsCount++;
    }

    public static void getObjectsCount() {
        System.out.println("Количество собак: " + objectsCount);
    }
}
