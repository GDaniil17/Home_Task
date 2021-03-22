import java.sql.DriverManager
import java.sql.SQLException

class EarthAnimals {
    fun init(animalId: Int, area: String, size: String) {
        try {
            val conn = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/EarthAnimals")
                .use {
                    it.createStatement().use {
                        val rs =
                            it.executeUpdate("CREATE TABLE EarthAnimals (animalId INTEGER , area VARCHAR, size VARCHAR)")
                        val addEl =
                            it.executeUpdate("INSERT INTO EarthAnimals(animalId , area, size) VALUES (${animalId}, '$area', '$size')")
                    }
                }
        } catch (e: SQLException) {
            println(e)
        }
    }

    fun printEl(){
        try {
            val conn = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/EarthAnimals")
                .use {
                    it.createStatement().use { it ->
                        val res = it.executeQuery("SELECT * FROM EarthAnimals")
                        println("EarthAnimals:")
                        while(res.next()){
                            val id = res.getInt("animalId").also {
                                println(it)
                            }
                        }
                    }
                }
        } catch (e: SQLException) {
            println(e)
        }
    }
}