package pojo;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import groovyjarjarantlr4.v4.parse.ANTLRParser.range_return;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class P1 {
	String randmail;
@Test
public void postt() throws JsonProcessingException {
	String random = RandomStringUtils.randomAlphanumeric(3);
	 randmail = random+"@gmail.com";
	
	Create_user_Pojo data = new Create_user_Pojo();
	data.setCity("Bangalore");
	data.setCountry("India");
	data.setEmail(randmail);
	data.setFirstName("Shiva");
	data.setGender("MALE");
	data.setLastName("Pavan");
	data.setPassword("Siva@0312");
	data.setPhone("9440248752");
	data.setState("Karnataka");
	data.setZoneId("ALPHA");
	
	
	ObjectMapper obj=new ObjectMapper();
	String jsonbody=obj.writerWithDefaultPrettyPrinter().writeValueAsString(data);
	System.out.println(jsonbody);
	
	
	Response res = RestAssured.given().baseUri("https://www.shoppersstack.com/shopping").body(jsonbody)
	.contentType("application/json").when().post("/shoppers").then().statusCode(201)
	.statusLine("HTTP/1.1 201 ").extract().response();
	System.out.println(res.asPrettyString());
	
}

	}


