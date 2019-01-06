
import io.kotlintest.specs.StringSpec
import org.junit.gen5.api.Assertions.assertEquals
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.WebDriverWait
import page.GooglePage
import java.util.concurrent.TimeUnit

class GoogleTest : StringSpec() {
    private val driver: WebDriver = autoClose(WebDriverCloseable(ChromeDriver()))
    private val googlePage = GooglePage(driver)
    private val wait = WebDriverWait(driver, 10)


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
            loginButton.click()
            mailLine.sendKeys("lidzeGit@gmail.com")
            nextButton.click()
            passwordLine.sendKeys("fsdsfd")
            wait.until { nextButton.isDisplayed }
            nextButton.click()
            val errorDescription = errorMessage.text
            assertEquals(errorDescription,"Неверный пароль. Повторите попытку или нажмите на ссылку \"Забыли пароль?\", чтобы сбросить его.")
        }
    }
}


