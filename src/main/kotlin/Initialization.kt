import java.sql.DriverManager
import java.sql.SQLException

class Initialization {
    private val arrayOfNames = arrayOf("Host", "Birds", "EarthAnimals")
    fun delete(numberOfBase: Int){
        try {
            val conn = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/${arrayOfNames[numberOfBase-1]}")
                .use {
                    it.createStatement().use {
                        val rs = it.executeUpdate("DROP TABLE ${arrayOfNames[numberOfBase-1]}")
                    }
                }
        }
        catch(e: SQLException){
            println(e)
        }
    }

    fun printOptions() {
        for (i in 0..2)
            println("${i+1}) ${arrayOfNames[i]}")
    }
}