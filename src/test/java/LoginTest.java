import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginTest {

    UtilityApi utilityApi = new UtilityApi();
    LoginPageObjectsModel lom = new LoginPageObjectsModel();

    UserModel userModel = new UserModel(
            UserModel.EMAIL,
            UserModel.PASSWORD,
            UserModel.NAME);

    @Before
    @DisplayName("Create new user")
        public void createNewUser () {
        utilityApi.createNewUser(userModel);
    }

    @Test
    @DisplayName("Login with valid data on main page")
    public void loginMainPageTest() {
        lom.loginMainPage();
    }

    @Test
    @DisplayName("Login on personal page")
    public void loginPersonalButtonTest() {
        lom.loginPersonalButton();
    }

    @Test
    @DisplayName("Login on registration page")
    public void loginRegistrationPageTest() {
        lom.loginRegistrationPage();
    }

    @Test
    @DisplayName("Login on reset password page")
    public void loginResetPasswordPageTest() {
        lom.loginResetPasswordPage();
    }

    @After
    @DisplayName("Delete user")
    public void deleteUser() {
        utilityApi.deleteUser();
    }
}
