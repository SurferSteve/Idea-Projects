package ex10;

import ex7.Animal;

/**
 * Created by Steve on 22.05.2016.
 */
public class Gen11<T extends Number> {
    T number;

    void foo() {
        Gen11<Integer> integer;
//        integer = new Gen11<Integer>[3]; // невозможно (Generic array creation is forbidden)
        Gen11<?>[] integer2 = new Gen11<?>[3]; // ? - wildcards вохможны только в методах
    }

//    class ClassTest<T> extends Animal { // можно
//    class ClassTest<T> extends Throwable { // запрещено, нельзя ---- ограничение конкретно от Throwable
//        // чтобы не делать обобщённые исключения
//    }
}
