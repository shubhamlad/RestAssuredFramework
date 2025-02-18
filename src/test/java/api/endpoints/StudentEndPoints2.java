package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.Student;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StudentEndPoints2 {
	public StudentEndPoints2() {
		
	}
	static ResourceBundle getURL() {
		// TODO Auto-generated method stub	
		ResourceBundle routes=ResourceBundle.getBundle("routes");//load properties file
		return routes;
	}
	
	public static Response createStudent(Student payload)
	{
		String post_url_student=getURL().getString("post_url_student");
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(post_url_student);
		return res;
	}
	
	
	
	
	public static Response readStudent(String id)
	{
		String get_url_student=getURL().getString("get_url_student");

		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("id", id)
		.when()
			.get(Routes.get_url_student);
		return res;
	}
	
	public static Response updateStudent(String id,Student payload)
	{
		String update_url_student=getURL().getString("update_url_student");

		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("id", id)
			.body(payload)
		.when()
			.put(update_url_student);
		return res;
	}
	
	public static Response deleteStudent(String id)
	{
		String delete_url_student=getURL().getString("delete_url_student");

		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("id", id)
		.when()
			.delete(delete_url_student);
		return res;
	}

}
