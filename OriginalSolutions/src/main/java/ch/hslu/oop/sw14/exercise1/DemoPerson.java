/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw14.exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author yannk
 */
public class DemoPerson {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person(1, "Kraemer", "Yannis"));
        persons.add(new Person(4, "Geu", "Tabea"));
        persons.add(new Person(2, "Kraemer", "Marius"));
        persons.add(new Person(3, "Geu", "Samira"));
        persons.add(new Person(5, "Meier", "Samira"));
        persons.add(new Person(6, "A", "C"));
        persons.add(new Person(7, "B", "A"));
        persons.add(new Person(8, "C", "B"));
        printPersonList(persons);
        
        Collections.sort(persons);
        printPersonList(persons);
        
        Collections.sort(persons, Person.SURNAME_COMPARATOR.thenComparing(Person.FIRSTNAME_COMPARATOR));
        printPersonList(persons);
        
        Collections.sort(persons, Person.FIRSTNAME_COMPARATOR.reversed().thenComparing(Person.SURNAME_COMPARATOR.reversed()));
        printPersonList(persons);
    }
    
    public static void printPersonList(List<Person> persons) {
        System.out.println("#################################################");
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }
}
