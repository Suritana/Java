import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try {
            // Чтение и парсинг JSON файла с помощью Gson
            Gson gson = new Gson();
            Type visitorListType = new TypeToken<List<Visitor>>(){}.getType();
            List<Visitor> visitors = gson.fromJson(new FileReader("books.json"), visitorListType);

            System.out.println("=== ЛАБОРАТОРНАЯ РАБОТА 4 ===");
            System.out.println("Stream API, Gson, Lombok\n");

            // Задание 1
            task1(visitors);

            // Задание 2
            task2(visitors);

            // Задание 3
            task3(visitors);

            // Задание 4
            task4(visitors);

            // Задание 5
            task5(visitors);

            // Задание 6
            task6(visitors);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Задание 1: Вывести список посетителей и их количество
    public static void task1(List<Visitor> visitors) {
        System.out.println("=== ЗАДАНИЕ 1 ===");
        System.out.println("Список посетителей:");

        visitors.stream()
                .map(v -> v.getName() + " " + v.getSurname() + " (" + v.getPhone() + ")")
                .forEach(System.out::println);

        long count = visitors.stream().count();
        System.out.println("\nОбщее количество посетителей: " + count);
        System.out.println();
    }

    // Задание 2: Вывести список и количество всех уникальных книг
    public static void task2(List<Visitor> visitors) {
        System.out.println("=== ЗАДАНИЕ 2 ===");

        List<Book> uniqueBooks = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Уникальные книги в избранном:");
        uniqueBooks.forEach(book ->
                System.out.println("- " + book.getName() + " (" + book.getAuthor() + ")")
        );

        System.out.println("\nКоличество уникальных книг: " + uniqueBooks.size());
        System.out.println();
    }

    // Задание 3: Отсортировать книги по году издания
    public static void task3(List<Visitor> visitors) {
        System.out.println("=== ЗАДАНИЕ 3 ===");
        System.out.println("Книги, отсортированные по году издания:");

        List<Book> sortedBooks = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .distinct()
                .sorted(Comparator.comparingInt(Book::getPublishingYear))
                .collect(Collectors.toList());

        sortedBooks.forEach(book ->
                System.out.println(book.getPublishingYear() + ": " + book.getName() + " - " + book.getAuthor())
        );

        System.out.println();
    }

    // Задание 4: Проверить наличие книг Jane Austen
    public static void task4(List<Visitor> visitors) {
        System.out.println("=== ЗАДАНИЕ 4 ===");

        boolean hasJaneAusten = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .anyMatch(book -> "Jane Austen".equals(book.getAuthor()));

        if (hasJaneAusten) {
            List<String> austenLovers = visitors.stream()
                    .filter(v -> v.getFavoriteBooks().stream()
                            .anyMatch(book -> "Jane Austen".equals(book.getAuthor())))
                    .map(v -> v.getName() + " " + v.getSurname())
                    .collect(Collectors.toList());

            System.out.println("Книги Jane Austen найдены в избранном у следующих посетителей:");
            austenLovers.forEach(System.out::println);
        } else {
            System.out.println("Книги Jane Austen не найдены в избранном.");
        }
        System.out.println();
    }

    // Задание 5: Максимальное количество книг у одного посетителя
    public static void task5(List<Visitor> visitors) {
        System.out.println("=== ЗАДАНИЕ 5 ===");

        OptionalInt maxBooks = visitors.stream()
                .mapToInt(v -> v.getFavoriteBooks().size())
                .max();

        if (maxBooks.isPresent()) {
            int max = maxBooks.getAsInt();
            List<String> topReaders = visitors.stream()
                    .filter(v -> v.getFavoriteBooks().size() == max)
                    .map(v -> v.getName() + " " + v.getSurname() + " - " + max + " книг")
                    .collect(Collectors.toList());

            System.out.println("Максимальное количество книг у одного посетителя: " + max);
            System.out.println("Посетители с максимальным количеством книг:");
            topReaders.forEach(System.out::println);
        }
        System.out.println();
    }

    // Задание 6: Генерация SMS сообщений
    public static void task6(List<Visitor> visitors) {
        System.out.println("=== ЗАДАНИЕ 6 ===");

        // Вычисляем среднее количество книг
        double averageBooks = visitors.stream()
                .mapToInt(v -> v.getFavoriteBooks().size())
                .average()
                .orElse(0.0);

        System.out.println("Среднее количество книг на посетителя: " + String.format("%.2f", averageBooks));

        // Генерируем SMS сообщения для подписанных посетителей
        List<SmsMessage> smsMessages = visitors.stream()
                .filter(Visitor::isSubscribed)
                .map(v -> {
                    int bookCount = v.getFavoriteBooks().size();
                    String message;

                    if (bookCount > averageBooks) {
                        message = "you are a bookworm";
                    } else if (bookCount < averageBooks) {
                        message = "read more";
                    } else {
                        message = "fine";
                    }

                    return new SmsMessage(v.getPhone(), message);
                })
                .collect(Collectors.toList());

        System.out.println("\nСгенерированные SMS сообщения:");
        smsMessages.forEach(System.out::println);
    }
}