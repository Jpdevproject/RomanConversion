package com.jp.practice.romanconversionapi.service;

import com.jp.practice.romanconversionapi.exception.InvalidInputException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Service
public class RomanServiceImpl implements RomanService{
    @Override
    public Optional<String> getRomanValue(Integer number) {
        if(number>0){
            String[] thousands=new String[]{"","M","MM","MMM","MMMM"};
            String[] hundreds=new String[]{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
            String[] tens=new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
            String[] units=new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};
            return Optional.of(thousands[number/1000]+hundreds[(number%1000)/100]+tens[(number%100)/10]+units[(number%10)]);
       }else{
            throw new InvalidInputException(number);
        }
    }

    @Override
    public Optional<Integer> getNumericValue(String romanString) {
        Map<Character,Integer> romanMap=new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);
        int result=0;
        for (int i=0;i<romanString.length();i++){
            if(i>0 && romanMap.get(romanString.charAt(i))>romanMap.get(romanString.charAt(i-1))){
                result+=romanMap.get(romanString.charAt(i))-2  * romanMap.get(romanString.charAt(i-1));
            }else{
                result+=romanMap.get(romanString.charAt(i));
            }
        }
        return Optional.of(result);
    }
}
