import helpers.SeleniumHelpers
import org.junit.gen5.api.Assertions.assertEquals
import page.GooglePage

class GoogleTest : SeleniumHelpers() {

    val googlePage = GooglePage(driver)

    init {
        "Проверка авторизации в Gmail"{
            authorization()
        }
    }

    fun authorization() {
        googlePage.run {
            open()
            verifyUrl()
            click(loginButton)
            sendKeys(mailLine, "lidzeGit@gmail.com")
            click(nextButton)
            sendKeys(passwordLine, "dasd")
            click(nextButton)
            try {
                assertEquals(errorMessage.text, "Неверный пароль. Повторите попытку или нажмите на ссылку \"Забыли пароль?\", чтобы сбросить его.")
            } finally {
                close()
            }
        }
    }
}


