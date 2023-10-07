package org.example;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class PetBaseTestScenario {
    Response response;

    private static final String BASE_URL = "https://petstore.swagger.io/v2/";
    PetBaseTestStrategy petScenario = new PetBaseTestStrategy(BASE_URL);

    @When("^User adds new pet to the store with custom (.+)$")
    public void addPetToStore(String id) {

        String body = String.format("""
                                {
                                "id": %s,
                                "category": {
                            "id": 0,
                                    "name": "string"
                        },
                        "name": "piesio1",
                                "photoUrls": [
                        "string"
                  ],
                        "tags": [
                        {
                            "id": 0,
                                "name": "string"
                        }
                  ],
                        "status": "available"
                }
                """, id);
        System.out.println(body);
        response = petScenario.addNewPetToStore(body, ContentType.JSON);
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());

    }

    @Then("Check if the response code is 200")
    public void checksResponseCode() {
        Assert.assertEquals(200, response.getStatusCode());
    }


    @When("^User get pet by (.+)$")
    public void userGetPetById(String id) {
        response = petScenario.findPetByID(id);
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());

    }

    @Then("Check if the code of response is 200")
    public void checkIfTheCodeOfResponseIs() {
        Assert.assertEquals(200, response.getStatusCode());
    }

    @And("User checks if the pet's name is equal to declared one")
    public void userChecksIfThePetSNameIsEqualToDeclaredOne() {
        JsonObject jsonObject = JsonParser.parseString(response.getBody().asString()).getAsJsonObject();
        String nameValue = jsonObject.get("name").getAsString();
        System.out.println(nameValue);
        Assert.assertTrue(nameValue.contains("piesio1"));
    }

    @And("^User removes pet from the store with (.+)$")
    public void userRemovesPetFromTheStoreWithId(String id) {
        response = petScenario.deletePetFromStore(id);
    }


}