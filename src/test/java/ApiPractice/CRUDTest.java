package ApiPractice;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;

public class CRUDTest {

    private static final Faker FAKER = new Faker();
    private static final String APIHOST = "https://gorest.co.in/public";
    private static final String APIV = "/v2";
    private static final String AUTH = "N/A";

    @Test
    public void getUsersTest() {
        // Setting up baseURL by adding host to version of api
        RestAssured.baseURI = APIHOST + APIV;

        // Response interface is where we store our response results
        // * status code, * body, * headers
        Response responseListUsers = RestAssured

                //Arrange our tests
                .given()
                // we provide data type for body we send in contentType
                .contentType(ContentType.JSON)
                // setup headers, auth keys in headers
                .headers("Authorization","Bearer " + AUTH)
                // we provide data type for body we want to receive in accept
                .accept(ContentType.JSON)
                // act of tests
                .when()
                // send request with get method to endpoint /users
                // baseURL gets attached at the beginning of /
                .get("/users");

        Assertions.assertAll(
                () -> Assertions.assertEquals( 200, responseListUsers.getStatusCode(),"Status codes are not the same"),
                () -> Assertions.assertTrue(responseListUsers.getBody().asString().contains("id"),"id key is not present in the response body"),
                () -> Assertions.assertTrue(responseListUsers.getBody().asString().contains("name"),"name key is not present in the response body"),
                () -> Assertions.assertTrue(responseListUsers.getBody().asString().contains("email"),"email key is not present in the response body"),
                () -> Assertions.assertTrue(responseListUsers.getBody().asString().contains("status"),"status key is not present in the response body"),
                () -> Assertions.assertTrue(responseListUsers.getBody().asString().contains("gender"),"gender key is not present in the response body")
        );
    }

    @Test
    public void createUserTest(){
        // Setting up baseURL by adding host to version of api
        RestAssured.baseURI = APIHOST + APIV;

        // Preparing request body
        String name = FAKER.name().fullName();
        String email = FAKER.internet().emailAddress();
        String body = "{\n" +
                "   \"name\": \"" + name + "\",\n" +
                "   \"email\": \""+ email + "\",\n" +
                "   \"gender\": \"male\",\n" +
                "   \"status\": \"inactive\"\n" +
                "}";

        // Save response to variable
        // We will need status code of response
        // We will need body of response
        Response responseCreateUser = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization","Bearer " + AUTH)
                .accept(ContentType.JSON)
                // We provide the request body to the .body()
                // .body() accepts String and converts it to JSON
                .body(body)
                // Act part
                .when()
                // Use post method to create new use in /users endpoint
                .post("/users");

        // Assumptions find issues with your implementation/steps
        // Assertions find issues with the application
        Assumptions.assumeTrue(responseCreateUser.getStatusCode() == 201, "Create user did not return 201 status code" );

        // Save get response in variable
        // We need it to make sure 100% that our use has been created and saved to the database
        // We need status code
        // We need body of response
        Response responseGetUserById = RestAssured
                // Arrange
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization","Bearer " + AUTH)
                .accept(ContentType.JSON)
                // Act
                .when()
                // responseCreateUser.jsonPath().getString("id") -> gets id from POST response
                .pathParam("userId", responseCreateUser.jsonPath().getString("id"))
                // get user by id, userID is pathrparam where we dynamically provide id of newly created user
                .get("/users/{userId}");

        Assertions.assertAll(
                ()-> Assertions.assertEquals(201, responseCreateUser.getStatusCode(), "Status codes are not the same"),
                ()-> Assertions.assertEquals(name, responseCreateUser.jsonPath().getString("name"), "Names are not the same"),
                ()-> Assertions.assertEquals(email, responseCreateUser.jsonPath().getString("email"), "Emails are not the same"),
                ()-> Assertions.assertEquals(200, responseGetUserById.getStatusCode(), "Status codes are not the same"),
                ()-> Assertions.assertEquals(name, responseGetUserById.jsonPath().getString("name"), "Names are not the same"),
                ()-> Assertions.assertEquals(email, responseGetUserById.jsonPath().getString("email"), "Emails are not the same"),
                () -> Assertions.assertTrue(responseGetUserById.getBody().asString().contains("id"), "id key is not present in the response body"),
                () -> Assertions.assertTrue(responseGetUserById.getBody().asString().contains("name"), "name key is not present in the response body"),
                () -> Assertions.assertTrue(responseGetUserById.getBody().asString().contains("email"), "email key is not present in the response body"),
                () -> Assertions.assertTrue(responseGetUserById.getBody().asString().contains("status"), "status key is not present in the response body"),
                () -> Assertions.assertTrue(responseGetUserById.getBody().asString().contains("gender"), "gender key is not present in the response body")
        );
    }

