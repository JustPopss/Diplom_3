import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPageObjectsModel {

    // Поля имя, почты и пароля
    protected static final String EMAIL_FIELD = "//label[text()='Email']/following-sibling::input";
    protected static final String PASSWORD_FIELD = ".text.input__textfield.text_type_main-default[name=\"Пароль\"]";
    protected final String NAME_FIELD = "//label[text()='Имя']/following-sibling::input";

    // Кнопка "Войти" на странице регистрации
    protected static final String BUTTON_ENTER_ON_REG_PAGE = "Auth_link__1fOlj";

    // Кнопка "Зарегистрироваться на странице регистрации"
    protected final String REGISTRATION_BUTTON_ON_REGISTER_PAGE = "//button[contains(text(), 'Зарегистрироваться')]";

    @Step("Registration test")
    public void registration() {
        open(MainPageObjectsModel.MAIN_PAGE);
        $(byCssSelector(MainPageObjectsModel.BUTTON_ENTER_MAIN)).shouldHave(text("Войти в аккаунт")).click();
        $(By.xpath(LoginPageObjectsModel.REGISTRATION_BUTTON_ON_ENTER_PAGE)).click();

        $(By.xpath(NAME_FIELD)).setValue(UserModel.NAME);
        $(By.xpath(EMAIL_FIELD)).setValue(UserModel.EMAIL);
        $(By.cssSelector(PASSWORD_FIELD)).setValue(UserModel.PASSWORD);
        $(By.xpath(REGISTRATION_BUTTON_ON_REGISTER_PAGE)).click();

        $(By.xpath(EMAIL_FIELD)).shouldBe(visible).setValue(UserModel.EMAIL);
        $(byCssSelector(PASSWORD_FIELD)).setValue(UserModel.PASSWORD);
        $(byCssSelector(LoginPageObjectsModel.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        $(By.xpath(MainPageObjectsModel.BUTTON_CREATE_ORDER)).should(visible);

        PersonalPageObject.logout();
    }
}
