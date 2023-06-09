import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement usernameField = $(byCssSelector("[name='username']"));

    private SelenideElement passwordField = $(byAttribute("placeholder", "Password"));

    private SelenideElement loginButton = $x("//button[@type='submit']");

    private SelenideElement errorMessage = $x("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");

    // заводим две переменные для текста ошибки, который возникает под пустыми полями при авторизации
    private SelenideElement requiredMessageLogin = $x("//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]");

    private SelenideElement requiredMessagePassword = $x("//div[@class='orangehrm-login-form']//div[2]//div[1]//span[1]");

    private SelenideElement forgotPasswordLink = $(byClassName("orangehrm-login-forgot"));

    private SelenideElement logoOnLoginPage = $(byAttribute("alt", "company-branding"));

    private SelenideElement credentionals = $(byClassName("orangehrm-demo-credentials"));

    // пишем методы для заполнения полей авторизации
    public void enterUsername(String usernameValue){
        usernameField.shouldBe(visible);
        usernameField.setValue(usernameValue);
    }
    public void enterPassword(String passwordValue){
        // passwordField.shouldBe(visible);
        passwordField.setValue(passwordValue);
    }
    public void clickLoginButton(){
        loginButton.click();
    }

    public void errorMessageText(){
        errorMessage.shouldBe(visible);
        errorMessage.shouldHave(text("Invalid credentials"));
    }

//    public void invalidCredText(String expectedText){
//        errorMessage.shouldHave(text(expectedText));
//    }

    public void checkRequiredMessageLogin(){
        requiredMessageLogin.shouldBe(text("Required"));
    }
    public void checkRequiredMessagePassword(){
        requiredMessagePassword.shouldBe(text("Required"));
    }

    public void followTheForgotPasswordLink(){
        forgotPasswordLink.shouldBe(visible);
        forgotPasswordLink.click();
    }

    public void checkCompanyLogoIsDisplayed(){
        logoOnLoginPage.shouldBe(visible);
    }

    public void logoImageIsCorrect(){

        logoOnLoginPage.shouldHave(attributeMatching("src",
                ".*branding.png.*"));
    }

    public void checkCredentionalsIsDisplayed(){
        credentionals.shouldBe(visible);
    }

}
