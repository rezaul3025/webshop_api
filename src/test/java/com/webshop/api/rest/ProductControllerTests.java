package com.webshop.api.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.webshop.api.dto.ProductDTO;

public class ProductControllerTests extends TestConfig{
	
	private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired 
    private ObjectMapper objectMapper;

    private JacksonTester<ProductDTO> jsonTesterProduct;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        JacksonTester.initFields(this, objectMapper);
    }
    
    @Test
    public void testProductCreate() throws Exception {
    	ProductDTO productDTO = new ProductDTO();
    	productDTO.setName("Product 3");
    	productDTO.setPrice(99.99);
        final String categoryDTOJson = jsonTesterProduct.write(productDTO).getJson();
    	this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/product")
    			.content(categoryDTOJson).contentType(MediaType.APPLICATION_JSON_UTF8))
    		    .andExpect(status().isCreated())
    		    .andExpect(jsonPath("$.id").value(3))
    		    .andExpect(jsonPath("$.name").value("Product 3"))
    		    .andExpect(jsonPath("$.price").value(99.99));
    }
    
    @Test
    public void testProductGetAll() throws Exception {
    	this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products")
    			.contentType(MediaType.APPLICATION_JSON_UTF8))
    		    .andExpect(status().isOk())
    		    .andExpect(jsonPath("$[0].id").value(1))
    		    .andExpect(jsonPath("$[0].name").value("Product 1"))
    		    .andExpect(jsonPath("$[0].price").value(99.98));
    }
    
    @Test
    public void testProductUpdate() throws Exception {
    	ProductDTO productDTO = new ProductDTO();
    	productDTO.setId(2);
    	productDTO.setName("Product 3");
    	productDTO.setPrice(99.90);
        final String categoryDTOJson = jsonTesterProduct.write(productDTO).getJson();
    	this.mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/product")
    			.content(categoryDTOJson).contentType(MediaType.APPLICATION_JSON_UTF8))
    		    .andExpect(status().isOk())
    		    .andExpect(jsonPath("$.id").value(2))
    		    .andExpect(jsonPath("$.name").value("Product 3"))
    		    .andExpect(jsonPath("$.price").value(99.90));
    }

}
