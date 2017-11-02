package requestTest.controller;

import requestTest.model.DBConnection;
import requestTest.model.JsonObjParser;
import requestTest.model.RequestModel;

import java.util.HashMap;

public class CurrencyRateInsertionController {
    private RequestModel requestModel;
    private JsonObjParser parser;
    private RequestController requestController;
    private StatementsController statementsController;
    private HashMap<String, String> rates;
    private DBConnection dbConn;

    public CurrencyRateInsertionController(){
        this.requestModel = new RequestModel();
        this.parser = new JsonObjParser();
    }

    /*Setters*/
    public void setRequestModel(RequestModel requestModel) {
        this.requestModel = requestModel;
    }

    public void setParser(JsonObjParser parser) {
        this.parser = parser;
    }

    public void setRequestController(RequestController requestController) {
        this.requestController = requestController;
    }

    public void setStatementsController(StatementsController statementsController) {
        this.statementsController = statementsController;
    }

    public void setRates(String date) {
        String url = "http://api.fixer.io/" + date;
        this.rates = requestController.getRequest(url);
    }

    public void setDbConn(DBConnection dbConn) {
        this.dbConn = dbConn;
    }

    /*Getters*/
    public RequestModel getRequestModel() {
        return requestModel;
    }

    public JsonObjParser getParser() {
        return parser;
    }

    public RequestController getRequestController() {
        return requestController;
    }

    public StatementsController getStatementsController() {
        return statementsController;
    }

    public HashMap<String, String> getRates() {
        return rates;
    }

    public DBConnection getDbConn() {
        return dbConn;
    }

    /*Others*/
    public void setConnection(){
        this.getStatementsController().setConnection();
    }

    public void insertToDatabase(){
        this.getStatementsController().insertRecord(this.getRates().get("date"),
                Double.parseDouble(this.getRates().get("PLN")),
                Double.parseDouble(this.getRates().get("USD")),
                Double.parseDouble(this.getRates().get("GBP")),
                Double.parseDouble(this.getRates().get("JPY")));
    }

    public void viewFromDatabase(){
        this.getStatementsController().viewTable();
    }

    public void deleteFromDatabase(String condition){
        this.getStatementsController().deleteRecord(condition);
    }
}
