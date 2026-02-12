import io.qameta.allure.Step;
import org.junit.Test;

public class LoginWithWrongPasswordTest {

    Utility utility = new Utility();

    @Test
    @Step ("Login with invalid password")
    public void loginWithWrongPassword() {
        utility.loginWithWrongPassword();
    }
}
