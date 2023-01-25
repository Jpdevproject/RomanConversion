package com.jp.practice.romanconversionapi.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidInputException extends RuntimeException{
    Integer number;
    public InvalidInputException(Integer number){
        super(String.format("Number %s is negative and hence invalid",number));
        this.number=number;
    }
}
