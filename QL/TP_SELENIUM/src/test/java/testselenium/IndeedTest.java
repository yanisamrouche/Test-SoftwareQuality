package testselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class IndeedTest
{
    public static void main(String[] args) throws InterruptedException {
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
                logger.info("Succès => la page contient un lien hypertexte dont une partie du texte est « Guide ».");
                break;
            }
        }
//Vérifier que la page contient un champ de formulaire dont le nom est q.
        String q = "q";
        WebElement form = driver.findElement(By.tagName("form"));
        WebElement input = form.findElement(By.tagName("input"));
        if (input.getAttribute("name").contentEquals("q")){
            logger.info("Succès => la page contient un champ de formulaire dont le nom est q.");
            //Entrer  la  chaîne  de  recherche  « Développeur  web »  dans  l’input
            input.sendKeys("Développeur web");
            Thread.sleep(2000);
            logger.info("Succès => saisir la  chaîne  de  recherche  « Développeur  web »  dans  l’input.");
            input.sendKeys(Keys.TAB);
            logger.info("Succès => tabulation sur l'élément dont le nom q & le champ \"ou\" devrait apparaître sélectionné.");
            //Entrer  la  chaîne  de  recherche  « Aix-en-Provence »  dans  l’input
            driver.findElement(By.name("l")).sendKeys("Aix-en-Provence"); // ajouter la chaine
            Thread.sleep(2000);
            logger.info("Succès => Entrer  la  chaîne  de  recherche  « Aix-en-Provence »  dans  l’input l.");
            //sélectionner et envoyer le formulaire avec la méthode submit
            driver.findElement(By.cssSelector(".yosegi-InlineWhatWhere-primaryButton")).submit();
            Thread.sleep(5000); // pause de 5sec
            driver.findElement(By.xpath("//*[@id=\"google-Only-Modal\"]/div/div[1]/button\n")).click();
            Thread.sleep(5000); // pause de 5sec
            logger.info("Succès => Fermeture de la fenêtre popup de connexion.");
            driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]\n")).click();
            Thread.sleep(5000); // pause de 5sec
            logger.info("Succès => accepter tous les cookies .");
            if (driver.findElement(By.id("filter-radius")).getTagName().equals("button"))
                logger.info("Succès => Vérifier que la page de résultat contient un élément dont l’id est « filter-radius ».");
            else
                logger.info("Echec.");

            // cliquer sur hypertext 'date'
            List<WebElement> alllinks = driver.findElements(By.tagName("a"));
            for (WebElement link : alllinks){
                if (link.getText().equals("date")){
                    link.click();
                    logger.info("Succès => cliquer sur hypertext 'date'.");
                    break;
                }
            }
            Thread.sleep(5000); // pause de 5sec
            //pop up
            if(driver.findElement(By.cssSelector("#popover-x > button")).getTagName().equals("button")){
                driver.findElement(By.cssSelector("#popover-x > button")).click();
            }
            // récupération de la liste de tous les offres
            List<WebElement> offres = driver.findElements(By.className("job_seen_beacon"));
            Actions actions = new Actions(driver);
            for (WebElement offre : offres){
                actions.release().perform();
                actions.moveToElement(offre);
                actions.clickAndHold();
                Thread.sleep(1000);
            }




        }




// Quitter le navigateur
        //driver.close();
    }
}
