package model;

public class OutcomeModel {
    
    private int id;
    private String fullDescription;
    private String value;
    private String odd;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFullDescription() {
        return fullDescription;
    }
    public void setFullDescription(String value) {
        this.fullDescription = value;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getOdd() {
        return odd;
    }
    public void setOdd(String odd) {
        this.odd = odd;
    }
    
}
