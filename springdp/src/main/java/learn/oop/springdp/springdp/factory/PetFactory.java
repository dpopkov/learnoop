package learn.oop.springdp.springdp.factory;

import org.springframework.stereotype.Component;

@Component
public class PetFactory {

    public Pet createPet(String animalType) {
        switch (animalType.toLowerCase()) {
            case "dog":
                return new Dog();
            case "cat":
                return new Cat();
            default:
                throw new UnsupportedOperationException("Cannot create pet of unknown animal type " + animalType);
        }
    }
}
