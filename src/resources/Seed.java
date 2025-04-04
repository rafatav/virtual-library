package resources;

import entities.Book;
import entities.BookStatus;
import services.BookService;

public abstract class Seed {

    public static void books() {
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
        BookService.insert(new Book(11L, "Fahrenheit 451", "Ray Bradbury",
                "978-8525052247", 1953, "Editora Biblioteca Azul", BookStatus.AVAILABLE));
        BookService.insert(new Book(12L, "A Metamorfose", "Franz Kafka",
                "978-8571646858", 1915, "Companhia das Letras", BookStatus.AVAILABLE));
        BookService.insert(new Book(13L, "Vista Chinesa", "Tatiana Salém Levy",
                "978-6551140204", 2021, "Editora Todavia", BookStatus.AVAILABLE));
        BookService.insert(new Book(14L, "Olhos D'água", "Conceição Evaristo",
                "978-8534705257", 2014, "Fósforo Pallas", BookStatus.AVAILABLE));
        BookService.insert(new Book(15L, "A Pediatra", " Andréa del Fuego",
                "978-6559213481", 2021, "Companhia das Letras", BookStatus.AVAILABLE));
        BookService.insert(new Book(16L, "O Sol é Para Todos", "Harper Lee",
                "978-8503009492", 1960, "Editora José Olympio", BookStatus.AVAILABLE));
        BookService.insert(new Book(17L, "Uma Vida Pequena", "Hanya Yanagihara",
                "978-8501071545", 2015, "Editora Record", BookStatus.AVAILABLE));
        BookService.insert(new Book(18L, "Maurice", "E. M. Forster",
                "978-8525041197", 1971, "Editora Biblioteca Azul", BookStatus.AVAILABLE));
        BookService.insert(new Book(19L, "Meridiano de Sangue", "Cormac McCarthy",
                "978-8560281930", 1985, "Editora Alfaguara", BookStatus.UNAVAILABLE));
        BookService.insert(new Book(20L, "Ratos e Homens", "John Steinbeck",
                "978-8525427991", 1937, "Editora L&PM", BookStatus.AVAILABLE));
    }

}
