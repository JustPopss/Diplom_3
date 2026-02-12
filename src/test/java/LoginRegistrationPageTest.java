import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginRegistrationPageTest {


    Utility utility = new Utility();

    @Before
    @Step("Create new user and take token")
    public void createNewUser () {
        utility.createNewUser();
    }

    @Test
    @Step("Login on registration page")
    public void loginRegistrationPageTest() {
        utility.loginRegistrationPage();
    }

    @After
    @Step("Delete user")
    public void deleteUser() {
        utility.deleteUser();
    }
}

