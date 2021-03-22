import java.sql.DriverManager
import java.sql.SQLException

class Host {
    fun init(host_id: Int, animalId: Int, name: String) {
        try {
            val conn = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/Host")
                .use {
                    it.createStatement().use {
                        val rs =
                            it.executeUpdate("CREATE TABLE Host (host_id INTEGER , animalId INTEGER, name VARCHAR)")
                        val addEl =
                            it.executeUpdate("INSERT INTO Host(host_id , animalId, name) VALUES (${host_id}, $animalId, '$name')")
                    }
                }
        }
        catch(e: SQLException){
            println(e)
        }
    }

    fun printEl(){
        try {
            val conn = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/Host")
                .use {
                    it.createStatement().use { it ->
                        val res = it.executeQuery("SELECT * FROM Host")
                        println("Host:")
                        while(res.next()){
                            val id = res.getInt("id").also {
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