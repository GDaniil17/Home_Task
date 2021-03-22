import java.sql.DriverManager
import java.sql.SQLException

class Client {
    private val arrayOfNames = arrayOf("Host", "Birds", "EarthAnimals")
    private val arrayOfCreate = arrayOf(
        "CREATE TABLE Host (host_id INTEGER , animalId INTEGER, name VARCHAR)",
        "CREATE TABLE Birds (animalId INTEGER , height INTEGER, climate VARCHAR)",
        "CREATE TABLE EarthAnimals (animalId INTEGER, area VARCHAR, size VARCHAR)"
    )

    fun init(numberOfBase: Int) {
        try {
            val conn = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/${arrayOfNames[numberOfBase - 1]}")
                .use {
                    it.createStatement().use {
                        val rs = it.executeUpdate(arrayOfCreate[numberOfBase - 1])
                    }
                }
        } catch (e: SQLException) {
            println(e)
        }
    }

    fun sqlRequest(request: String, numberOfBase: Int) {
        try {
            val conn = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/${arrayOfNames[numberOfBase - 1]}")
                .use {
                    it.createStatement().use {
                        val rs = it.executeUpdate(request)
                    }
                }
        } catch (e: SQLException) {
            println(e)
        }
    }

    fun printOptions() {
        for (i in 0..2)
            println("${i+1}) ${arrayOfNames[i]}")
    }
}
