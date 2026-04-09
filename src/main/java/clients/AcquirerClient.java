package clients;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.AcquirerEndpoints;
import api.endpoints.MerchantEndpoints;

import static io.restassured.RestAssured.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class AcquirerClient {

	@Test
	public static Response CreateAcquirer() {
		Map<String, Object> payload = new HashMap<>();

		payload.put("id", System.currentTimeMillis());
		payload.put("name", "doggie");

		Map<String, Object> category = new HashMap<>();
		category.put("id", 1);
		category.put("name", "Dogs");

		payload.put("category", category);

		payload.put("photoUrls", Arrays.asList("https://example.com/photo1"));

		Map<String, Object> tag = new HashMap<>();
		tag.put("id", 1);
		tag.put("name", "tag1");

		payload.put("tags", Arrays.asList(tag));

		payload.put("status", "available");

		Response response= 	given()
				.accept("application/json")
    .header("Content-Type", "application/json")
    .body(payload)
	.when()
	.post(AcquirerEndpoints.Create_Acquirer);

return response;
}
	public static Response getAcquirer(int id) {
		Response response= 
				given()
				.accept(ContentType.JSON)
				.pathParam("id", id)
				
				
				.when()
				.get(AcquirerEndpoints.Get_Acquirer);
	
	return response;
	}
	public static Response updateAcquirer(String payload,String username) {
		Response response= 
				given().accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)
				
				
				.when()
				.put(AcquirerEndpoints.Update_Acquirer);
	
	return response;
	}
	public static Response deleteAcquirer(String username) {
		Response response= 
				given()
				.accept(ContentType.JSON)
				.pathParam("username", username)
				
				
				.when()
				.delete(AcquirerEndpoints.Delete_Acquirer);
	
	return response;
	}
	}
