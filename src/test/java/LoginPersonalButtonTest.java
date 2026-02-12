import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginPersonalButtonTest {

    Utility utility = new Utility();

    @Before
    @Step("Create new user and take token")
    public void createNewUser () {
        utility.createNewUser();
    }

    @Test
    @Step("Login on personal page")
    public void loginPersonalButtonTest() {
        utility.loginPersonalButton();
    }

    @After
    @Step("Delete user")
    public void deleteUser() {
        utility.deleteUser();
    }
}
