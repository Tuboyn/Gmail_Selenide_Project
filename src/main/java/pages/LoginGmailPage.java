package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginGmailPage {
    private final SelenideElement emailInout = $x("//input[@type='email']");
    private final SelenideElement passwordInput = $x("//input[@type='password']");
    private final SelenideElement nextButton = $x("//span[text()='Далее']/..");

    public void login(String email, String password) {
        emailInout.setValue(email);
        nextButton.click();
        passwordInput.setValue(password);
        nextButton.click();
    }
}