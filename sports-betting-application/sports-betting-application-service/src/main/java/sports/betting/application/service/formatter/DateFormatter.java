package sports.betting.application.service.formatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

@Component
public class DateFormatter {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    /**
     * Uses the format of the date picker: MM/DD/YYYY
     * to parse a String to LocalDate
     * */
    public LocalDate parseDate(String date) {
        return LocalDate.parse(date, dateTimeFormatter);
    }

    public String formatDate(LocalDateTime localDateTime) {
        String date = localDateTime.toString();
        String temp = date.substring(0, date.indexOf("T")) + ", " + date.substring((date.indexOf("T") + 1));
        return temp.substring(0,temp.lastIndexOf(":"));
    }
    
    public LocalDateTime formatDate(String date) {
        String temp = date.substring(0, date.indexOf(",")) + "T" + date.substring(date.indexOf(",") + 2) + ":00.000";
        LocalDateTime localDateTime = LocalDateTime.parse(temp);
        return localDateTime;
    }
    
    public XMLGregorianCalendar convertDate(LocalDate localDate) {
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault())));
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public XMLGregorianCalendar convertDate(LocalDateTime localDateTime) {
        try {
            return DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(GregorianCalendar.from(localDateTime.toLocalDate().atStartOfDay(ZoneId.systemDefault())));
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
