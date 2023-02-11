package ge.tbc.testautomation.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilities {
    public static Date stringToDate(String stringDate) throws ParseException {
        Date sdf = null;
        try {
            sdf =  new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return sdf;
    }
}
