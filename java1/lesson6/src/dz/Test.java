package dz;


/**
 * Created by Steve on 11.05.2016.
 */
public class Test implements TestInterf {
    public static void main(String[] args) {
        Test test = new Test();
        test.act();
    }

    public abstract class TestA implements TestInterf {
        int x;
        int y;

        void say() {
            System.out.println("Hello");
        }

//    Test test = new Test(); // нельзя

        Test1 test1 = new Test1() {
            @Override
            public void sayTest() {

            }
        };
//    Test1.sayTest(); // нельзя
//    test1.sayTest(); // нельзя
    }
    public interface Test1 {
        final static int X = 1;

        void sayTest();
//        void sayTest2() { // нельзя реализовывать метод в интерфейсе
//            System.out.println();
//        }
    }

//    public class TestUsualClass extends Test1 { // запрещено наследовать абстрактный класс не-абстрактным классом
//
//    }
}