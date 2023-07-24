package singleton;

import singleton.Caching;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CachingTest {

    private Caching caching;

    @BeforeEach
    public void setUp() {
        caching = Caching.getInstance();
    }

    @Test
    public void testGetValue() {
        caching.addValue("key1", "value1");
        assertEquals("value1", caching.getValue("key1"));
    }

    @Test
    public void testAddValue() {
        caching.addValue("newKey", "newValue");
        assertTrue(caching.hasKey("newKey"));
        assertEquals("newValue", caching.getValue("newKey"));
    }

    @Test
    public void testDeleteKey() {
        caching.addValue("keyToDelete", "valueToDelete");
        assertTrue(caching.hasKey("keyToDelete"));
        caching.deleteKey("keyToDelete");
        assertFalse(caching.hasKey("keyToDelete"));
    }

    @Test
    public void testHasKey() {
        assertFalse(caching.hasKey("nonExistingKey"));
        caching.addValue("existingKey", "existingValue");
        assertTrue(caching.hasKey("existingKey"));
    }

    @Test
    public void testLoadCache() {
        assertTrue(caching.hasKey("key1"));
        assertTrue(caching.hasKey("key2"));
        assertTrue(caching.hasKey("key3"));
        assertTrue(caching.hasKey("key4"));
    }
}
