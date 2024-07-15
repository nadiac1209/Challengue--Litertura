package com.example.literAlura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Menú:");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Listar todos los autores");
            System.out.println("4. Listar autores vivos en determinado año");
            System.out.println("5. Mostrar estadísticas de libros por idioma");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            switch (option) {
                case 1:
                    System.out.print("Introduce el título del libro: ");
                    String title = scanner.nextLine();
                    bookService.searchBookByTitle(title);
                    break;
                case 2:
                    bookService.listAllBooks();
                    break;
                case 3:
                    bookService.listAllAuthors();
                    break;
                case 4:
                    System.out.print("Introduce el año: ");
                    int year = scanner.nextInt();
                    bookService.listAuthorsAliveInYear(year);
                    break;
                case 5:
                    bookService.showBookStatisticsByLanguage();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}
