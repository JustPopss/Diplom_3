public class FieldPageObjectsModel {

    // Поля имя, почты и пароля
    protected final String EMAIL_FIELD = "//label[text()='Email']/following-sibling::input";
    protected final String PASSWORD_FIELD = ".text.input__textfield.text_type_main-default[name=\"Пароль\"]";
    protected final String NAME_FIELD = "//label[text()='Имя']/following-sibling::input";
}
