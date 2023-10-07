package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class CommonRequest {
    public Response sendGetAndReturnResponse(String url) {
        RequestSpecification request = RestAssured.given();
        Response response = request.get(url);
        return response;
    }

    public Response sendPostAndReturnResponse(String requestBody, ContentType contentType, String url) {
        RequestSpecification request = RestAssured.given().body(requestBody).contentType(contentType);
        Response response = request.post(url);
        return response;
    }

    public Response sendDeleteAndReturnResponse(String url) {
        RequestSpecification request = RestAssured.given();
        Response response = request.delete(url);
        return response;
    }

    public Response sendGetWithMultipleQueryParams(List<Map<String, String>> originparams, String url) {
        RequestSpecification request = RestAssured.given();
        Response response=null;
        //originparams = new ArrayList<>();
        for (Map<String, String> QueryParams : originparams) {
            response = request.queryParams(QueryParams)
                    .when()
                    .get(url);

        }
        return response;
    }
    public Response sendPutAndReturnResponse(String url) {
        RequestSpecification request = RestAssured.given();
        Response response = request.delete(url);
        return response;
    }
}