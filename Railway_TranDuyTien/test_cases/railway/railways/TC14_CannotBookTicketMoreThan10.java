package railway.railways;

import org.testng.Assert;
import org.testng.annotations.Test;
import railway.*;
import railway.railway_objects.AccountInfo;
import railway.railway_objects.TicketInfo;
import railway.testbase.TestBase;
import java.util.Hashtable;

public class TC14_CannotBookTicketMoreThan10 extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    RegisterPage registerPage = new RegisterPage();
    TicketInfo ticketInfo;
    AccountInfo accountInfo;

    @Test(dataProvider = "getDataObjects")
    public void TC14(Hashtable<String, String> data) {
        System.out.println("TC14 - User can't book more than 10 tickets");
        System.out.println("1. Navigate to railway website");
        homePage.open();

        System.out.println("2. Click register tab");
        registerPage.goToRegisterTab();

        System.out.println("3. Enter info valid to all fields on form register");
        registerPage.register(data.get("email"), data.get("password"), data.get("confirmPassword"), data.get("pid"));

        System.out.println("4. Click login tab");
        loginPage.goToLoginPage();

        System.out.println("5. Login with username and password created account ");
        accountInfo = new AccountInfo(data.get("email"), data.get("password"));
        loginPage.login(accountInfo);

        System.out.println("6. CLick bookticket tab");
        homePage.goToBookTicketTab();

        System.out.println("7. Select information into all fields on form");
        ticketInfo = new TicketInfo(data.get("departDate"), data.get("departFrom"), data.get("arriveAt"), data.get("seatType"), data.get("ticketAmount10"));
        bookTicketPage.bookTicket(ticketInfo);

        System.out.println("8. Click bookticket tab");
        homePage.goToBookTicketTab();

        ticketInfo.setAmountTicket(data.get("ticketAmount1"));
        bookTicketPage.bookTicket(ticketInfo);

        System.out.println("9. Check message bookticket");
        String actualMsg = bookTicketPage.getMsgBookTicketMoreThan10();
        String expectedMsg = data.get("expectedMsgBook10Ticket");
        Assert.assertEquals(actualMsg, expectedMsg);

        System.out.println("10. Check message ticket amount");
        String actualMsgBook1Ticket = bookTicketPage.getMsgBookTicketAmountMorethan10();
        String expectedMsgBook1Ticket = data.get("expectedMsgBookMore10Ticket");
        Assert.assertEquals(actualMsgBook1Ticket, expectedMsgBook1Ticket);

        System.out.println("11. Go to myticket tab");
        homePage.goToMyTicketTab();

        System.out.println("12. Delete ticket");
        myTicketPage.deleteNewTicket();

    }
}
