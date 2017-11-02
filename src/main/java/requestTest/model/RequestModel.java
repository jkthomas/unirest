package requestTest.model;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RequestModel implements ModelAPI {
    public HttpResponse<JsonNode> request(String url) {
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest.get(url).asJson();
            return jsonResponse;
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }










    /*public HttpResponse<JsonNode> postResponse() {
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest.post(url)
                    .header("accept", "application/json")
                    .body("{\"parameter\":\"value\", \"foo\":\"bar\"}")
                    .asJson();
            return jsonResponse;
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }*/
}

