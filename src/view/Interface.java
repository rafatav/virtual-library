package view;

import entities.Book;
import services.BookService;

public class Interface {

    public static void showCatalog() {
        System.out.println("|||\n||| CATÁLOGO DE LIVROS:\n");
        for (Book book : BookService.findAll()) {
            System.out.println("|||\n||| (" + book.getId() + ") " + book.getTitle() + " " + book.getYear());
        }
    }
}
