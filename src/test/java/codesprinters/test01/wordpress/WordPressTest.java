package codesprinters.test01.wordpress;

import codesprinters.test01.wordpress.page.WordPressHomePage;
import codesprinters.test01.wordpress.section.WordPressArticlePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WordPressTest extends TestBase {


    @Test
    public void goToWordPressPageAndAddComment() {
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

    @Test()
    public void addCommentAndAddReplay() {
        WordPressHomePage wordPressPage = new WordPressHomePage(this.driver);
        WordPressArticlePage articlePage = new WordPressArticlePage(this.driver);

        long x = System.currentTimeMillis();
        String myComment = "Arkadiusz Bajerski " + x;
        String replyComment = "REPLY COMMENT";

        wordPressPage.goToWordPress();
        wordPressPage.clickThirdCommentOnPage();

        wait.until(ExpectedConditions.textToBe(By.id("reply-title"), "Leave a Reply"));

        articlePage.putCommentToArea(myComment);
        articlePage.putEmail("babsxab@baasdsadsadsadsadbaba.pl");
        articlePage.putName("babasdsada");
        articlePage.submitComment();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("comment-form-nascar")));

        articlePage.findCommentAndClickReplay(myComment, replyComment);
        articlePage.putName("sdsadsadsadsad");
        articlePage.putEmail("xxasdsadsadsadasx@dsadsadsasadsad.pl");
        articlePage.submitComment();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("comment-form-nascar")));

        Assert.assertTrue(articlePage.haveTexts(myComment, replyComment));
    }
}