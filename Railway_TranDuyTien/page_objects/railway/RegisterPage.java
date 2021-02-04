package railway;

import Common.Utilities;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class RegisterPage extends Generalpage {

    //element method
    public WebElement getTxtEmailRegister() {
        return Constant.WEBDRIVER.findElement(By.id("email"));
    }

    public WebElement getTxtPasswordRegister() {
        return Constant.WEBDRIVER.findElement(By.id("password"));
    }

    public WebElement getbtnRegister() {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@value='Register']"));
    }

    public WebElement getTxtConfirmPasswordRegister() {
        return Constant.WEBDRIVER.findElement(By.id("confirmPassword"));
    }

    public WebElement getTxtPidRegister() {
        return Constant.WEBDRIVER.findElement(By.id("pid"));
    }

    public WebElement getMsgCommon() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//p[@class='message error']"));
    }

    public WebElement getMsgPassword() {
        return Constant.WEBDRIVER.findElement(By.xpath("//li[@class='password']//label[@class='validation-error']"));
    }

    public WebElement getMsgPid() {
        return Constant.WEBDRIVER.findElement(By.xpath("//li[@class='pid-number']//label[@class='validation-error']"));
    }

    public WebElement getMsgRegister() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//p"));
    }

    //method
    public String msgCommon() {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(Constant.MEDIUM_WAIT_TIME, TimeUnit.SECONDS);
        String common = this.getMsgCommon().getText();
        return common;
    }

    public void enterEmail(String email) {
        Utilities.waitControl(getTxtEmailRegister(), Constant.MEDIUM_WAIT_TIME);
        getTxtEmailRegister().clear();
        this.getTxtEmailRegister().sendKeys(email);
    }

    public void enterPassword(String password) {
        Utilities.waitControl(getTxtPasswordRegister(), Constant.MEDIUM_WAIT_TIME);
        getTxtPasswordRegister().clear();
        this.getTxtPasswordRegister().sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        Utilities.waitControl(getTxtConfirmPasswordRegister(), Constant.MEDIUM_WAIT_TIME);
        getTxtConfirmPasswordRegister().clear();
        this.getTxtConfirmPasswordRegister().sendKeys(confirmPassword);
    }

    public void enterPid(String pid) {
        Utilities.waitControl(getTxtPidRegister(), Constant.MEDIUM_WAIT_TIME);
        getTxtPidRegister().clear();
        this.getTxtPidRegister().sendKeys(pid);
    }

    public void clickBtnRegister() {
        scrollToElement(getbtnRegister());
        getbtnRegister().click();
    }

    public void register(String email, String password, String confirmPassword, String pid) {

        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        enterPid(pid);
        clickBtnRegister();

    }
}


