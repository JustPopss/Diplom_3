import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.junit.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class UtilitySelenide {

    MainPageObjectsModel pom = new MainPageObjectsModel();
    LoginPageObjectsModel lom = new LoginPageObjectsModel();
    FieldPageObjectsModel fom = new FieldPageObjectsModel();
    OthersPO opo = new OthersPO();

    @Step("Login with valid data")
    public void loginMainPage() {
        open(pom.MAIN_PAGE);
        $(byCssSelector(pom.BUTTON_ENTER_MAIN)).shouldHave(text("Войти в аккаунт")).click();

        $(By.xpath(fom.EMAIL_FIELD)).setValue(UserModel.EMAIL);
        $(byCssSelector(fom.PASSWORD_FIELD)).setValue(UserModel.PASSWORD);
        $(byCssSelector(lom.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        $(By.xpath(pom.BUTTON_CREATE_ORDER)).should(visible);
    }

    @Step ("Login with invalid password")
    public void loginWithWrongPassword() {
        open(pom.MAIN_PAGE);
        $(byCssSelector(pom.BUTTON_ENTER_MAIN)).shouldHave(text("Войти в аккаунт")).click();

        $(By.xpath(fom.EMAIL_FIELD)).setValue(UserModel.EMAIL);
        $(byCssSelector(fom.PASSWORD_FIELD)).setValue("12345");
        $(byCssSelector(lom.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        String actual = $(byCssSelector(lom.WRONG_PASSWORD_TEXT)).getText();
        String expected = "Некорректный пароль";
        Assert.assertEquals("Текст не совпадает", expected, actual);
    }

    @Step ("Registration test")
    public void registration() {
        open(pom.MAIN_PAGE);
        $(byCssSelector(pom.BUTTON_ENTER_MAIN)).shouldHave(text("Войти в аккаунт")).click();
        $(By.xpath(lom.REGISTRATION_BUTTON_ON_ENTER_PAGE)).click();

        $(By.xpath(fom.NAME_FIELD)).setValue(UserModel.NAME);
        $(By.xpath(fom.EMAIL_FIELD)).setValue(UserModel.EMAIL);
        $(By.cssSelector(fom.PASSWORD_FIELD)).setValue(UserModel.PASSWORD);
        $(By.xpath(opo.REGISTRATION_BUTTON_ON_REGISTER_PAGE)).click();

        $(By.xpath(fom.EMAIL_FIELD)).shouldBe(visible).setValue(UserModel.EMAIL);
        $(byCssSelector(fom.PASSWORD_FIELD)).setValue(UserModel.PASSWORD);
        $(byCssSelector(lom.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        $(By.xpath(pom.BUTTON_CREATE_ORDER)).should(visible);

        logout();
    }

    @Step("Logout user")
    public void logout() {
        $(By.xpath(pom.PERSONAL_BUTTON)).click();
        $(byClassName(opo.EXIT_BUTTON)).click();
        $(byCssSelector(lom.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).shouldBe(visible);
    }

    @Step("Login on personal page")
    public void loginPersonalButton() {
        open(pom.MAIN_PAGE);
        $(By.xpath(pom.PERSONAL_BUTTON)).click();

        $(By.xpath(fom.EMAIL_FIELD)).setValue(UserModel.EMAIL);
        $(byCssSelector(fom.PASSWORD_FIELD)).setValue(UserModel.PASSWORD);
        $(byCssSelector(lom.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        $(By.xpath(pom.BUTTON_CREATE_ORDER)).should(visible);
    }

    @Step("Login on registration page")
    public void loginRegistrationPage() {
        open(pom.MAIN_PAGE);
        $(byCssSelector(pom.BUTTON_ENTER_MAIN)).shouldHave(text("Войти в аккаунт")).click();
        $(By.xpath(lom.REGISTRATION_BUTTON_ON_ENTER_PAGE)).click();
        $(byClassName(opo.BUTTON_ENTER_ON_REG_PAGE)).click();

        $(By.xpath(fom.EMAIL_FIELD)).setValue(UserModel.EMAIL);
        $(byCssSelector(fom.PASSWORD_FIELD)).setValue(UserModel.PASSWORD);
        $(byCssSelector(lom.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        $(By.xpath(pom.BUTTON_CREATE_ORDER)).should(visible);
    }

    @Step("Login on reset password page")
    public void loginResetPasswordPage() {
        open(pom.MAIN_PAGE);
        $(byCssSelector(pom.BUTTON_ENTER_MAIN)).shouldHave(text("Войти в аккаунт")).click();
        $(By.xpath(lom.BUTTON_RESET_PASSWORD)).click();
        $(byClassName(opo.BUTTON_ENTER_ON_REG_PAGE)).click();

        $(By.xpath(fom.EMAIL_FIELD)).setValue(UserModel.EMAIL);
        $(byCssSelector(fom.PASSWORD_FIELD)).setValue(UserModel.PASSWORD);
        $(byCssSelector(lom.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        $(By.xpath(pom.BUTTON_CREATE_ORDER)).should(visible);
    }

    @Step("Check element Bulki is visible")
    public void visibleElementBulki() {
        open(pom.MAIN_PAGE);
        $(By.xpath(pom.LOCATOR_BULKI)).scrollTo().shouldBe(visible);
    }

    @Step("Check element Nachinki is visible")
    public void visibleElementNachinki() {
        open(pom.MAIN_PAGE);
        $(By.xpath(pom.LOCATOR_NACHINKI)).scrollTo().shouldBe(visible);
    }

    @Step("Check element Souses is visible")
    public void visibleElementSouses() {
        open(pom.MAIN_PAGE);
        $(By.xpath(pom.LOCATOR_SOUSES)).scrollTo().shouldBe(visible);
    }
}