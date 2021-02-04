package railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends Generalpage {
    private final String btnCheckPrice = "//li[text()='%s to %s']//ancestor::tr//a";

    //element method
    public WebElement getTicketPrice(String departFrom, String arriveAt) {
        String checkPrice = String.format(btnCheckPrice, departFrom, arriveAt);
        return Constant.WEBDRIVER.findElement(By.xpath(checkPrice));
    }

    //method
    public TicketPricePage clickCheckPrice(String departFrom, String arriveAt) {
        this.getTicketPrice(departFrom, arriveAt).click();
        return new TicketPricePage();
    }

}
