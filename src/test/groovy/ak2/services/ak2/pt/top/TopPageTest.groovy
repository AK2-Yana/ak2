package ak2.services.ak2.pt.top

import ak2.services.ak2.pt.GebPcTest
import ak2.services.ak2.pt.common.page.LoginPage
import ak2.services.ak2.pt.top.page.TopPage

class TopPageTest extends GebPcTest {

    def "Display Top page"() {
        when:
        go TopPage.url

        then:
        at LoginPage
    }
}
