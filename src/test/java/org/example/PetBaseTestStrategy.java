package org.example;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
enum Status{
    available,
    pending,
    sold
}
public class PetBaseTestStrategy extends CommonRequest{
    private String BASE_URL;
    private final String pet = "pet";
    public PetBaseTestStrategy(String BASE_URL){
        this.BASE_URL = BASE_URL;
        RestAssured.baseURI = BASE_URL;
    }

    public Response addNewPetToStore(String requestBody, ContentType contentType){
        return sendPostAndReturnResponse(requestBody, contentType, pet);
    }


    /*public Response addNewPetToStore(String requestbody){
        RequestSpecification request = RestAssured.given().body(requestbody).contentType("application/json");
        Response response = request.post(pet);
        return response;
    }*/

    public Response findPetByID(String id) {
        return sendGetAndReturnResponse(pet + "/" + id);
    }

    /*public Response findPetByID(String id){
        RequestSpecification request = RestAssured.given();
        Response response = request.get("pet/" + id);
        return response;
    }*/

    public Response findByStatus(Status status){
        return sendGetAndReturnResponse(pet + "/findByStatus?status=" + status);
    }

    /*public Response findByStatus(Status status){
        RequestSpecification request = RestAssured.given();
        Response response = request.get("pet/findByStatus?status=" + status);
        return response;
    }*/

    public Response deletePetFromStore(String id){
        return sendDeleteAndReturnResponse(pet + "/" + id);
    }
}
