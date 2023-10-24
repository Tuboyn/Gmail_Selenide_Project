import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class BaseTest {

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