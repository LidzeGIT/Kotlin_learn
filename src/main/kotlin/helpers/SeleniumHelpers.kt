package helpers

import io.kotlintest.specs.StringSpec
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import page.GooglePage


open class SeleniumHelpers : StringSpec() {

    protected val driver: WebDriver = ChromeDriver()
    val googlePage = GooglePage(driver)
    protected val wait = WebDriverWait(driver, 10)

    fun click(element: WebElement){
        wait.until(ExpectedConditions.visibilityOf(element)).click()
    }

    fun sendKeys(field:WebElement, value:String){
        field.sendKeys(value)
        field.sendKeys(Keys.TAB)
    }

    fun close(){
        driver.close()
    }

}