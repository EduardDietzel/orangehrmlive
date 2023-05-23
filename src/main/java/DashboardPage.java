import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private SelenideElement header = $(byTagName("h6"));

    public void correctHeaderText(){
        header.shouldBe(visible);
        header.shouldHave(text("Dashboard"));
    }


}
