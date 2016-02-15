/**
 * Created by Steve on 23.08.2015.
 */
public class Test4 {
    public static void main(String[] args) {
        String plate;
        plate = "сметана, ";
        plate = plate + "листья салата, ";
        plate = plate + slicer("помидорки, ");
        plate = plate + slicer("огурцы");
        System.out.println("plate"); // Выводит только слово plate
        System.out.println(plate);

    }

    private static String slicer(String vegetable) {
        String resultPlate = "нарезанные " + vegetable;
        return resultPlate;
    }

}


