package testjunit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YoutubeTest
{
        private WebDriver driver;

        @BeforeEach // avant chaque test
        public void openBrowser() {
            System.setProperty("webdriver.chrome.driver", "QL/TP_SELENIUM/node_modules/chromedriver/bin/chromedriver");
            driver = new ChromeDriver();
        }

        @Test
        public void home(){
            String url = "https://www.youtube.com/";
            driver.get(url);
            String title = "YouTube";
            assertEquals(driver.getTitle(),title);
        }

        @AfterEach
        public void quitBrowser(){
            driver.close();
        }




}
