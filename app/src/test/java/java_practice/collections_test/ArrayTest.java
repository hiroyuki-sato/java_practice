package java_practice.collections_test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayTest
{
    @Test
    void myTest(){
        List<Integer> myList = new ArrayList<>();
        assertEquals(0,myList.size(),"length");
    }

    @Test
    void basicListMethodTests(){
        List fruits = sampleArray();

        assertEquals(4, fruits.size(),"fruits size");
        fruits.remove(0);
        assertEquals(3, fruits.size());
        assertEquals("banana", fruits.get(0), "first fruits name");
        // List<String> test = List.of("a","b","c");

        fruits.add(0,"grape");
        assertEquals(4,fruits.size());
        assertEquals("grape", fruits.get(0));
    }

    private List sampleArray() {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("peach");
        fruits.add("orange");
        return fruits;
    }
}
