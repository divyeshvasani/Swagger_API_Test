package QA_Technical_Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Post_Product 
{
	@Test(priority = 1)
	public void Verify_Response_Code() 
	{
		RestAssured.baseURI = "http://localhost:5000/v1";					// Base URL
		RequestSpecification request = RestAssured.given();
		String data = "name=Test_Product_01&price=8.99";					// "name" and "price" parameter values
		request.header("Content-Type", "application/x-www-form-urlencoded");
		request.header("Accept", "application/json");
		request.body(data);
		Response response = request.post("/product");						// Post URL
		int code = response.getStatusCode();
		System.out.println("Response Code = " + code);						// Print Response code
		Assert.assertEquals(code, 200);										// Validation For Response Code
	}
	
	@Test(priority = 2)
	public void Verify_Response_Body() 
	{
		RestAssured.baseURI = "http://localhost:5000/v1";					// Base URL
		RequestSpecification request = RestAssured.given();
		String data = "name=Test_Product_01&price=8.99";					// "name" and "price" parameter values
		request.header("Content-Type", "application/x-www-form-urlencoded");
		request.header("Accept", "application/json");
		request.body(data);
		Response response = request.post("/product");						// Post URL
		String body = response.asString();		
		System.out.println("Response Body = " + body);						// Print Response Data
		Assert.assertNotEquals("null", body);								// Validation For Response Data
	}
	
	@Test(priority = 3)
	public void Verify_Response_Time() 
	{
		RestAssured.baseURI = "http://localhost:5000/v1";					// Base URL
		RequestSpecification request = RestAssured.given();
		String data = "name=Test_Product_01&price=8.99";					// "name" and "price" parameter values
		request.header("Content-Type", "application/x-www-form-urlencoded");
		request.header("Accept", "application/json");
		request.body(data);
		Response response = request.post("/product");						// Post URL
		long time = response.getTime();		
		System.out.println("Response Time = " + time + " ms");				// Print Response Time
	}
	
}