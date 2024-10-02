package com.qa.petstore.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.petstore.endpoints.UserEndpoints;
import com.qa.petstore.payload.User;
import com.qa.petstore.utilities.DataProviders;

import io.restassured.response.Response;

public class DataDrivenTests {

	User payload;

	@Test(priority = 1, dataProvider = "testData", dataProviderClass = DataProviders.class)
	public void testPostUser(String userId, String userName, String fristName, String lastName, String email,
			String password, String phone) {
		payload = new User();
		payload.setId(Integer.parseInt(userId));
		payload.setUsername(userName);
		payload.setFirstName(fristName);
		payload.setLastName(lastName);
        payload.setEmail(email);
        payload.setPassword(password);
        payload.setPhone(phone);
        Response response=UserEndpoints.createUser(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority = 3, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String userName) {
		Response response=UserEndpoints.deleteUser(userName);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);   
	}
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testGetUserByName(String userName) {
		System.out.println(userName);
		Response response=UserEndpoints.readUser(userName);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);   
	}
}
