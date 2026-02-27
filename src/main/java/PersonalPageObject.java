import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class PersonalPageObject {

    // Кнопка "Выход" в личном кабинете
    protected static final String EXIT_BUTTON = "Account_button__14Yp3";

    @Step("Logout user")
    public static void logout() {
        $(By.xpath(MainPageObjectsModel.PERSONAL_BUTTON)).click();
        $(byClassName(EXIT_BUTTON)).click();
        $(byCssSelector(LoginPageObjectsModel.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).shouldBe(visible);
    }
}
