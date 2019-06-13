package QA_Technical_Test;

import static io.restassured.RestAssured.get;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class API_Get_Product 
{

	Response URL = get("http://localhost:5000/v1/products");				// Base URL
	
	@Test(priority = 1)
	public void Verify_Response_Code() 
	{
		int code = URL.getStatusCode();
		System.out.println("Response Code = " + code);						// Print Response code
		Assert.assertEquals(code, 200);										// Validation For Response Code
	}
	
	@Test(priority = 2)
	public void Verify_Response_Body() 
	{
		String body = URL.asString();		
		System.out.println("Response Body = " + body);						// Print Response Data
		Assert.assertNotEquals(null, body);									// Validation For Response Data
	}
	
	@Test(priority = 3)
	public void Verify_Response_Time() 
	{
		long time = URL.getTime();		
		System.out.println("Response Time = " + time + " ms");				// Print Response Time		
	}
	
}