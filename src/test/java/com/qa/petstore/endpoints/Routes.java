package com.qa.petstore.endpoints;

public class Routes {
	
	/*
	Swagger URI ---->  https://petstore.swagger.io

    Create User (post)   : https://petstore.swagger.io/v2/user
    Get User (get)       : https://petstore.swagger.io/v2/user/{username}
    Update User (update) : https://petstore.swagger.io/v2/user/{username}
    Delete user (delete) : https://petstore.swagger.io/v2/user/{username}
	 */

	public static String base_Url="https://petstore.swagger.io/v2";
	
	
	//User Module
	
	public static String post_Url=base_Url+"/user";
	
	public static String get_Url=base_Url+"/user/{username}";
	
	public static String update_Url=base_Url+"/user/{username}";
	
	public static String delete_Url=base_Url+"/user/{username}";
	
	
	//Pet Module
	
	
	//Store Module
}
