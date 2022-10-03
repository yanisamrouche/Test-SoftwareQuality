package testselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IndeedTest
{
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(IndeedTest.class);
        WebDriver driver;
        String titreAttendu = "Emploi | Indeed";
        String titreObtenu = "";
// Créer le pilote pour Chrome
// remplacer CHEMIN/ par le chemin d’accès à geckodriver sur votre disque
        System.setProperty( "webdriver.chrome.driver", "QL/TP_SELENIUM/node_modules/chromedriver/bin/chromedriver");
        driver = new ChromeDriver();
// Lancer le navigateur, charger l'URL
        logger.info("Chargement de l'URL https://fr.indeed.com/");
        driver.get("https://fr.indeed.com/");
// Récupérer le titre de la page web
        titreObtenu = driver.getTitle();
        logger.info("Titre obtenu : " + titreObtenu);
        logger.info("Titre attendu : " + titreAttendu);



// Vérifier que le titre de la page est celui obtenu
        if (titreObtenu.contentEquals(titreAttendu)){
            logger.info("Succès");
        } else {
            logger.info("Echec");
        }
// Récupérer l'id = jobsearch
        WebElement jobsearch = driver.findElement(By.id("jobsearch"));
        if(jobsearch.getTagName().equals("form")){
            logger.info("Succès");
        }else {
            logger.info("Echec");
        }
// Quitter le navigateur
        driver.close();
    }
}
