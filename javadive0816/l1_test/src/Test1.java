
class Test1 {

    public static void main(String[] args) {
        System.out.println("находимся дома");
        buySomething();
    }

    static void buySomething() {
        // sout + Tab
        System.out.println("купили картошку"); // Shift - Ctrl - Enter - перенос строки и создание фигурныъ
        System.out.println("купили фасоль"); // Ctrl - D - родублировать строку
        goPark();
    }

    static void goToSea() {
        System.out.println("идём купаться");
        System.out.println("накупались");
    }

    static void goPark() {
        System.out.println("теперь мы в парке");
        goToSea();
        System.out.println("завершили прогулку в парке");
    }

    void nonStaticTest() {

    }
}