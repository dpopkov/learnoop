package learn.oop.springdp.springdp.controller;

import learn.oop.springdp.springdp.factory.Pet;
import learn.oop.springdp.springdp.factory.PetFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetFactory petFactory;

    public PetController(PetFactory petFactory) {
        this.petFactory = petFactory;
    }

    @PostMapping("/adopt/{type}/{name}")
    public Pet adoptPet(@PathVariable String type, @PathVariable String name) {
        Pet pet = petFactory.createPet(type);
        pet.setName(name);
        pet.feed();
        return pet;
    }
}
