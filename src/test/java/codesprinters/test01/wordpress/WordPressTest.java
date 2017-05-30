package codesprinters.test01.wordpress;

import codesprinters.test01.wordpress.page.WordPressHomePage;
import codesprinters.test01.wordpress.section.WordPressArticlePage;
import org.junit.Assert;
import org.junit.Test;

public class WordPressTest extends TestBase {

    @Test
    public void goToWordPressPageAndOpenComment() {
        WordPressHomePage wordPressPage = new WordPressHomePage(this.driver);
        WordPressArticlePage articlePage = new WordPressArticlePage(this.driver);
        wordPressPage.goToWordPress();
        wordPressPage.clickThirdCommentOnPage();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long x = System.currentTimeMillis();
        String myComment = "Arkadiusz Bajerski " + x;
        articlePage.putCommentToArea(myComment);
        articlePage.putEmail("babsxab@bababa.pl");
        articlePage.putName("baba");
        articlePage.submitComment();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        articlePage.assertComment(myComment);

    }

}
