package sports.betting.application.web.model;

import java.util.List;

public class SportEventView {
    
    private int id;
    private String type;
    private String title;
    private String startDate;
    private String endDate;
    private List<BetView> bets;
    private boolean ended;
    private String fullTimeResult;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public List<BetView> getBets() {
        return bets;
    }
    public void setBets(List<BetView> bets) {
        this.bets = bets;
    }
    public boolean isEnded() {
        return ended;
    }
    public void setEnded(boolean ended) {
        this.ended = ended;
    }
    public String getFullTimeResult() {
        return fullTimeResult;
    }
    public void setFullTimeResult(String fullTimeResult) {
        this.fullTimeResult = fullTimeResult;
    }
}
