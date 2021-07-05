package java_practice.stream_test;

import org.junit.jupiter.api.Test;

import javax.annotation.OverridingMethodsMustInvokeSuper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamTest
{

    @Test
    public void basicTest() {
        List<Student> students = sampleStudents();

        //assertEquals(3,students.size(),"number of students");

        students.stream()
                .filter(s -> s.getScore() > 70 )
                .forEach(s -> System.out.println(s));

//        Collections.sort(students, (student1, student2) -> Integer.compare(student1.getScore(), student2.getScore()));
        Collections.sort(students,(Student student1, Student student2) -> { return Integer.compare(student1.getScore(), student2.getScore());});

        System.out.println(students);
    }



    private class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
        public int getScore() {
            return score;
        }
        public String getName() {
            return name;
        }
        @Override
        public String toString() {
            return name + ": " + score;
        }
    }
    private List<Student> sampleStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("ken",100));
        students.add(new Student("shin", 60));
        students.add(new Student("Takuya",80));

        return students;
    }
}
