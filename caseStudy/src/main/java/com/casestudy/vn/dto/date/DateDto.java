package com.casestudy.vn.dto.date;

import com.casestudy.vn.model.customer.Customer;
import com.casestudy.vn.service.customer.ICustomerService;
import com.casestudy.vn.service.customer.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

}
