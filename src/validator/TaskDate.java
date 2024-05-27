package validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskDate {

    public static boolean isValidDate(String date){

        String dateformat = "dd-MM-yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateformat);

        try {
            LocalDate.parse(date,formatter);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }
}
