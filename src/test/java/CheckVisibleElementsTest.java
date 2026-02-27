import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class CheckVisibleElementsTest {

    MainPageObjectsModel mom = new MainPageObjectsModel();

    @Test
    @DisplayName("Check element Bulki is visible")

    public void visibleElementBunsTest() {
        mom.visibleElementBuns();
    }

    @Test
    @DisplayName("Check element Nachinki is visible")

    public void visibleElementFillingsTest() {
        mom.visibleElementFillings();
    }

    @Test
    @DisplayName("Check element Souses is visible")

    public void visibleElementSousesTest() {
        mom.visibleElementSouses();
    }

}
