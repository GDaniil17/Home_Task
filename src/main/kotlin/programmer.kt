class programmer (override val start: Int, override val last: Int, override val salary: Int, private var language: String): jobs{
    override fun wage(){
        println("Зарплата: $salary долларов")
    }

    fun firstProgrammingLanguage(){
        println("Первый ЯП этого программиста: $language")
    }
}