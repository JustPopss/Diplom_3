import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPageObjectsModel {

    protected static final String MAIN_PAGE = "https://stellarburgers.education-services.ru/";

    // Кнопка "Личный кабинет" на главной странице
    protected static final String PERSONAL_BUTTON = "//p[contains(text(), 'Личный Кабинет')]";

    // Кнопка "Войти" в аккаунт на главной странице
    protected static final String BUTTON_ENTER_MAIN = ".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg";

    // Кнопка "Оформить заказ" на главной странице
    protected static final String BUTTON_CREATE_ORDER = "//button[contains(text(), 'Оформить заказ')]";

    protected final String BUTTON_BULKI = "//div[./span[text()='Булки']]";
    protected final String ACTIVE_LOKATOR_BUNS = "//div[contains(@class, 'tab_tab_type_current__2BEPc') and .//span[text()='Булки']]";

    protected final String BUTTON_SOUSES = "//div[./span[text()='Соусы']]";
    protected final String ACTIVE_LOKATOR_SOUSES = "//div[contains(@class, 'tab_tab_type_current')]/span[text()='Соусы']";

    protected final String BUTTON_NACHINKI = "//div[./span[text()='Начинки']]";
    protected final String ACTIVE_LOKATOR_FILLINGS = "//div[contains(@class, 'tab_tab_type_current')]/span[text()='Начинки']";

    @Step("Check element Bulki is visible")
    public void visibleElementBuns() {
        Selenide.open(MAIN_PAGE);

        if (!$(By.xpath(ACTIVE_LOKATOR_BUNS)).is(visible)) {
            $(By.xpath(BUTTON_BULKI)).shouldBe(enabled).click();
        }

        $(By.xpath(ACTIVE_LOKATOR_BUNS)).shouldBe(visible);
    }

    @Step("Check element Nachinki is visible")
    public void visibleElementFillings() {
        Selenide.open(MAIN_PAGE);

        if (!$(By.xpath(ACTIVE_LOKATOR_FILLINGS)).is(visible)) {
            $(By.xpath(BUTTON_NACHINKI)).shouldBe(enabled).click();
        }

        $(By.xpath(ACTIVE_LOKATOR_FILLINGS)).shouldBe(visible);
    }

    @Step("Check element Souses is visible")
    public void visibleElementSouses() {
        Selenide.open(MAIN_PAGE);

        if (!$(By.xpath(ACTIVE_LOKATOR_SOUSES)).is(visible)) {
            $(By.xpath(BUTTON_SOUSES)).shouldBe(enabled).click();
        }

        $(By.xpath(ACTIVE_LOKATOR_SOUSES)).shouldBe(visible);
    }
}