package testng_assign;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.baseURI;
public class FirstAssignment {
	@Parameters({"url"})
	@Test
	public void testAPIResponse() {
		// Set base URI
		baseURI = "https://dummyjson.com/products/1";
		System.out.println(baseURI);

		// Make a GET request and store the response
		Response response = given().get(baseURI);
		System.out.println("Response: " + response.jsonPath().get("images"));

		// Get status code from the response
		int statusCode = response.getStatusCode();

		// Verify status code is 200
		Assert.assertEquals(statusCode, 200, "Status code is 200");

		// Get the response body as a string
		//String responseBody = response.getBody().asString();

		String title = response.getBody().jsonPath().getString("title");
		System.out.println("The title value is " + title);
		String price_value = response.getBody().jsonPath().getString("price");
		System.out.println("Validate the price value " + price_value);
		String brand_value = response.getBody().jsonPath().getString("brand");
		System.out.println("Validate the brand name "  + brand_value);
		int image_count = response.getBody().jsonPath().getList("images").size();
		System.out.println("Validate total image count "+image_count);

		for(int i=0;i<image_count;i++)
		{
			String images =response.getBody().jsonPath().getString("images["+i+"]");
			System.out.println("Images .jpg file: "+images);
		}


	}
}
