package ex7;

/**
 * Created by Steve on 22.05.2016.
 */
public class Gen73<T extends Animal> {
    private T animal;

    public Gen73(T animal) {
        this.animal = animal;
    }

    //    public void show(Gen73<?> anotherAnimal) { // не работает для метода Cat
    public void show(Gen73<? extends Cat> anotherAnimal) { // потомки в том числе от кошки // ограничение по потомкам Animal -> Cat
        anotherAnimal.animal.destroySofa();
    }

    public void show2(Gen73<? super Animal> anotherAnimal) { // предки в том числе Animal // ограничение по предкам Animal
        anotherAnimal.animal.test();
    }
}
