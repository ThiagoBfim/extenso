package org.math.resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ExtensoResource.class)
public class ExtensoResourceENTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnTwo() throws Exception {
        mockMvc.perform(get("/extenso/2?linguagem=EN")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("extenso").value("two"));
    }

    @Test
    public void shouldReturnNinityNine() throws Exception {
        mockMvc.perform(get("/extenso/99?linguagem=EN")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("extenso").value("ninety nine"));
    }

    @Test
    public void shouldReturnThreeHundredThirtyTree() throws Exception {
        mockMvc.perform(get("/extenso/333?linguagem=EN")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("extenso").value("three hundred thirty three"));
    }

    @Test
    public void shouldReturnMinusThreeHundredThirtyTree() throws Exception {
        mockMvc.perform(get("/extenso/-333?linguagem=EN")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("extenso").value("minus three hundred thirty three"));
    }

}
