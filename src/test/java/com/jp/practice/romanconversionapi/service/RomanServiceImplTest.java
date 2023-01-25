package com.jp.practice.romanconversionapi.service;

import com.jp.practice.romanconversionapi.exception.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RomanServiceImplTest {
    @MockBean
    private RomanServiceImpl romanService;
    private static final Integer inputNumeric=1011;
    private static final String roman="MXI";

    @BeforeEach
    void setUp() {
        romanService=new RomanServiceImpl();

    }

    @Test
    void getRomanValueForSuccess() {
        String expected="MXI";
        Optional<String> result = romanService.getRomanValue(inputNumeric);
        assertEquals(expected,result.get());
    }
    @Test
    void getRomanValueForFailure() {
        Integer input=-10;
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            romanService.getRomanValue(input);
        });
        assertEquals("Number "+input+" is negative and hence invalid",exception.getMessage());
    }

    @Test
    void getNumericValue() {
        Integer expected=1011;
        Optional<Integer> result=romanService.getNumericValue(roman);
        assertEquals(expected,result.get());
    }
}