package com.hexlet.humans;

import com.hexlet.common.Course;

public class Student {

    // public <type> <name> [ = <initial value>];
    public String name = "N/A";

    public int age = 16;

    public Course course = new Course();

    // public void <name>(<values>) <exception> {...}
    public void sayHello() {
        System.out.println("Hello!!!1111");
        System.out.println("My name is - " + name);
        System.out.println("My age is: " + age);
        course.aboutCourse();
    }

}
