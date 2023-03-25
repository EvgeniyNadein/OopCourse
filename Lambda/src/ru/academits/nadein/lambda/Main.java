package ru.academits.nadein.lambda;

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Ivan", 33),
                new Person("Petr", 22),
                new Person("Olga", 17),
                new Person("Ilya", 25),
                new Person("irina", 22),
                new Person("Garik", 30),
                new Person("Ivan", 27),
                new Person("Mihail", 45)
        );

        List<String> uniqueNames = persons.stream()
                .map(Person::name)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueNames);
        System.out.println();

        String uniqueNamesString = persons.stream()
                .map(Person::name)
                .distinct()
                .collect(Collectors.joining(", ", "»мена: ", "."));

        System.out.println(uniqueNamesString);
        System.out.println();

        OptionalDouble averageAge = persons.stream()
                .filter(p -> p.age() < 18)
                .mapToDouble(Person::age)
                .average();

        if (averageAge.isPresent()) {
            System.out.println("—редний возраст людей младше 18: " + averageAge.getAsDouble());
        }

        System.out.println();

        Map<String, Double> averageAgeByPersons = persons.stream()
                .collect(Collectors.groupingBy(Person::name,
                        Collectors.averagingDouble(Person::age)));

        averageAgeByPersons.forEach((name, p) -> System.out.printf("name %s: %s%n", name, p));
        System.out.println();

        Stream<Person> personFrom20To45 = persons.stream()
                .filter(p -> p.age() >= 20)
                .filter(p -> p.age() <= 45)
                .sorted((p1, p2) -> p2.age() - p1.age());

        personFrom20To45.forEach((person) -> System.out.printf("%s, %n", person));

        Scanner scanner = new Scanner(System.in);

        System.out.println("¬ведите сколько элементов из потока корней чисел нужно пропустить:");
        int skip = scanner.nextInt();

        System.out.println("¬ведите 2лимит элементов из потока корней чисел:");
        int limit = scanner.nextInt();

        DoubleStream numbersSquareRoots = DoubleStream.iterate(0, x -> x +1)
                .skip(skip)
                .limit(limit)
                .map(Math::sqrt);

                numbersSquareRoots.forEach(System.out::println);
    }
}