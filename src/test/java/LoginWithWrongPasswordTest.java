import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class LoginWithWrongPasswordTest {

    LoginPageObjectsModel lom = new LoginPageObjectsModel();

    @Test
    @DisplayName("Login with invalid password")
    public void loginWithWrongPassword() {
        lom.loginWithWrongPassword();
    }
}
