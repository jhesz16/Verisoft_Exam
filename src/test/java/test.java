import Enum.columnText;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static Driver.Setup.killDriver;

public class test extends base {


    @Test(dataProvider = "htmlTableGetData")
    public void TC1(String searchColumn, String searchText, String returnColumnText, String expectedText) throws Exception {
        Assert.assertTrue(htmlTables.verifyTableCellText(htmlTables.getTable(), columnText.valueOf(searchColumn).col, searchText,
                columnText.valueOf(returnColumnText).col, expectedText));
    }

    @AfterMethod
    public void after() {
        killDriver();
    }
}
