package edu.ti.caih313.collections.dataobj;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static edu.ti.caih313.collections.dataobj.Person.Gender.MALE;
import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testToString() {
        Person bob = new Person(new Name("Bob", "Smith"), MALE, LocalDate.of(1960, Month.MARCH, 15));
        bob.emailAddress = new EmailAddress("bob@gmail.com", EmailAddress.Type.HOME);
        assertEquals("Person{ name = Smith, Bob, gender = MALE, birthdate = Mar 15, 1960 CE, emails = bob@gmail.com", bob.toString());
    }

    @Test
    public void testToStringNoEmail() {
        Person bob = new Person(new Name("Bob", "Smith"), MALE, LocalDate.of(1960, Month.MARCH, 15));
        assertEquals("Person{ name = Smith, Bob, gender = MALE, birthdate = Mar 15, 1960 CE, emails = no emails available", bob.toString());
    }
}

