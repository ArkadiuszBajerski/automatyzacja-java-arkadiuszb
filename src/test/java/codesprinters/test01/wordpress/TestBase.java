package codesprinters.test01.wordpress;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    private final String KEY = "webdriver.gecko.driver";
    private final String DRIVER_PATH = "C:\\driver\\geckodriver.exe";
    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void initTest(){
        System.setProperty(KEY, DRIVER_PATH);

        driver = new FirefoxDriver();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void finalize(){
        if(driver!=null){
            driver.quit();
        }
    }
}