package railway.railways;

import org.testng.Assert;
import org.testng.annotations.Test;
import railway.BookTicketPage;
import railway.HomePage;
import railway.LoginPage;
import railway.TicketPricePage;
import railway.railway_objects.AccountInfo;
import railway.testbase.TestBase;
import java.util.Hashtable;

public class TC15_BookTicket extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    AccountInfo accountInfo;

    @Test(dataProvider = "getDataObjects")
    public void TC15(Hashtable<String, String> data) {

        System.out.println("TC15 - User can open book ticket page by click on book ticket link in ticket price");
        System.out.println("1. Navigate to railway website");
        homePage.open();

        System.out.println("2. Click login tab");
        loginPage.goToLoginPage();

        System.out.println("3. Login with username and password created account ");
        accountInfo = new AccountInfo(data.get("username"),data.get("password"));
        loginPage.login(accountInfo);

        System.out.println("4. CLick ticket price tab");
        homePage.goToTicketPriceTab();

        System.out.println("5. Click on any ticket from list");
        ticketPricePage.clickCheckPrice(data.get("departFrom"), data.get("arriveAt"));
        bookTicketPage.clickBookTicketSeat(data.get("nameSeatType"));

        System.out.println("5. Check selected bookticket");
        Assert.assertEquals(bookTicketPage.getSelectedDepartFrom(),data.get("departFrom"));
        Assert.assertEquals(bookTicketPage.getSelectedArriveAt(),data.get("arriveAt"));
        Assert.assertEquals(bookTicketPage.getSelectedSeatType(),data.get("nameSeatType"));
    }
}