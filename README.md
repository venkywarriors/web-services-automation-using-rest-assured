![Rest Assured API Testing Framework](https://1.bp.blogspot.com/-AIE764EqgyQ/XOjijRSSnII/AAAAAAAArmA/u3QjS9N6-no_zo7YASd8IFh1hom0kikQQCLcBGAs/s1600/framework%2Blogo.JPG)

How to resolve javax.net.ssl.SSLHandshakeException: sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: 

###### **RestAssured.useRelaxedHTTPSValidation();**      //disable usual https verification aswell 

[Basics](https://www.hascode.com/2011/10/testing-restful-web-services-made-easy-using-the-rest-assured-framework/)

[Example](https://medium.com/gradeup/rest-api-testing-using-rest-assured-56a6cf772ca3)

[rest-assured offical](https://github.com/rest-assured/rest-assured/wiki/usage)

Sample programs :
[https://github.com/rest-assured/rest-assured/tree/master/examples/rest-assured-itest-java/src/test/java/io/restassured/itest/java](https://github.com/rest-assured/rest-assured/tree/master/examples/rest-assured-itest-java/src/test/java/io/restassured/itest/java) <br>

### :dart: GET Request Method using Rest Assured
```
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class RestAssuredAPITest {
 
 @Test
public void GetBooksDetails() { 
	// Specify the base URL to the RESTful web service 
	RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books"; 
	RequestSpecification httpRequest = RestAssured.given();

	Response response = httpRequest.request(Method.GET, "/Hyderabad");
  //Passing the resource details by Query Parameters
  Response res = httpRequest.queryParam("ISBN","9781449325862").get("/Book");

	System.out.println("Status received => " + response.getStatusLine()); 
	System.out.println("Response=>" + response.prettyPrint());
  System.out.println("Server value: " + response.header("Server"));

  int statusCode = response.getStatusCode();

  // Assert that correct status code is returned.
  Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");

	// Retrieve the body of the Response
	ResponseBody body = response.getBody();

	// By using the ResponseBody.asString() method, we can convert the  body
	String bodyAsString = body.asString();
	Assert.assertEquals(bodyAsString.contains("Hyderabad") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");

  // Get all the headers and then iterate over allHeaders to print each header 
   Headers allHeaders = response.headers(); 
   // Iterate over all the Headers 
   for(Header header : allHeaders) { 
     System.out.println("Key: " + header.getName() + " Value: " + header.getValue()); 
   }

  // First get the JsonPath object instance from the Response interface
	JsonPath jsonPathEvaluator = response.jsonPath();

	// Then simply query the JsonPath object to get a String value of the node
	String city = jsonPathEvaluator.get("City");

	// Validate the response
	Assert.assertEquals(city, "Hyderabad", "Correct city name received in the Response");
}
}
```
### :dart: POST Request Method using Rest Assured
```
    RestAssured.baseURI ="https://demoqa.com/Account/v1"; 
    RequestSpecification request = RestAssured.given(); 
    JSONObject requestParams = new JSONObject();
    requestParams.put("userName", "test_rest");
    requestParams.put("password", "Testrest@123"); 
    request.body(requestParams.toJSONString());
    Response response = request.put("/User"); 
    ResponseBody body = response.getBody();
    System.out.println(response.getStatusLine());
    System.out.println(body.asString());
```
### :dart: Serialization and Deserialization using Rest Assured
Make sure you have the Jackson library in your project
```
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationExample {

    public static void main(String[] args) {
        // Create an instance of the class to serialize
        Person person = new Person();
        person.setName("John");
        person.setAge(30);

        // Create an ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Serialize the object to JSON string
            String jsonString = objectMapper.writeWithDefaultPrettyPrinter().writeValueAsString(person);

            // Print the JSON string
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
### :dart: Deserialization Using ObjectMapper
```
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializationExample {

    public static void main(String[] args) {
        // JSON string to deserialize
        String jsonString = "{\"name\":\"John\",\"age\":30}";

        // Create an ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Deserialize the JSON string into a Person object
            Person person = objectMapper.readValue(jsonString, Person.class);

            // Use the deserialized object
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());

            Map<string,object> personmap = objectMapper.readValue(jsonString, Map.class);
            System.out.println("Name: " + person.get("Name"));
            System.out.println("Age: " + person.get("Age"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
### :dart: Serialization and Deserialization Using Apache Juneau
```
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.json.JsonParser;

public class JuneauSerializationAndDeserializationExample {

    public static void main(String[] args) {
        // Create an instance of the class to serialize
        Person person = new Person();
        person.setName("John");
        person.setAge(30);

        // Serialize the object to JSON string
        String jsonString = JsonSerializer.DEFAULT_READABLE.serialize(person);

        // Print the JSON string
        System.out.println("Serialized JSON: " + jsonString);

        // Deserialize the JSON string back to a Person object
        Person deserializedPerson = JsonParser.DEFAULT.parse(jsonString, Person.class);

        // Use the deserialized object
        System.out.println("Deserialized Person: " + deserializedPerson.getName() + ", " + deserializedPerson.getAge());
    }
}
```
