package com.skipthedishes.vanhackathon.customer;

import com.google.gson.Gson;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerResource.class)
public class CustomerResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService service;

    private final Gson gson = new Gson();

    @Test
    @Ignore
    public void shouldReturnAllProducts() throws Exception {
        Customer customer = mock(Customer.class);
        when(customer.getName()).thenReturn("Priscila Carvalho");
        when(customer.getEmail()).thenReturn("pri.carvalho86@gmail.com");
        when(customer.getAddress()).thenReturn("15 Paulista Avenue");
        when(customer.getCreation()).thenReturn(new Date());

//        when(service.save(any(Customer.class))).thenReturn(customer);

        CustomerCreateRequest customerCreateRequest = new CustomerCreateRequest(
                                                        "pri.carvalho86@gmail.com",
                                                        "Priscila Carvalho",
                                                        "pri.carvalho86@gmail.com",
                                                        "vanhackaton");
        String jsonRequest = gson.toJson(customerCreateRequest);
        System.out.println(jsonRequest);
        this.mockMvc.perform(
                post("/api/v1/Customer")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonRequest))
            .andDo(log())
            .andExpect(status().isCreated())
            .andExpect(content().json("{jjojojo}"));


    }


}
