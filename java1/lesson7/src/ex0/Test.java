package ex0;

import java.io.IOException;

/**
 * Created by Steve on 18.05.2016.
 */
public class Test {
    void foo1() {
        foo2();
    }

    void foo2() {
//        if (test1() == -1) {
//            System.out.println("Error in test1()");
//        }
//        if (!test2()) {
//            System.out.println("Error in test2()");
//        }
        try {
            test3();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Error!");
        }
    }

//    int test1() {
//        return -1;
//    }
//
//    boolean test2() {
//        return false;
//    }

    Cat test3() throws Exception {
//    Cat test3() {
        // опа, ошибка!
        Exception exception = new Exception("Our exception");
//        throw exception; // передача сообщения и одновременно выход из метожа (return)
//        throw new IOException();
//        throw new Error(); // не обязаны отлавливать
//        throw new NullPointerException(); // не обязаны отлавливать
//        throw new ArrayIndexOutOfBoundsException(); // не обязаны отлавливать
//        throw new RuntimeException(); // не обязаны отлавливать
        throw new IOException(); // ОБЯЗАНЫ отлавливать
//        return new Cat();
    }
}
