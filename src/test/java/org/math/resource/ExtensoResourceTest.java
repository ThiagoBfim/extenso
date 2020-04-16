package org.math.resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtensoResourceTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilter(((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                })).build();
    }

    @Test
    public void shouldReturnBadRequestWhenLanguageIsWrong() throws Exception {
        mockMvc.perform(get("/extenso/2")
                .param("linguagem", "XX")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("O parâmetro 'linguagem' está incorreto. Valores aceitos são: 'PT, EN'"));
    }

    @Test
    public void shouldReturnBadRequestWhenNumberIsNotInRange() throws Exception {
        mockMvc.perform(get("/extenso/1000000")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("O parâmetro 'numero' precisa estar no conjunto : [-99999, 99999]"));
    }

    @Test
    public void shouldReturnBadRequestWhenNumberIsNotInRangeWithNegativeNumber() throws Exception {
        mockMvc.perform(get("/extenso/-1000000")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("O parâmetro 'numero' precisa estar no conjunto : [-99999, 99999]"));
    }
}
