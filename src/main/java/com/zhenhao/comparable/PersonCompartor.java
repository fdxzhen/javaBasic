package com.zhenhao.comparable;

import java.util.Arrays;
import java.util.Comparator;

public class PersonCompartor implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Person[] people = new Person[]{new Person("xujian", 20), new Person("xiewei", 10)};
        System.out.println("≈≈–Ú«∞");
        for (Person person : people) {
            System.out.print(person.getName() + ":" + person.getAge());
        }
        Arrays.sort(people, new PersonCompartor());
        System.out.println("\n≈≈–Ú∫Û");
        for (Person person : people) {
            System.out.println(person.getName() + ":" + person.getAge());
        }

        System.out.println("****************************");
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return 1;
            }
        });
        for (Person person : people) {
            System.out.println(person.getName() + ":" + person.getAge());
        }

    }
}
