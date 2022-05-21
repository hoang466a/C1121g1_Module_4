package com.testmodule4.vn.dto.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDto {

    public String chanceDateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public Date getToday() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        return date;
    }

    public int compareToToday(Date date) {
        Date today = this.getToday();
        if (date.before(today)) {
            return -1;
        } else if (date.after(today)) {
            return 1;
        } else {
            return 0;
        }
    }

    public int compareToStartDay(Date beforeDate,Date afterDate){
        if(afterDate.before(beforeDate)){
            return -1;
        }else if(afterDate.after(beforeDate)){
            return 1;
        }else{
            return 0;
        }

    }


}
