package spec;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Spec_builder {
@BeforeMethod
 RequestSpecification request(String uri, String body,String content) {
	RequestSpecBuilder spec=new RequestSpecBuilder();
RequestSpecification req=spec.setBaseUri(uri)
                         .setBody(body).setContentType(content).build();
return req;
}
@AfterMethod
public void response(int code, String line) {
	ResponseSpecBuilder spec=new ResponseSpecBuilder();
  ResponseSpecification	res=spec.expectStatusCode(code)
		  .expectStatusLine(line).
		  
	
}
}
