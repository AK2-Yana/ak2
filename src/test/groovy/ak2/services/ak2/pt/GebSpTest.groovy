package ak2.services.ak2.pt

class GebSpTest extends CommonPageTest {
    static def cachedSpDriver

    def setupSpec() {
        if (cachedSpDriver == null) {
            cachedSpDriver = getChromeDriver(true)
        }
    }

    def setup() {
        driver = cachedSpDriver
    }

    def cleanup() {
        driver.manage().deleteAllCookies()
    }

    def cleanupSpec() {
        def windowHandles = cachedSpDriver.getWindowHandles()
        for (String window : windowHandles) {
            cachedSpDriver.switchTo().window(window)
            cachedSpDriver.quit()
        }
        cachedSpDriver = null
    }
}
