package org.example;
import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class UserBaseTestStrategy extends CommonRequest{
    private String BASE_URL;
    private final String user = "user";
    public UserBaseTestStrategy(String BASE_URL){
        this.BASE_URL = BASE_URL;
        RestAssured.baseURI = BASE_URL;
    }
    public Response loggingIntoAccount (DataTable table){
        List <Map<String, String>> originparams = dataTableToMap(table);
        return sendGetWithMultipleQueryParams(originparams, user + "/" + "login?");
    }

    private List<Map<String, String>> dataTableToMap (DataTable table) {
        List<Map<String, String>> originParams = new ArrayList<>();
        Map<String, String> inputMap = table.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : inputMap.entrySet()) {
            Map<String, String> singleEntryMap = new HashMap<>();
            singleEntryMap.put(entry.getKey(), entry.getValue());
            originParams.add(singleEntryMap);
        }
        return originParams;

}
}
