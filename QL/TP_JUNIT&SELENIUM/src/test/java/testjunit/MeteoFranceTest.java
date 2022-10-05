package testjunit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MeteoFranceTest {



    private int getStatusCode(String u) throws IOException {
        URL url = new URL(u);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        int code = http.getResponseCode();
        return code;
    }

    @Test
    public void homePageTest() throws IOException {
        int code = getStatusCode("https://meteofrance.com/");
        assertEquals(code,200);
    }

    @Test
    public void notFoundPageTest() throws IOException {
        int code = getStatusCode("https://meteofrance.com/meteo-marines");
        assertEquals(code,404);
    }








}
