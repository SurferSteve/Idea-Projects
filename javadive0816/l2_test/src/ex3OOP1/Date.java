package ex3OOP1;

/**
 * Created by Steve on 25.02.2016.
 */
public class Date {
    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day <= 31) {
            this.day = day;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month <= 12) {
            this.month = month;
        }
    }

    public int getYear() {
            return year;
    }

    public void setYear(int year) {
        if (year >= -10000 || year <= 3100) {
            this.year = year;
        }
    }
}
