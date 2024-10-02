package com.qa.petstore.test;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import com.qa.petstore.endpoints.UserEndpoints;
import com.qa.petstore.payload.User;

import org.apache.logging.log4j.LogManager;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User payload;
	public Logger logger;
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		payload=new User();
		payload.setId(faker.idNumber().hashCode());
		payload.setUsername(faker.name().username());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password(5, 10));
		payload.setPhone(faker.phoneNumber().cellPhone());
		logger=LogManager.getLogger(this.getClass());
	}
	@Test(priority = 1)
	public void testPostUser() {
		logger.info("********** Create User *************");
		Response response=UserEndpoints.createUser(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);  
		logger.info("********** User is Created*************");
	}
	@Test(priority = 2)
	public void testGetUserByName() {
		Response response=UserEndpoints.readUser(this.payload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);   
	}
	@Test(priority = 3)
	public void testUpdateUser() {
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		Response response=UserEndpoints.updateUser(this.payload.getUsername(),payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);   
		
		//check data after update
		Response responseAfterUpdate=UserEndpoints.readUser(this.payload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);  
	}
	@Test(priority = 4)
	public void testDeleteUserByName() {
		Response response=UserEndpoints.deleteUser(this.payload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);   
	}
}
