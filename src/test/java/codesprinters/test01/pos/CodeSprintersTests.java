package codesprinters.test01.pos;


import codesprinters.test01.pos.page.CodeSprintersPage;
import codesprinters.test01.pos.page.GooglePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CodeSprintersTests extends TestBase {

    private final String CODE_SPRINTERS = "Code sprinters";

    @Test
    public void verifyIfGoogleFindCodeSprinters() throws Exception{

        System.out.println("I'm going to - " + GooglePage.GOOGLE_URL);

        GooglePage googlePage = new GooglePage(this.driver);
        googlePage.googleFor(CODE_SPRINTERS, CodeSprintersPage.CODESPRINTERS_PAGE_TITLE);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs(CodeSprintersPage.CODESPRINTERS_PAGE_TITLE));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.endsWith(CodeSprintersPage.CODE_SPRINTERS_URL));
    }
}
