import io.restassured.http.ContentType;
import org.openqa.selenium.By;
import org.junit.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.*;



public class Utility {

    PageObjectsModel pom = new PageObjectsModel();
    protected String accessToken;

    public void loginMainPage() {
        open(pom.MAIN_PAGE);
        $(byCssSelector(pom.BUTTON_ENTER_MAIN)).shouldHave(text("Войти в аккаунт")).click();

        $(By.xpath(pom.EMAIL_FIELD)).setValue(pom.EMAIL);
        $(byCssSelector(pom.PASSWORD_FIELD)).setValue(pom.PASSWORD);
        $(byCssSelector(pom.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        $(By.xpath(pom.BUTTON_CREATE_ORDER)).should(visible);
    }

    public void loginWithWrongPassword() {
        open(pom.MAIN_PAGE);
        $(byCssSelector(pom.BUTTON_ENTER_MAIN)).shouldHave(text("Войти в аккаунт")).click();

        $(By.xpath(pom.EMAIL_FIELD)).setValue(pom.EMAIL);
        $(byCssSelector(pom.PASSWORD_FIELD)).setValue("12345");
        $(byCssSelector(pom.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        String actual = $(byCssSelector(pom.WRONG_PASSWORD_TEXT)).getText();
        String expected = "Некорректный пароль";
        Assert.assertEquals("Текст не совпадает", expected, actual);
    }

    public void registration() {
        open(pom.MAIN_PAGE);
        $(byCssSelector(pom.BUTTON_ENTER_MAIN)).shouldHave(text("Войти в аккаунт")).click();
        $(By.xpath(pom.REGISTRATION_BUTTON_ON_ENTER_PAGE)).click();

        $(By.xpath(pom.NAME_FIELD)).setValue(pom.NAME);
        $(By.xpath(pom.EMAIL_FIELD)).setValue(pom.EMAIL);
        $(By.cssSelector(pom.PASSWORD_FIELD)).setValue(pom.PASSWORD);
        $(By.xpath(pom.REGISTRATION_BUTTON_ON_REGISTER_PAGE)).click();

        $(By.xpath(pom.EMAIL_FIELD)).shouldBe(visible).setValue(pom.EMAIL);
        $(byCssSelector(pom.PASSWORD_FIELD)).setValue(pom.PASSWORD);
        $(byCssSelector(pom.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        $(By.xpath(pom.BUTTON_CREATE_ORDER)).should(visible);

        logout();
    }

    public void loginOnLoginPage() {
        $(By.xpath(pom.EMAIL_FIELD)).setValue(pom.EMAIL);
        $(byCssSelector(pom.PASSWORD_FIELD)).setValue(pom.PASSWORD);
        $(byCssSelector(pom.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();
        $(By.xpath(pom.BUTTON_CREATE_ORDER)).should(visible);
    }

    public void logout() {
        $(By.xpath(pom.PERSONAL_BUTTON)).click();
        $(byClassName(pom.EXIT_BUTTON)).click();
        $(byCssSelector(pom.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).shouldBe(visible);
    }

    public void loginPersonalButton() {
        open(pom.MAIN_PAGE);
        $(By.xpath(pom.PERSONAL_BUTTON)).click();

        $(By.xpath(pom.EMAIL_FIELD)).setValue(pom.EMAIL);
        $(byCssSelector(pom.PASSWORD_FIELD)).setValue(pom.PASSWORD);
        $(byCssSelector(pom.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        $(By.xpath(pom.BUTTON_CREATE_ORDER)).should(visible);
    }

    public void loginRegistrationPage() {
        open(pom.MAIN_PAGE);
        $(byCssSelector(pom.BUTTON_ENTER_MAIN)).shouldHave(text("Войти в аккаунт")).click();
        $(By.xpath(pom.REGISTRATION_BUTTON_ON_ENTER_PAGE)).click();
        $(byClassName(pom.BUTTON_ENTER_ON_REG_PAGE)).click();

        $(By.xpath(pom.EMAIL_FIELD)).setValue(pom.EMAIL);
        $(byCssSelector(pom.PASSWORD_FIELD)).setValue(pom.PASSWORD);
        $(byCssSelector(pom.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        $(By.xpath(pom.BUTTON_CREATE_ORDER)).should(visible);
    }

    public void loginResetPasswordPage() {
        open(pom.MAIN_PAGE);
        $(byCssSelector(pom.BUTTON_ENTER_MAIN)).shouldHave(text("Войти в аккаунт")).click();
        $(By.xpath(pom.BUTTON_RESET_PASSWORD)).click();
        $(byClassName(pom.BUTTON_ENTER_ON_REG_PAGE)).click();

        $(By.xpath(pom.EMAIL_FIELD)).setValue(pom.EMAIL);
        $(byCssSelector(pom.PASSWORD_FIELD)).setValue(pom.PASSWORD);
        $(byCssSelector(pom.BUTTON_ENTER_AFTER_PW_AND_EMAIL)).click();

        $(By.xpath(pom.BUTTON_CREATE_ORDER)).should(visible);
    }

    public void visibleElementBulki() {
        open(pom.MAIN_PAGE);
        $(By.xpath(pom.LOCATOR_BULKI)).scrollTo().shouldBe(visible);
    }

    public void visibleElementNachinki() {
        open(pom.MAIN_PAGE);
        $(By.xpath(pom.LOCATOR_NACHINKI)).scrollTo().shouldBe(visible);
    }

    public void visibleElementSouses() {
        open(pom.MAIN_PAGE);
        $(By.xpath(pom.LOCATOR_SOUSES)).scrollTo().shouldBe(visible);
    }

    public void createNewUser() {
        accessToken = given()
                .baseUri(pom.MAIN_PAGE)
                .log().body()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"" + pom.NAME
                        + "\", \"email\": \""
                        + pom.EMAIL + "\", \"password\": \""
                        + pom.PASSWORD + "\" }")
                .when()
                .post("/api/auth/register")
                .then()
                .extract().path("accessToken");
    }

    public void deleteUser() {
        given()
                .baseUri(pom.MAIN_PAGE)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + accessToken)
                .delete("/api/auth/user");
    }

    public void loginUser() {
        accessToken = given()
                .baseUri(pom.MAIN_PAGE)
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"" + pom.NAME
                        + "\", \"email\": \""
                        + pom.EMAIL + "\", \"password\": \""
                        + pom.PASSWORD + "\" }")
                .header("Authorization", "Bearer" + accessToken)
                .when()
                .post("/api/auth/login")
                .then()
                .log().all()
                .extract().path("accessToken");
    }
}
