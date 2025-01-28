package gherkin;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.ResponseSpecification;

public class ShopperrAdmin {
@Test
public void admin() {
ResponseSpecification res=(ResponseSpecification) RestAssured.given().baseUri("https://www.shoppersstack.com/shopping")
	.body("{\r\n"
			+ "  \"city\": \"Bangalore\",\r\n"
			+ "  \"country\": \"India\",\r\n"
			+ "  \"createdDateTime\": \"2024-12-04T04-13-31.363Z\",\r\n"
			+ "  \"dob\": \"2024-11-01\",\r\n"
			+ "  \"email\": \"shvaninP@23gmail.com\",\r\n"
			+ "  \"firstName\": \"Siva\",\r\n"
			+ "  \"gender\": \"MALE\",\r\n"
			+ "  \"imageId\": \"string\",\r\n"
			+ "  \"jwtToken\": \"string\",\r\n"
			+ "  \"lastName\": \"Pavan\",\r\n"
			+ "  \"password\": \"Siva@0312\",\r\n"
			+ "  \"phone\": \"9440848750\",\r\n"
			+ "  \"role\": \"ADMIN\",\r\n"
			+ "  \"state\": \"karnataka\",\r\n"
			+ "  \"status\": \"ACTIVE\",\r\n"
			+ "  \"token\": \"string\",\r\n"
			+ "  \"zoneId\": \"ALPHA\"\r\n"
			+ "}").contentType("application/json").when().post("/admin").then().assertThat().statusCode(201).and().statusLine("HTTP/1.1 201 ").extract().response();
	
System.out.println(((ResponseBodyData) res).asPrettyString());

}}
