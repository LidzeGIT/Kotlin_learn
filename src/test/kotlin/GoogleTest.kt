import helpers.SeleniumHelpers
import org.junit.gen5.api.Assertions.assertEquals
import java.util.concurrent.TimeUnit

class GoogleTest : SeleniumHelpers() {


    init {
        driver.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage()?.window()?.maximize()

        "Проверка авторизации в Gmail"{
            authorization()
        }
    }


    fun authorization(){
        googlePage.run {
            open()
            verifyUrl()
            click(loginButton)
            sendKeys(mailLine,"lidzeGit@gmail.com")
            click(nextButton)
            sendKeys(passwordLine,"asd")
            click(nextButton)
            var errorDescription = errorMessage.text
            assertEquals(errorDescription,"Неверный пароль. Повторите попытку или нажмите на ссылку \"Забыли пароль?\", чтобы сбросить его.")
            close()
        }
    }
}


