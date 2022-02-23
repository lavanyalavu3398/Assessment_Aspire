package Aspire;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assessment_1 {

	public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://aspireapp.odoo.com/web/login");
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("user@aspireapp.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("@sp1r3app");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement inve = driver.findElement(By.xpath("//div[.='Inventory']"));
        wait.until(ExpectedConditions.visibilityOf(inve));
        inve.click();
        WebElement prod = driver.findElement(By.xpath("//span[.='Products']"));
        wait.until(ExpectedConditions.visibilityOf(prod));
        prod.click();
        driver.findElement(By.xpath("//a[.='Products']")).click();
        WebElement create_in = driver.findElement(By.xpath("//div[@class='o_cp_buttons']/child::div"));
        wait.until(ExpectedConditions.visibilityOf(create_in));
        create_in.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='e.g. Cheese Burger']")).sendKeys("Cheesee2");
        driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.navigate().refresh();
        WebElement q1 = driver.findElement(By.xpath("(//div[@class='o_statusbar_buttons']/child::button)[2]"));
        Thread.sleep(3000);
        js.executeScript("arguments[0].click();", q1);
        Thread.sleep(3000);
                driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
        driver.findElement(By.xpath("(//td)[6]/input")).clear();
        driver.findElement(By.xpath("(//td)[6]/input")).sendKeys("10");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
        driver.findElement(By.xpath("//a[@title='Home menu']")).click();
        driver.findElement(By.xpath("//div[.='Manufacturing']")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
        WebElement prod_enter = driver.findElement(By.xpath("(//div[@class='o_input_dropdown']/child::input[@type='text'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(prod_enter));
        prod_enter.sendKeys("Cheesee2");
        Thread.sleep(2000);
        prod_enter.sendKeys(Keys.ENTER);
        WebElement confirm_pro = driver.findElement(By.xpath("//span[.='Confirm']"));
        wait.until(ExpectedConditions.visibilityOf(confirm_pro));
        confirm_pro.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[.='Mark as Done'])[2]")).click();
        driver.findElement(By.xpath("//span[.='Ok']")).click();
        driver.findElement(By.xpath("//span[.='Apply']")).click();
        String pr = driver.findElement(By.xpath("//a[@name='product_id']")).getText();
        System.out.println(pr);
        driver.quit();
    }
}
