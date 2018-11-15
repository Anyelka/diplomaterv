package model;

import java.util.List;

public class SportEventModel {
    
    private int id;
    private String type;
    private String title;
    private String startDate;
    private String endDate;
    private List<BetModel> bets;
    private boolean ended;
    
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
    public List<BetModel> getBets() {
        return bets;
    }
    public void setBets(List<BetModel> bets) {
        this.bets = bets;
    }
    public boolean isEnded() {
        return ended;
    }
    public void setEnded(boolean ended) {
        this.ended = ended;
    }
    
}
