package railway.testbase;

import Common.Utilities;
import Constant.Constant;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Hashtable;

public class TestBase {
    String curentClassName;

    public static Object[] getData(String key, String dataFilePath) {
        Hashtable<String, Hashtable<String, String>[]> data = new Hashtable<String, Hashtable<String, String>[]>();
        Gson gson = new Gson();
        try {
            FileReader file = new FileReader(dataFilePath);
            Type objectType = new TypeToken<Hashtable<String, Hashtable<String, String>[]>>() {
            }.getType();
            data = gson.fromJson(file, objectType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Hashtable<String, String>[] array = data.get(key);
        return array;
    }

    @Parameters("browser")
    @BeforeClass
    public void beforeclass(@Optional("chrome") String nameBrowser) {
        System.out.println("Pre-condition");
        Utilities.selectBrowser(nameBrowser);
        Utilities.maximizeBrowser();
        curentClassName = getClass().getSimpleName();
    }

    @AfterClass
    public void afterclass() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @DataProvider(name = "getDataObjects")
    public Object[] getDataObjects() {
        String className = getClass().getSimpleName();
        return getData(className, ".\\data_objects\\Data\\data.json");
    }
}
