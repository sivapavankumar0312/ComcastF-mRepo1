package reqres;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Basic_script {
@org.testng.annotations.Test
public void get()
{
	RestAssured.baseURI="https://reqres.in/";
	RequestSpecification req=RestAssured.given();
    Response res=req.request(Method.GET,"/api/users?page=2");
    System.out.println(res.asPrettyString());
	System.out.println(res.getStatusCode());
	System.out.println(res.statusLine());
}
}
