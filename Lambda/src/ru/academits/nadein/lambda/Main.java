package ru.academits.nadein.lambda;

import ru.academits.nadein.lambda.person.Person;

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

        System.out.println(uniqueNames.stream().collect(Collectors.joining(", ", "»мена: ", ".")));
        System.out.println();

        OptionalDouble averageAge = persons.stream()
                .filter(p -> p.age() < 18)
                .mapToDouble(Person::age)
                .average();

        if (averageAge.isPresent()) {
            System.out.println("—редний возраст людей младше 18: " + averageAge.getAsDouble());
        } else {
            System.out.println("Ћюдей младше 18 лет в списке нет.");
        }

        System.out.println();

        Map<String, Double> averageAgeByNames = persons.stream()
                .collect(Collectors.groupingBy(Person::name, Collectors.averagingDouble(Person::age)));

        averageAgeByNames.forEach((name, middleAge) -> System.out.printf("name %s: %s%n", name, middleAge)); // averageAge уже существует
        System.out.println();

        Stream<Person> personsFrom20To45 = persons.stream()
                .filter(p -> p.age() >= 20 && p.age() <= 45)
                .sorted((p1, p2) -> p2.age() - p1.age());

        personsFrom20To45.forEach(person -> System.out.printf("%s, %n", person));

        Scanner scanner = new Scanner(System.in);

        System.out.println("¬ведите сколько элементов из потока корней чисел нужно пропустить:");
        int skipItem = scanner.nextInt();

        System.out.println("¬ведите лимит элементов из потока корней чисел:");
        int limitItem = scanner.nextInt();

        DoubleStream numbersSquareRoots = DoubleStream.iterate(0, x -> x + 1)
                .map(Math::sqrt)
                .skip(skipItem)
                .limit(limitItem);

        numbersSquareRoots.forEach(System.out::println);
    }
}