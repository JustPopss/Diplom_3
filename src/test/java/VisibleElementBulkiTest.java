import io.qameta.allure.Step;
import org.junit.Test;

public class VisibleElementBulkiTest {

    Utility utility = new Utility();

    @Test
    @Step("Check element Bulki is visible")

    public void visibleElementBulkiTest() {
        utility.visibleElementBulki();
    }

}
