package clients;
import static io.restassured.RestAssured.given;
import api.endpoints.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class MerchatClient{

	public static Response createMerchant(String payload) {
		Response response= 
				given().accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(MerchantEndpoints.Create_Merchant);
	
	return response;
	}
	public static Response getMerchant(String username) {
		Response response= 
				given()
				.accept(ContentType.JSON)
				.pathParam("username", username)
				
				
				.when()
				.get(MerchantEndpoints.Get_MerchantDetail);
	
	return response;
	}
	public static Response updateMerchant(String payload,String username) {
		Response response= 
				given().accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)
				
				
				.when()
				.put(MerchantEndpoints.Update_MerchantDetil);
	
	return response;
	}
	public static Response deleteMerchant(String username) {
		Response response= 
				given()
				.accept(ContentType.JSON)
				.pathParam("username", username)
				
				
				.when()
				.delete(MerchantEndpoints.Delete_Merchant);
	
	return response;
	}
}
