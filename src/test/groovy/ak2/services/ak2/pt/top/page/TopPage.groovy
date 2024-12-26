package ak2.services.ak2.pt.top.page

import geb.Page

class TopPage extends Page {

    static url = 'https://ak2.prod.jp.local/ak2/top'

    static at = { title ==~ /ak2.*page/ }

    static content = {
        H1Title { $("[data-top='top']") }
    }
}
