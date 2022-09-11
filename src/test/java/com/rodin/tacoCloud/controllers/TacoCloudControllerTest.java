package com.rodin.tacoCloud.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)

@WebMvcTest(TacoCloudController.class)
public class TacoCloudControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCorrectWork_TacoCloudController() throws Exception {
        this.mockMvc.perform(get("/")) // выполнить GET запрос
                .andExpect(status().isOk()) // Ожидается код ответа HTTP 200
                .andExpect(view().name("tacoCloud")) // Ожидается имя представления tacoCloud
                .andExpect(content().string(
                        containsString("Taco") // Ожидается наличие строки "Taco"
                ));
    }

}