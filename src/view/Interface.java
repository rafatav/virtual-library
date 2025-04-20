package view;

import entities.Book;
import entities.BookLoan;
import entities.BookStatus;
import services.BookLoanService;
import services.BookService;
import services.UserService;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Interface {

    static Scanner sc = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("    Escolha uma das opções abaixo:\n");
        System.out.println("    (1)CATÁLOGO DE LIVROS");
        System.out.println("    (2)LIVROS EMPRESTADOS");
        System.out.println("    (3)LIVROS RECOMENDADOS");
        System.out.println("    (4)HISTÓRICO");
        System.out.println("    (5)SAIR");

        System.out.print("    >>> Digite a opção: ");

        String n = sc.next();
        switch (n) {
            case ("1"):
                showCatalog();
            case ("2"):
                showBorrowedBook();
            case ("3"):
                showRecommendedBook();
            case ("4"):
                showBrowsingHistory();
            case ("5"):
                System.out.println("\n    >>> FIM DA APLICAÇÃO <<<");
                System.exit(0);
        }
    }

    public static void showCatalog() {
        System.out.println("\n    [CATÁLOGO DE LIVROS]");
        for (Book book : BookService.findAll()) {
            System.out.println("    (" + book.getId() + ") " + book.getTitle() + ", ano: " + book.getYear());
        }
        System.out.print("\n    >>> Digite o código do livro que deseja vizualizar: ");
        Long id = sc.nextLong();
        Book book = BookService.findById(id);
        UserService.addToBrowsingHistory(book);
        System.out.println(book);
        System.out.print("\n    >>> Deseja pegar esse livro emprestado? (s/n)? ");
        char c = sc.next().toLowerCase().charAt(0);
        if (c == 's') {
            if (book.getStatus() == BookStatus.AVAILABLE) {
                BookLoan bookLoan = BookLoanService.loan(book);
                System.out.println("\n    LIVRO EMPRESTADO COM SUCESSO! ");
                System.out.print(bookLoan);
                pressEnter();
                System.out.println();
                mainMenu();
            }
            BookService.addToWaitlist(book);
            System.out.println("\n    LIVRO INDISPONÍVEL. USUÁRIO ADICIONADO À LISTA DE ESPERA.");
            pressEnter();
        }
        System.out.println();
        mainMenu();
    }

    public static void showBrowsingHistory() {
        System.out.println("\n    [HISTÓRICO DE NAVEGAÇÃO]");
        for (Book book : UserService.getBrowsingHistory().reversed()) {
            System.out.println("    Título: " + book.getTitle());
        }
        pressEnter();
        mainMenu();
    }

    public static void showBorrowedBook() {
        System.out.println("\n    [LIVROS EMPRESTADOS]");
        for (BookLoan bookLoan : UserService.getBorrowedBooks()) {
            System.out.println("    Título: " + bookLoan.getBook().getTitle() + " || Data de devolução: " +
                    BookLoan.fmt.format(bookLoan.getDueDate()));
        }
        pressEnter();
        System.out.println();
        mainMenu();
    }

    private static void showRecommendedBook() {
        System.out.println("\n    [LIVROS RECOMENDADOS]");

        // recommendation based on a random borrowed book:
        Random random = new Random();
        Book randomBookBorrowed = UserService.getBorrowedBooks().get(random.nextInt(UserService.getBorrowedBooks().size())).getBook();

        System.out.println("\n    Livros recomendados baseado no seu interesse em " + randomBookBorrowed.getTitle() +
                " e " + randomBookBorrowed.getCategories().getFirst().getName() + ":\n");

        for (Book book : Objects.requireNonNull(BookService.getGraph(randomBookBorrowed))) {
            System.out.print("    " + book.getTitle() + ", de " + book.getAuthor() + "\n");
        }

        // recommendation based only on the first book borrowed:
//        Book firstBookBorrowed = UserService.getBorrowedBooks().getFirst().getBook();
//
//        for (Book book : Objects.requireNonNull(BookService.getGraph(firstBookBorrowed))) {
//                System.out.print("    " + book.getTitle() + "\n");
//            }

        // recommendation based on all the books borrowed:
//        for (BookLoan bookLoan : UserService.getBorrowedBooks()) {
//            for (Book book : BookService.getGraph(bookLoan.getBook())) {
//                System.out.print("    " + book.getTitle() + "\n");
//            }
//        }
        pressEnter();
        mainMenu();
    }

    public static void pressEnter() {
        System.out.print("    Pressione ENTER para voltar ao menu principal.");
        try {
            System.in.read();
            sc.nextLine();
        } catch(Exception e) {
        }
    }
}
