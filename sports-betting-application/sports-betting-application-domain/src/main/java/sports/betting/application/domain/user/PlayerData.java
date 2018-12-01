package sports.betting.application.domain.user;

public class PlayerData {
    private String name;
    private String accountNumber;
    private int balance;
    private String currency;
    private String dateOfBirth;
    
    public PlayerData(String name, String accountNumber, int balance, String currency, String dateOfBirth) {
        super();
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
        this.dateOfBirth = dateOfBirth;
    }

    public PlayerData(String name, String accountNumber, String balance, String currency, String dateOfBirth) {
        super();
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = Integer.parseInt(balance);
        this.currency = currency;
        this.dateOfBirth = dateOfBirth;
    }


    public PlayerData() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
}
