package codesprinters.test01.wordpress.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WordPressHomePage extends PageObject {


    private By thirdCommentOnPage = By.xpath("(//span[@class='comments-link'])[3]");

    public final static String wordPressUrl = "https://autotestjava.wordpress.com/";

    public WordPressHomePage(WebDriver drv) {
        super(drv);
    }

    public void goToWordPress() {
        driver.get(wordPressUrl);
    }

    public void clickThirdCommentOnPage() {
        WebElement thirdComment = driver.findElement(thirdCommentOnPage);
        thirdComment.click();
    }
}