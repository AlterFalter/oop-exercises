/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw14.exercise1;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author yannk
 */
public class Person implements Comparable<Person> {
    public final static Comparator<Person> ID_COMPARATOR = (p1, p2) -> Long.compare(p1.getID(), p2.getID());
    public final static Comparator<Person> SURNAME_COMPARATOR = (p1, p2) -> p1.getSurname().compareTo(p2.getSurname());
    public final static Comparator<Person> FIRSTNAME_COMPARATOR = (p1, p2) -> p1.getFirstname().compareTo(p2.getFirstname());
    
    private final long ID;
    private String surname;
    private String firstname;
    
    public Person(final long id, String surname, String firstname) {
        this.ID = id;
        this.surname = surname;
        this.firstname = firstname;
    }
    
    public long getID() {
        return this.ID;
    }
    
    public String getSurname() {
        return this.surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    @Override
    public String toString() {
        return "Class: " + Person.class.getName() +
                " - ID: " + this.ID + 
                " | surname: " + this.surname + 
                " | firstname: " + this.firstname;
    }
    
    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        // also makes null check
        else if (!(other instanceof Person)) {
            return false;
        }
        else {
            Person otherPerson = (Person) other;
            return otherPerson.ID == this.ID &&
                   otherPerson.surname.equals(this.surname) &&
                   otherPerson.firstname.equals(this.firstname);
        }
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.ID);
    }

    @Override
    public int compareTo(Person other) {
        return ID_COMPARATOR.compare(this, other);
    }
}
