package services;

import entities.Book;
import entities.BookLoan;
import entities.User;
import repositories.UserRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

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

    public static void addToBrowsingHistory(Book book) {
        findById(1L).getBrowsingHistory().add(book);
    }

    public static Stack<Book> getBrowsingHistory() {
        return findById(1L).getBrowsingHistory();
    }

    public static LinkedList<BookLoan> getBorrowedBooks() {
        return findById(1L).getLoans();
    }
}
