/**
 * Created by Steve on 23.08.2015.
 */
public class Test5ifSwitch {
    public static void main(String[] args) {
        int hp = 100;
        int damage = 10;

//        hp = hp - damage;
        hp -= damage; // короткий способ записи

        if (hp <= 0) {
            System.out.println("Dead");
        } else {
            System.out.println("wounded");
            System.out.println("current hp: " + hp);
        }


//        int grade = 4;
//        if (grade == 5) {
//            System.out.println("best");
//        }
//        if (grade == 4) {
//            System.out.println("good");
//        }
//        if (grade == 3) {
//            System.out.println("normal");
//        }
//        if (grade == 2) {
//            System.out.println("bad");
//        }


        int grade = 4;
        switch (grade) {
            case 5:
            System.out.println("best");
            break;
            case 4:
            System.out.println("good");
            break;
            case 3:
            System.out.println("normal");
            break;
            case 2:
            System.out.println("bad");
            break;
        }


        }
    }
