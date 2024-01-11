package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.imdb.com/chart/top/");
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.id("sort-by-selector")));
        Thread.sleep(2000);
        select.selectByVisibleText("IMDb rating");

        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//li[1]//h3")).getText());
        System.out.println(driver.findElements(By.xpath("//ul[@class='ipc-metadata-list ipc-metadata-list--dividers-between sc-71ed9118-0 kxsUNk compact-list-view ipc-metadata-list--base']//li")).size());
        select.selectByVisibleText("Release date");
        WebElement btn = driver.findElement(By.id("swap-sort-order-button"));
        btn.click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//li[1]//h3")).getText());
        btn.click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//li[1]//h3")).getText());
        select.selectByVisibleText("Popularity");
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//li[1]//h3")).getText());







        System.out.println("end Test case: testCase02");
    }


}
