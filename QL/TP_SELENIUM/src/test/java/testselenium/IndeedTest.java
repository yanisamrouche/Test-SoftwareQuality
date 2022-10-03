package testselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

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
            logger.info("Succès => le titre de la page est celui obtenu");
        } else {
            logger.info("Echec");
        }
// vérifie que la page web contient un formulaire dont l’id est jobsearch.
        WebElement jobsearch = driver.findElement(By.id("jobsearch"));
        if(jobsearch.getTagName().equals("form")){
            logger.info("Succès => la page web contient un formulaire dont l’id est jobsearch");
        }else {
            logger.info("Echec");
        }
// Vérifier que l'élément h2 contient la chaine "recherches populaires"
        String chaineAttendu = "Recherches populaires";
        List<WebElement> listH = driver.findElements(By.tagName("h2"));
        for (WebElement webElement : listH){
            if (webElement.getText().equals(chaineAttendu)){
                logger.info("Succès => l'élément h2 contient la chaine 'recherches populaires'");
                break;
            }
        }
// Vérifier que la page contient un lien hypertexte dont le texte est « À propos »
        String apropos = "À propos";
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(WebElement link : links){
            if (link.getText().contentEquals(apropos)){
                logger.info("Succès => la page contient un lien hypertexte dont le texte est « À propos »");
                break;
            }
        }
//Vérifier que la page contient un lien hypertexte dont une partie du texte est « Guide »
        String guide = "Guide";
        List<WebElement> links_ = driver.findElements(By.tagName("a"));
        for(WebElement link : links_){
            if (link.getText().contains(guide)){
                logger.info("Succès => la page contient un lien hypertexte dont une partie du texte est « Guide »");
                break;
            }
        }
//Vérifier que la page contient un champ de formulaire dont le nom est q.
        String q = "q";
        List<WebElement> forms = driver.findElements(By.tagName("form"));
        for (WebElement form : forms){
            if (form.getText().toLowerCase().contains("q")){
                logger.info("Succès => la page contient un champ de formulaire dont le nom est q.");
                break;
            }
        }


// Quitter le navigateur
        driver.close();
    }
}
