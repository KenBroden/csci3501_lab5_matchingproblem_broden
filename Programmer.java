import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Programmer {
    private String id; // unique identifier
    private List<String> preferences; // ordered list of preferred companies
    private Set<String> appliedCompanies; // Set to track companies already applied to
    private String currentMatch; // Currently matched company (initially null)

    // Constructor
    public Programmer(String id, List<String> preferences) {
        this.id = id;
        this.preferences = preferences;
        this.appliedCompanies = new HashSet<>();
        this.currentMatch = null;
    }

    // Getter for id
    public String getId() {
        return id;
    }

    // Getter for company preferences
    public List<String> getPreferences() {
        return preferences;
    }

    // Getter for current company match, initially null
    public String getCurrentMatch() {
        return currentMatch;
    }

    // Setter for current company match
    public void setCurrentMatch(String companyId) {
        this.currentMatch = companyId;
    }

    // Method to check if programmer has applied to a company
    public boolean hasAppliedTo(String companyId) {
        return appliedCompanies.contains(companyId);
    }

    // Method to apply to a company
    public void applyTo(String companyId) {
        appliedCompanies.add(companyId);
    }

    // Method to get the next company to apply to
    public String getNextCompany() {
        for (String company : preferences) {
            if (!appliedCompanies.contains(company)) {
                return company;
            }
        }
        return null;
    }
}