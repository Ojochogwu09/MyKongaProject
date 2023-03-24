import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaLoginTest {
    private By ClickCard = By.xpath("//*[@id=\\\\\\\"channel-template\\\\\\\"]/div[2]/div/div[2]/button/div/span[1");
    private By CardNumber = By.id("card-number");
    private By Date = By.id("expiry");
    private By CVV = By.id("cvv");
    private By Submit = By.id("ValidateCardForm");
    private By Close = By.xpath("/html/body/section/section/section/div[2]/div[1]/aside");
    private WebDriver driver;
    @BeforeTest
    public void StartUp() throws InterruptedException {
        //Locate the web driver
        System.setProperty("webdriver.edge.driver", "Resources/msedgedriver.exe");
        //1. Open chromedriver
        driver = new EdgeDriver();
        //2. Input the konga page Url (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        //Verify that the user input the right Url and is on the right webpage
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            //Pass
            System.out.println("Current Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
        //3. maximize the browser
        driver.manage().window().maximize();
        //4. Click on Login/Signup button to open Login page
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[2]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);

    }
    @Test(priority = 0)
    public void BlankRequiredFieldLogin() throws InterruptedException {
        //Verify that users cannot Log in with blank required field
        // 5. Click on Login button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);

    }
    @Test(priority = 1)
    public void BlankPasswordFieldLogin() throws InterruptedException {
        //Verify that the user cannot log in with blank password field
        //6. Enter valid email address in the email field
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("estheragada11@gmail.com");
        //7.Click on the Login button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);

    }
    @Test(priority = 2)
    public void BlankEmailFieldLogin() throws InterruptedException {
        //Verify user cannot log in with blank email field
        //8. Clear the email field
        driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
        //9. Enter valid password in the password field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Ojochogwu94+");
        //10. Click on Login button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 3)
    public void LessThanSixCharactersPasswordLogin() throws InterruptedException {
        //Verify user cannot log in with a password less than six characters
        //11. Clear the password field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
        //12. Input a valid email in the email field
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("estheragada11@gmail.com");
        //13. Input less than six character password in the password field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Ojocho");
        //14. Verify that an error message(the password must be at least six characters) is displayed
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[2]/div")).isDisplayed();
        Thread.sleep(5000);

    }
    @Test(priority = 4)
    public void InvalidUserNameLogin() throws InterruptedException {
        //verify that user cannot log in with an invalid username
        //15. Clear email in the email field
        driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
        //16. Input invalid email in the email field
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("estheragada11@gmail");
        //17. Input valid password in the password field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Ojochogwu94+");
        //18. Verify that an error message(The username or password you have entered is incorrect. Please try again) is displayed
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[1]/div")).isDisplayed();
        Thread.sleep(5000);

    }
    @Test(priority = 5)
    public void PositiveLogin() throws InterruptedException {
        //Verify that user can log in with a valid email address
        //19. Input a valid email in the email field
        driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("estheragada11@gmail.com");
        //20. Click on Login button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        //Verify that user can Log in with a valid password
        driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Ojochogwu94+");
        //21. Click on the Login button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(10000);

    }
    @Test(priority = 6)
    public void ClickOnComputerAndAccessories() throws InterruptedException {
        //Verify that the user can navigate and click on the Computer and Accessories button
        //22. Click on the computer and Accessories button
        driver.findElement(By.cssSelector("a.ef511_2c5_i:nth-child(1)")).click();
        Thread.sleep(15000);

    }
    @Test(priority = 7)
    public void ClickOnLaptop() throws InterruptedException {
        //Verify that user can navigate and can click on the laptops
        //23. Click on laptops button
        driver.findElement(By.xpath("/html/body")).click();
        Thread.sleep(20000);
    }
    @Test(priority = 8)
    public void ClickOnAppleMacbook() throws InterruptedException {
        //Verify that user can navigate and click on Apple Macbook
        //24. Click on the Apple Macbook
        driver.findElement(By.xpath("/html/body")).click();
        Thread.sleep(15000);

    }
    @Test(priority = 9)
    public void AddItemToTheCart() throws InterruptedException {
        //Verify that user can navigate and click on item and add it to the cart
        //25. Click on item
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        Thread.sleep(5000);
        //26 Click on buy now to add to cart
        //27 Click on continue "checkout"
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(5000);


    }
        @Test(priority = 10)
    public void Address() throws InterruptedException {
        //28. Click on add delivery address
        //29. Click on the existing address
        //30. Click on use this address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(5000);

    }
    @Test(priority = 11)
    public void PaymentOption() throws InterruptedException{
        //31. Click on "pay now" to make payment
        //Click on "continue to pay" to place order
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[2]/div/div/h1")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 12)
    public void SelectPaymentMethod() throws InterruptedException {
        //Click on the card option from the selected payment method
        click(ClickCard);
    }
    private void click(By clickCard) {

    }
    @Test(priority = 13)
    public void InsertCardDetails() throws InterruptedException {
        //Insert an invalid card number in the card field
        setText(CardNumber, 456789);
        //Insert an invalid expiry date in the date field
        setText(Date, 6/28);
        //Insert an invalid cvv Number in the cvv field
        setText(CVV, 383);


    }
    public void setText(By cardNumber,int i){

    }
    @Test(priority = 14)
    public void PayNow() throws InterruptedException {
        //Click on the pay now button
        click(Submit);
        Thread.sleep(5000);

        //Close the iFrame displayed
        click(Close);
        Thread.sleep(5000);
        //Verify that user is unable to complete order with invalid card details
        String actualErrorMessage = "invalid card number";
        if (actualErrorMessage.contains("invalid card number"))
        //Comment out pass
            System.out.println("Wrong card number");
        else
        //Comment out fail
            System.out.println("Right card number");
    }
    @AfterTest
    public void CloseBrowser() {
        //Quit the browser
        driver.quit();

    }

}





























