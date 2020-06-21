/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08.exercise2;

import java.util.Comparator;

/**
 *
 * @author yannk
 */
public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person person, Person otherPerson) {
        int compareResult = person.getSurname().compareTo(otherPerson.getSurname());
        if (compareResult == 0) {
            compareResult = person.getFirstname().compareTo(otherPerson.getFirstname());
            if (compareResult == 0) {
                compareResult = Long.compare(person.getID(), otherPerson.getID());
            }
        }
        return compareResult;
    }
}
