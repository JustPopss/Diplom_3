import com.github.javafaker.Faker;

public class PageObjectsModel {

    static Faker faker = new Faker();

    protected final String MAIN_PAGE = "https://stellarburgers.education-services.ru/";

    // Кнопка "Личный кабинет" на главной странице
    protected final String PERSONAL_BUTTON = "//p[contains(text(), 'Личный Кабинет')]";

    // Кнопка "Выход" в личном кабинете
    protected final String EXIT_BUTTON = "Account_button__14Yp3";

    // Кнопка "Войти" в аккаунт на главной странице
    protected final String BUTTON_ENTER_MAIN = ".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg";
    // Кнопка "Войти" на странице логина
    protected final String BUTTON_ENTER_AFTER_PW_AND_EMAIL = ".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa";
    // Кнопка "Войти" на странице регистрации
    protected final String BUTTON_ENTER_ON_REG_PAGE = "Auth_link__1fOlj";


    // Кнопка "Оформить заказ" на главной странице
    protected final String BUTTON_CREATE_ORDER = "//button[contains(text(), 'Оформить заказ')]";

    protected final String WRONG_PASSWORD_TEXT = ".input__error.text_type_main-default";

    // Кнопка "Зарегистрироваться на странице входа"
    protected final String REGISTRATION_BUTTON_ON_ENTER_PAGE = "//a[contains(text(), 'Зарегистрироваться')]";
    // Кнопка "Зарегистрироваться на странице регистрации"
    protected final String REGISTRATION_BUTTON_ON_REGISTER_PAGE = "//button[contains(text(), 'Зарегистрироваться')]";

    protected final String BUTTON_RESET_PASSWORD = "//a[contains(text(), 'Восстановить пароль')]";


    protected static final String NAME = faker.name().firstName() + System.currentTimeMillis();
    protected static final String PASSWORD = faker.regexify("[0-9]{6}");
    protected static final String EMAIL = NAME.toLowerCase() + "@pochta.ru";

    // Поля имя, почты и пароля
    protected final String EMAIL_FIELD = "//label[text()='Email']/following-sibling::input";
    protected final String PASSWORD_FIELD = ".text.input__textfield.text_type_main-default[name=\"Пароль\"]";
    protected final String NAME_FIELD = "//label[text()='Имя']/following-sibling::input";

    protected final String LOCATOR_BULKI = "//h2[contains(text(), 'Булки')]";
    protected final String LOCATOR_SOUSES = "//h2[contains(text(), 'Соусы')]";
    protected final String LOCATOR_NACHINKI = "//h2[contains(text(), 'Начинки')]";

}

