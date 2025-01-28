package pojo;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class P2 {
@Test
public void login() throws JsonProcessingException {
Login_user_Pojo data=new Login_user_Pojo();
data.setEmail("sivapavankumarbh@gmail.com");
data.setPassword("Siva@0312");
data.setRole("SHOPPER");


ObjectMapper obj=new ObjectMapper();
String jsonbody=obj.writerWithDefaultPrettyPrinter().writeValueAsString(data);
System.out.println(jsonbody);


Response res =RestAssured.given().baseUri("https://www.shoppersstack.com/shopping").body(jsonbody)
.contentType("application/json").when().post("/users/login").then()
.statusCode(200).and().statusLine("HTTP/1.1 200 ")
.and().time(Matchers.lessThanOrEqualTo(5000l))
.and().body("message",Matchers.equalTo("OK"))
.and().contentType("application/json")
.and().header("Server", Matchers.equalTo("nginx"))
.extract().response();
System.out.println(res.asPrettyString());
}
}
