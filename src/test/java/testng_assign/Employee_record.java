package testng_assign;

import Reusable.Reuse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Employee_record {
	public String id;
	Reuse Ruseable;

	@BeforeClass
	public void setUp()
	{
		Ruseable=new Reuse();
	}

	@Parameters({"baseurl","name","year","DOB","Address","Salary"})
	@Test(priority = 0)
	public void post_call(String baseurl,String name,String year,String DOB,String Address,String Salary)
	{
		Response response = given().
				contentType(ContentType.JSON).
				body(Ruseable.CreatePostJson(name,year,DOB,Address,Salary)).
				when().
				post(baseurl);

		int statusCode = response.getStatusCode();
		System.out.println("POST Response Status Code: " + statusCode);

		String responseBody = response.getBody().asString();
		System.out.println("POST Response Body: " + responseBody);

		id=response.getBody().jsonPath().getString("id");
		System.out.println("Id :"+id);

	}

	@Parameters({"baseurl"})
	@Test(priority = 1)
	public void get_call(String baseurl)
	{
		Response response = get(baseurl+"?id="+id);

		String responseBody1= response.getBody().asString();
		System.out.println("GET Response Body: " + responseBody1);

		int statusCode = response.getStatusCode();
		System.out.println("GET Response Status Code: " + statusCode);

	}

	@Parameters({"baseurl","name","year","DOB","UpdatedAddress","Salary"})
	@Test(priority = 2)
	public void put_call(String url,String name,String year,String DOB,String Address1,String Salary)
	{

		Response response = given().
				contentType(ContentType.JSON).
				body(Ruseable.CreatePostJson(name,year,DOB,Address1,Salary)).
				when().
				put(url+"/"+id);

		int statusCode = response.getStatusCode();
		System.out.println("PUT Response Status Code: " + statusCode);

		Response response1 = get(url+"?id="+id);

		String Address = response1.getBody().jsonPath().getString("data.Address");
		System.out.println("Updated Address is "+Address);
		Assert.assertEquals(Address,Address);

		String responseBody2 = response.getBody().asString();
		System.out.println("PUT Response Body: " + responseBody2);
	}

}