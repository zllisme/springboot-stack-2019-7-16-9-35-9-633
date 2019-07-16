package com.tw.apistackbase.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.apistackbase.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.awt.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void should_return_employees_list_when_get_employees_given_get_mapping() throws Exception {
        this.mockMvc.perform(get("/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("[{\"id\":1,\"age\":12,\"name\":\"Jasmine\",\"gender\":\"female\"}]")));
    }

    @Test
    public void should_return_employee_when_get_employees_given_id() throws Exception {
        this.mockMvc.perform(get("/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("[{\"id\":1,\"age\":12,\"name\":\"Jasmine\",\"gender\":\"female\"}]")));
    }

    @Test
    public void should_return_employees_list_when_get_employees_given_page_and_page_size() throws Exception {
        this.mockMvc.perform(get("/employees?page=1&pageSize=2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("[{\"id\":1,\"age\":12,\"name\":\"Jasmine\",\"gender\":\"female\"},{\"id\":2,\"age\":13,\"name\":\"Berio\",\"gender\":\"male\"}]")));
    }

    @Test
    public void should_return_employees_list_when_get_employees_given_gender() throws Exception {
        this.mockMvc.perform(get("/employees?gender=female"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(containsString("[{\"id\":1,\"age\":12,\"name\":\"Jasmine\",\"gender\":\"female\"}]")));
    }

    @Test
    public void should_return_updated_employees_list_when_update_employee_given_id() throws Exception {
        Employee employee = new Employee(1, 22, "Jasmine", "female");
        String content = mapper.writeValueAsString(employee);
        final RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/employees/1")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]['id']").value(1))
                .andExpect(jsonPath("$[0]['name']", is("Jasmine")))
                .andExpect(jsonPath("$[0]['gender']", is("female")))
                .andExpect(jsonPath("$[0]['age']").value(22));

    }
}