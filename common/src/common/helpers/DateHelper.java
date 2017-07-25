package common.helpers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Logan.Moen on 6/8/2017.
 */
public class DateHelper extends CommonHelper{

    public static java.sql.Date utilDateToSqlDate(java.util.Date date){
        return new java.sql.Date(date.getTime());
    }

    public static java.util.Date sqlDateToUtilDate(java.sql.Date date){
        return new java.util.Date(date.getTime());
    }

    public static java.util.Date stringToUtilDate(String dateIn, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date dateOut = null;

        try {
            dateOut = dateFormat.parse(dateIn);
        } catch ( ParseException parseEx) {
            logger.error(parseEx);
        }
        return dateOut;
    }


}

