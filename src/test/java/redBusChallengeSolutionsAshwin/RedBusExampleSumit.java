package redBusChallengeSolutionsAshwin;


//import java.time.YearMonth;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//public class RedBusExampleSumit {
//
//    public static Map<String, String> hmap = new LinkedHashMap<String, String>();
//    public static List<String> weekendDate = new ArrayList<String>();
//
//    public static boolean validateMonthYear(String input) {
//        try {
//            DateTimeFormatter formatter;
//            if (input.contains(" ")) {
//                String[] parts = input.split(" ");
//                String monthPart = parts[0];
//                String yearPart = parts[1];
//                if (monthPart.equalsIgnoreCase("sep") && yearPart.length() == 4) {
//                    formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);
//                } else {
//                    formatter = DateTimeFormatter.ofPattern("MMM yyyy", Locale.ENGLISH);
//                }
//            } else {
//                return false; // Invalid format
//            }
//
//            YearMonth inputYearMonth = YearMonth.parse(input, formatter);
//            YearMonth currentYearMonth = YearMonth.now();
//            if (inputYearMonth.isBefore(currentYearMonth)) {
//                return false; // Previous month and year entered
//            }
//            return true; // Valid month and year format
//        } catch (DateTimeParseException e) {
//            return false; // Invalid format
//        }
//    }
//
//    public static void printHoliday(WebDriver driver) {
//        // current month holiday
//        String currmonth = "";
//        int presence = driver.findElements(By.cssSelector("div[class='holiday_count']")).size();
//        if (presence != 0) {
//            currmonth = (driver.findElement(By.cssSelector("div[class*='DayNavigator__I']:nth-of-type(2)")).getText()
//                    .split("\n")[0]);
//            String holiday = driver.findElement(By.cssSelector("div[class='holiday_count']")).getText();
//            hmap.put(currmonth, holiday);
//        } else {
//            currmonth = (driver.findElement(By.cssSelector("div[class*='DayNavigator__I']:nth-of-type(2)")).getText()
//                    .split("\n")[0]);
//            String holiday = "0";
//            hmap.put(currmonth, holiday);
//        }
//
//    }
//
//    public static void weekend_currMoth(WebDriver driver, String year_month_user_enetred) {
//
//        String currmonth = (driver.findElement(By.cssSelector("div[class*='DayNavigator__I']:nth-of-type(2)")).getText()
//                .split("\n")[0]);
//
//        List<WebElement> dates = driver
//                .findElements(By.cssSelector("span[class^='DayTiles__CalendarDaysSpan-sc-']"));
//        for (int i = 0; i < dates.size(); ++i) {
//            String property = dates.get(i).getCssValue("color");
//
//            if (property.equals("rgba(216, 78, 85, 1)")) {
//                weekendDate.add(dates.get(i).getText());
//            }
//
//        }
//        System.out.println("Weekend date for month " + currmonth + " are below");
//
//        if (currmonth.equals(year_month_user_enetred)) {
//
//            int date1 = Integer.valueOf(weekendDate.get(0)) - 7;
//            int date2 = Integer.valueOf(weekendDate.get(1)) - 7;
//            while (date1 > 0 && date2 > 0) {
//                weekendDate.add(String.valueOf(date1));
//                weekendDate.add(String.valueOf(date2));
//                date1 = date1 - 7;
//                date2 = date2 - 7;
//
//            }
//
//        }
//        System.out.print(weekendDate);
//
//        weekendDate.clear();
//        System.out.println("");
//    }
//
//    public static void SelectMonth_year(String year, WebDriver driver) {
//        RedBusCode.printHoliday(driver);// already default month holiday print
//
//        while (!(driver.findElement(By.cssSelector("div[class*='DayNavigator__I']:nth-of-type(2)")).getText().split("\n")[0]
//                .equals(year))) {
//
//            driver.findElement(By.cssSelector("div[class*='DayNavigator__I']:nth-of-type(3)")).click();
//
//            RedBusCode.printHoliday(driver);
//
//        }
//        RedBusCode.weekend_currMoth(driver, year);
//
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//
//        String year_month = "May 2024"; // change value from here give in MMM YYYY and MMMM YYYY for only sept
//        if (RedBusCode.validateMonthYear(year_month)) {
//             
//
//            Map<String, Object> prefs = new HashMap<String, Object>();
//
//            prefs.put("profile.default_content_setting_values.notifications", 2);
//
//            ChromeOptions options = new ChromeOptions();
//
//            options.setExperimentalOption("prefs", prefs);
//
//            WebDriver driver = new ChromeDriver(options);
//
//            driver.get("http://redbus.in/");
//            driver.findElement(By.cssSelector("div[id='onwardCal']")).click();
//
//            // This will print whatever month will be there by default
//
//            RedBusCode.SelectMonth_year(year_month, driver);
//
//            System.out.println(hmap);
//        }
//
//        else {
//
//            System.out.println("Previous year month entered it should be same month-year or greater");
//
//        }
//    }
//
//        }
//
//}
//}
//}

