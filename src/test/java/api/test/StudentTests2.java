package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StudentEndPoints2;
import api.payload.Student;
import io.restassured.response.Response;

public class StudentTests2 {
	Faker faker;
	Student studentPayload;

	
	@BeforeClass
	public void setUpData() {
		faker= new Faker();
		studentPayload= new Student();
		studentPayload.setAge(faker.idNumber().hashCode());
		studentPayload.setName(faker.name().username());
		String[] subjects= {faker.book().genre(),faker.book().genre(),faker.book().genre()};
		studentPayload.setSubjects(subjects);
		studentPayload.setGrade(faker.buffy().characters());
		studentPayload.setId(String.valueOf(faker.idNumber().hashCode()));
	
	}
	
	@Test(priority = 1,dataProvider = "")
	public void testPostUser()
	{
		 Response response= StudentEndPoints2.createStudent(studentPayload);
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 201);
	}
	
	@Test(priority = 2)
	public void testGetUserById()
	{		 
		 Response response= StudentEndPoints2.readStudent(this.studentPayload.getId());
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void testUpdateUserById()
	{	
		studentPayload.setGrade(faker.buffy().characters());		
		studentPayload.setName(faker.name().username());
		studentPayload.setAge(faker.idNumber().hashCode());		
		Response response= StudentEndPoints2.updateStudent(this.studentPayload.getId(),studentPayload);		
		 response.then().log().body().statusCode(200);		 
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
		 Response responseAterUpdate= StudentEndPoints2.readStudent(this.studentPayload.getId());
		 responseAterUpdate.then().log().all();
		 Assert.assertEquals(responseAterUpdate.getStatusCode(), 200);

	}
	
	@Test(priority = 4)
	public void testDeleteStudentById()
	{		 
		 Response response= StudentEndPoints2.deleteStudent(this.studentPayload.getId());
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 200);
	}
}
