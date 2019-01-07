package helpers

import io.kotlintest.specs.StringSpec
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import page.GooglePage
import java.util.concurrent.TimeUnit


open class SeleniumHelpers : StringSpec() {

    private val driver: WebDriver = ChromeDriver()
    val googlePage = GooglePage(driver)
    private val wait = WebDriverWait(driver, 10)
    private val config:ConfigHelpers? = ConfigHelpers()


    init {
        driver.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage()?.window()?.maximize()
    }

    fun click(element: WebElement){
        wait.until(ExpectedConditions.visibilityOf(element)).click()
    }

    fun sendKeys(field:WebElement, value:String){
        field.clear()
        field.sendKeys(value)
        field.sendKeys(Keys.TAB)
    }

    fun config(key:String): String {
        val lol = config!!.getProperty(key)
        return lol!!
    }

    fun close(){
        driver.close()
    }

}