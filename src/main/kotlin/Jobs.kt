interface Jobs{
    val start: Int
    val last: Int
    val salary: Int
    fun wage(){
        println("Зарплата: $salary рублей")
    }

    fun  workExperience(){
        println("Его/Её стаж: ${last - start} лет")
    }
}