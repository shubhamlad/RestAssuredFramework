package api.endpoints;
//Storing all the URLs
public class Routes {

	//https://petstore.swagger.io/v2/user
	public static String base_url="https://petstore.swagger.io/v2/";
	
	//User Model
	public static String post_url=base_url+"user";
	public static String get_url=base_url+"user/{username}";
	public static String update_url=base_url+"user/{username}";
	public static String delete_url=base_url+"user/{username}";
	
	
public static String base_url_local="http://localhost:3000/students";
	
	public static String post_url_student=base_url_local;
	public static String get_url_student=base_url_local+"/{id}";
	public static String update_url_student=base_url_local+"/{id}";
	public static String delete_url_student=base_url_local+"/{id}";

	
	
	
	
}
