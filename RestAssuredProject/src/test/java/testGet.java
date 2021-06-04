import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseLogSpec;


public class testGet {
	@Test //Verify status code is 200
	void test() {
		Response response = get("https://api.spacexdata.com/v4/launches/latest");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		
	}
	
	@Test //Verify value of field fairings.reused
	void test02() {
		given()
		.get("https://api.spacexdata.com/v4/launches/latest")
		.then()
		.body("fairings.reused",equalTo(true));
		
		}
	
	@Test //Verify value of array field fairings.ships 
	void test03() {
		given()
		.get("https://api.spacexdata.com/v4/launches/latest")
		.then()
		.body("fairings.ships[0]",equalTo("5ea6ed2e080df4000697c909"));
		
		}
	
	@Test //Verify value of field ships
	void test04() {
		given()
		.get("https://api.spacexdata.com/v4/launches/latest")
		.then()
		.body("ships",hasItems("5ea6ed30080df4000697c913","5ea6ed2f080df4000697c90c"));
		
		}
	
	@Test //Verify value of array cores
	void test05() {
		given()
		.get("https://api.spacexdata.com/v4/launches/latest")
		.then()
		.body("cores[0].core",equalTo("5f57c54a0622a633027900a1"));
		
		}
	@Test //Verify invalid url
		void test06() {
		Response response = get("https://api.spacexdata.com/v4/launches/latest1");
		//System.out.println(response.asString());
		String errMsg = response.asString();
		Assert.assertEquals(errMsg, "Not Found");
			}
	
	
	
}
