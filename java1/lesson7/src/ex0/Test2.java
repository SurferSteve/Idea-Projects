package ex0;

import java.io.IOException;

/**
 * Created by Steve on 18.05.2016.
 */
public class Test2 {
    void foo1() throws Exception {
        foo2();
    }

    void foo2() throws Exception {
        // try                  (if no finally)
        // try - catch
        // try - catch - finally
        // try - finally
        try {
            test3();
        } catch (OurException e) {
            System.out.println("поймали OurException");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("поймали ошибку");
            return;
//            throw new IOException();
        } finally {  // в блоке finally - освобождение ресурсов
            System.out.println("освободили ресурсы");
        }
//        System.out.println("неправильно освободили ресурсы"); // неправильный вариант
        System.out.println("doing smth");
    }

    Cat test3() throws OurException {
//    Cat test3() {
        // опа, ошибка!
        Exception exception = new Exception("Our exception");
//        throw exception; // передача сообщения и одновременно выход из метожа (return)
        throw new OurException("что-то пошло не так");
//        throw new IOException();
//        throw new Error(); // не обязаны отлавливать
//        throw new NullPointerException(); // не обязаны отлавливать
//        throw new ArrayIndexOutOfBoundsException(); // не обязаны отлавливать
//        throw new RuntimeException(); // не обязаны отлавливать

//        throw new IOException(); // ОБЯЗАНЫ отлавливать
//        return new Cat();
    }
}
