package codesprinters.test01.wordpress.page;


import org.openqa.selenium.WebDriver;

public abstract class PageObject {

    protected WebDriver driver;
    
    public PageObject(WebDriver drv) {
        this.driver = drv;
    }
}