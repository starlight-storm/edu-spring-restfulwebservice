package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.controller.SampleController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainingApplicationTests {

    private MockMvc mvc;

    @Before
    public void before() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new SampleController()).build();
    }

    @Test
    public void testGet_Ok() throws Exception {
        mvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().string("index"));
    }
}