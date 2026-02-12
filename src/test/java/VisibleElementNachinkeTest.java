import io.qameta.allure.Step;
import org.junit.Test;

public class VisibleElementNachinkeTest {


    Utility utility = new Utility();

    @Test
    @Step("Check element Nachinki is visible")

    public void visibleElementNachinkiTest() {
        utility.visibleElementNachinki();
    }
}
