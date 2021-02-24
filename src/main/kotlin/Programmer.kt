class Programmer (override val start: Int, override val last: Int, override val salary: Int, private var language: String): Jobs{
    override fun wage(){
        println("Зарплата: $salary долларов")
    }

    fun firstProgrammingLanguage(){
        println("Первый ЯП этого программиста: $language")
    }
}