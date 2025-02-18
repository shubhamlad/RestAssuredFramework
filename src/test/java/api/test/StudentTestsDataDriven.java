package api.test;

import java.util.Hashtable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StudentEndPoints;
import api.payload.Student;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class StudentTestsDataDriven {
	Faker faker;
	public Logger logger;
	
	@BeforeClass
	public void setUpData() {
		faker= new Faker();
		logger=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1,dataProvider = "data",dataProviderClass = DataProviders.class)
	public void testPostUser(Hashtable<String,String> data)
	{
		logger.info("crating user");
		Student studentPayload= new Student();
		studentPayload.setId(data.get("id"));
		studentPayload.setName(data.get("name"));
		studentPayload.setAge(Integer.parseInt(data.get("age")));		
		String[] subjects= data.get("subjects").toString().split(",");
		studentPayload.setSubjects(subjects);
		studentPayload.setGrade(data.get("grade"));	
		
		 Response response= StudentEndPoints.createStudent(studentPayload);
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 201);
	}
	
	@Test(priority = 2,dataProvider = "data",dataProviderClass = DataProviders.class)
	public void testGetUserById(Hashtable<String,String> data)
	{		 
		 Response response= StudentEndPoints.readStudent(data.get("id"));
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	//@Test(priority = 3,dataProvider = "data",dataProviderClass = DataProviders.class)
//	public void testUpdateUserById(Hashtable<String, String> data)
//	{	
//		Student studentPayload;
//
//		studentPayload.setName(data.get("name"));
//		studentPayload.setAge(Integer.parseInt(data.get("age")));		
//		Response response= StudentEndPoints.updateStudent(this.studentPayload.getId(),studentPayload);		
//		 response.then().log().body().statusCode(200);		 
//		 Assert.assertEquals(response.getStatusCode(), 200);
//		 
//		 Response responseAterUpdate= StudentEndPoints.readStudent(this.studentPayload.getId());
//		 responseAterUpdate.then().log().all();
//		 Assert.assertEquals(responseAterUpdate.getStatusCode(), 200);
//
//	}
//	
	@Test(priority = 4,dataProvider = "data",dataProviderClass = DataProviders.class)
	public void testDeleteStudentById(Hashtable<String, String> data)
	{		 
		 Response response= StudentEndPoints.deleteStudent(data.get("id"));
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 200);
	}
}
