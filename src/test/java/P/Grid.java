package P;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static com.google.gson.internal.bind.TypeAdapters.URL;

public class Grid {

    DesiredCapabilities cap;
    ChromeOptions option;
    FirefoxOptions option1;

    @Test(priority = 1)
    public void openChromeBrowser() throws MalformedURLException, Exception {

        cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WINDOWS);
        option  = new ChromeOptions();
        option.merge(cap);


        String nodeUrl    = "http://10.10.4.108:4444/wd/hub";
        WebDriver driver = new RemoteWebDriver(new URL(nodeUrl),option);

        driver.navigate().to("http://dcstaging.tiecheservice.com/designcubestaging/web/#/auth/login");
        System.out.println(driver.getTitle());
    }

    @Test(priority = 2)
    public void fireFoxBrowser() throws MalformedURLException {
        cap = new DesiredCapabilities();
        cap.setBrowserName("firefox");
        cap.setPlatform(Platform.MAC);
        option1 = new FirefoxOptions();
        option1.merge(cap);

        String nodeUrl    = "http://10.10.4.108:4444/wd/hub";
        WebDriver driver = new RemoteWebDriver(new URL(nodeUrl),option1);

        driver.navigate().to("http://dcstaging.tiecheservice.com/designcubestaging/web/#/auth/login");
        System.out.println(driver.getTitle());

    }


}
