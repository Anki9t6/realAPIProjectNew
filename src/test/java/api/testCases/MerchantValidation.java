package api.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import api.payload.MerchantPayload;
import api.utilities.AssertUtils;
import base.Base;
import clients.MerchatClient;
import io.restassured.response.Response;


public class MerchantValidation extends Base{
	Faker faker;
	MerchantPayload payload;
	@BeforeClass
	public void generateTestData() {
		faker=new Faker();
		payload=new MerchantPayload();
		payload.setId(faker.idNumber().hashCode());
		payload.setUsername(faker.name().username());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPhone(faker.phoneNumber().cellPhone());
		payload.setPassword(faker.internet().password(5, 10));
		
	}



	/*@Test(priority=1)
	public void testCreateMerchant()throws JsonProcessingException  {
	
		Response response = MerchatClient.createMerchant();
	
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}*/
	@Test(priority=2)
	public void testGetMerchantDetail() {
		  Base.getTest().info("Calling GetMerchantDetail API...");
		Response response=MerchatClient.getMerchant("theUser");
		response.then().log().all();
		AssertUtils.verifyStatusCode(response, 200);
		
		  Base.getTest().info("Status Code: " +response.getStatusCode());
          Base.getTest().info("Response Body: " + response.asPrettyString());
          Base.getTest().info("Response Time: " +response.getTime());
	
	}
	/*@Test(priority=3)
	public void testUpdateMerchantDetail() throws JsonProcessingException {
		MerchantValidation body=new MerchantValidation(10,"theUser","john","James","johnupdate@email.com","12345","12345",1);
		ObjectMapper maper=new ObjectMapper();
	   	String body1=maper.writeValueAsString(body);

		Response response=MerchatClient.updateMerchant(body1, getUsername());
	}*/
	@Test(priority=4)
	public void testDeleteMerchant() {
		 Base.getTest().info("Calling DeleteMerchantDetail API...");
		Response response=MerchatClient.getMerchant("theUser");
		response.then().log().all();
		AssertUtils.verifyStatusCode(response, 200);
		  Base.getTest().info("Status Code: " +response.getStatusCode());
          Base.getTest().info("Response Body: " + response.asPrettyString());
          Base.getTest().info("Response Time: " +response.getTime());
	
	}
	}
   	


	