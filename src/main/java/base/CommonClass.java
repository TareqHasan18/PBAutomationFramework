package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utility.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonClass {

    public static WebDriver driver;
    public static Properties properties;

    //Constructor to read the load and read the credential properties
    public CommonClass(){

        try{
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("/Users/tareqhasan/IdeaProjects/PBAutomationFramework/src/main/java/config/secret.properties");
            properties.load(fileInputStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @BeforeMethod
    public static void setUp(){
        String browserName = properties.getProperty("browser");
        if(browserName.equals("chrome")){
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\tareq\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browserName.equals("FF")){
            //System.setProperty("webdriver.gecko.driver", "C:\\Users\\tareq\\Downloads\\chromedriver-win64\\chromedriver-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

        driver.get(properties.getProperty("url"));
    }

    @AfterMethod
    public static void tearDown(){
        driver.quit();
    }


}
