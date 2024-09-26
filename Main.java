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
            System.out.println("Programmer " + programmer.getId() + " matched with Company " + programmer.getCurrentMatch());
        }
    }
    
}
