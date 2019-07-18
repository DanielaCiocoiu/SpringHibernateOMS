package com.home.springboot.OMS;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.home.springboot.OMS.entity.Product;

@RunWith(SpringRunner.class)  //ii spune lui JUnit să ruleze folosind suportul de testare de la Spring
@SpringBootTest(classes = {OmsApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) //attribute of @SpringBootTest to further refine how your tests run

//SpringBootTest.WebEnvironment DEFINED_PORT
//Creează un context de aplicație web (reactivă) fără a defini nicio server.port=0 Environmentproprietate.

public class OmsApplicationTests {


    private static final String API_ROOT
      = "http://localhost:8080/api/products";
	
   
    @Test
    public void whenGetAllProducts_thenOK() {
      final  Response response = RestAssured.get(API_ROOT);
      
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }
     
    @Test
    public void whenGetProductsByProduct_name_thenOK() {
        Product product = createRandomProduct();
        createProductAsUri(product);
        Response response = RestAssured.get(
          API_ROOT + "/product_name/" + product.getProduct_name());
         
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertTrue(response.as(List.class)
          .size() > 0);
    }
    @Test
    public void whenGetCreatedProductById_thenOK() {
        Product product = createRandomProduct();
        String location = createProductAsUri(product);
        final  Response response = RestAssured.get(location);
         
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(product.getProduct_name(), response.jsonPath()
          .get("product_name"));
    }
     
    @Test
    public void whenGetNotExistProductById_thenNotFound() {
   final     Response response = RestAssured.get(API_ROOT + "/" + randomNumeric(4));
         
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }
	
	
	 private Product createRandomProduct() {
	    	Product product = new Product();
	    	product.setProduct_name(randomAlphabetic(10));
	    	//product.setproduct_code(randomAlphanumeric(15));
	        return product;
	    }
	 
	    private String createProductAsUri(Product product) {
	        Response response = RestAssured.given()
	          .contentType(MediaType.APPLICATION_JSON_VALUE)
	          .body(product)
	          .post(API_ROOT);
	        return API_ROOT + "/" + response.jsonPath().get("id");
	    }

}
