package railway;

import Common.Utilities;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends Generalpage {

    private final String btnCalcel = "//td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td//input[@value='Cancel']";

    public WebElement getbtnCancle(String departFrom, String arriveAt) {
        String btnCancel = String.format(btnCalcel, departFrom, arriveAt);
        return Constant.WEBDRIVER.findElement(By.xpath(btnCancel));
    }

    public void clickCanCel(String departFrom, String arriceAt) {
        JavascriptExecutor executor = (JavascriptExecutor) Constant.WEBDRIVER;
        executor.executeScript("arguments[0].click();", getbtnCancle(departFrom, arriceAt));
    }

    public WebElement btnCancelNewTicket() {
        return Constant.WEBDRIVER.findElement(By.xpath("//tr[contains(td[8],'New')]//input"));
    }

    public void deleteNewTicket() {
        try {
            Utilities.waitControl(btnCancelNewTicket(), Constant.MEDIUM_WAIT_TIME);
            while (btnCancelNewTicket().isDisplayed()) {
                JavascriptExecutor executor = (JavascriptExecutor) Constant.WEBDRIVER;
                executor.executeScript("arguments[0].click();", btnCancelNewTicket());
                Constant.WEBDRIVER.switchTo().alert().accept();
            }
        } catch (Exception ex) {

        }
    }

    public By checkBtnCancel(String departStation, String arriveStation) {
        Utilities.waitControlJavaScriptExecutor();
        String path = String.format(btnCalcel,
                departStation, arriveStation);
        return By.xpath(path);
    }
}
