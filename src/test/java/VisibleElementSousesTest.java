import io.qameta.allure.Step;
import org.junit.Test;

public class VisibleElementSousesTest {

    Utility utility = new Utility();

    @Test
    @Step("Check element Souses is visible")

    public void visibleElementSousesTest() {
        utility.visibleElementSouses();
    }
}
