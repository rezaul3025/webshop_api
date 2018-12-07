package com.webshop.api.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webshop.api.TestConfig;
import com.webshop.api.dto.OrderDTO;
import com.webshop.api.dto.OrderLineDTO;

public class OrderControllerTests extends TestConfig{
	
	private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired 
    private ObjectMapper objectMapper;
    
    private JacksonTester<OrderDTO> jsonTesterOrder;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        JacksonTester.initFields(this, objectMapper);
    }
    
    @Test
    public void test1OrderPlace() throws Exception {
    	OrderDTO orderDTO = new OrderDTO();
    	orderDTO.setCustomerId(1001);
    	orderDTO.setCustomerEmail("customer_em@gtm.com");
    	orderDTO.setOrderDate(new Date());
    	
    	List<OrderLineDTO>  orderLinesDTO = new ArrayList<>();
    	OrderLineDTO orderLine  = new OrderLineDTO();
    	orderLine.setProductId(1);
    	orderLine.setTitle("Product 1");
    	orderLine.setPrice(99.98);
    	orderLine.setQuantity(4);
    	orderLinesDTO.add(orderLine);
    	
    	OrderLineDTO orderLine1  = new OrderLineDTO();
    	orderLine1.setProductId(1);
    	orderLine1.setTitle("Product 2");
    	orderLine1.setPrice(99.87);
    	orderLine1.setQuantity(2);
    	orderLinesDTO.add(orderLine1);
    	
    	orderDTO.setOrderLines(orderLinesDTO);
    	
    	 final String orderDTOJson = jsonTesterOrder.write(orderDTO).getJson();
     	this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/order")
     			.content(orderDTOJson).contentType(MediaType.APPLICATION_JSON_UTF8))
     		    .andExpect(status().isCreated())
     		    .andExpect(jsonPath("$.id").value(3))
     		    .andExpect(jsonPath("$.customerId").value(1001))
     		    .andExpect(jsonPath("$.customerEmail").value("customer_em@gtm.com"))
     			.andExpect(jsonPath("$.orderLines[0].id").value(3))
     			.andExpect(jsonPath("$.orderLines[0].title").value("Product 1"))
     			.andExpect(jsonPath("$.orderLines[0].price").value(99.98))
     			.andExpect(jsonPath("$.orderLines[0].quantity").value(4));
    }
    
    @Test
    public void test2FindOrdersInGivenTimePeriod() throws Exception {
    	this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/orders")
    			.param("from", "2018-12-01T18:47:52.692")
                .param("to", "2018-12-02T14:30:50.672")
    			.contentType(MediaType.APPLICATION_JSON_UTF8))
    		    .andExpect(status().isOk())
    		    .andExpect(jsonPath("$[0].id").value(1))
    		    .andExpect(jsonPath("$[0].customerId").value(2001))
				.andExpect(jsonPath("$[0].orderDate").value("2018-12-01T17:47:52.692+0000"))
    		    .andExpect(jsonPath("$[0].customerEmail").value("customer_em@text.com"))
    			.andExpect(jsonPath("$[1].id").value(2))
				.andExpect(jsonPath("$[1].customerId").value(2002))
				.andExpect(jsonPath("$[1].orderDate").value("2018-12-02T13:30:50.672+0000"))
				.andExpect(jsonPath("$[1].customerEmail").value("customer_em1@text76.com"));
    }

}
