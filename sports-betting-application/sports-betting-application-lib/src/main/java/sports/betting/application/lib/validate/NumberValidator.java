package sports.betting.application.lib.validate;

import org.springframework.stereotype.Component;

@Component
public class NumberValidator {

    public boolean notInt(String stake) {
        try{
            Integer.parseInt(stake);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public boolean isNonPositive(int number) {
        return number <= 0;
    }
}