    // How to test delete user and make it independent
    // create user, validate he exists
    // get user validate he exist
    // delete user
    // get user, validate he does not exist
    // in the hooks, you have before and after
    // before test you can create user
    // hook clean data after you delete user and the history

    @Test
    public void deleteUserTest() {
        // Setting up baseURL by adding host to version of api
        RestAssured.baseURI = APIHOST + APIV;

        // Preparing request body
        String name = FAKER.name().fullName();
        String email = FAKER.internet().emailAddress();
        String body = "{\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"email\": \"" + email + "\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"inactive\"\n" +
                "}";

        // Save post response to variable
        // We will need status code of response
        // We will need body of response
        Response responseCreateUser = RestAssured
                // Arrange part
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + AUTH)
                .accept(ContentType.JSON)
                // We provide the request body to the .body()
                // .body() accepts String and converts it to JSON
                .body(body)
                // Act part
                .when()
                // Use post method to create new user in /users ep
                .post("/users");

        String userId = responseCreateUser.jsonPath().getString("id");

        // Assumptions to find issues with your implementation
        // Assertions to find issues with the application under test
        Assumptions.assumeTrue(responseCreateUser.getStatusCode() == 201, "Create user didn't return 201 status code");

        // Save get response in variable
        // We need it to make sure 100% that our user has been created and saved to DB
        // We need status code
        // We need body of response
        Response responseGetUserById = RestAssured
                // Arrange
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + AUTH)
                .accept(ContentType.JSON)
                // Act
                .when()
                // responseCreateUser.jsonPath().getString("id") -> get id from post response
                .pathParam("userId", userId)
                // get user by id, userId is pathparam where we dynamically provide id of newly created user
                .get("/users/{userId}");

        Assumptions.assumeTrue(responseGetUserById.getStatusCode() == 200, "Get user didn't return 200 status code");

        // Save delete response in variable
        Response responseDeleteUser = RestAssured
                // Arrange
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + AUTH)
                .accept(ContentType.JSON)
                // Act
                .when()
                // Provide id of user you want to delete
                .pathParam("userId", userId)
                // Delete method is used
                .delete("/users/{userId}");

        Assumptions.assumeTrue(responseDeleteUser.getStatusCode() == 204, "Delete user didn't return 204 status code");

        // Save get response after delete
        Response responseGetUserByIdAfterDelete = RestAssured
                // Arrange
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + AUTH)
                .accept(ContentType.JSON)
                // Act
                .when()
                // responseCreateUser.jsonPath().getString("id") -> get id from post response
                .pathParam("userId", userId)
                // get user by id, userId is pathparam where we dynamically provide id of newly created user
                .get("/users/{userId}");

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(204, responseDeleteUser.getStatusCode(), "Status codes are not the same"),
                () -> Assertions.assertEquals(404, responseGetUserByIdAfterDelete.getStatusCode(), "Status codes are not the same"),
                () -> Assertions.assertEquals("Resource not found", responseGetUserByIdAfterDelete.jsonPath().getString("message"), "Message key is not present in the response with status code 404")
        );
    }
}
