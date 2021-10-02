package lesson05;

/**
 * 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 * 2. Конструктор класса должен заполнять эти поля при создании объекта.
 * 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
 * 4. Создать массив из 5 сотрудников.
 *    Пример:
 *    Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 *    persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
 *    persArray[1] = new Person(...);
 *    ...
 *    persArray[4] = new Person(...);
 *
 * 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */

public class HomeWorkApp {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivan@list.ru", "892312312", 30000, 30);
        persArray[1] = new Person("Fedorov Fedor", "Director", "fedja@mail.ru", "89266114578", 50000, 41);
        persArray[2] = new Person("Vitalov Vitalij", "Janitor", "vital@bk.ru", "890199319", 10000, 16);
        persArray[3] = new Person("Sidorov Sidor", "Teacher", "sidor@list.ru", "891112355", 60000, 45);
        persArray[4] = new Person("Petrov Piter", "Tsar", "petrov@mail.ru", "892312798", 300000, 55);

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40) {
                persArray[i].print();
            }
        }
    }
}
