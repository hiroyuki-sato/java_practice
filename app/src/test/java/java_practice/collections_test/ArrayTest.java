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
}
