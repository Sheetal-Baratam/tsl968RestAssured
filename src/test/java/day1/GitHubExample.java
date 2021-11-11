package day1;

import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GitHubExample {
  @Test(enabled=false,description="getting all repositories")
  public void getAllRepo() {
	  given()
	  .auth()////specifying authentication meeded
	  .oauth2("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")
	  .when()
	  .get("https://api.github.com/user/repos")
	  .then()
	  .log()
	  .body()
	  .statusCode(200)
	  .time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
  }
  
  @Test(enabled=true,description="Adding Repository")
  public void addRepository(){
	  JSONObject js = new JSONObject();
	  js.put("name","tsl968-restAssured");
	  js.put("description","I created by restassured");
	  js.put("homepage","https://github.com/Sheetal-Baratam");
	  
	  
	  
	  given()
	     .auth()
	     .oauth2("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")
	     .header("Content-Type","application/json")
	     .body(js.toJSONString())
	     
	  .when()
	     .post("https://api.github.com/user/repos")//to get this go in repositories 
	  .then()
	      .log()
	      .body()
	      .statusCode(201)
	      .time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
	  
  }
  
}
