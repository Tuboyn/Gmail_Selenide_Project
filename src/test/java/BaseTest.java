import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.aeonbits.owner.ConfigFactory;
import utils.MyConfig;

public class BaseTest {
    protected MyConfig config = ConfigFactory.create(MyConfig.class);

    protected void start(String url) {
        Configuration.browser = "safari";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        Selenide.open(url);
    }

    protected void stop() {
        Selenide.closeWebDriver();
    }
}