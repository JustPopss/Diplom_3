import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Test;

public class RegistrationTest {

    Utility utility = new Utility();

    @Test
    @Step ("Registration test")
    public void registrationTest () {
        utility.registration();
    }

    @After
    @Step("Login user for token and delete")
    public void deleteUser () {
        utility.loginUser();
        utility.deleteUser();
    }
}
