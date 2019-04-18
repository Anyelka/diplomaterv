package sports.betting.application.web.model;

import java.util.List;

public class BetView {
    
    private int id;
    private String description;
    private String type;
    private List<OutcomeView> outcomes;
    private boolean ended;
    private String result;
        
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
    public List<OutcomeView> getOutcomes() {
        return outcomes;
    }
    public void setOutcomes(List<OutcomeView> outcomes) {
        this.outcomes = outcomes;
    }
    public boolean isEnded() {
        return ended;
    }
    public void setEnded(boolean ended) {
        this.ended = ended;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
