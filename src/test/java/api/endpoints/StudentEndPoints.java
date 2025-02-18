package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Student;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StudentEndPoints {
	public static Response createStudent(Student payload)
	{
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url_student);
		return res;
	}
	
	
	
	
	public static Response readStudent(String id)
	{
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
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("id", id)
			.body(payload)
		.when()
			.put(Routes.update_url_student);
		return res;
	}
	
	public static Response deleteStudent(String id)
	{
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("id", id)
		.when()
			.delete(Routes.delete_url_student);
		return res;
	}

}
