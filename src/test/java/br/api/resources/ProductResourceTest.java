package br.api.resources;

import br.api.BootapiApplication;
import br.api.models.Category;
import br.api.models.Product;
import br.api.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Dewes on 24/07/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootapiApplication.class)
@WebAppConfiguration
public class ProductResourceTest {

    @Autowired private ProductRepository productRepository;

    @Autowired private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    private ProductResource productResource;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        productResource = new ProductResource();
        mockMvc = MockMvcBuilders.standaloneSetup(productResource).build();
        ReflectionTestUtils.setField(productResource, "productRepository", productRepository);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void save() throws Exception {
        /*Product product = new Product("Product1", "Description1", new BigDecimal(0.0), new Category("Cateogry1", "Description1"));
        String body = objectMapper.writeValueAsString(product);
        mockMvc.perform(post("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isCreated());*/
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void getById() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

}