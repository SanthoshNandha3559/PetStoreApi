package com.qa.petstore.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import com.qa.petstore.payload.User;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {

	static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");// Load properties file
		return routes;
	}

	public static Response createUser(User payload) {
		String post_Url=getURL().getString("post_Url");
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(post_Url);
		return response;
	}

	public static Response readUser(String userName) {
		String get_Url=getURL().getString("get_Url");
		Response response = given().pathParam("username", userName).when().get(get_Url);
		return response;
	}

	public static Response updateUser(String userName, User payload) {
		String update_Url=getURL().getString("update_Url");
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).body(payload).when().put(update_Url);

		return response;
	}

	public static Response deleteUser(String userName) {
		String delete_Url=getURL().getString("delete_Url");
		Response response = given().pathParam("username", userName).when().delete(delete_Url);
		return response;
	}
}
