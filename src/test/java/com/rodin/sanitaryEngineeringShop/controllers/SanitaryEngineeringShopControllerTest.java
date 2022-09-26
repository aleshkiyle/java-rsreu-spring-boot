package com.rodin.sanitaryEngineeringShop.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SpringRunner.class)

@WebMvcTest(HomeController.class) /*Тест для SanitaryEngineeringShopController*/
public class SanitaryEngineeringShopControllerTest {

    @Autowired
    private MockMvc mockMvc; /*Внедряет MockMvc*/

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/homePage")) /*Выполнение GET-запроса*/
                .andExpect(MockMvcResultMatchers.status().isOk()) /*Ожидание HTTP-ответа 200*/
                .andExpect(MockMvcResultMatchers.view().name("sanitaryEngineeringShop")) /*Ожидание ответа "sanitaryEngineeringShop"*/
                .andExpect(MockMvcResultMatchers.content().string(containsString("Магазин"))); /* Проверка на наличие содержания текста в строке */
    }

    @Test
    public void testControllerSanitaryShop_correctWork() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.put("/sanitaryShop/homePage"))
                .andReturn();
    }
}