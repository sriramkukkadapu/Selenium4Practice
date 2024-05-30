package redBusChallengeSolutionsAshwin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import static redBusChallengeSolutionsAshwin.RedBusSolutionHelper.getWeekEndDates;

public class RedBusChallenegeSolution {

    static final String APP_URL = "https://www.redbus.in/";
    static WebDriver driver;
    private static  List<String> getWeekEndDates = new ArrayList<String>();
    private static  By btnCalender = By.id("onwardCal");
    private static  By lblgetMonthYearHolidayDetails = By.cssSelector("div[class*='DayNavigator__IconBlock-qj8jdz-2']:nth-child(2)");
    private static  By btnRightArrow = By.cssSelector("#Layer_1");
    private static By lblGetAllWeekends = By.cssSelector(".DayTiles__CalendarDaysSpan-sc-1xum02u-1.bwoYtA");
    private static final int waitTime = 50;


    public static void main(String[] args){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        List<String> weekEnds;
        String setDate = "Jul 2025";

     
  
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        int dayOfMonth  = LocalDate.now().getDayOfMonth();

        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofMillis(waitTime));
        driver.get(APP_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));

        driver.findElement(btnCalender).click();

        String getmonthYearHolidays = driver.findElement(lblgetMonthYearHolidayDetails).getText();

        if(getmonthYearHolidays.contains(setDate)){
            // to check if the present date is a weekend
            if(String.valueOf(dayOfWeek).equalsIgnoreCase("sunday") || String.valueOf(dayOfWeek).equalsIgnoreCase("saturday")){
                getWeekEndDates.add(String.valueOf(dayOfMonth));
            }
            System.out.println(getmonthYearHolidays);

        }else{
            while (!(getmonthYearHolidays.contains(setDate))){
                driver.findElements(btnRightArrow).get(driver.findElements(btnRightArrow).size()-1).click();
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(lblgetMonthYearHolidayDetails));
                getmonthYearHolidays = driver.findElement(lblgetMonthYearHolidayDetails).getText();
                System.out.println(getmonthYearHolidays);
            }
        }

        driver.findElements(lblGetAllWeekends)
                .stream()
                .map(s->s.getText())
                .forEach(s->getWeekEndDates.add(s));

        driver.quit();

        System.out.println(getWeekEndDates);


}
    
}
