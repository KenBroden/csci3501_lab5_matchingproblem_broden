import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Create a list of programmers
        List<Programmer> programmers = new ArrayList<>();
        programmers.add(new Programmer("1", Arrays.asList("E", "A", "D", "B", "C")));
        programmers.add(new Programmer("2", Arrays.asList("D", "E", "B", "A", "C")));
        programmers.add(new Programmer("3", Arrays.asList("D", "B", "C", "E", "A")));
        programmers.add(new Programmer("4", Arrays.asList("C", "B", "D", "A", "E")));
        programmers.add(new Programmer("5", Arrays.asList("A", "D", "B", "C", "E")));

        // Create a list of companies
        List<Company> companies = new ArrayList<>();
        companies.add(new Company("A", Arrays.asList("2", "5", "1", "3", "4")));
        companies.add(new Company("B", Arrays.asList("1", "2", "3", "4", "5")));
        companies.add(new Company("C", Arrays.asList("5", "3", "2", "1", "4")));
        companies.add(new Company("D", Arrays.asList("1", "3", "2", "4", "5")));
        companies.add(new Company("E", Arrays.asList("2", "3", "5", "4", "1")));

        // Create a stable matching instance
        StableMatching stableMatching = new StableMatching(programmers, companies);

        // Find stable matches
        stableMatching.findStableMatches();

        // Print the matches
        for (Programmer programmer : programmers) {
            System.out.println(
                    "Programmer " + programmer.getId() + " matched with Company " + programmer.getCurrentMatch());
        }

        // Test for stability
        System.out.println("\nStability: " + stableMatching.isStable());

        // Create a new list of programmers
        List<Programmer> programmers2 = new ArrayList<>();
        programmers2.add(new Programmer("Ken", Arrays.asList("IBM", "Toro", "3M", "Digi-Key", "Polaris")));
        programmers2.add(new Programmer("John", Arrays.asList("Digi-Key", "IBM", "Polaris", "Toro", "3M")));
        programmers2.add(new Programmer("Sara", Arrays.asList("3M", "Polaris", "IBM", "Digi-Key", "Toro")));
        programmers2.add(new Programmer("Zoe", Arrays.asList("Toro", "3M", "Digi-Key", "Polaris", "IBM")));
        programmers2.add(new Programmer("Tim", Arrays.asList("Polaris", "Digi-Key", "Toro", "IBM", "3M")));

        // Create a new list of companies. Ken is a bad programmer and no company wants him
        List<Company> companies2 = new ArrayList<>();
        companies2.add(new Company("IBM", Arrays.asList("John", "Sara", "Zoe", "Tim", "Ken")));
        companies2.add(new Company("Toro", Arrays.asList("Sara", "Tim", "John", "Zoe", "Ken")));
        companies2.add(new Company("3M", Arrays.asList("Zoe", "John", "Tim", "Sara", "Ken")));
        companies2.add(new Company("Digi-Key", Arrays.asList("Tim", "Zoe", "Sara", "John", "Ken")));
        companies2.add(new Company("Polaris", Arrays.asList("Sara", "Zoe", "Tim", "John", "Ken")));

        // Create a stable matching instance
        StableMatching stableMatching2 = new StableMatching(programmers2, companies2);

        // Find stable matches
        stableMatching2.findStableMatches();

        System.out.println("\n\n");
        // Print the matches
        for (Programmer programmer : programmers2) {
            System.out.println(
                    "Programmer " + programmer.getId() + " matched with Company " + programmer.getCurrentMatch());
        }

        // Test for stability of 2nd dataset
        System.out.println("\nStability: " + stableMatching2.isStable());
    }
}
