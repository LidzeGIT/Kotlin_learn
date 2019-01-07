package helpers

import io.kotlintest.specs.StringSpec
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.util.Properties

open class ConfigHelpers: StringSpec() {

    private var fis: FileInputStream? = null
    private var PROPERTIE: Properties? = null

    fun getProperty(key:String): String? {
        try {
            fis = FileInputStream("src/main/resources/config.properties")
            PROPERTIE = Properties()
            PROPERTIE?.load(fis)
        } catch (fn: FileNotFoundException) {
            fn.printStackTrace()
        } catch (e:IOException) {
            e.printStackTrace()
        }finally {
            if (fis != null){
                try {
                    fis!!.close()
                }catch (e:IOException){
                    e.printStackTrace()
                }
            }
        }
        return PROPERTIE!!.getProperty(key)
    }
}





