import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

public class RegistrationTest {

    UtilitySelenide utilitySelenide = new UtilitySelenide();
    UtilityApi utilityApi = new UtilityApi();
    UserModel userModel = new UserModel(
            UserModel.EMAIL,
            UserModel.PASSWORD,
            UserModel.NAME);

    @Test
    @DisplayName ("Registration test")
    public void registrationTest () {
        utilitySelenide.registration();
    }

    @After
    @DisplayName("Login user for token and delete")
    public void deleteUser () {
        utilityApi.loginUser(userModel);
        utilityApi.deleteUser();
    }
}
