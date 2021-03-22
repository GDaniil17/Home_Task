import java.sql.DriverManager
import java.sql.SQLException

class Birds {
    fun init(animalId: Int, height: Int, climate: String) {
        try {
            val conn = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/Birds")
                .use {
                    it.createStatement().use {
                        val rs =
                            it.executeUpdate("CREATE TABLE Birds (animalId INTEGER , height INTEGER, climate VARCHAR)")
                        val addEl =
                            it.executeUpdate("INSERT INTO Birds(animalId , height, climate) VALUES (${animalId}, $height, '$climate')")
                    }
                }
        } catch (e: SQLException) {
            println(e)
        }
    }
    fun printEl(){
        try {
            val conn = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/Birds")
                .use {
                    it.createStatement().use { it ->
                        val res = it.executeQuery("SELECT * FROM Birds")
                        println("Birds:")
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