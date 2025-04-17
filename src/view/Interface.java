package view;

import entities.Book;
import entities.BookLoan;
import entities.BookStatus;
import services.BookLoanService;
import services.BookService;
import java.util.Scanner;

public class Interface {

    static Scanner sc = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("    (1) CATÁLOGO DE LIVROS");
        System.out.println("    (2) LIVROS EMPRESTADOS");
        System.out.println("    (3) LISTA DE ESPERA");
        System.out.println("    (4) HISTÓRICO");
        System.out.println("    (5) SAIR");

        System.out.print("    >>> Digite a opção: ");

        String n = sc.next();
        switch (n) {
            case ("1"):
                Interface.showCatalog();
        }
    }

    public static void showCatalog() {
        System.out.println("\n    [CATÁLOGO DE LIVROS]");
        for (Book book : BookService.findAll()) {
            System.out.println("    (" + book.getId() + ") " + book.getTitle() + ", ano: " + book.getYear());
        }
        System.out.print("\n    >>> Digite o número do livro que deseja vizualizar: ");
        Long id = sc.nextLong();
        Book book = BookService.findById(id);
        System.out.println(book);
        System.out.print("\n    >>> Deseja pegar esse livro emprestado? (s/n)? ");
        char c = sc.next().toLowerCase().charAt(0);
        if (c == 's') {
            if (book.getStatus() == BookStatus.AVAILABLE) {
                BookLoan bookLoan = BookLoanService.loan(book);
                System.out.println("\n    LIVRO EMPRESTADO COM SUCESSO! ");
                System.out.print(bookLoan);
                System.out.print("\n    Pressione ENTER para voltar ao menu principal.\n");
                try {
                    System.in.read();
                    sc.nextLine();
                } catch(Exception e) {
                }
                mainMenu();
            }
        }
    }
}
