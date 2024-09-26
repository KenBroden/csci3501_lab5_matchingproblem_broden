import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StableMatching {
    private List<Programmer> programmers;
    private List<Company> companies;

    // Constructor
    public StableMatching(List<Programmer> programmers, List<Company> companies) {
        this.programmers = programmers;
        this.companies = companies;
    }

    public void findStableMatches() {
        Queue<Programmer> freeProgrammers = new LinkedList<>(programmers); // Queue of free programmers

        while (!freeProgrammers.isEmpty()) {
            Programmer programmer = freeProgrammers.poll(); // Get the first programmer from the queue
            String nextCompanyId = programmer.getNextCompany(); // Get the next company to apply to

            // If there are no more companies to apply to, keep programmer free
            if (nextCompanyId != null) {
                programmer.applyTo(nextCompanyId);
                Company company = findCompany(nextCompanyId);

                // If company is not matched, match them
                if (company.getCurrentMatch() == null) {
                    company.setCurrentMatch(programmer.getId());
                    programmer.setCurrentMatch(company.getId());
                } else { // If company is matched

                    // Get current match of company
                    String currentMatch = company.getCurrentMatch();

                    // If programmer is preferred over current match, match them
                    if (company.prefers(programmer.getId(), currentMatch)) {
                        company.setCurrentMatch(programmer.getId());
                        programmer.setCurrentMatch(nextCompanyId);
                        freeProgrammers.add(findProgrammer(currentMatch));
                    } else {

                        // If programmer is not preferred, keep them free
                        freeProgrammers.add(programmer);
                    }
                }
            }
        }
    }

    // Method to find a company by id
    private Company findCompany(String companyId) {
        for (Company company : companies) {
            if (company.getId().equals(companyId)) {
                return company;
            }
        }
        return null;
    }

    // Method to find a programmer by id
    private Programmer findProgrammer(String programmerId) {
        for (Programmer programmer : programmers) {
            if (programmer.getId().equals(programmerId)) {
                return programmer;
            }
        }
        return null;
    }

    // Method to print the stable matches
    public void printMatches() {
        for (Programmer programmer : programmers) {
            System.out.println(programmer.getId() + " is matched with " + programmer.getCurrentMatch());
        }
    }

    // Method to check for stability of matches
    public boolean isStable() {
        for (Programmer programmer : programmers) {
            for (String companyId : programmer.getPreferences()) {
                if (companyId.equals(programmer.getCurrentMatch())) {
                    break;
                }
                Company company = findCompany(companyId);
                if (company.prefers(programmer.getId(), company.getCurrentMatch())) {
                    return false;
                }
            }
        }
        return true;
    }
}
