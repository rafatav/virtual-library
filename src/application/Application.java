package application;

import entities.Book;
import services.BookService;

public class Application {

    public static void main(String[] args) {
        BookService.insert(new Book(1L, "Memórias do Subsolo", "Fiódor Dostoiévski",
                "978-8573261851", 1864, "Editora 34"));
        BookService.insert(new Book(2L, "O Senhor das Moscas", "William Golding",
                "978-8520918432", 1954, "Editora Nova Fronteira"));
        BookService.insert(new Book(3L, "Torto Arado", "Itamar Vieira Junior",
                "978-6580309313", 2019, "Editora Todavia"));

        for (Book book : BookService.findAll()) {
            System.out.println(book);
        }
    }
}
