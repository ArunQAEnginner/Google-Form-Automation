package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bsh.ParseException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    public static ChromeDriver driver;
    boolean status = false;
     
    @Test
    public void testCase01() throws InterruptedException, ParseException{
        Wrappers test = new Wrappers();
        test.GoogleFormPage();
        Thread.sleep(4000);
        test.Name("Crio Learner");
        String Epoch = test.EpocTime();
        test.ParticipatingAutomation("I want to be the best QA Engineer! "+Epoch);
        test.AutomationTestingExperience(3);

        List<String> learns = new ArrayList<>();
        learns.add("Java");
        learns.add("Selenium");
        learns.add("TestNG");
        test.LearnedInCrioDoAutomationTesting(learns);
        test.ShouldYouBeAddressed("Mr");
        test.SevenDaysAgo();
        test.TimeRightNow("07","30");
        test.SubmitButton();
        status = test.SubmissionSuccessMessage();
         Assert.assertTrue(status);
    }



    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Start Test");
    }

    @AfterTest
    public void endTest()
    {
        System.out.println("End Test");
        driver.close();
        driver.quit();

    }
}