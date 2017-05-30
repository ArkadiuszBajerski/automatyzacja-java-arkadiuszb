package codesprinters.test01.pos.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage extends PageObject {

    public final static String GOOGLE_URL = "https://www.google.com";

    //Points of Interest

    private final By searchField = By.name("q");

    //----------


    public GooglePage(WebDriver drv) {
        super(drv);
    }

    public void goToGoogle(){
        driver.get(GOOGLE_URL);
    }

    public void searchOnGoogle(String query){
        WebElement googleSearchBox = driver.findElement(searchField);
        googleSearchBox.sendKeys(query);
        googleSearchBox.sendKeys(Keys.ENTER);
    }

    public void clickOnGoogleContaining(String pattern){
        WebElement codeSprinters = driver.findElement(resultWithPattern(pattern));
        codeSprinters.click();
    }

    public void googleFor(String what, String where){
        this.goToGoogle();
        this.searchOnGoogle(what);
        this.clickOnGoogleContaining(where);
    }

    private By resultWithPattern(String pattern){
        return By.xpath("//a[text()='" + pattern + "']");
    }
}