package com.jp.practice.romanconversionapi.controller;

import com.jp.practice.romanconversionapi.service.RomanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transform/")
public class RomanController {
    @Autowired
    RomanService romanService;
    @GetMapping("/to/roman/{number}")
    public ResponseEntity<String> transformToRoman(@PathVariable("number") Integer number){
      return ResponseEntity.of(romanService.getRomanValue(number));
    }

    @GetMapping("/to/numeric/{roman}")
    public ResponseEntity<Integer> transformFromRoman(@PathVariable("roman") String roman){

        return ResponseEntity.of(romanService.getNumericValue(roman));
    }
}
