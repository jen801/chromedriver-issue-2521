package test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ChromeDriverHeadlessTest {
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.verboseLogging", "true");
    }

    @Test
    public void notWorkingWithHeadless() {
        ChromeOptions headlessChromeOptions = new ChromeOptions();
        headlessChromeOptions.addArguments("--headless");
        testFileInputDirectory(headlessChromeOptions);
    }

    @Test
    public void workingWithoutHeadless() {
        testFileInputDirectory(new ChromeOptions());
    }

    private void testFileInputDirectory(ChromeOptions chromeOptions) {

        WebDriver driver = new ChromeDriver(chromeOptions);
        try {
            driver.get("file://" + getFilePath("test.html"));

            WebElement element = driver.findElement(By.id("upload-directory"));

            element.sendKeys(getFilePath("data"));

            assertEquals("C:\\fakepath\\test", element.getAttribute("value"));
        } finally {
            driver.quit();
        }
    }

    private String getFilePath(String fileName) {
        String filePath = null;
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            filePath = classLoader.getResource(fileName).getFile();
            filePath = new File(filePath).getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
