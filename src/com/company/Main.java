package com.company;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Comparator<Person> comparator =  new PersonNameComparator().thenComparing(new PersonAgeComparator());
        Person vadim = new Person(1, "Vadim", 25);
        Person svetlana = new Person(2, "Svetlana", 25);
        Person svetlana1 = new Person(3, "Svetlana", 15);
        Person svetlana2 = new Person(4, "Svetlana", 20);
        Person bob = new Person(5, "Bob", 25);

        TreeSet<Person> personTreeSet = new TreeSet<>(comparator);

        personTreeSet.add(vadim);
        personTreeSet.add(svetlana);
        personTreeSet.add(svetlana1);
        personTreeSet.add(svetlana2);

        personTreeSet.add(bob);

        for (Person person: personTreeSet) {
            System.out.println(person.getName() + " " + person.getAge());
        }

    }
}
