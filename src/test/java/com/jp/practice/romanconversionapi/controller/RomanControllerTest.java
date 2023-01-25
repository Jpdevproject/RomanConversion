package com.jp.practice.romanconversionapi.controller;

import com.jp.practice.romanconversionapi.service.RomanServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RomanController.class)
class RomanControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RomanServiceImpl romanService;

    @Test
    void transformToRoman() throws Exception {
       when(romanService.getRomanValue(anyInt())).thenReturn(Optional.of("MXI"));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/transform/to/roman/1011")
                .accept(MediaType.ALL))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testTransformFromRoman() throws Exception {
        when(romanService.getNumericValue(anyString())).thenReturn(Optional.of(1011));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/transform/to/numeric/MXI")
                        .accept(MediaType.ALL))
                .andDo(print())
                .andExpect(status().isOk());
    }
}