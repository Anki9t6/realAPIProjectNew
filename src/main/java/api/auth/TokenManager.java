package api.auth;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class TokenManager {

	 private static String token;
	    private static long expiryTime;

	    public static String getToken() {
	        if (token == null || isTokenExpired()) {
	            generateNewToken();
	        }
	        return token;
	    }

	    private static void generateNewToken() {
	        Response response = given()
	            .contentType("application/x-www-form-urlencoded")
	            .formParam("client_id", "client_id")
	            .formParam("client_secret", "client_secret")
	            .formParam("grant_type", "client_credentials")
	        .when()
	            .post("/oauth/token");

	        token = response.jsonPath().getString("access_token");
	        int expiresIn = response.jsonPath().getInt("expires_in");

	        expiryTime = System.currentTimeMillis() + (expiresIn * 1000);
	    }

	    private static boolean isTokenExpired() {
	    	
	        return System.currentTimeMillis() >= expiryTime;
	    }
	}
