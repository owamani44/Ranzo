import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AnimalRegistryIntegrationTests {
    @BeforeAll
    static void setup() {
        // Set up any necessary configurations or test data here
        RestAssured.baseURI = "http://localhost:8085";
    }

    @Test
    public void  shouldReturnOkWithValidToken(){
        String loginPayload= """
            {
                      "username": "ekabendera",
                      "password": "Password1234"
             }
          """;
       String token = given()
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post("auth/login")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("token");

      given()
               .header("Authorization", "Bearer " + token)
               .when()
               .get("/api/animals")
               .then()
               .statusCode(200)
               .body("animals", notNullValue());
    }
}
