package lesson06;

import lesson06.items.Cat;
import lesson06.items.Dog;
import lesson06.model.Animal;

/**
 * 1. Создать классы Собака и Кот с наследованием от класса Животное.
 *
 * 2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
 *    Результатом выполнения действия будет печать в консоль.
 *    (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
 *
 * 3. У каждого животного есть ограничения на действия
 *    (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
 *
 * 4. * Добавить подсчет созданных котов, собак и животных.
 */

public class HomeWorkApp {
    public static void main(String[] args) {
        Cat matroskin = new Cat("Матроскин");
        Cat leopold = new Cat("Леопольд");
        Dog sharik = new Dog("Шарик");
        Dog bobik = new Dog("Вобик");
        Dog mukhtar = new Dog("Мухтар");

        matroskin.run(100);
        sharik.run(100);
        leopold.run(250);
        bobik.run(250);
        mukhtar.run(600);
        matroskin.swim(5);
        sharik.swim(5);
        bobik.swim(15);

        Cat.getObjectsCount();
        Dog.getObjectsCount();
        Animal.getObjectsCount();
    }
}
