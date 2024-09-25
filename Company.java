import java.util.List;

public class Company {
    private String id; // unique identifier
    private List<String> preferences; // List of preferred programmers (ordered)
    private String currentMatch; // Currently matched programmer (initially null)

    // Constructor
    public Company(String id, List<String> preferences) {
        this.id = id;
        this.preferences = preferences;
        this.currentMatch = null;
    }

    // Getter for id
    public String getId() {
        return id;
    }

    // Getter for programmer preferences
    public List<String> getPreferences() {
        return preferences;
    }

    // Getter for current programmer match, initially null
    public String getCurrentMatch() {
        return currentMatch;
    }

    // Setter for current programmer match
    public void setCurrentMatch(String programmerId) {
        this.currentMatch = programmerId;
    }

    // Method to check if a programmer is preferred OVER the current match
    public boolean prefers(String newProgrammerId, String currentProgrammerId) {
        int newProgrammerIndex = preferences.indexOf(newProgrammerId);
        int currentProgrammerIndex = preferences.indexOf(currentProgrammerId);
        return newProgrammerIndex < currentProgrammerIndex; // Lower index means higher preference
    }
}
