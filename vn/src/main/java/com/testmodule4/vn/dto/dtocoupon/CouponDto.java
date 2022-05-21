package com.testmodule4.vn.dto.dtocoupon;

import com.testmodule4.vn.dto.date.DateDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class CouponDto implements Validator {
    DateDto dateDto =new DateDto();

    private Integer id;
    @NotBlank
    @Size(min=0,max=50)
    private String title;
    @NotNull
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date couponStartDate;
    @NotNull
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date couponEndDate;
    @NotBlank
    @Column(columnDefinition = "Decimal(10,2)")
    private String couponMoney;
    @NotBlank(message = "Hãy nhập chi tiết")
    @Size(min=0,max=50)
    private String detail;

    public CouponDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCouponStartDate() {
        return couponStartDate;
    }

    public void setCouponStartDate(Date couponStartDate) {
        this.couponStartDate = couponStartDate;
    }

    public Date getCouponEndDate() {
        return couponEndDate;
    }

    public void setCouponEndDate(Date couponEndDate) {
        this.couponEndDate = couponEndDate;
    }

    public String getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(String couponMoney) {
        this.couponMoney = couponMoney;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CouponDto couponDto= (CouponDto)target;
        if (couponDto.couponMoney.trim().isEmpty()) {
            errors.rejectValue("couponMoney",
                    "std.notnull", "Ô không được để trống");
        } else {
            if (!couponDto.couponMoney.matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$")) {
                errors.rejectValue("couponMoney",
                        "std.type", "Định dạng nhập vào không hợp lệ!");
            } else if (Double.parseDouble(couponDto.couponMoney) < 0) {
                errors.rejectValue("couponMoney",
                        "std.number", "Số không được âm, xin nhập lại!");
            }
        }


        if(couponDto.couponStartDate==null){
            errors.rejectValue("couponStartDate",
                    "std.null", "Ngày khởi tạo không được null!");
        }
        else if(dateDto.compareToToday(couponDto.couponStartDate)!=1){
            errors.rejectValue("couponStartDate",
                    "std.startdate", "Ngày khởi tạo khuyến mãi không hợp lệ!");
        }

        if(couponDto.couponEndDate==null){
            errors.rejectValue("couponEndDate",
                    "std.null", "Ngày kết thúc không được null!");
        }
        else if(dateDto.compareToStartDay(couponDto.couponStartDate,couponDto.couponEndDate)!=1){
            errors.rejectValue("couponEndDate",
                    "std.enddate", "Ngày kết thúc hợp đồng không hợp lệ!");
        }
    }
}
