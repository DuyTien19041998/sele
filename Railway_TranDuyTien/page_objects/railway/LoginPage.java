package railway;

import Common.Utilities;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import railway.railway_objects.AccountInfo;


public class LoginPage extends Generalpage {

    //element method
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(By.id("username"));
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(By.id("password"));
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@value='Login']"));
    }

    public WebElement getLbLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message error LoginForm']"));
    }

    public WebElement getTextLinkChangePassword() {
        return Constant.WEBDRIVER.findElement(By.linkText("Forgot Password page"));
    }

    //reset password
    public WebElement getTxtEmailReset() {
        return Constant.WEBDRIVER.findElement(By.id("email"));
    }

    public WebElement getBtnSendInstructions() {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@value='Send Instructions']"));
    }

    public WebElement getMsgResetEmail() {
        return Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message error']"));
    }

    public void enterUserName(String username) {
        Utilities.waitControl(getTxtUsername(), Constant.MEDIUM_WAIT_TIME);
        getTxtUsername().clear();
        this.getTxtUsername().sendKeys(username);
    }

    public void enterPassWord(String password) {
        Utilities.waitControl(getTxtPassword(), Constant.MEDIUM_WAIT_TIME);
        getTxtPassword().clear();
        this.getTxtPassword().sendKeys(password);
    }

    public void clickBtnLogin() {
        scrollToElement(getBtnLogin());
        getBtnLogin().click();
    }

    //method
    public void login(AccountInfo accountInfo) {

        enterUserName(accountInfo.getUsername());
        enterPassWord(accountInfo.getPassword());
        clickBtnLogin();
    }
}
