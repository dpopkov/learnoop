package learn.oop.acdpsp.ch04interf.nullobj;

import java.util.List;

public class UserRepositoryList implements UserRepository {
    private List<User> users = List.of(
            new RegularUser(100),
            new RegularUser(101),
            new RegularUser(102),
            new RegularUser(103)
    );

    @Override
    public User getById(int id) {
        User found = NullUser.get();
        for (User ru : users) {
            if (id == ru.getId()) {
                found = ru;
                break;
            }
        }
        return found;
    }
}
