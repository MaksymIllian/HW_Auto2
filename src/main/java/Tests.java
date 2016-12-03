import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by User on 24.11.2016.
 */

public class Tests {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver(); // Open Firefox
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String URL = "http://80.92.229.236:81"; // Poker URL
        driver.get(URL + "/auth/login"); // Open Poker
        loginTest(driver);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Players";
        Player player = new Player();
        addPlayer(driver, player);
        addedPlayerTest(driver, player);
        driver.close();
        driver.quit(); // Close Browser

    }
    public static void checkElement(WebElement webElement, String value) {
        String attributeValue = webElement.getAttribute("Value");
        if(attributeValue==null){
            System.err.println("Attribute value is null!");
            editAttribute(webElement, value);
        }
        else if(value==null) {
            System.err.println("Value is null!");
            editAttribute(webElement, value);
        }
        else if(attributeValue.equals(value)!= true) {
            System.err.println(attributeValue + " and " + value + " is not equals!");
            editAttribute(webElement, value);
        }
    }
    public static void checkElement(WebElement webElement, String webElenentName, String value, String valueName) {
        String attributeValue = webElement.getAttribute("Value");
        if(attributeValue==null){
            System.err.println(webElenentName + " value is null!");
            editAttribute(webElement, value);
        }
        else if(value==null) {
            System.err.println(valueName + "is null!");
            editAttribute(webElement, value);
        }
        else if(attributeValue.equals(value)!= true) {
            System.err.println(webElenentName + ": " + attributeValue + " and " + valueName + ": " + value + " is not equals!");
            editAttribute(webElement, value);
        }
    }
    public static void editAttribute(WebElement webElement, String value) {
        webElement.clear();
        webElement.sendKeys(value);
        System.out.println("Change attribute is complete.");
    }
    public static void addedPlayerTest(WebDriver driver, Player player) {
        System.out.println("run player test");
        driver.findElement(By.id("723a925886__login")).clear();
        driver.findElement(By.id("723a925886__login")).sendKeys(player.getUserName());
        driver.findElement(By.name("search")).click();
        driver.findElement(By.xpath(".//td/a/img[@alt=\"Edit\"]/parent::a")).click();
        WebElement userName = driver.findElement(By.id("ff14642ac1c__us_login"));
        checkElement(userName,"User name", player.getUserName(),"User name in object");
        WebElement eMail = driver.findElement(By.id("ff14642ac1c__us_email"));
        checkElement(eMail,"Email", player.getEmail(),"Email in object");
        WebElement fName = driver.findElement(By.id("ff14642ac1c__us_fname"));
        checkElement(fName,"First name", player.getfName(),"First name in object");
        WebElement lName = driver.findElement(By.id("ff14642ac1c__us_lname"));
        checkElement(lName,"Last name", player.getlName(),"Last name in object");
        WebElement address = driver.findElement(By.id("ff14642ac1c__us_address"));
        checkElement(address,"Address", player.getAddress(),"Address in object");
        WebElement city = driver.findElement(By.id("ff14642ac1c__us_city"));
        checkElement(city,"City", player.getCity(),"City in object");
        WebElement phone = driver.findElement(By.id("ff14642ac1c__us_phone"));
        checkElement(phone,"Phone", player.getPhone(),"Phone in object");
        driver.findElement(By.name("button_save")).click();
        System.out.println("done");
    }
    public static void addPlayer(WebDriver driver, Player player){
        WebElement insertLink = driver.findElement(By.xpath(".//div/a[text()=\"Insert\"]")); // Find Insert
        insertLink.click(); // click on Insert
        driver.findElement(By.id("ff14642ac1c__us_login")).sendKeys(player.getUserName());
        driver.findElement(By.id("ff14642ac1c__us_email")).sendKeys(player.getEmail());
        driver.findElement(By.id("ff14642ac1c__us_password")).sendKeys(player.getPasword());
        driver.findElement(By.id("ff14642ac1c__confirm_password")).sendKeys(player.getPasword());
        driver.findElement(By.id("ff14642ac1c__us_fname")).sendKeys(player.getfName());
        driver.findElement(By.id("ff14642ac1c__us_lname")).sendKeys(player.getlName());
        driver.findElement(By.id("ff14642ac1c__us_address")).sendKeys(player.getAddress());
        driver.findElement(By.id("ff14642ac1c__us_city")).sendKeys(player.getCity());
        driver.findElement(By.id("ff14642ac1c__us_phone")).sendKeys(player.getPhone());
        driver.findElement(By.name("button_save")).click();
    }

    public static void loginTest(WebDriver driver){
        WebElement usernameInput = driver.findElement(By.id("username")); // Find username input
        usernameInput.sendKeys("admin"); // Set username

        WebElement passwordInput = driver.findElement(By.id("password")); // Find password input
        passwordInput.sendKeys("123"); // Set password

        WebElement loginButton = driver.findElement(By.id("logIn")); // Find login button
        loginButton.click(); // click on LogIn button
        String actualTitle = driver.getTitle();
        String expectedTitle = "Players";
        assertText(actualTitle, expectedTitle); // Make assertions
    }
    public static void assertText(String actualValue, String expectedValue) {
        if(actualValue.equals(expectedValue)) {
            System.out.println("Passed.");
        } else {
            System.err.println("Failed. Expected text is "
                    + expectedValue + ", but Actual title is " + actualValue);
        }
    }
}
