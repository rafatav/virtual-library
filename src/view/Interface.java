package view;

import entities.Book;
import entities.BookLoan;
import entities.BookStatus;
import services.BookLoanService;
import services.BookService;
import services.UserService;

import java.util.*;

public class Interface {

    static Scanner sc = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("    Escolha uma das opções abaixo:\n");
        System.out.println("    (1)CATÁLOGO DE LIVROS");
        System.out.println("    (2)LIVROS EMPRESTADOS");
        System.out.println("    (3)LIVROS RECOMENDADOS");
        System.out.println("    (4)HISTÓRICO");
        System.out.println("    (0)SAIR");

        System.out.print("    >>> Digite o código: ");

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
            case ("0"):
                System.out.println("\n    >>> FIM DA APLICAÇÃO <<<");
                System.exit(0);
            default:
                mainMenu();
        }
    }

    public static void showCatalog() {
        try {
            System.out.println("\n    [CATÁLOGO DE LIVROS]");
            for (Book book : BookService.findAll()) {
                System.out.println("    (" + book.getId() + ") " + book.getTitle() + ", ano: " + book.getYear());
            }
            System.out.print("\n    >>> Digite o código do livro que deseja visualizar: ");
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
                } else if (book.getWaitlist().contains(UserService.findById(1L))) {
                    System.out.println("\n    USUÁRIO JÁ ESTÁ CADASTRADO NA LISTA DE ESPERA.");
                    pressEnter();
                } else {
                    BookService.addToWaitlist(book);
                    System.out.println("\n    LIVRO INDISPONÍVEL. USUÁRIO ADICIONADO À LISTA DE ESPERA.");
                    pressEnter();
                }
            }
            System.out.println();
            mainMenu();
        } catch (RuntimeException e) {
            System.out.println("\n    Código inexistente!");
            pressEnter();
            mainMenu();
        }
    }

    public static void showBrowsingHistory() {
        System.out.println("\n    [HISTÓRICO DE NAVEGAÇÃO]");
        System.out.println("    Visitas mais recentes: ");
        for (Book book : UserService.getBrowsingHistory().reversed()) {
            System.out.println("    - " + book.getTitle());
        }
        pressEnter();
        mainMenu();
    }

    public static void showBorrowedBook() {
        System.out.println("\n    [LIVROS EMPRESTADOS]");
        for (BookLoan bookLoan : UserService.getBorrowedBooks()) {
            System.out.println("    Cód: " + (bookLoan.getId() + 1) + " | Livro: " + bookLoan.getBook().getTitle() +
                    " || Data de devolução: " + BookLoan.fmt.format(bookLoan.getDueDate()));
        }
        pressEnter();
        System.out.println();
        mainMenu();
    }

    private static void showRecommendedBook() {
        System.out.println("\n    [LIVROS RECOMENDADOS]");
        Random random = new Random();
        try {
            Book randomBookBorrowed = UserService.getBorrowedBooks().get(random.nextInt(UserService.getBorrowedBooks().
                    size())).getBook();

            System.out.println("    Baseado no seu interesse em " + randomBookBorrowed.getTitle() + ", recomendamos:\n");

            Map<Book, Integer> distances = BookService.djikstraAlgorithm(BookService.bookRecommendationGraph(), randomBookBorrowed);

            distances.remove(randomBookBorrowed);

            List<Map.Entry<Book, Integer>> lineup = new ArrayList<>(distances.entrySet());
            lineup.sort(Map.Entry.comparingByValue());

            int limit = 4;
            int count = 0;

            for (Map.Entry<Book, Integer> entry : lineup) {
                Book book = entry.getKey();
                int distance = entry.getValue();
                System.out.print("    " + book.getTitle() + ", de " + book.getAuthor() + "\n");
                if (++count == limit) break;
            }
            pressEnter();
            mainMenu();
        } catch (IllegalArgumentException e) {
            System.out.println("    SELECIONE UM LIVRO DO CATÁLOGO DE LIVROS E FAÇA UM EMPRÉSTIMO ANTES DE RECEBER RECOMENDAÇÕES.");
            pressEnter();
            mainMenu();
        }
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
