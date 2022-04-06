package com.example.customphonevalidation.Model;

import javax.validation.constraints.Pattern;

public class PhoneNumber {
    @Pattern(regexp = "09[5-9][0-9]{7}",message = "ban nhap sai roi ban oi!")
    private String number;

    public PhoneNumber() {
    }

    public PhoneNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
