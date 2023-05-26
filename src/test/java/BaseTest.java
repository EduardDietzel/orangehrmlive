import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setUp(){
        // делаем добавление скриншота проблем для Селенида в отчет Аллюра
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open(BASE_URL);
    }

    @After
    public void tearDown(){
        closeWebDriver();
    }

    // при создании любой новой страницы лучше сразу заводить для неё здесь новую переменную
    LoginPage loginPage = new LoginPage();

    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

    DashboardPage dashboardPage = new DashboardPage();
}
