package gherkin;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Shopperprofile {
	String email;
	String random=RandomStringUtils.randomAlphanumeric(3);
	String randomemail="siva"+random+"@gmail.com";
	String bearer_token;
	String tk;

	String id;
	
@Test(priority=0)
public void post() {
	Response res=RestAssured.given().baseUri("https://www.shoppersstack.com/shopping").body("{\r\n"
			+ "  \"city\": \"Bangalore\",\r\n"
			+ "  \"country\": \"India\",\r\n"
			+ "  \"email\": \""+randomemail+"\",\r\n"
			+ "  \"firstName\": \"Siva\",\r\n"
			+ "  \"gender\": \"MALE\",\r\n"
			+ "  \"lastName\": \"Bhimavarapu\",\r\n"
			+ "  \"password\": \"Siva@0312\",\r\n"
			+ "  \"phone\": 9440241545,\r\n"
			+ "  \"state\": \"Karnataka\",\r\n"
			+ "  \"zoneId\": \"ALPHA\"\r\n"
			+ "}")
			.contentType("application/json")
			
			
			.when()
			.post("/shoppers")
			
			.then()
			.log().all()
			.statusCode(201).and().statusLine("HTTP/1.1 201 ").extract().response();
	System.out.println(res.asPrettyString());
	JsonPath jp=new JsonPath(res.asPrettyString());
	email=jp.getString("data.email");
	System.out.println(email);
	
}
@Test(priority = 1,dependsOnMethods = {"post"})
public void  login()
{
	Response res=RestAssured.given().baseUri("https://www.shoppersstack.com/shopping")
	.body("{\r\n"
			+ "  \"email\": \""+email+"\",\r\n"
			+ "  \"password\": \"Siva@0312\",\r\n"
			+ "  \"role\": \"SHOPPER\"\r\n"
			+ "}\r\n"
			+ "")
	.contentType("application/json")
	
	.when()
	.post("/users/login")
	
	.then()
	.statusCode(200)
	
	.and().statusLine("HTTP/1.1 200 ").extract().response();
	System.out.println(res.asPrettyString());
	JsonPath jp=new JsonPath(res.asPrettyString());
	bearer_token=jp.getString("data.jwtToken");
	System.out.println(bearer_token);
	
	
	JsonPath jp1=new JsonPath(res.asPrettyString());
	id=jp1.getString("data.userId");
	System.out.println(id);
	
}
@Test(priority = 2,dependsOnMethods = {"login"})
public void getData() {
    Response res=RestAssured.given().baseUri("https://www.shoppersstack.com/shopping").auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzaXZhUEZDQGdtYWlsLmNvbSBTSE9QUEVSIiwiZXhwIjoxNzM0ODc5NTUxLCJpYXQiOjE3MzQ4NDM1NTF9.UToNyZFA7pDiK8sRfJflHE68hf3MjjfhkhNhYPjIo9E\r\n").pathParam("shopperId",193265).contentType("application/json").when().get("/shoppers/{shopperId}").then().statusCode(200).and().statusLine("HTTP/1.1 200 ").extract().response();
System.out.println(res.asPrettyString());
}
@Test(priority=3)
public void put() {
Response res=RestAssured.given().baseUri("https://www.shoppersstack.com/shopping").body("{\r\n"
			+ "  \"city\": \"Bangalore\",\r\n"
			+ "  \"country\": \"India\",\r\n"
			+ "  \"email\": \""+randomemail+"\",\r\n"
			+ "  \"firstName\": \"Siva\",\r\n"
			+ "  \"gender\": \"MALE\",\r\n"
			+ "  \"lastName\": \"Bhima\",\r\n"
			+ "  \"password\": \"Siva@0312\",\r\n"
			+ "  \"phone\": 9440241545,\r\n"
			+ "  \"state\": \"Karnataka\",\r\n"
			+ "  \"zoneId\": \"ALPHA\"\r\n"
			+ "}")
	.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzaXZhd2RyQGdtYWlsLmNvbSBTSE9QUEVSIiwiZXhwIjoxNzM0ODgxODg1LCJpYXQiOjE3MzQ4NDU4ODV9.Pdgy_P2CJE0jZWD5mY12jZglVsqau1cjh5j3BH3o27c")
	.pathParam("shopperId",193265).contentType("application/json")
	.when().patch("/shoppers/{shopperId}")
	.then().statusCode(200).and().statusLine("HTTP/1.1 200 ").extract().response();
System.out.println(res.asPrettyString());
}
@Test(priority=4,dependsOnMethods = {"login"})
public void frgtpasswd(){
Response res=RestAssured.given().baseUri("https://www.shoppersstack.com/shopping")
	.headers("email",randomemail,"role","SHOPPER")
	.contentType("application/json")
	.when().post("/users/forgot-password")
	.then().statusCode(200)
	.and().statusLine("HTTP/1.1 200 ").extract().response();
	System.out.println(res.asPrettyString());
	JsonPath jp=new JsonPath(res.asPrettyString());
	tk=jp.getString("data.token");
	System.out.println(tk);
}
@Test(priority=5,dependsOnMethods = {"frgtpasswd"})
public void verifyacc() {
Response res=RestAssured.given().baseUri("https://www.shoppersstack.com/shopping")
    .headers("password","Guru@234").
    queryParam("token",tk)
    .contentType("application/json")
	.when().post("/users/verify-account")
	.then().statusCode(200)
	.and().statusLine("HTTP/1.1 200 ").extract().response();
	System.out.println(res.asPrettyString());
}

}
