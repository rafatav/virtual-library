package services;

import entities.User;
import repositories.UserRepository;

import java.util.List;
import java.util.Objects;

public abstract class UserService {

    public static List<User> findAll() {
        return UserRepository.getList();
    }

    public static User findById(Long id) {
        for (User user : UserRepository.getList()) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }

    public static void insert(User user) {
        UserRepository.getList().add(user);
    }

    public static void remove(User userToRemove) {
        UserRepository.getList().removeIf(bookLoan -> bookLoan.equals(userToRemove));
    }
}
