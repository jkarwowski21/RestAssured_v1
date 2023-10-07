package org.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test {
    private static final String BASE_URL = "https://petstore.swagger.io/v2/";

    public static void main(String[] args) {

        PetBaseTestStrategy petStrategy = new PetBaseTestStrategy(BASE_URL);
        String body = """
                {
                "id": 0,
                "category": {
            "id": 0,
                    "name": "string"
        },
        "name": "doggie",
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
""";

        Response response = petStrategy.addNewPetToStore(body, ContentType.JSON);
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());


        response = petStrategy.findByStatus(Status.sold);
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());

        response = petStrategy.findByStatus(Status.pending);
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());

        response = petStrategy.findPetByID("9223372036854775807");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());


    }

}
