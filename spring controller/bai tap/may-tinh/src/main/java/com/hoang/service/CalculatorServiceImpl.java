package com.hoang.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String calculate(double first, double second, String calculate) {
        String result="";
        switch(calculate)
        {
            case "addition":
                result=String.valueOf(first+second);
                break;
            case "subtraction":
                result=String.valueOf(first-second);
                break;
            case "multiplication":
                result=String.valueOf(first*second);
                break;
            case "division":
                if(second!=0){
                result=String.valueOf(first/second);}
                else if(second==0)
                {
                    result="Khong the chia cho so 0, xin nhap lai!";
                }
                break;
        }
        return result;
    }
}
