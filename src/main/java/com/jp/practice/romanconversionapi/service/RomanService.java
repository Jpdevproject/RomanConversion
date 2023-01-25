package com.jp.practice.romanconversionapi.service;

import java.util.Optional;

public interface RomanService {
    Optional<String> getRomanValue(Integer number);
    Optional<Integer> getNumericValue(String romanString);
}
