package railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Generalpage {

    public final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    public final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    public final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    protected final By tabTicketPrice = By.xpath("//div[@id='menu']//a[@href='/Page/TrainPriceListPage.cshtml']");
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By lbWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabContact = By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']");

    public WebElement getElementPage(By element) {
        return Constant.WEBDRIVER.findElement(element);
    }

    //method
    public String getWelcomeMessage() {
        return this.getElementPage(lbWelcomeMessage).getText();
    }

    public LoginPage goToLoginPage() {
        this.getElementPage(tabLogin).click();
        return new LoginPage();
    }

    public HomePage goToMyTicketTab() {
        this.getElementPage(tabMyTicket).click();
        return new HomePage();
    }

    public HomePage goToRegisterTab() {
        this.getElementPage(tabRegister).click();
        return new HomePage();
    }

    public HomePage goToBookTicketTab() {
        this.getElementPage(tabBookTicket).click();
        return new HomePage();
    }

    public HomePage goToContactTab() {
        this.getElementPage(tabContact).click();
        return new HomePage();
    }

    public HomePage goToTicketPriceTab() {
        this.getElementPage(tabTicketPrice).click();
        return new HomePage();
    }

    public boolean isElementDisplayed(By element) {
        try {
            return getElementPage(element).isDisplayed();
        } catch (Exception exp) {
            return false;
        }
    }

    public boolean checkElementExist(By element) {
        return !Constant.WEBDRIVER.findElements(element).isEmpty();
    }

    public String randomEmail() {
        Random rd = new Random();
        String email = "gmail" + rd.nextInt(10000) + "@gmail.com";
        return email;
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) Constant.WEBDRIVER;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
