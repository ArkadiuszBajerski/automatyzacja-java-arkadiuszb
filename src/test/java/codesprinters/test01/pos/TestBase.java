package codesprinters.test01.pos;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    private final String KEY = "webdriver.gecko.driver";
    private final String DRIVER_PATH = "C:\\driver\\geckodriver.exe";
    protected WebDriver driver;

    @Before
    public void initTest(){
        System.setProperty(KEY, DRIVER_PATH);

        driver = new FirefoxDriver();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void finalize(){
        if(driver!=null){
            driver.quit();
        }
    }

}