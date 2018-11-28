package sports.betting.application.domain.user;

import java.time.LocalDate;
import java.util.Currency;

public class PlayerData {
    private String name;
    private String accountNumber;
    private int balance;
    private Currency currency;
    private LocalDate dateOfBirth;
    
    public PlayerData(String name, String accountNumber, int balance, Currency currency, LocalDate dateOfBirth) {
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
        this.currency = Currency.getInstance(currency);
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
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
    public Currency getCurrency() {
        return currency;
    }
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
}
