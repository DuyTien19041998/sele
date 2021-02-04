package railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePassword {

    //element method
    public WebElement getTxtCurrentPassword() {
        return Constant.WEBDRIVER.findElement(By.id("currentPassword"));
    }

    public WebElement getTxtNewPassword() {
        return Constant.WEBDRIVER.findElement(By.id("newPassword"));
    }

    public WebElement getConfirmPassword() {
        return Constant.WEBDRIVER.findElement(By.xpath("confirmPassword"));
    }

    public WebElement getBtnPassword() {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@value='Change Password']"));
    }

    //method
    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {

        this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getConfirmPassword().sendKeys(confirmPassword);
        this.getBtnPassword().click();

    }
}
