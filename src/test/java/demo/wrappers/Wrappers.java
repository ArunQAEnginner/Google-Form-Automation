package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bsh.ParseException;
import demo.TestCases;

import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    ChromeDriver driver = TestCases.driver;

    public void GoogleFormPage(){
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
    }

    public void Name(String name){
       WebElement NameTextBox = driver.findElement(By.xpath("(//input[@jsname='YPqjbf'])[1]"));
       NameTextBox.sendKeys(name);
    }

    public void ParticipatingAutomation(String message) {        
        WebElement ParticipatingAutomationTextBox = driver.findElement(By.xpath("//textarea"));
        ParticipatingAutomationTextBox.sendKeys(message);
    }

    public String EpocTime(){
        long epoch = System.currentTimeMillis()/1000;
        return String.valueOf(epoch);
    }

    public void AutomationTestingExperience(int experience){
        if(experience>=0 && experience<=2){
            WebElement RadioButton02 = driver.findElement(By.xpath("//div[@data-value='0 - 2']"));
            RadioButton02.click();
        }else if(experience>=3 && experience<=5){
            WebElement RadioButton35 = driver.findElement(By.xpath("//div[@data-value='3 - 5']"));
            RadioButton35.click();
        }else if(experience>=6 && experience<=10){
            WebElement RadioButton610 = driver.findElement(By.xpath("//div[@data-value='6 - 10']"));
            RadioButton610.click();
        }else if(experience>10){
            WebElement RadioButton11 = driver.findElement(By.xpath("//div[@data-value='> 10']"));
            RadioButton11.click();
        }
    }

    public void LearnedInCrioDoAutomationTesting(List<String> learns){
       for(int i=0 ; i<learns.size() ; i++){
            String learn = learns.get(i);

            switch (learn){
                case "Java":
                WebElement JavaCheckBox = driver.findElement(By.xpath("//div[@aria-label='Java']"));
                JavaCheckBox.click();
                break;

                case "Selenium":
                WebElement SeliniumCheckBox = driver.findElement(By.xpath("//div[@aria-label='Selenium']"));
                SeliniumCheckBox.click();
                break;

                case "Springboot":
                WebElement SpringBootCheckBox = driver.findElement(By.xpath("//div[@aria-label='Springboot']"));
                SpringBootCheckBox.click();
                break;

                case "TestNG":
                WebElement TestNGCheckBox = driver.findElement(By.xpath("//div[@aria-label='TestNG']"));
                TestNGCheckBox.click();
                break;
            }
       }
    }

    public void ShouldYouBeAddressed(String gender) throws InterruptedException{
        WebElement AddressedDropDown = driver.findElement(By.xpath("//span[text()='Choose']"));
        AddressedDropDown.click();

        switch (gender){
            case "Mr":
            WebElement MrSelect = driver.findElement(By.xpath("(//span[text()='Mr'])[2]"));
            MrSelect.click();
            break;

            case "Ms":
            WebElement MsSelect = driver.findElement(By.xpath("(//span[text()='Ms'])[2]"));
            MsSelect.click();
            break;

            case "Mrs":
            WebElement MrsSelect= driver.findElement(By.xpath("(//span[text()='Mrs'])[2]"));
            MrsSelect.click();
            break;

            case "Dr":
            WebElement DrSelect = driver.findElement(By.xpath("(//span[text()='Dr'])[2]"));
            DrSelect.click();
            break;

            case "Rather not say":
            WebElement RatherNotSaySelect = driver.findElement(By.xpath("(//span[text()='Rather not say'])[2]"));
            RatherNotSaySelect.click();
            break;
        }
    }

    public void SevenDaysAgo(){
        LocalDate myDateObj = LocalDate.now();
        LocalDate dateMinusSevenDays = myDateObj.minusDays(7);

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    
        String formattedDate = dateMinusSevenDays.format(myFormatObj);

        WebElement DateTextBox = driver.findElement(By.xpath("//input[@type='date']"));
        DateTextBox.sendKeys(formattedDate);
    }

    public void TimeRightNow(String hour,String minute){
        WebElement HourTextBox = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        HourTextBox.sendKeys(hour);

        WebElement MinuteTextBox = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        MinuteTextBox.sendKeys(minute);
    }

    public void SubmitButton() throws InterruptedException {
        WebElement SubmitButton = driver.findElement(By.xpath("//span[text()='Submit']"));
        SubmitButton.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(SubmitButton));
    }

    public boolean SubmissionSuccessMessage(){
        WebElement SuccessMessageText = driver.findElement(By.xpath("//div[text()='Thanks for your response, Automation Wizard!']"));
        System.out.println(SuccessMessageText.getText());
        return  SuccessMessageText.isDisplayed();
    }
}
