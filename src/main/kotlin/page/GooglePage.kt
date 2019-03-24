package page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.WebDriverWait


class GooglePage(private val driver: WebDriver) {

    private val pageUrl = "https://www.google.com/"

    init {
        PageFactory.initElements(driver, this)
    }

    @FindBy(xpath = "//*[@name='q']")
    lateinit var findLine: WebElement

    @FindBy(xpath = "//a[@id='gb_70']")
    lateinit var loginButton : WebElement

    @FindBy(xpath = "//input[@id='identifierId']")
    lateinit var mailLine: WebElement

    @FindBy(xpath = "//content[@class='CwaK9']//span[text()='Далее']")
    lateinit var nextButton:WebElement

    @FindBy(xpath = "//content[contains(text(),'Неверный пароль. Повторите попытку или нажмите на ссылку \"Забыли пароль?\", чтобы сбросить его.')]")
    lateinit var errorMessage: WebElement

    @FindBy(xpath = "//input[@name='password']")
    lateinit var passwordLine: WebElement

    @FindBy(xpath = "//div[@class='FPdoLc VlcLAe']//*[@value='Поиск в Google']")
    lateinit var findGoogle: WebElement

    @FindBy(xpath = "//div[@class='FPdoLc VlcLAe']//*[@value='Мне повезёт!']")
    lateinit var findLucky: WebElement

    @FindBy(xpath = "//div[@class='gb_Q gb_R']//a[@data-pid='23']")
    lateinit var mailButton: WebElement

    @FindBy(xpath = "//div[@class='gb_Q gb_R']//a[@data-pid='2']")
    lateinit var pictureButton: WebElement


    fun open() = driver.get(pageUrl)

    fun verifyUrl() {
        WebDriverWait(driver, 10).until { it.currentUrl == pageUrl }
    }
}