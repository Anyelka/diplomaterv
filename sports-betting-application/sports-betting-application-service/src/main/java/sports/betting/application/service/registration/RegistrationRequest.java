package sports.betting.application.service.registration;

import java.util.Currency;

public class RegistrationRequest {

    private String email;
    private String username;
    private String password;

    private String fullName;
    private String accountNumber;
    private Currency currency;
    private String dateOfBirth;

    public RegistrationRequest() {
    }

    public RegistrationRequest(String email, String username, String password, String fullName, String accountNumber, Currency currency, String dateOfBirth) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
