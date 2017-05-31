package codesprinters.test01.wordpress.section;


import codesprinters.test01.pos.page.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class WordPressArticlePage extends PageObject {

    private By commentArea = By.id("comment-form-comment");
    private By emailField = By.xpath("//label[@for='email']");
    private By nameField = By.xpath("//label[@for='author']");
    private By postComment = By.id("comment-submit");

    public WordPressArticlePage(WebDriver drv) {
        super(drv);
    }

    private WebDriverWait waiting = new WebDriverWait(driver, 10);

    public void putCommentToArea(String comment) {
        WebElement commentField = driver.findElement(commentArea);
        commentField.click();
        waiting.until(ExpectedConditions.numberOfElementsToBe(By.id("comment-form-nascar"), 1));
        commentField.sendKeys(comment);
    }

    public void putEmail(String email) {
        WebElement emailArea = driver.findElement(emailField);
        emailArea.sendKeys(email);
    }

    public void putName(String name) {
        WebElement nameArea = driver.findElement(nameField);
        nameArea.sendKeys(name);
    }

    public void submitComment() {
        WebElement submitButton = driver.findElement(postComment);
        submitButton.click();
    }

    public boolean hasText(String expectedComment) {
        List<WebElement> comments = driver.findElements(By.xpath("//*[contains(text(), '" + expectedComment + "')]"));
        int count = comments.size();
        if (count == 1) {
            return !comments.isEmpty();
        }
        return false;
    }
}