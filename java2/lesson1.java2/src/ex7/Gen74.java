package ex7;

import java.util.Collection;
import java.util.List;

/**
 * Created by Steve on 22.05.2016.
 */
public class Gen74<T extends Animal> {
    List<T> animals;

    public Gen74(List<T> animals) {
        this.animals = animals;
    }

    public void put(Gen74<? extends Animal> anotherAnimals) { // потомки в том числе от кошки // ограничение по потомкам Animal -> Cat
        animals.addAll((Collection<? extends T>) anotherAnimals.animals);

    }
    public void show2(Gen74<? super Animal> anotherAnimal) { // предки в том числе Animal // ограничение по предкам Animal
//        anotherAnimal.animal[0].test();
    }
}
