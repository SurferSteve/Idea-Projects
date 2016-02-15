package com.hexlet;

import com.hexlet.common.Course;
import com.hexlet.buildings.Building;
import com.hexlet.humans.Student;

public class Main {

//    public static void main - psvm

    public static void main(String[] args) {

        Student studentMax = new Student();
        studentMax.course.name = "Java course";
        studentMax.name = "Max";
        studentMax.sayHello();
        // System.out.println(studentMax.course);
        Student studentSlava = new Student();
        studentSlava.sayHello();
    }
}


// <type> <name>
//        System.out.println("1");
//        com.hexlet.humans.Student studentMax = null;
//        studentMax = new com.hexlet.humans.Student();
//        studentMax.name = "Max";
//        System.out.println("2");
//        studentMax.sayHello();
//        studentMax.age = 25;
//        System.out.println("3");
//        studentMax.sayHello();
//
//        System.out.println("~~~~~~~~~~~~");
//        com.hexlet.humans.Student studentSlava = new com.hexlet.humans.Student();
//        studentSlava.name = "Viacheslav";
//        studentSlava.sayHello();
//        System.out.println("~~~~~~~~~~~~");
//        studentMax.sayHello();
//
//        com.hexlet.common.Course courseJava = new com.hexlet.common.Course();
//        courseJava.name = "Java class";
//        System.out.println(courseJava.name);


//    import java.io.IOException;
//
//    public class com.hexlet.Main {
//
//        public static void main (String[] args ) throws IOException       {
//            String name = "Sergey";
//            int myAge = 23;
//            double weight = 60.5;
//            String outString = name + ": age " + myAge + ", weight " + weight;
//            System.out.println(outString);
//            System.out.println(outString);
//            // > < >= <= !=
//            boolean old = myAge >= 99;
//            boolean y = myAge < 99;
//            System.out.println("Old: " + old);
//            System.out.println("Young: " + y);
//        }
//
//    }