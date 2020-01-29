package learn.oop.acdpsp.ch04interf.nullobj;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository repository = new UserRepositoryList();
        User user;

        user = repository.getById(100);
        user.incrementValue();
        System.out.println(user);

        user = repository.getById(42);
        user.incrementValue();
        System.out.println(user);

        Optional<String> os = Optional.empty();

    }
}
