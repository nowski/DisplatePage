package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import page.objects.BasePage;
import page.objects.CartPage;
import page.objects.MainMenu;
import page.objects.PosterPage;

import static org.assertj.core.api.Assertions.assertThat;
import static page.objects.CartPage.CODE;
import static page.objects.CartPage.USA;

public class DisplateTest extends BasePage {

    MainMenu mainmenu;
    PosterPage posterPage;
    CartPage cartPage;

    public DisplateTest() {
        super();
    }

    @Test(priority = 1)
    public void beforeClass() {
        initital();
        mainmenu = new MainMenu();
        posterPage = new PosterPage();
        cartPage = new CartPage();
    }


    @Test(priority = 2)
    public void mainMenuTest() {
        assertThat(mainmenu.chooseFirstProduct()).isTrue();
    }

    @Test(priority = 3)
    public void chooseSizeOfPoster() {
        posterPage.chooseSizeOfPoster(PosterPage.LARGE_SIZE);
    }


    @Test(priority = 4)
    public void checkPriceOfPoster() {
        assertThat(posterPage.checkPriceOfPoster()).isNotNull();
    }

    @Test(priority = 6)
    public void addPosterToCart() {
        assertThat(posterPage.addPosterToCart()).isTrue();
    }


    @Test(priority = 6)
    public void goToCartPage() {
        assertThat(posterPage.goToCartPage()).isTrue();
    }

    @Test(priority = 7)
    public void checkIfThePricesAreEqual() {
        assertThat(cartPage.checkIfThePricesAreEqual()).isTrue();
    }

    @Test(priority = 8)
    public void addCode() throws InterruptedException {
        assertThat(cartPage.addCode(CODE)).isTrue();
    }

    @Test(priority = 9)
    public void checkCountryFromShipToList() {
        assertThat(cartPage.checkCountryFromShipToList(USA)).isTrue();
    }


    @Test(priority = 10)
    public void checkValueOfDiscount() {
        cartPage.checkValueOfDiscount();
    }

    @Test(priority = 11)
    public void checkIsPriceIsAppropriate() {
        assertThat(cartPage.checkIsPriceIsAppropriate()).isTrue();
    }

    @AfterClass
    public void disponseDriver() {
        disposeDriver();
    }


}
