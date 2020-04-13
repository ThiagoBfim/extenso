package org.math.resource;

import org.junit.Ignore;
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
public class ExtensoResourceTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @Ignore("TODO implementar")
    public void shouldReturnFullNumber() throws Exception {
        mockMvc.perform(get("/extenso/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("extenso").value("dois"));
    }

    @Test
    public void shouldReturnBadRequestWhenLanguageIsWrong() throws Exception {
        mockMvc.perform(get("/extenso/2")
                .param("linguagem", "XX")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("The Param 'linguagem' was incorrect. Accept values  are: 'PT, EN'"));
    }

    @Test
    public void shouldReturnBadRequestWhenNumberIsNotInRange() throws Exception {
        mockMvc.perform(get("/extenso/1000000")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("The Param 'numero' have to be in range [-99999, 99999]"));
    }

    @Test
    public void shouldReturnBadRequestWhenNumberIsNotInRangeWithNegativeNumber() throws Exception {
        mockMvc.perform(get("/extenso/-1000000")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("The Param 'numero' have to be in range [-99999, 99999]"));
    }
}
