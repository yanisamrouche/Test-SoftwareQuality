package testjunit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MeteoFranceFumeeParametreTest {



    private URL baseUrl;
    WebDriver driver;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "QL/TP_SELENIUM/node_modules/chromedriver/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://meteofrance.com/");
    }
    private int getStatusCode(String u) throws IOException {
        baseUrl = new URL(u);
        HttpURLConnection http = (HttpURLConnection) baseUrl.openConnection();
        int code = http.getResponseCode();
        return code;
    }

    @ParameterizedTest
    @CsvSource({"/actualites, 200", "/climat, 200", "/meteo-marine, 200"})
    public void okTest(String url, int res) throws IOException {

        int code_res = getStatusCode("https://meteofrance.com/"+url);
        assertEquals(res,code_res);

    }

    @ParameterizedTest
    @CsvSource({"/actualites, ACTUALITES METEO avec Météo-France", "/climat, CLIMAT FRANCE par Météo-France - Normales et relevés sur la France métropolitaine", "/meteo-marine, METEO MARINE par Météo-France - COTE"})
    public void okTestEdited(String url, String res_title) throws IOException {
        driver.get("https://meteofrance.com"+url);
        String title = driver.getTitle();
        assertEquals(res_title,title);

    }

    @ParameterizedTest
    @CsvSource({"/clima, 404", "/meteo-marines, 404"})
    public void notFoundTest(String url, int res) throws IOException {
        int code_res = getStatusCode("https://meteofrance.com/"+url);
        assertEquals(res,code_res);
    }



    @AfterEach
    public void quitBrowser(){
        driver.close();
    }






}
