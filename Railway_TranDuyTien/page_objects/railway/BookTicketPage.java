package railway;

import Common.Utilities;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import railway.railway_objects.TicketInfo;

import java.util.concurrent.TimeUnit;

public class BookTicketPage extends Generalpage {
    //locator
    private final String btnBookTicket = "//td[text()='%s']//ancestor::tr//a";

    // element
    public String getSelectedItem(String selectName){
        String path = String.format("//select[@name='%s']//option[@selected='selected']",selectName);
        return Constant.WEBDRIVER.findElement(By.xpath(path)).getText();
    }

    public String getSelectedDepartFrom(){
        return getSelectedItem("DepartStation");
    }

    public String getSelectedArriveAt(){
        return getSelectedItem("ArriveStation");
    }

    public String getSelectedSeatType(){
        return getSelectedItem("SeatType");
    }

    public WebElement getCbbDepartDate() {
        return Constant.WEBDRIVER.findElement(By.xpath("//ol//select[@name='Date']"));
    }

    public WebElement getCbbDepartFrom() {
        return Constant.WEBDRIVER.findElement(By.xpath("//ol//select[@name='DepartStation']"));
    }

    public WebElement getCbbArriveAt() {
        return Constant.WEBDRIVER.findElement(By.xpath("//ol//select[@name='ArriveStation']"));
    }

    public WebElement getCbbSeatType() {
        return Constant.WEBDRIVER.findElement(By.xpath("//ol//select[@name='SeatType']"));
    }

    public WebElement getCbbTicketMount() {
        return Constant.WEBDRIVER.findElement(By.xpath("//ol//select[@name='TicketAmount']"));
    }

    public WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(By.xpath("//form//input[@value='Book ticket']"));
    }

    public WebElement getMsgBookticket() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//h1[text()='Ticket booked successfully!']"));
    }

    public WebElement getMsgBookTicketCommon() {
        return Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message error']"));
    }

    public WebElement getMsgBookTicketAmount() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//label[@class='validation-error']"));
    }

    public String getMsgBookTicketMoreThan10() {
        String msg = getMsgBookTicketCommon().getText();
        return msg;
    }

    public String getMsgBookTicketAmountMorethan10() {
        String msg = getMsgBookTicketAmount().getText();
        return msg;
    }

    public void selectDapartDate(String departdate) {
        Utilities.waitControl(getCbbDepartDate(), Constant.MEDIUM_WAIT_TIME);
        Select departDate = new Select(getCbbDepartDate());
        departDate.selectByVisibleText(departdate);
    }

    public void selectDaparFrom(String departfrom) {
        Utilities.waitControlJavaScriptExecutor();
        Select departFrom = new Select(getCbbDepartFrom());
        scrollToElement(getCbbDepartFrom());
        departFrom.selectByVisibleText(departfrom);
    }

    public void selectArriveAt(String arriveat) {
        Utilities.waitControlJavaScriptExecutor();
        Select arriveAt = new Select(getCbbArriveAt());
        scrollToElement(getCbbArriveAt());
        arriveAt.selectByVisibleText(arriveat);
    }

    public void selectSeatType(String seattype) {
        Utilities.waitControl(getCbbSeatType(), Constant.MEDIUM_WAIT_TIME);
        Select seatType = new Select(getCbbSeatType());
        seatType.selectByVisibleText(seattype);
    }

    public void selectAmountTicket(String amountticket) {
        Utilities.waitControl(getCbbTicketMount(), Constant.MEDIUM_WAIT_TIME);
        Select amountTicket = new Select(getCbbTicketMount());
        amountTicket.selectByVisibleText(amountticket);
    }

    public void clickBtnBookTicket() {
        scrollToElement(getBtnBookTicket());
        this.getBtnBookTicket().click();
    }

    public WebElement getBtnBookTicket(String nameSeatType) {
        String selectSeatType = String.format(btnBookTicket, nameSeatType);
        return Constant.WEBDRIVER.findElement(By.xpath(selectSeatType));
    }

    public void clickBookTicketSeat(String nameSeatType) {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(Constant.MEDIUM_WAIT_TIME, TimeUnit.SECONDS);
        JavascriptExecutor executor = (JavascriptExecutor) Constant.WEBDRIVER;
        executor.executeScript("arguments[0].click();", getBtnBookTicket(nameSeatType));
    }

    //method
    public void bookTicket(TicketInfo ticket) {

        selectDapartDate(ticket.getDepartDate());
        selectDaparFrom(ticket.getDepartFrom());
        selectArriveAt(ticket.getArriveAt());
        selectSeatType(ticket.getSeatType());
        selectAmountTicket(ticket.getAmountTicket());
        clickBtnBookTicket();
    }
}
