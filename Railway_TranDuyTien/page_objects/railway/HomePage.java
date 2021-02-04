package railway;

import Constant.Constant;

public class HomePage extends Generalpage {

    //methods
    public HomePage open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
}
