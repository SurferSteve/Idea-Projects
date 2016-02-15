/**
 * Created by Steve on 23.08.2015.
 */
public class Test9 {
    public static void main(String[] args) {
        Test1.goPark();// Вызвали статический метод из другого класса
//        Test1.nonStaticTest();//Не можем тк. не статический

        Test1 t; // необходимый код для добавления нестатического метода
        t = new Test1();
        t.nonStaticTest();
    }
}
