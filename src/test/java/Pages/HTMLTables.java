package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HTMLTables {

    @FindBy(xpath = "//table[@id='customers']/tbody")
    public WebElement table;

    public WebElement getTable() {
        return table;
    }

    public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText) throws Exception {
        return table.findElement(By.xpath("tr[td[contains(text(),'" + searchText + "')]]/td[" + returnColumnText + "]")).getText();
    }


    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) throws Exception {
        String result = getTableCellTextByXpath(table, searchColumn, searchText, returnColumnText);

        return result.equals(expectedText);
    }
}
