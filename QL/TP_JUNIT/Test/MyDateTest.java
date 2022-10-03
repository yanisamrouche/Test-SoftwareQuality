import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MyDateTest {

    @Test
    public void testSetDay32(){
        MyDate myDate = new MyDate();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            myDate.setDay(32);
        });
        String expectedMessage = "erreur format : jour";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void testSetDay0(){
        MyDate myDate = new MyDate();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            myDate.setDay(0);
        });
        String expectedMessage = "erreur format : jour";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void testSetDay1(){
        MyDate myDate = new MyDate();
        myDate.setDay(1);


        assertTrue(myDate.getDay() == 1);

    }

    @Test
    public void testSetDay2(){
        MyDate myDate = new MyDate();
        myDate.setDay(2);


        assertTrue(myDate.getDay() == 2);

    }

    @Test
    public void testSetDay31(){
        MyDate myDate = new MyDate();
        myDate.setDay(31);


        assertTrue(myDate.getDay() == 31);

    }

    @Test
    public void testSetDay30(){
        MyDate myDate = new MyDate();
        myDate.setDay(30);


        assertTrue(myDate.getDay() == 30);

    }

    @Test
    public void testSetMonth1(){
        MyDate myDate = new MyDate();
        myDate.setMonth(1);
        assertTrue(myDate.getMonth() == 1);
    }

    @Test
    public void testSetMonth2(){
        MyDate myDate = new MyDate();
        myDate.setMonth(2);
        assertTrue(myDate.getMonth() == 2);
    }

    @Test
    public void testSetMonth11(){
        MyDate myDate = new MyDate();
        myDate.setMonth(11);
        assertTrue(myDate.getMonth() == 11);
    }

    @Test
    public void testSetMonth12(){
        MyDate myDate = new MyDate();
        myDate.setMonth(12);
        assertTrue(myDate.getMonth() == 12);
    }


    @Test
    public void testSetMonth13(){
        MyDate myDate = new MyDate();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            myDate.setMonth(13);
        });
        String expectedMessage = "erreur format : mois";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void testSetMonth0(){
        MyDate myDate = new MyDate();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            myDate.setMonth(0);
        });
        String expectedMessage = "erreur format : mois";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void testSetYEar0(){
        MyDate myDate = new MyDate();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            myDate.setYear(0);
        });
        String expectedMessage = "erreur format : year";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void testSetYEar1(){
        MyDate myDate = new MyDate();
        myDate.setYear(1);
        assertTrue(myDate.getYear()==1);

    }


}
