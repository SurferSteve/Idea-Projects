package ex10;

/**
 * Created by Steve on 22.05.2016.
 */
public class Gen10<T, V> {
    // static использовать нельзя
    //    static T o1s; // T уточняется только тогда, когда используем new
    // если захотим вызвать из другого класса, непонятно что использовать для вызова
    T o1;
    V o2;

    T[] objects;

    void set(T object1) {
        o1 = object1;
    }

//    void set(V object1) { // нельзя, т.к. T и V могут быть одинаковые объекты
//        o2 = object1; // поэтому такой метод перегрухить нельзя
//    } // + Generics доступны только во время компиляции, а
    // на самом деле при выполнении программы (или .class, .jar) Дженерики заменены на объекты
    // это сделано для совместимости со старыми JRE версиями - СТИРАНИЕ
    // все типы (T, V) - замещаются на объекты, т.е. вначале стираются

    void set(T object1, V object2) {
        o1 = object1;
        o2 = object2;
    }

    void createNewObject() {
//        o1 = new T(); // невозможно (а в языке C, C++ так нельзя)
//        o1 = new Object(); // нисходящее преобразование, ПРЕДОК -> Потомок (поэтому нельзя)

//        objects = new Object[3]; // невозможно из-за стирания
//        objects = new T[3];      // невозможно из-за стирания
    }
}
