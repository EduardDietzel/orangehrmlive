import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LoginTest extends BaseTest{

//    @Test
//    public void successLogin() {
//        // импортируем метод open только из Selenide.open
//        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        // импортируем метод sleep только из Selenide
//        // sleep(3000);
//        // варианты написания запроса:
//        // $(byName("username")).setValue("Admin");
//        $(byCssSelector("[name='username']")).setValue("Admin");
//        // setValue вводит данные в поле, найденное по селектору
//        $(byAttribute("placeholder", "Password")).setValue("admin123");
//        // $x("//button[@type=\"submit\"]").click();
//        $(byXpath("//button[@type=\"submit\"]")).click();
//        $(byTagName("h6")).shouldHave(text("Dashboard"));

//        // а давайте ка теперь используем Пейдж Обжект...//
//    }

    @Test
    public void successLogin() {
        // LoginPage loginPage = new LoginPage();
        // вынесли эту переменную в BaseTest
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        // $(byTagName("h6")).shouldHave(text("Dashboard"));
        // DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.correctHeaderText();
    }

    // проверим реакцию при вводе некорректного пароля
    @Test
    public void invalidPassword(){
        // check error message text "Invalid credentials"
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin12");
        loginPage.clickLoginButton();
        loginPage.errorMessageText();
        // loginPage.invalidCredText("Invalid credentials");
    }

    @Test
    public void emptyInputFields(){
        // check error messages with empty Input fields "Required"
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        loginPage.checkRequiredMessageLogin();
        loginPage.checkRequiredMessagePassword();
    }

    @Test
    public void emptyInputUsernameFields(){
        // check error messages with empty Input fields "Required"
        loginPage.enterPassword("admin12");
        loginPage.clickLoginButton();
        loginPage.checkRequiredMessageLogin();
    }

    // надо написать еще один тест с пустым одним из двух полей
    @Test
    public void emptyInputPasswordFields(){
        loginPage.enterUsername("Admin");
        loginPage.clickLoginButton();
        loginPage.checkRequiredMessagePassword();
    }

    @Test
    public void forgotYorPassword(){
        loginPage.followTheForgotPasswordLink();
        // check that we on Reset Password page
        // ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        resetPasswordPage.checkResetPasswordTitle();
        resetPasswordPage.urlIsCorrect();
    }

    @Test
    public void elementsAreVisible(){
        // logo is displayed
        // credentionals section is displayed
        loginPage.checkCompanyLogoIsDisplayed();
        loginPage.checkCredentionalsIsDisplayed();
        loginPage.logoImageIsCorrect();
    }
}
