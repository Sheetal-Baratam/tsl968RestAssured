package day1;



import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OpenWeatherAPI {
  @Test(enabled=false,description="Getting weather API ifo generally")
  public void OpenWeatherInfo() {
	  /*Given >pre condition,like content type, authentication
	   * When >user performs something
	   * Then >expected outcome from system*/
	  RestAssured.given()//classname.methodORfunction name
	              .when()
	              .get("http://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=563f35938249e8885aa209bdd3a60c31")
	              .then()
	              .log()
	              .body()
	              .statusCode(200);
	              
  }
  @Test(enabled=true,description="Getting weather API ifo generally")
  public void OpenWeatherInfo2() {
	  
	  Response res=RestAssured.given()
	              .when()
	              .get("http://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=563f35938249e8885aa209bdd3a60c31");
	  System.out.println(res.prettyPrint());
	  System.out.println(res.getTime());
	  System.out.println(res.getStatusCode());
	  System.out.println(res.getContentType());
	              
  }
  @Test(enabled=false,description="Getting weather API ifo generally")
  public void OpenWeatherInfo3() {
	  Map<String,String> param= new HashMap<String,String>();
	  param.put("q","Mumbai");
	  param.put("appid", "563f35938249e8885aa209bdd3a60c31");
	  RestAssured.given()
	             // .queryParam("q","Mumbai")
	              //.queryParam("appid", "563f35938249e8885aa209bdd3a60c31")
	             .params(param)
	              .when()
	              .get("http://api.openweathermap.org/data/2.5/weather")
	              .then()
	              .log()
	              .body()
	              .statusCode(200);
	              
  }
}
