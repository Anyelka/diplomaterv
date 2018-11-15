package sports.betting.application.web.model;

import java.util.List;

public class BetModel {
    
    private int id;
    private String description;
    private String type;
    private List<OutcomeModel> outcomes;
        
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public List<OutcomeModel> getOutcomes() {
        return outcomes;
    }
    public void setOutcomes(List<OutcomeModel> outcomes) {
        this.outcomes = outcomes;
    }
    
}
