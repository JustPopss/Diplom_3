import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class LoginWithWrongPasswordTest {

    UtilitySelenide utilitySelenide = new UtilitySelenide();

    @Test
    @DisplayName("Login with invalid password")
    public void loginWithWrongPassword() {
        utilitySelenide.loginWithWrongPassword();
    }
}
