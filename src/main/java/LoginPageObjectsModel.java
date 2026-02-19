import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPageObjectsModel {

    // Кнопка "Войти" на странице логина
    protected static final String BUTTON_ENTER_AFTER_PW_AND_EMAIL = ".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa";

    //Текст всплывающей ошибки на странице логина
    protected final String WRONG_PASSWORD_TEXT = ".input__error.text_type_main-default";

    // Кнопка "Зарегистрироваться на странице логина"
    protected static final String REGISTRATION_BUTTON_ON_ENTER_PAGE = "//a[contains(text(), 'Зарегистрироваться')]";

    // Кнопка Восстановить пароль на странице логина
    protected final String BUTTON_RESET_PASSWORD = "//a[contains(text(), 'Восстановить пароль')]";

    @Step("Login on registration page")
    public void loginRegistrationPage() {
        open(MainPageObjectsModel.MAIN_PAGE);
        $(byCssSelector(MainPageObjectsModel.BUTTON_ENTER_MAIN)).shouldHave(text("Войти в аккаунт")).click();
        $(By.xpath(REGISTRATION_BUTTON_ON_ENTER_PAGE)).click();
        $(byClassName(RegistrationPageObjectsModel.BUTTON_ENTER_ON_REG_PAGE)).click();

        $(By.xpath(RegistrationPageObjectsModel.EMAIL_FIELD)).setValue(UserModel.EMAIL);
        $(byCssSelector(RegistrationPageObjectsModel.PASSWORD_FIELD)).setValue(UserModel.PASSWORD);
        $(byCssSelector(BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        $(By.xpath(MainPageObjectsModel.BUTTON_CREATE_ORDER)).should(visible);
    }

    @Step("Login on reset password page")
    public void loginResetPasswordPage() {
        open(MainPageObjectsModel.MAIN_PAGE);
        $(byCssSelector(MainPageObjectsModel.BUTTON_ENTER_MAIN)).shouldHave(text("Войти в аккаунт")).click();
        $(By.xpath(BUTTON_RESET_PASSWORD)).click();
        $(byClassName(RegistrationPageObjectsModel.BUTTON_ENTER_ON_REG_PAGE)).click();

        $(By.xpath(RegistrationPageObjectsModel.EMAIL_FIELD)).setValue(UserModel.EMAIL);
        $(byCssSelector(RegistrationPageObjectsModel.PASSWORD_FIELD)).setValue(UserModel.PASSWORD);
        $(byCssSelector(BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        $(By.xpath(MainPageObjectsModel.BUTTON_CREATE_ORDER)).should(visible);
    }

    @Step("Login on personal page")
    public void loginPersonalButton() {
        open(MainPageObjectsModel.MAIN_PAGE);
        $(By.xpath(MainPageObjectsModel.PERSONAL_BUTTON)).click();

        $(By.xpath(RegistrationPageObjectsModel.EMAIL_FIELD)).setValue(UserModel.EMAIL);
        $(byCssSelector(RegistrationPageObjectsModel.PASSWORD_FIELD)).setValue(UserModel.PASSWORD);
        $(byCssSelector(BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        $(By.xpath(MainPageObjectsModel.BUTTON_CREATE_ORDER)).should(visible);
    }

    @Step("Login with valid data")
    public void loginMainPage() {
        open(MainPageObjectsModel.MAIN_PAGE);
        $(byCssSelector(MainPageObjectsModel.BUTTON_ENTER_MAIN)).shouldHave(text("Войти в аккаунт")).click();

        $(By.xpath(RegistrationPageObjectsModel.EMAIL_FIELD)).setValue(UserModel.EMAIL);
        $(byCssSelector(RegistrationPageObjectsModel.PASSWORD_FIELD)).setValue(UserModel.PASSWORD);
        $(byCssSelector(BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        $(By.xpath(MainPageObjectsModel.BUTTON_CREATE_ORDER)).should(visible);
    }

    @Step ("Login with invalid password")
    public void loginWithWrongPassword() {
        open(MainPageObjectsModel.MAIN_PAGE);
        $(byCssSelector(MainPageObjectsModel.BUTTON_ENTER_MAIN)).shouldHave(text("Войти в аккаунт")).click();

        $(By.xpath(RegistrationPageObjectsModel.EMAIL_FIELD)).setValue(UserModel.EMAIL);
        $(byCssSelector(RegistrationPageObjectsModel.PASSWORD_FIELD)).setValue("12345");
        $(byCssSelector(BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        String actual = $(byCssSelector(WRONG_PASSWORD_TEXT)).getText();
        String expected = "Некорректный пароль";
        Assert.assertEquals("Текст не совпадает", expected, actual);
    }
}
