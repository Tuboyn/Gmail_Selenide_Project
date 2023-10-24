import annotations.PropertyValue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GmailPage;
import utils.PropertyLoader;

public class GmailTest extends BaseTest {

    @PropertyValue("email")
    private String email;

    @PropertyValue("password")
    private String password;

    @PropertyValue("wrongEmail")
    private String wrongEmail;

    public GmailTest() {
        PropertyLoader.loadProperties(this);
    }

    @BeforeMethod
    public void setUp() {
        start("http://gmail.com");
    }

    @Test()
    public void testSuccessesSend() {
        new GmailPage()
                .login(email, password)
                .sendMessage("Hello world!", "Demo message", email)
                .checkSuccessSend();
    }

    @Test()
    public void testUnsuccessfullySend() {
        new GmailPage()
                .login(email, password)
                .sendMessage("Hello world!", "Demo message", wrongEmail)
                .checkUnsuccessfullySend();
    }

    @AfterMethod
    public void close() {
        stop();
    }
}