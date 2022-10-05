package testjunit;
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

public class IndeedjunitTest {


    WebDriver driver;

    @BeforeEach
    public  void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "QL/TP_SELENIUM/node_modules/chromedriver/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://fr.indeed.com");
    }

    @Test
    public void home(){
        String titreAttendu = "Emploi | Indeed";
        String lienAttendu = "À propos";
        String titreObtenu = driver.getTitle();
        String guide = "Guide";
        String lien_apropos_Obtenu = "";
        String lien_guide="";
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(WebElement link : links){
            String lien = link.getText();
            if(lien.equals(lienAttendu)){
                 lien_apropos_Obtenu = lien;
            }
            if(lien.contains(guide)){
                lien_guide = lien;
            }
        }
        assertEquals(titreObtenu,titreAttendu);
        assertEquals(lien_apropos_Obtenu, lienAttendu);
        assertTrue(lien_guide.contains("Guide"));

        WebElement jobsearch = driver.findElement(By.id("jobsearch"));
        assertTrue(jobsearch.getTagName().equals("form"));

    }

    @Test
    public void search() throws InterruptedException {
        WebElement form = driver.findElement(By.tagName("form"));
        WebElement input = form.findElement(By.tagName("input"));
        if (input.getAttribute("name").contentEquals("q")){
            //Entrer  la  chaîne  de  recherche  « Développeur  web »  dans  l’input
            input.sendKeys("Développeur web");
            Thread.sleep(2000);
            input.sendKeys(Keys.TAB);
            //Entrer  la  chaîne  de  recherche  « Aix-en-Provence »  dans  l’input
            driver.findElement(By.name("l")).sendKeys("Aix-en-Provence"); // ajouter la chaine
            Thread.sleep(2000);
            //sélectionner et envoyer le formulaire avec la méthode submit
            driver.findElement(By.cssSelector(".yosegi-InlineWhatWhere-primaryButton")).submit();
            Thread.sleep(5000); // pause de 5sec
            driver.findElement(By.xpath("//*[@id=\"google-Only-Modal\"]/div/div[1]/button\n")).click();
            Thread.sleep(5000); // pause de 5sec
            driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]\n")).click();
            Thread.sleep(5000); // pause de 5sec
            assertTrue(driver.findElement(By.id("filter-radius")).getTagName().equals("button"));
        }
    }
    @AfterEach
    public  void quitBrowser(){
        driver.close();
    }

}
