import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

public class RegistrationTest {

    RegistrationPageObjectsModel rom = new RegistrationPageObjectsModel();
    UtilityApi utilityApi = new UtilityApi();
    UserModel userModel = new UserModel(
            UserModel.EMAIL,
            UserModel.PASSWORD,
            UserModel.NAME);

    @Test
    @DisplayName ("Registration test")
    public void registrationTest () {
        rom.registration();
    }

    @After
    @DisplayName("Login user for token and delete")
    public void deleteUser () {
        utilityApi.loginUser(userModel);
        utilityApi.deleteUser();
    }
}
