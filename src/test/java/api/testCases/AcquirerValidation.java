package api.testCases;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import api.utilities.AssertUtils;
import base.Base;
import clients.AcquirerClient;
import clients.MerchatClient;
import io.restassured.response.Response;

public class AcquirerValidation extends Base{

	/*@Test(priority=1)
	public void testCreateAcquirer()throws JsonProcessingException  {
	
		Response response = null;
		try {
			response = AcquirerClient.CreateAcquirer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=2)
	public void testGetAcquirerDetail() {
		  Base.getTest().info("Calling GetAcquirerDetail API...");
		Response response=AcquirerClient.getAcquirer(10);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		 Base.getTest().info("Validation done");
		//Assert.assertEquals(response.jsonPath().getString("email"), "john@email.com");
	}
	@Test(priority=3)
	public void testUpdateAcquirerDetail() throws JsonProcessingException {
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
		Response response=AcquirerClient.updateAcquirer(payload.toString(), "dogs");
	}*/
	@Test(priority=4)
	public void testDeleteMerchant() {
		 Base.getTest().info("Calling DeleteAcquirerDetail API...");
		Response response=MerchatClient.getMerchant("theUser");
		response.then().log().all();
		AssertUtils.verifyStatusCode(response, 200);
		   Base.getTest().info("Status Code: " +response.getStatusCode());
           Base.getTest().info("Response Body: " + response.asPrettyString());
           Base.getTest().info("Response Time: " +response.getTime());
	
	}
	
}
