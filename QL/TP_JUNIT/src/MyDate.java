public class MyDate {
   private int day,month,year;


    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day > 31 || day <1)
            throw new IllegalArgumentException("erreur format : jour");
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1)
            throw new IllegalArgumentException("erreur format : year");
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month > 12 || month <1)
            throw new IllegalArgumentException("erreur format : mois");
        this.month = month;
    }

}
