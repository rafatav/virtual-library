package application;

import entities.User;
import resources.Seed;
import services.BookService;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Seed.books();

        System.out.print("Digite o seu nome: ");
        String name = sc.nextLine();
        User user = new User(1L, name, name.toLowerCase().replaceAll("\\s", "") +
                "@gmail.com", "123456");

        user.getBrowsingHistory().add(BookService.findById(1L));

        System.out.println("\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| BIBLIOTECA VIRTUAL DALTON TREVISAN |||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

        System.out.println("\nOlá, " + user.getName() + ". Bem-vindo à Biblioteca Virtual Dalton Trevisan");

    }
}
