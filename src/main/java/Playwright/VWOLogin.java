package Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;


public class VWOLogin {
    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeTest
    public void setup() {
        Playwright playwright = Playwright.create();
       browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
       page = browser.newPage();
    }

    @Test

        public void VWOlogin(){

        page.navigate("https://app.vwo.com/#/login");
        page.locator("#login-username").fill("user@gmail.com");
        page.locator("#login-password").fill("Neha1702#");
        page.click("#js-login-btn");
        page.waitForLoadState(LoadState.NETWORKIDLE);

        assertEquals("Dashboard",page.title());
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Dashboard.png")));


    }
    @AfterTest
    public  void tearDown(){

        page.close();
    }


}
