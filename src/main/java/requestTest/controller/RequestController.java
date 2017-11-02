package requestTest.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONObject;
import requestTest.model.JsonObjParser;
import requestTest.model.RequestModel;

import java.io.IOException;
import java.util.HashMap;

public class RequestController {
    private RequestModel requestModel;
    private JsonObjParser parser;
    private HashMap<String, String> map;

    public RequestController(RequestModel requestModel, JsonObjParser parser){
        this.requestModel = requestModel;
        this.parser = parser;
    }

    public HashMap<String, String> getRequest(String url) {
        HttpResponse<JsonNode> request = requestModel.request(url);
        JSONObject jsonObject = parser.getRatesFromRequest(request);

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {
        };

        try {
            this.map = mapper.readValue(jsonObject.toString(), typeRef);
            map.put("date", parser.getDateFromRequest(request));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.map;
    }
}
