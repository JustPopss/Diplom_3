import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginMainPageTest {

    Utility utility = new Utility();

    @Before
    @Step("Create new user and take token")
    public void createNewUser () {
        utility.createNewUser();
    }

    @Test
    @Step("Login with valid data")
    public void loginMainPageTest() {
        utility.loginMainPage();
    }

    @After
    @Step("Delete user")
    public void deleteUser() {
        utility.deleteUser();
    }
}
