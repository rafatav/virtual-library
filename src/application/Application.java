package application;

import entities.Book;
import entities.BookStatus;
import services.BookService;

public class Application {

    public static void main(String[] args) {
        BookService.insert(new Book(1L, "Memórias do Subsolo", "Fiódor Dostoiévski",
                "978-8573261851", 1864, "Editora 34", BookStatus.AVAILABLE));
        BookService.insert(new Book(2L, "O Senhor das Moscas", "William Golding",
                "978-8520918432", 1954, "Editora Nova Fronteira", BookStatus.AVAILABLE));
        BookService.insert(new Book(3L, "Torto Arado", "Itamar Vieira Junior",
                "978-6580309313", 2019, "Editora Todavia", BookStatus.AVAILABLE));
        BookService.insert(new Book(4L, "O Acontecimento", "Annie Ernaux",
                "978-6589733553", 2000, "Fósforo Editora", BookStatus.AVAILABLE));
        BookService.insert(new Book(5L, "O Apanhador no Campo de Centeio", "J.D. Salinger",
                "978-6580309030", 1951, "Editora Todavia", BookStatus.AVAILABLE));
        BookService.insert(new Book(6L, "A Festa do Bode", "Mario Vargas Llosa",
                "978-8579620638", 2000, "Editora Alfaguara", BookStatus.AVAILABLE));
        BookService.insert(new Book(7L, "Crime e Castigo", "Fiódor Dostoiévski",
                "978-8525416476", 1866, "Editora L&PM", BookStatus.AVAILABLE));
        BookService.insert(new Book(8L, "A Morte de Ivan Ilitch", "Lev Tolstói",
                "978-8573263596", 1886, "Editora 34", BookStatus.AVAILABLE));
        BookService.insert(new Book(9L, "Tudo é Rio", "Carla Madeira",
                "978-6555871784", 2014, "Editora Record", BookStatus.UNAVAILABLE));
        BookService.insert(new Book(10L, "O Senhor do Lado Esquerdo", "Alberto Mussa",
                "978-8501101143", 2011, "Editora Record", BookStatus.AVAILABLE));

        for (Book book : BookService.findAll()) {
            System.out.println(book);
        }
    }
}
