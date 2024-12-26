package ak2.services.ak2.pt.common.page

import geb.Page
import geb.module.TextInput

class LoginPage extends Page {

    static url = 'https://ak2.prod.jp.local/ak2/login'

    static at = { title ==~ /.*Page/ }

    static content = {
        username { $('input#username').module(TextInput) }
        password { $ { ("input#password") }.module(TextInput) }
        submitButton { $ { 'button#submit' } }
    }
}
