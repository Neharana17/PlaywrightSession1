package Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PlaywrightBasic {
    public static void main(String[] args) {
        Playwright playwright= Playwright.create();
        //chorme
       Browser browser=  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

       //Firefox
       // Browser browser1=  playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        // Safari
      //  Browser browser2=  playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
      Page page= browser.newPage();
      page.navigate("https://www.amazon.in");
      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("test.png")));
     String tiile=  page.title();
        System.out.println("My page title is:"+tiile);

        String Url= page.url();
        System.out.println("My page URL is :"+Url);


        browser.close();
        playwright.close();;
    }
}
