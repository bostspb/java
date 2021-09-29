package lesson05;
/**
 * 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 * 2. Конструктор класса должен заполнять эти поля при создании объекта.
 * 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
 */

public class Person {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private float salary;
    private int age;

    public Person(String fio, String position, String email, String phone, float salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void print() {
        System.out.println(
                "-------------" +
                "\nСотрудник:\t" + fio +
                "\nДолжность:\t" + position +
                "\nEmail:\t\t" + email +
                "\nТелефон:\t" + phone +
                "\nЗарплата:\t" + salary +
                "\nВозраст:\t" + age +
                "\n-------------"
        );
    }

    public int getAge() {
        return age;
    }

}
