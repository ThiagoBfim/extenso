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
public class ExtensoResourcePTTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDois() throws Exception {
        mockMvc.perform(get("/extenso/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("extenso").value("dois"));
    }

    @Test
    public void shouldReturnNoventaENove() throws Exception {
        mockMvc.perform(get("/extenso/99")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("extenso").value("noventa e nove"));
    }

    @Test
    public void shouldReturnTrezentosETrintraETres() throws Exception {
        mockMvc.perform(get("/extenso/333")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("extenso").value("trezentos e trinta e três"));
    }

    @Test
    public void shouldReturnQuarentaMilTrezentosETrintraETres() throws Exception {
        mockMvc.perform(get("/extenso/40333")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("extenso").value("quarenta mil e trezentos e trinta e três"));
    }

}
