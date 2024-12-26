package ak2.services.ak2.pt

import geb.spock.GebSpec
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.Proxy
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Ignore

@Ignore
@SpringBootTest
class CommonPageTest extends GebSpec {
//    static final sql = Sql.newInstance("")
    static final String DEFAULT_WINDOW_SIZE = "window-size=1280,1024"
    static final String DEFAULT_SP_WINDOW_SIZE = "window-size=640,960"


    def getChromeDriver(boolean isSp) {
        WebDriverManager.chromedriver().setup()
        def chromeOptions = new ChromeOptions()
        chromeOptions.addArguments("--ignore-certificate-errors")
        chromeOptions.addArguments("--headless")
        chromeOptions.addArguments(isSp ? DEFAULT_SP_WINDOW_SIZE : DEFAULT_WINDOW_SIZE)

        Proxy proxy = new Proxy()
        proxy.setHttpProxy("localhost:13128")
        proxy.setSslProxy("localhost:13128")
        chromeOptions.setProxy(proxy)

        def driver = new ChromeDriver(chromeOptions)
        return driver
    }

    def logout() {
        go "https://ak2.prod.local/ak2/logout"
    }
}
