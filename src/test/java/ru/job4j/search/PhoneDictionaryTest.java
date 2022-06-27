package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class PhoneDictionaryTest {

    @Test
    public void phoneDictionaryTest() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenKeyNotFound() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Frodo", "Baggins", "350743", "Shire"));
        var persons = phones.find("Gollum");
        assertTrue(persons.isEmpty());
    }
}