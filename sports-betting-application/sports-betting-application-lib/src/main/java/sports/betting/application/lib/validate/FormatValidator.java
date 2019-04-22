package sports.betting.application.lib.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sports.betting.application.lib.formatter.DateFormatter;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Currency;

@Component
public class FormatValidator {

    @Autowired
    private DateFormatter dateFormatter;

    public boolean isValidDateFormat(String dateOfBirth) {
        try {
            dateFormatter.parseDate(dateOfBirth);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    /**
     * DOES NOT VALIDATE DATE FORMAT!
     * may throw DateTimeParseException!
     */
    public boolean isDateLessThanEighteenYearsAgo(String date) {
        return dateFormatter.parseDate(date).isAfter(LocalDate.now().minusYears(18));
    }

    public boolean isValidEmailFormat(String email) {
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException e) {
            return false;
        }
        return true;
    }

    public boolean isValidFullTimeResultFormat(String fullTimeResult) {
        try {
            Integer.parseInt(fullTimeResult.split("-")[0].trim());
            Integer.parseInt(fullTimeResult.split("-")[1].trim());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isValidMoneyFormat(String money) {
        try {
            Integer.parseInt(money);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isPositiveMoney(String money) {
        int amount = Integer.parseInt(money);
        if (amount < 0) {
            return false;
        }
        return true;
    }

    public boolean isValidCurrencyFormat(String currency) {
        try {
            Currency.getInstance(currency);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
