import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class CheckVisibleElementsTest {

    UtilitySelenide utilitySelenide = new UtilitySelenide();

    @Test
    @DisplayName("Check element Bulki is visible")

    public void visibleElementBulkiTest() {
        utilitySelenide.visibleElementBulki();
    }

    @Test
    @DisplayName("Check element Nachinki is visible")

    public void visibleElementNachinkiTest() {
        utilitySelenide.visibleElementNachinki();
    }

    @Test
    @DisplayName("Check element Souses is visible")

    public void visibleElementSousesTest() {
        utilitySelenide.visibleElementSouses();
    }

}
