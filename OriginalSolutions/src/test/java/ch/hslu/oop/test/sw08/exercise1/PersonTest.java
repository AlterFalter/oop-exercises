/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.test.sw08.exercise1;

import ch.hslu.oop.sw08.exercise1.Person;
import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author yannk
 */
public class PersonTest {
    public Person person;
    
    @BeforeAll
    public void preparePerson() {
        this.person = new Person(1, "Kraemer", "Yannis");
    }
    
    @Test
    public void testPersonConstructorSetID() {
        assertEquals(1, person.getID());
    }
    
    @Test
    public void testPersonConstructorSetSurname() {
        assertEquals("Kraemer", person.getSurname());
    }
    
    @Test
    public void testPersonConstructorSetFirstname() {
        assertEquals("Yannis", person.getFirstname());
    }
    
    @Test
    public void testToString() {
        assertEquals("Class: Person - ID: 1 | Surname: Kraemer | Firstname: Yannis", person.toString());
    }
    
    @Test
    public void testEqualsVerifier() {
        EqualsVerifier.forClass(Person.class).verify();
    }
    
    @Test
    public void testEqualsSameValues() {
        Person person2 = new Person(1, "Kraemer", "Yannis");
        assertEquals(person, person2);
    }
    
    @Test
    public void testEqualsNegative() {
        Person person2 = new Person(2, "Kraemer", "Marius");
        assertEquals(person, person2);
    }
    
    @Test
    public void testHashCode() {
        Person person2 = new Person(1, "Kraemer", "Yannis");
        assertEquals(person.hashCode(), person2.hashCode());
    }
}
