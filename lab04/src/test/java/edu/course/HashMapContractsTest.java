package edu.course.lab04;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class HashMapContractsTest {

    private static final class CollidingKey {
        private final String code;

        private CollidingKey(String code) {
            this.code = code;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CollidingKey that = (CollidingKey) o;
            return Objects.equals(code, that.code);
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

    private static final class MutableKey {
        private String code;

        private MutableKey(String code) {
            this.code = code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MutableKey that = (MutableKey) o;
            return Objects.equals(code, that.code);
        }

        @Override
        public int hashCode() {
            return Objects.hash(code);
        }
    }

    @Test
    void hashMapShouldHandleCollisionsWhenHashCodeIsFixed() {
        Map<CollidingKey, String> map = new HashMap<>();
        CollidingKey key1 = new CollidingKey("A");
        CollidingKey key2 = new CollidingKey("B");

        assertEquals(key1.hashCode(), key2.hashCode());

        map.put(key1, "Task A");
        map.put(key2, "Task B");

        assertEquals(2, map.size());
        assertEquals("Task A", map.get(new CollidingKey("A")));
        assertEquals("Task B", map.get(new CollidingKey("B")));
    }

    @Test
    void mutatingKeyAfterPutBreaksHashMapLookup() {
        Map<MutableKey, String> map = new HashMap<>();
        MutableKey key = new MutableKey("INIT");
        map.put(key, "Important Task");

        key.setCode("CHANGED");

        assertNull(map.get(key));
        assertNull(map.get(new MutableKey("INIT")));
        assertNull(map.get(new MutableKey("CHANGED")));
        assertEquals(1, map.size());
    }
}