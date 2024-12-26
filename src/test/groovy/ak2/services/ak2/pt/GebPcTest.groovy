package ak2.services.ak2.pt

class GebPcTest extends CommonPageTest {
    static def cachedPcDriver

    def setupSpec() {
        if (cachedPcDriver == null) {
            cachedPcDriver = getChromeDriver(false)
        }
    }

    def setup() {
        driver = cachedPcDriver
    }

    def cleanup() {
        driver.manage().deleteAllCookies()
    }

    def cleanupSpec() {
//        def windowHandles = cachedPcDriver.getWindowHandles()
//        for (String window : windowHandles) {
//            cachedPcDriver.switchTo().window(window)
//            cachedPcDriver.quit()
//        }
        cachedPcDriver = null
    }
}
