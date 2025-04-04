package application;

import entities.Book;
import entities.User;
import resources.Seed;
import services.BookService;

public class Application {

    public static void main(String[] args) {
        Seed.books();

        User user = new User(1L, "Wellington Monteiro", "wellington@gmail.com", "123456");

        for (Book book : BookService.findAll()) {
            System.out.println(book);
        }
    }
}
