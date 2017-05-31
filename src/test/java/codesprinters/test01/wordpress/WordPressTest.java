package codesprinters.test01.wordpress;

import codesprinters.test01.wordpress.page.WordPressHomePage;
import codesprinters.test01.wordpress.section.WordPressArticlePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WordPressTest extends TestBase {


    @Test
    public void goToWordPressPageAndOpenComment() {
        WordPressHomePage wordPressPage = new WordPressHomePage(this.driver);
        WordPressArticlePage articlePage = new WordPressArticlePage(this.driver);

        long x = System.currentTimeMillis();
        String myComment = "Arkadiusz Bajerski " + x;

        wordPressPage.goToWordPress();
        wordPressPage.clickThirdCommentOnPage();

        wait.until(ExpectedConditions.textToBe(By.id("reply-title"), "Leave a Reply"));

        articlePage.putCommentToArea(myComment);
        articlePage.putEmail("babsxab@bababa.pl");
        articlePage.putName("baba");
        articlePage.submitComment();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("comment-form-nascar")));

        Assert.assertTrue(articlePage.hasText(myComment));
    }
}