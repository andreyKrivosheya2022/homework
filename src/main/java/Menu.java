import repository.PersonRepository;
import models.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    PersonRepository dbView = new PersonRepository();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        do {
            System.out.println("1 - ALL users \n" + "2 - Add new user \n" + "3 - Users who age older than (>) \n"
                    + "4 - delete user by id \n" + "5 - update user by id \n" + "6 - user by id \n"
                    + "7 - user by name");

            int number = scanner.nextInt();

            Runnable addPerson = () -> {
                do {
                    dbView.addPerson(usersData());
                    System.out.println("Do you want add someone more? (Yes/No)");
                } while (!Objects.equals(scanner.next(), "No"));
            };

            Map<Integer, Runnable> actions = new HashMap<>();
            actions.put(1, this::readUserInput);
            actions.put(2, addPerson);
            actions.put(3, () -> {
                System.out.println("Input user`s age:");
                dbView.getPersonWhereAgeUnder(scanner.nextInt());
            });
            actions.put(4, () -> {
                System.out.println("Input user`s id");
                dbView.deletePerson(scanner.nextInt());
            });
            actions.put(5, () -> {
                System.out.println("Input id, then your changing");
                dbView.updatePerson(scanner.nextInt(), usersData());
            });
            actions.put(6, () -> {
                System.out.println("Input id");
                dbView.findById(scanner.nextInt());
            });
            actions.putIfAbsent(7, () -> {
                System.out.println("Input name");
                dbView.getPersonWhereName(scanner.next());
            });

            if (actions.containsKey(number)) {
                actions.get(number).run();
            }

            System.out.println("Do you want to continue? (Yes/No)");

        } while (!Objects.equals(scanner.next(), "No"));
    }

    private Person usersData() {
        Person person = new Person();

        System.out.println("Input data about Person (First_name):");
        person.setFirstName(scanner.next());
        System.out.println("Input data about Person (Last_name):");
        person.setLastName(scanner.next());
        System.out.println("Input data about Person (Age):");
        person.setAge(scanner.nextInt());
        return person;
    }

    private void readUserInput() {
        dbView.findAllPeople();
    }
}
