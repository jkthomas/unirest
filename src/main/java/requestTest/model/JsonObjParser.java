package requestTest.model;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONObject;


public class JsonObjParser implements ModelAPI{
    public JSONObject getRatesFromRequest(HttpResponse<JsonNode> request){
        JSONObject parsedJson = request.getBody().getObject();
        return parsedJson.getJSONObject("rates");
    }

    public String getDateFromRequest(HttpResponse<JsonNode> request){
        JSONObject parsedDate = request.getBody().getObject();
        return parsedDate.getString("date");
    }
}
