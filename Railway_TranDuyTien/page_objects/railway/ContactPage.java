package railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends Generalpage {
    //locator
    private final By linkTextEmail = By.linkText("thanh.viet.le@logigear.com");

    public WebElement getLinkTextEmail() {
        return Constant.WEBDRIVER.findElement(linkTextEmail);
    }

}
