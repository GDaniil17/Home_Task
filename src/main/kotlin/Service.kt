import java.sql.DriverManager
import java.sql.SQLException
import java.util.concurrent.locks.Condition

class Service {
    fun findElById(id: Int, base: String) {
        try {
            val conn = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/$base")
                .use {
                    it.createStatement().use {
                        if (base == "Host") {
                            val rs =
                                it.executeUpdate("SELECT * FROM Host WHERE host_id = (SELECT host_id FROM Host WHERE host_id = $id) ")
                        } else {
                            val rs =
                                it.executeUpdate("SELECT * FROM $base WHERE id = (SELECT id FROM $base WHERE id = $id) ")
                        }
                    }
                }
        } catch (e: SQLException) {
            println(e)
        }
    }

    fun findElWithConditionId(condition: String, base: String) {
        try {
            val conn = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/$base")
                .use {
                    it.createStatement().use {
                        if (base == "Host") {
                            val rs =
                                it.executeUpdate("SELECT * FROM Host WHERE host_id = (SELECT host_id FROM Host WHERE host_id $condition) ")
                        } else {
                            val rs =
                                it.executeUpdate("SELECT * FROM $base WHERE id = (SELECT id FROM $base WHERE id $condition) ")
                        }
                    }
                }
        } catch (e: SQLException) {
            println(e)
        }
    }

    fun groupBy(field: String, base: String) {
        try {
            val conn = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/$base")
                .use {
                    it.createStatement().use {
                        val rs =
                            it.executeUpdate("SELECT * FROM $base GROUP BY $field")

                    }
                }
        } catch (e: SQLException) {
            println(e)
        }
    }

    fun sortByReverse(field: String, base: String) {
        try {
            val conn = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/$base")
                .use {
                    it.createStatement().use {
                        val rs =
                            it.executeUpdate("SELECT * FROM $base ORDER BY $field DESC")

                    }
                }
        } catch (e: SQLException) {
            println(e)
        }
    }
}