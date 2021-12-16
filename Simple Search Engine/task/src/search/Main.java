package search;

import java.util.*;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    static boolean repeat = true;
    Searcher searcher = new Searcher();

    public static void main(String[] args) {
        Main m = new Main();
        m.searcher.readData(args[1]);
        while (repeat) m.menu();
    }

    public void menu() {
        System.out.printf("=== Menu ===%n1. Find a person%n2. Print all people%n0. Exit%n");
        switch (scanner.nextInt()) {
            case 1:
                searchMenu();
                break;
            case 2:
                printAllPeople();
                break;
            case 0:
                exit();
                break;
            default:
                System.out.println("Incorrect option! Try again.");
        }
    }

    public void searchMenu() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE.");
        String strategy = "";
        boolean repeat = true;
        while (repeat) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                strategy = line.toUpperCase(Locale.ROOT);
                repeat = false;
            }
        }
        switch (strategy) {
            case "ALL":
                searcher.setMethod(new allSearchStrategy(searcher));
                break;
            case "ANY":
                searcher.setMethod(new anySearchStrategy(searcher));
                break;
            case "NONE":
                searcher.setMethod(new noneSearchStrategy(searcher));
                break;
            default:
                break;
        }
        if (searcher == null) {
            throw new RuntimeException(
                    "Unknown strategy type passed. Please, write to the author of the problem.");
        }
        searcher.search(searcher.formRequest());
    }

    public void printAllPeople() {
        System.out.println("=== List of People ===");
        searcher.userData.forEach(System.out::println);
    }

    public static void exit() {
        System.out.println("Bye!");
        repeat = false;
    }
}











/*




    public static void findPerson() {
        System.out.println("Query:");
        String request;
        List<Integer> indexes = new ArrayList<>();
        boolean matchWasFound = false;
        while (!matchWasFound) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                request = line.toLowerCase(Locale.ROOT);
                if (invertedIndex.containsKey(request)) {
                    indexes = invertedIndex.get(request);
                    matchWasFound = true;
                }
                if (!matchWasFound) {
                    matchWasFound = true;
                    System.out.println("No matching people found.");
                } else {
                    System.out.printf("%d persons found:%n", indexes.size());
                    for (Integer index : indexes) System.out.println(userData.get(index));
                }
            }
        }
    }

    public static void printAllPeople() {
        System.out.println("=== List of People ===");
        userData.forEach(System.out::println);
    }
 */