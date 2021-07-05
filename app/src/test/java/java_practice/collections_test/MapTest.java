package java_practice.collections_test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapTest
{
    @Test
    public void basicMapTest() {
        Map<String,String> map = new HashMap<>();
        map.put("apple","fruits");
        map.put("cucumber","vegetables");
        map.put("banana", "fruits");
        assertEquals(3,map.size());
        assertEquals("vegetables",map.get("apple"));
    }
}
