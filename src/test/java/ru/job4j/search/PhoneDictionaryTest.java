package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PhoneDictionaryTest {

    @Test
    public void phoneDictionaryTest() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenKeyNotFound() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Frodo", "Baggins", "350743", "Shire"));
        ArrayList<Person> persons = phones.find("Gollum");
        assertThat(persons.isEmpty(), is(true));
    }
}