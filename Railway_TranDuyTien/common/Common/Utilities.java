package Common;

import Constant.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

    public static void waitControl(WebElement control, int timeWait) {
        WebDriverWait webDriverWait = new WebDriverWait(Constant.WEBDRIVER, timeWait);
        webDriverWait.until(ExpectedConditions.visibilityOf(control));
    }

    public static void waitControlCommon(WebElement control){
        WebDriverWait webDriverWait = new WebDriverWait(Constant.WEBDRIVER,Constant.MEDIUM_WAIT_TIME);
        webDriverWait.until(ExpectedConditions.visibilityOf(control));
    }

    public static void selectBrowser(String browserName) {
        switch (browserName) {
            case "chrome":
                String path = System.getProperty("user.dir") + "\\executables\\chromeDriver.exe";
                System.setProperty("webdriver.chrome.driver", path);
                Constant.WEBDRIVER = new ChromeDriver();
                break;
            case "fireFox":
                path = System.getProperty("user.dir") + "\\executables\\geckodriver.exe";
                System.setProperty("webdriver.gecko.driver", path);
                Constant.WEBDRIVER = new FirefoxDriver();
                break;
        }
    }

    public static void maximizeBrowser() {
        Constant.WEBDRIVER.manage().window().maximize();
    }

    public static void waitControlJavaScriptExecutor(){
        JavascriptExecutor js = (JavascriptExecutor)Constant.WEBDRIVER;
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1500);");
    }

}
