package lesson06.model;

public class Animal {
    protected String name;
    private static int objectsCount;
    private final String type;
    private final int restrictionOnRunning;
    private final int restrictionOnSwimming;

    public Animal(String name, String type, int restrictionOnRunning, int restrictionOnSwimming) {
        this.name = name;
        this.type = type;
        this.restrictionOnRunning = restrictionOnRunning;
        this.restrictionOnSwimming = restrictionOnSwimming;
        objectsCount++;
    }

    // Просто напрашивается сюда абстрактный метод, но вы запретили так делать
    public static void getObjectsCount() {
        System.out.println("Количество животных: " + objectsCount);
    }

    public void run(int distance) {
        if (restrictionOnRunning == 0) {
            System.out.println(type + " не умеет бегать.");
        }

        if(distance > restrictionOnRunning && restrictionOnRunning > 0) {
            System.out.println(name + " не смог пробежать " + distance + " м.");
        }

        if(distance <= restrictionOnRunning && restrictionOnRunning > 0)  {
            System.out.println(name + " пробежал " + distance + " м.");
        }
    }

    public void swim(int distance) {
        if (restrictionOnSwimming == 0) {
            System.out.println(type + " не умеет плавать.");
        }

        if (distance > restrictionOnSwimming && restrictionOnSwimming > 0) {
            System.out.println(name + " не смог проплыть " + distance + " м.");
        }

        if (distance <= restrictionOnSwimming && restrictionOnSwimming > 0) {
            System.out.println(name + " проплыл " + distance + " м.");
        }
    }
}
