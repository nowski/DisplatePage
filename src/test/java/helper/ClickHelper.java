package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static page.objects.BasePage.getDriver;
import static page.objects.BasePage.waitt;


public class ClickHelper {

    public static JavascriptExecutor js;

    public ClickHelper() {
        js = (JavascriptExecutor) getDriver();
    }


    public void clickElement(WebElement element) {
        waitUntilElementIsVisible(element);
        scrollToElement(element);
        waitt.until(ExpectedConditions.elementToBeClickable(element));
        clickElementJs(element);
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToElementPx(int px) {
        js.executeScript("window.scrollBy(0," + px + ")");
    }

    public void clickElementJs(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public void clickElementAndSendText(WebElement element, String text) {
        clickElement(element);
        element.sendKeys(text);
    }

    public void waitUntilElementIsVisible(WebElement element) {
        waitt.until(ExpectedConditions.visibilityOf(element));

    }

    public boolean isDisplayed(WebElement element) {
        waitUntilElementIsVisible(element);
        return element.isDisplayed();
    }

}
