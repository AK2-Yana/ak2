package ak2.services.ak2.ut.common.sevices

import ak2.services.ak2.common.services.CsrfService
import ak2.services.ak2.ut.SpockSpecification
import org.springframework.beans.factory.annotation.Autowired

class CsrfServiceTest extends SpockSpecification {

    @Autowired
    CsrfService sut

    def "compareCsrfToken returns true if both of csrf are same"() {
        when:
        def result = sut.compareCsrfToken(currentCsrf, sessionCsrf)

        then:
        result == expResult

        where:
        currentCsrf | sessionCsrf || expResult
        "1a.(="     | "1a.(="     || true
        "aaaaa"     | "bbbbb"     || false
        ""          | ""          || false
    }
}
