package requestTest;

import requestTest.controller.CurrencyRateInsertionController;
import requestTest.controller.RequestController;
import requestTest.controller.StatementsController;
import requestTest.model.DBConnection;

public class Application {
    public static void main(String[] args) {
        /* MUST BE ZONE */
        CurrencyRateInsertionController currencyRateInsertionController = new CurrencyRateInsertionController();

        RequestController requestController = new RequestController(currencyRateInsertionController.getRequestModel(),
                currencyRateInsertionController.getParser());
        currencyRateInsertionController.setRequestController(requestController);

        DBConnection dbConn = new DBConnection("root", "", "localhost",3306);
        currencyRateInsertionController.setDbConn(dbConn);

        StatementsController statementsController = new StatementsController(
                currencyRateInsertionController.getDbConn(),
                "exchange_rates" );
        currencyRateInsertionController.setStatementsController(statementsController);
        currencyRateInsertionController.setConnection();

        //GET: http://api.fixer.io/latest or date example: 2001-06-22
        currencyRateInsertionController.setRates("2011-06-22");
        /* END OF MUST BE ZONE */

        //currencyRateInsertionController.deleteFromDatabase(Integer.toString(1));
        currencyRateInsertionController.insertToDatabase();
        currencyRateInsertionController.viewFromDatabase();
    }
}
