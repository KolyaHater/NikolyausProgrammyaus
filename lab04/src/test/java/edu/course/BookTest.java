package edu.course.lab04;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldFindValueInHashMapByAnotherBookWithSameIsbn() {
        Map<Book, String> storage = new HashMap<>();
        Book putKey = new Book("978-5-001", "Java Basics");
        Book lookupKey = new Book("978-5-001", "Java Basics (2nd edition)");

        storage.put(putKey, "Shelf A1");

        assertEquals(putKey, lookupKey);
        assertEquals(putKey.hashCode(), lookupKey.hashCode());
        assertEquals("Shelf A1", storage.get(lookupKey));
    }

    @Test
    void booksWithDifferentIsbnShouldNotBeEqual() {
        Book first = new Book("978-5-001", "Same Title");
        Book second = new Book("978-5-002", "Same Title");

        assertNotEquals(first, second);
        assertFalse(first.equals(null));
        assertFalse(first.equals("978-5-001"));
    }
}